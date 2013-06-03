package com.tunisair.main;

import org.json.JSONObject;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
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
public class Authenti_Personel extends Fragment {
	Button  btnConnexion;
	EditText etMatricule;
	EditText etEmail;
	EditText etPass;
	SessionManager session;
	
	private static String KEY_SUCCESS 	= "success";
	
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		return inflater.inflate(R.layout.authenti_personnel, container, false);
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
		
		
		etMatricule = (EditText) getView().findViewById(R.id.et_matricule_pers);
		etEmail = (EditText) getView().findViewById(R.id.et_login_pers);
		etPass = (EditText) getView().findViewById(R.id.et_code_pers);
		
		
		btnConnexion = (Button) getView().findViewById(R.id.btn_connexion_pers);
		btnConnexion.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				String matricule = etMatricule.getText().toString();
				String email 	 = etEmail.getText().toString();
				String pass		 = etPass.getText().toString();
				ConnectionDetector isOnline = new ConnectionDetector(getActivity().getApplicationContext());
				
				if(isOnline.isConnectingToInternet() == false){
					Toast.makeText(getActivity().getBaseContext(), "Probleme de Cnx", Toast.LENGTH_SHORT).show();
				}else{
				
					try {
						if(matricule.equals("") || email.equals("")||pass.equals("")  ){
							Toast.makeText(getActivity().getBaseContext(), "Veuillez remplir tous les champs", Toast.LENGTH_SHORT).show();
						}else {
						UserFunction u 	= new UserFunction();
						JSONObject j = u.loginPerso(matricule, email, pass);
						if(j.getString(KEY_SUCCESS) != null){
						
							if (Integer.parseInt(j.getString(KEY_SUCCESS)) == 1) {
								Intent intent = new Intent(v.getContext(), PN_Index.class);
								startActivityForResult(intent,111);
								session.createLoginSession(j.toString());
								
								
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
	
	
	

}
