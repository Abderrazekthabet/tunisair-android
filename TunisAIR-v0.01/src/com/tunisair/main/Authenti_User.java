package com.tunisair.main;

import org.json.JSONObject;

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

import com.tunisair.libs.SessionManager;
import com.tunisair.libs.UserFunction;
import com.tunisair.main.R;

public class Authenti_User extends Activity {
	Button  btnConnexion;
	EditText txtEmail;
	EditText txtPass;
	SessionManager session;
	
	private static String KEY_SUCCESS 	= "success";
	
	
	
	
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.authenti_user);
		session = new SessionManager(getApplicationContext());
		
		txtEmail 	= (EditText) findViewById(R.id.et_login_user);
		txtPass = (EditText) findViewById(R.id.et_code_user);
		
		
		btnConnexion = (Button) findViewById(R.id.btn_connexion_user);
		btnConnexion.setOnClickListener(new OnClickListener() {
			
			
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				
				if(isOnline() == false){
					Toast.makeText(getBaseContext(), "Probleme de Cnx", Toast.LENGTH_SHORT).show();
				}else{
				try {
					String email	= txtEmail.getText().toString();
					String pass 	= txtPass.getText().toString();
					
					if(email.equals("") || pass.equals("") ){
						Toast.makeText(getBaseContext(), "Veuillez remplir tous les champs", Toast.LENGTH_SHORT).show();
					}else {
						UserFunction u 	= new UserFunction();
						JSONObject j = u.loginUser(email,pass);
					
						
						if(j.getString(KEY_SUCCESS) != null){
						
							if (Integer.parseInt(j.getString(KEY_SUCCESS)) == 1) {
							
								Intent intent = new Intent(getBaseContext(), Fidelys_index.class);
								session.createLoginSession(j.toString());
								Log.i("Session Result", j.toString());
								startActivityForResult(intent, 0);
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
