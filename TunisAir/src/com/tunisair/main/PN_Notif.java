package com.tunisair.main;


import static com.tunisair.utils.CommonUtilities.DISPLAY_MESSAGE_ACTION;
import static com.tunisair.utils.CommonUtilities.EXTRA_MESSAGE;
import static com.tunisair.utils.CommonUtilities.SENDER_ID;

import java.util.HashMap;

import org.json.JSONException;
import org.json.JSONObject;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Fragment;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gcm.GCMRegistrar;
import com.tunisair.libs.ServerUtilities;
import com.tunisair.libs.SessionManager;
import com.tunisair.utils.AlertDialogManager;
import com.tunisair.utils.ConnectionDetector;
import com.tunisair.utils.WakeLocker;

@SuppressLint("NewApi")
public class PN_Notif extends Fragment {
TextView lblMessage;
SessionManager session;
	// Asyntask
	AsyncTask<Void, Void, Void> mRegisterTask;
	
	// Alert dialog manager
	AlertDialogManager alert = new AlertDialogManager();
	ConnectionDetector cd;
	
	
	public static String name;
	public static String email;
	
	@Override
	public void onAttach(Activity activity) {
		// TODO Auto-generated method stub
		super.onAttach(activity);
	}
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		return inflater.inflate(R.layout.gcmnotif, container, false);
	}
	
	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onActivityCreated(savedInstanceState);
		
		cd = new ConnectionDetector(getActivity().getApplicationContext());

		// Check if Internet present
		if (!cd.isConnectingToInternet()) {
			// Internet Connection is not present
			alert.showAlertDialog(getActivity().getApplicationContext(),
					"Internet Connection Error",
					"Please connect to working Internet connection", false);
			// stop executing code by return
			return;
		}
		
		// Getting name, email from intent
		session = new SessionManager(getActivity().getApplicationContext());

        HashMap<String, String> user = session.getUserDetails();
    	String result = user.get(SessionManager.KEY_id);
    	try {
			JSONObject j = new JSONObject(result);
			name = j.getString("Nom");
            email = j.getString("E_mail");
		
       
       
      
       
    	
		
		// Make sure the device has the proper dependencies.
		GCMRegistrar.checkDevice(getActivity().getApplicationContext());

		// Make sure the manifest was properly set - comment out this line
		// while developing the app, then uncomment it when it's ready.
		GCMRegistrar.checkManifest(getActivity().getApplicationContext());

		lblMessage = (TextView) getView().findViewById(R.id.tv_gcmnotif);
		
		getActivity().registerReceiver(mHandleMessageReceiver, new IntentFilter(
				DISPLAY_MESSAGE_ACTION));
		
		// Get GCM registration id
		final String regId = GCMRegistrar.getRegistrationId(getActivity().getApplicationContext());

		// Check if regid already presents
		if (regId.equals("")) {
			// Registration is not present, register now with GCM			
			GCMRegistrar.register(getActivity().getApplicationContext(), SENDER_ID);
		} else {
			// Device is already registered on GCM
			if (GCMRegistrar.isRegisteredOnServer(getActivity().getApplicationContext())) {
				// Skips registration.				
				Toast.makeText(getActivity().getApplicationContext(), "Already registered with GCM", Toast.LENGTH_LONG).show();
			} else {
				// Try to register again, but not in the UI thread.
				// It's also necessary to cancel the thread onDestroy(),
				// hence the use of AsyncTask instead of a raw thread.
				
				mRegisterTask = new AsyncTask<Void, Void, Void>() {

					@Override
					protected Void doInBackground(Void... params) {
						// Register on our server
						// On server creates a new user
						Log.i("**Name**", name);
						ServerUtilities.register(getActivity().getApplicationContext(), name, email, regId);
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
	}
	
	
	private final BroadcastReceiver mHandleMessageReceiver = new BroadcastReceiver() {
		@Override
		public void onReceive(Context context, Intent intent) {
			String newMessage = intent.getExtras().getString(EXTRA_MESSAGE);
			// Waking up mobile if it is sleeping
			WakeLocker.acquire(getActivity().getApplicationContext());
			
			/**
			 * Take appropriate action on this message
			 * depending upon your app requirement
			 * For now i am just displaying it on the screen
			 * */
			
			// Showing received message
			lblMessage.append(newMessage + "\n");			
			Toast.makeText(getActivity().getApplicationContext(), "New Message: " + newMessage, Toast.LENGTH_LONG).show();
			
			// Releasing wake lock
			WakeLocker.release();
		}
	};
	
	
	public void onDestroy() {
		if (mRegisterTask != null) {
			mRegisterTask.cancel(true);
		}
		try {
			getActivity().unregisterReceiver(mHandleMessageReceiver);
			GCMRegistrar.onDestroy(getActivity().getApplicationContext());
		} catch (Exception e) {
			Log.e("UnRegister Receiver Error", "> " + e.getMessage());
		}
		super.onDestroy();
	}

}
