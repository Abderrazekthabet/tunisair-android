package com.tunisair.main;

import java.util.HashMap;

import org.json.JSONException;
import org.json.JSONObject;

import android.annotation.SuppressLint;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.webkit.WebView;

import com.tunisair.libs.SessionManager;

@SuppressLint("NewApi")
public class PN_Programme extends FragmentActivity {
		
		SessionManager session;
		WebView wv;
		
		@Override
		protected void onCreate(Bundle arg0) {
		// TODO Auto-generated method stub
		super.onCreate(arg0);
		setContentView(R.layout.pn_programme);
		setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        
        
        session = new SessionManager(getApplicationContext());

        HashMap<String, String> user = session.getUserDetails();
    	String result = user.get(SessionManager.KEY_id);
    	try {
			JSONObject j = new JSONObject(result);
			wv = (WebView) findViewById(R.id.wb_progpn);
	         wv.loadUrl("http://192.168.1.5/TunisAIR/progPn.php?tlc="+j.getString("TLC"));
             
		
       
       
      
       
    	} catch (JSONException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		}
		
		
		}
		


