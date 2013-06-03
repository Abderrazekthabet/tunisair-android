package com.tunisair.main;

import static com.tunisair.utils.CommonUtilities.DISPLAY_MESSAGE_ACTION;
import static com.tunisair.utils.CommonUtilities.EXTRA_MESSAGE;
import static com.tunisair.utils.CommonUtilities.SENDER_ID;

import java.util.HashMap;

import org.json.JSONException;
import org.json.JSONObject;

import android.annotation.SuppressLint;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.gcm.GCMRegistrar;
import com.tunisair.libs.ServerUtilities;
import com.tunisair.libs.SessionManager;
import com.tunisair.utils.AlertDialogManager;
import com.tunisair.utils.ConnectionDetector;
import com.tunisair.utils.WakeLocker;

@SuppressLint("NewApi")
public class PN_Index extends FragmentActivity {
	
	
	SessionManager session;
	AsyncTask<Void, Void, Void> mRegisterTask;
	
	// Alert dialog manager
	AlertDialogManager alert = new AlertDialogManager();
	ConnectionDetector cd;
	
	
	public static String name;
	public static String email;
	
	
	@Override
	protected void onCreate(Bundle arg0) {
		// TODO Auto-generated method stub
		super.onCreate(arg0);
		session = new SessionManager(this);
		session.checkLogin();
		cd = new ConnectionDetector(this);

		// Check if Internet present
		if (!cd.isConnectingToInternet()) {
			// Internet Connection is not present
			alert.showAlertDialog(this,
					"Internet Connection Error",
					"Please connect to working Internet connection", false);
			// stop executing code by return
			return;
		}
		setContentView(R.layout.pn_index);
		
		
		

		
        HashMap<String, String> user = session.getUserDetails();
    	String result = user.get(SessionManager.KEY_id);
		
		
		try {
		
    	
			JSONObject j = new JSONObject(result);
			name = j.getString("Nom");
            email = j.getString("E_mail");
            Log.i("name",email +name );
	
		// Make sure the device has the proper dependencies.
		GCMRegistrar.checkDevice(getApplicationContext());

		// Make sure the manifest was properly set - comment out this line
		// while developing the app, then uncomment it when it's ready.
		GCMRegistrar.checkManifest(getApplicationContext());

		
		
		registerReceiver(mHandleMessageReceiver, new IntentFilter(
				DISPLAY_MESSAGE_ACTION));
		
		// Get GCM registration id
		final String regId = GCMRegistrar.getRegistrationId(getApplicationContext());

		// Check if regid already presents
		if (regId.equals("")) {
			// Registration is not present, register now with GCM			
			GCMRegistrar.register(getApplicationContext(), SENDER_ID);
		} else {
			// Device is already registered on GCM
			if (GCMRegistrar.isRegisteredOnServer(getApplicationContext())) {
				// Skips registration.				
				Toast.makeText(getApplicationContext(), "Already registered with GCM", Toast.LENGTH_LONG).show();
			} else {
				// Try to register again, but not in the UI thread.
				// It's also necessary to cancel the thread onDestroy(),
				// hence the use of AsyncTask instead of a raw thread.
				
				mRegisterTask = new AsyncTask<Void, Void, Void>() {

					@Override
					protected Void doInBackground(Void... params) {
						// Register on our server
						// On server creates a new user
						 Log.i("name",email +name );
						ServerUtilities.register(getApplicationContext(), name, email, regId);
						return null;
					}

					@Override
					protected void onPostExecute(Void result) {
						mRegisterTask = null;
					}

				};
				mRegisterTask.execute(null, null, null);
			}
		}
    	} catch (JSONException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			
		}
		
		FragmentManager fm = getFragmentManager();
		FragmentTransaction transaction =fm.beginTransaction();
		
		transaction.replace(R.id.ll_pn_index, new PN_home());
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
	
	private final BroadcastReceiver mHandleMessageReceiver = new BroadcastReceiver() {
		@Override
		public void onReceive(Context context, Intent intent) {
			String newMessage = intent.getExtras().getString(EXTRA_MESSAGE);
			// Waking up mobile if it is sleeping
			WakeLocker.acquire(getApplicationContext());
			
			// Showing received message
			//lblMessage.append(newMessage + "\n");			
			Toast.makeText(getApplicationContext(), "New Message: " + newMessage, Toast.LENGTH_LONG).show();
			
			// Releasing wake lock
			WakeLocker.release();
		}
	};
	
	
	public void onDestroy() {
		if (mRegisterTask != null) {
			mRegisterTask.cancel(true);
		}
		try {
			unregisterReceiver(mHandleMessageReceiver);
			GCMRegistrar.onDestroy(getApplicationContext());
		} catch (Exception e) {
			Log.e("UnRegister Receiver Error", "> " + e.getMessage());
		}
		super.onDestroy();
	}

}	
	
	
	






