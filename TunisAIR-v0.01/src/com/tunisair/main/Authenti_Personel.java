package com.tunisair.main;

import org.json.JSONObject;

import com.tunisair.libs.SessionManager;
import com.tunisair.libs.UserFunction;
import com.tunisair.main.R;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Authenti_Personel extends Activity {
	Button  btnConnexion;
	EditText etMatricule;
	EditText etEmail;
	EditText etPass;
	SessionManager session;
	
	private static String KEY_SUCCESS 	= "success";
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.authenti_personnel);
		session = new SessionManager(getApplicationContext());
		
		
		etMatricule = (EditText) findViewById(R.id.et_matricule_pers);
		etEmail = (EditText) findViewById(R.id.et_login_pers);
		etPass = (EditText) findViewById(R.id.et_code_pers);
		
		
		btnConnexion = (Button) findViewById(R.id.btn_connexion_pers);
		btnConnexion.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				String matricule = etMatricule.getText().toString();
				String email 	 = etEmail.getText().toString();
				String pass		 = etPass.getText().toString();
				if(isOnline() == false){
					Toast.makeText(getBaseContext(), "Probleme de Cnx", Toast.LENGTH_SHORT).show();
				}else{
				
					try {
						if(matricule.equals("") || email.equals("")||pass.equals("")  ){
							Toast.makeText(getBaseContext(), "Veuillez remplir tous les champs", Toast.LENGTH_SHORT).show();
						}else {
						UserFunction u 	= new UserFunction();
						JSONObject j = u.loginPerso(matricule, email, pass);
						if(j.getString(KEY_SUCCESS) != null){
						
							if (Integer.parseInt(j.getString(KEY_SUCCESS)) == 1) {
								Intent intent = new Intent(v.getContext(),PN_Index.class);
								session.createLoginSession(j.toString());
								startActivityForResult(intent, 0);
								finish();
							}else {
								Toast.makeText(getBaseContext(), "Invalid Login Détails", Toast.LENGTH_SHORT).show();
							}	
						
						}
					}
					} catch (Exception e) {
						Toast.makeText(getBaseContext(), "Erreur Connexion", Toast.LENGTH_SHORT).show();
					}
				
				
			}}
		});
		
	}
	public boolean isOnline() {
    	ConnectivityManager cm = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
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
