package com.tunisair.main;

import java.util.HashMap;

import org.json.JSONException;
import org.json.JSONObject;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.tunisair.libs.SessionManager;
import com.tunisair.main.R;

public class Fidelys_index extends FragmentActivity  {
	Button btnModif;
	SessionManager session;
	
	@Override
	protected void onCreate(Bundle arg0) {
		// TODO Auto-generated method stub
		super.onCreate(arg0);
		setContentView(R.layout.fidelys_index);
		session = new SessionManager(getApplicationContext());
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
    	
    	
    	
    	
		
		
		FragmentManager fm = getSupportFragmentManager();
		FragmentTransaction transaction =fm.beginTransaction();
		Fidelys_profil fp = new Fidelys_profil();
		transaction.replace(R.id.ll_profile, fp);
		transaction.commit();
		
		
		
	}
	
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// TODO Auto-generated method stub
		getMenuInflater().inflate(R.menu.main_quitter, menu);
        return true;
	}
	
	@Override
	public boolean onMenuItemSelected(int featureId, MenuItem item) {
		session.logoutUser();
		finish();
		return super.onMenuItemSelected(featureId, item);
	}
	
	
	public void onClickV(View v){
		Fragment fr = null;
		
		fr = new Fidelys_modifProfil();
		
		
		FragmentManager fm = getSupportFragmentManager();
		FragmentTransaction transaction =fm.beginTransaction();
		transaction.setCustomAnimations(android.R.anim.slide_in_left, android.R.anim.slide_out_right);
		transaction.replace(R.id.ll_profile, fr);
		transaction.addToBackStack(null);
		transaction.commit();
		
		
	}
	
	

}
