package com.tunisair.main;

import java.util.HashMap;

import org.json.JSONException;
import org.json.JSONObject;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Bundle;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.tunisair.libs.SessionManager;

@SuppressLint("NewApi")
public class Fidelys_index extends Fragment  {
	Button btnModif;
	SessionManager session;
	
	@Override
	public void onAttach(Activity activity) {
		// TODO Auto-generated method stub
		super.onAttach(activity);
	}
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		return inflater.inflate(R.layout.fidelys_index,container,false);
	}
	
	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onActivityCreated(savedInstanceState);
		session = new SessionManager(getActivity().getApplicationContext());
		session.checkLogin();
		HashMap<String, String> user = session.getUserDetails();
    	String result = user.get(SessionManager.KEY_id);
    	try {
			JSONObject j = new JSONObject(result);
			
			
			Log.i("SP", j.getString("nom").toString());
			
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    	
    	
    	
		
		
		FragmentManager fm = getFragmentManager();
		FragmentTransaction transaction =fm.beginTransaction();
		Fidelys_profil fp = new Fidelys_profil();
		transaction.replace(R.id.index, fp);
		transaction.commit();
		
		
	}
	
	
	
	
	public boolean onCreateOptionsMenu(Menu menu) {
		// TODO Auto-generated method stub
		getActivity().getMenuInflater().inflate(R.menu.main_quitter, menu);
        return true;
	}
	
	public boolean onMenuItemSelected(int featureId, MenuItem item) {
		session.logoutUser();
		
		return super.getActivity().onMenuItemSelected(featureId, item);
	}
	

	
	

}
