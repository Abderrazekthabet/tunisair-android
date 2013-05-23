package com.tunisair.main;

import java.util.HashMap;

import org.json.JSONException;
import org.json.JSONObject;

import android.annotation.SuppressLint;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;

import com.tunisair.libs.SessionManager;

@SuppressLint("NewApi")
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
    	
    	
    	
    	
		
		
		FragmentManager fm = getFragmentManager();
		FragmentTransaction transaction =fm.beginTransaction();
		
		transaction.replace(R.id.ll_fidelys_index, new Authenti_User());
		transaction.commit();
		
	}
	
	
	
	
	
	
	
	public boolean onCreateOptionsMenu(Menu menu) {
		// TODO Auto-generated method stub
		getMenuInflater().inflate(R.menu.main_quitter, menu);
        return true;
	}
	
	public boolean onMenuItemSelected(int featureId, MenuItem item) {
		session.logoutUser();
		
		return super.onMenuItemSelected(featureId, item);
	}
	

	
	

}
