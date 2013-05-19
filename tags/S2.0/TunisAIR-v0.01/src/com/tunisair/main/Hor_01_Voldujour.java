package com.tunisair.main;



import org.json.JSONArray;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Context;
import android.net.ConnectivityManager;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.Toast;

import com.tunisair.libs.UserFunction;

@SuppressLint("NewApi")
public class Hor_01_Voldujour extends Fragment {
	 AutoCompleteTextView acPaysDe;
	 AutoCompleteTextView acPaysA;
	
	private Button btnRecherche;
	
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		return inflater.inflate(R.layout.hor_vol_recherche, container, false);
	}
	@Override
	public void onAttach(Activity activity) {
		// TODO Auto-generated method stub
		super.onAttach(activity);
	}
	
	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onActivityCreated(savedInstanceState);
		findViews();
		
		btnRecherche = (Button) getView().findViewById(R.id.btnRVol);
		btnRecherche.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				String de = acPaysDe.getText().toString();
				String a = acPaysA.getText().toString();
				if(isOnline() == false){
					Toast.makeText(getActivity().getBaseContext(), "Probleme de Cnx", Toast.LENGTH_SHORT).show();
				}else{
						if(de.equals("") || a.equals("")){
							Toast.makeText(getActivity().getBaseContext(), "Veuillez remplir tous les champs", Toast.LENGTH_SHORT).show();
						}else {
							UserFunction u = new UserFunction();
							JSONArray j = u.horair(de, a);
							if(j != null){
								Bundle b =new Bundle();
								
								b.putString("de", de);
								b.putString("a", a);
								FragmentManager fm = getFragmentManager();
								FragmentTransaction transaction =fm.beginTransaction();
								Fragment ff = new Hor_11_voljour_Afficher();
								ff.setArguments(b);
								transaction.replace(R.id.index, ff);
								transaction.commit();
								
								
							}else {
								Toast.makeText(getActivity().getBaseContext(), "Destination non prise en charge par TunisAIR", Toast.LENGTH_SHORT).show();
							}
							}
				}
					}
					
			
		});
	}

public boolean isOnline() {
	ConnectivityManager cm = (ConnectivityManager) getActivity().getSystemService(Context.CONNECTIVITY_SERVICE);
    // test for connection
    if (cm.getActiveNetworkInfo() != null
            && cm.getActiveNetworkInfo().isAvailable()
            && cm.getActiveNetworkInfo().isConnected()) {
    	Log.i("isOnline()", "ok");
        return true;
    } else {
    	Log.e("isOnline()", "No");
        return false;
    }  
}


private void findViews() {
	acPaysDe = (AutoCompleteTextView) getView().findViewById(R.id.acTVde);
	acPaysA = (AutoCompleteTextView) getView().findViewById(R.id.acTVa);
	String[] pays =
	getResources().getStringArray(R.array.Liste_Pays);
	ArrayAdapter<String> adapterPays =
			new ArrayAdapter<String>(this.getActivity(), android.R.layout.simple_list_item_1, pays);
	acPaysDe.setAdapter(adapterPays);
	acPaysA.setAdapter(adapterPays);
}



}
