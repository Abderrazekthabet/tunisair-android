package com.tunisair.main;

import java.util.HashMap;

import org.json.JSONException;
import org.json.JSONObject;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.tunisair.libs.SessionManager;
import com.tunisair.libs.UserFunction;

public class Fidelys_modifProfil extends Fragment {
	SessionManager session;
	EditText etNom;
	EditText etPrenom;
	Button btnValider;
	
	
	@Override
	public void onAttach(Activity activity) {
		// TODO Auto-generated method stub
		super.onAttach(activity);
	}
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		
		
		
		
		return inflater.inflate(R.layout.fidelys_modifprofil, container, false);
	}

	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onActivityCreated(savedInstanceState);
		
		btnValider = (Button) getView().findViewById(R.id.btn_valider);
		
		etNom = (EditText) getView().findViewById(R.id.et_profil_nom);
		etPrenom = (EditText) getView().findViewById(R.id.et_profil_prenom);
		session = new SessionManager(getActivity().getApplicationContext());
		session.checkLogin();
		HashMap<String, String> user = session.getUserDetails();
    	final String result = user.get(SessionManager.KEY_id);
    	
			
			
			
			btnValider.setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View v) {
					try {
					// TODO Auto-generated method stub
					JSONObject j = new JSONObject(result);
					UserFunction u = new UserFunction();
					JSONObject json = u.upDateUser(etNom.getText().toString(), etPrenom.getText().toString(), j.getString("id").toString());
					
					session.createLoginSession(json.toString());
					
					Log.i("SPUpdate ", json.toString());
					FragmentManager fm = getFragmentManager();
					FragmentTransaction transaction =fm.beginTransaction();
					transaction.setCustomAnimations(android.R.anim.slide_in_left, android.R.anim.slide_out_right);
					transaction.replace(R.id.ll_profile, new Fidelys_profil());
					
					transaction.addToBackStack(null);
					transaction.commit();
					
					
					
						Log.i("SPUpdate", session.getUserDetails().toString());
					} catch (JSONException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			});
			
			
		
		
	}
	
	
	
}
