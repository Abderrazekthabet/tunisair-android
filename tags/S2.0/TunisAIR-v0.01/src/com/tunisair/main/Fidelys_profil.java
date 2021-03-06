package com.tunisair.main;

import java.util.HashMap;

import org.json.JSONException;
import org.json.JSONObject;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TabHost;
import android.widget.TabHost.OnTabChangeListener;
import android.widget.TabHost.TabSpec;
import android.widget.TextView;

import com.tunisair.libs.SessionManager;

@SuppressLint("NewApi")
public class Fidelys_profil extends Fragment implements OnTabChangeListener {
	private static final String TAG = "FragmentTabs";
    public static final String TAB_FIDELYS = "Fidelys";
    public static final String TAB_CTNS = "Contactez-nous";
 
    private View mRoot;
    private TabHost mTabHost;
    private int mCurrentTab;
    TextView txtNom;
    TextView txtPrenom;
    Button btnModif;
    
   SessionManager session;
    
    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
    }
 
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
    	
    	
        mRoot = inflater.inflate(R.layout.fidelys_profil, null);
        
        setupTabs();
        return mRoot;
    }
    
   
    
 
    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        setRetainInstance(true);
        

    	txtNom = (TextView) getView().findViewById(R.id.txt_profil_Nom);
		txtPrenom = (TextView) getView().findViewById(R.id.txt_profil_prenom);
    	btnModif = (Button) getView().findViewById(R.id.btn_modifprofil);
    	btnModif.setOnClickListener(new OnClickListener() {
			
			public void onClick(View v) {
				Fragment fr = null;
				
				fr = new Fidelys_modifProfil();
				FragmentManager fm = getFragmentManager();
				FragmentTransaction transaction =fm.beginTransaction();
				transaction.replace(R.id.index, fr);
				transaction.commit();
				
			}
		});
    	session = new SessionManager(getActivity().getApplicationContext());
		session.checkLogin();
		HashMap<String, String> user = session.getUserDetails();
    	String result = user.get(SessionManager.KEY_id);
    	try {
			JSONObject j = new JSONObject(result);
			
			txtNom.setText(j.getString("nom").toString());
			txtPrenom.setText(j.getString("prenom").toString());
			
			
			
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
        
        mTabHost.setOnTabChangedListener(this);
        mTabHost.setCurrentTab(mCurrentTab);
        // manually start loading stuff in the first tab
        updateTab(TAB_FIDELYS, R.id.tab_1);
    }
 
    private void setupTabs() {
    	mTabHost = (TabHost) mRoot.findViewById(android.R.id.tabhost);
        mTabHost.setup(); // you must call this before adding your tabs!
        mTabHost.addTab(newTab(TAB_FIDELYS, "Tab1", R.id.tab_1));
        mTabHost.addTab(newTab(TAB_CTNS, "Tab2", R.id.tab_2));
    }
 
    private TabSpec newTab(String tag, String labelId, int tabContentId) {
        Log.d(TAG, "buildTab(): tag=" + tag);

        TabSpec tabSpec = mTabHost.newTabSpec(tag);
        tabSpec.setIndicator(tag);
        tabSpec.setContent(tabContentId);
        return tabSpec;
    }
 
    @Override
    public void onTabChanged(String tabId) {
        Log.d(TAG, "onTabChanged(): tabId=" + tabId);
        if (TAB_FIDELYS.equals(tabId)) {
            updateTab(tabId, R.id.tab_1);
            mCurrentTab = 0;
            
        }
        if (TAB_CTNS.equals(tabId)) {
            updateTab(tabId, R.id.tab_2);
            mCurrentTab = 1;
            
        }
    }
 
    private void updateTab(String tabId, int placeholder) {
        FragmentManager fm = getFragmentManager();
        Fragment f = null;
        Fidelys_contacteznous fc = new Fidelys_contacteznous();
        Log.d(TAG, "Test Tag tabId=" + fc.getTag());
        Fidelys_fidelys ff = new Fidelys_fidelys();
        if(tabId.equals("Fidelys")){
        	f= ff;
        }
        if(tabId.equals("Contactez-nous")){
        	f= fc;
        }
        
        if (fm.findFragmentByTag(tabId) == null) {
            fm.beginTransaction()
                    .replace(placeholder, f)
                    .commit();
       
    }
        
        
        
        
        
    }
}
	
	
	


