package com.tunisair.main;

import org.json.JSONObject;

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
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.tunisair.libs.SessionManager;
import com.tunisair.libs.UserFunction;
import com.tunisair.utils.ConnectionDetector;

@SuppressLint("NewApi")
public class Authenti_User extends Fragment {
	Button  btnConnexion;
	EditText txtEmail;
	EditText txtPass;
	SessionManager session;
	
	private static String KEY_SUCCESS 	= "success";
	
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		return inflater.inflate(R.layout.authenti_user, container, false);
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
		session = new SessionManager(getActivity().getApplicationContext());
		
		txtEmail 	= (EditText) getView().findViewById(R.id.et_login_user);
		txtPass = (EditText) getView().findViewById(R.id.et_code_user);
		
		
		btnConnexion = (Button) getView().findViewById(R.id.btn_connexion_user);
		btnConnexion.setOnClickListener(new OnClickListener() {
			
			
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				ConnectionDetector isOnline = new ConnectionDetector(getActivity().getApplicationContext());
				if(isOnline.isConnectingToInternet() == false){
					Toast.makeText(getActivity().getBaseContext(), "Probleme de Cnx", Toast.LENGTH_SHORT).show();
				}else{
				try {
					String email	= txtEmail.getText().toString();
					String pass 	= txtPass.getText().toString();
					
					if(email.equals("") || pass.equals("") ){
						Toast.makeText(getActivity().getBaseContext(), "Veuillez remplir tous les champs", Toast.LENGTH_SHORT).show();
					}else {
						UserFunction u 	= new UserFunction();
						JSONObject j = u.loginUser(email,pass);
					
						
						if(j.getString(KEY_SUCCESS) != null){
						
							if (Integer.parseInt(j.getString(KEY_SUCCESS)) == 1) {
							
								FragmentManager fm = getFragmentManager();
								FragmentTransaction transaction =fm.beginTransaction();
								
								transaction.replace(R.id.ll_fidelys_index, new Fidelys_profil());
								transaction.commit();
								session.createLoginSession(j.toString());
								Log.i("Session Result", j.toString());
								
								
							}else {
								Toast.makeText(getActivity().getBaseContext(), "Invalid Login Détails", Toast.LENGTH_SHORT).show();
							}	
						
						}
					}
				} catch (Exception e) {
					Toast.makeText(getActivity().getBaseContext(), "Erreur Connexion", Toast.LENGTH_SHORT).show();
					
				}
				
				
				
			}}
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

}
