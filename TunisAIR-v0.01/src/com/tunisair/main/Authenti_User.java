package com.tunisair.main;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

import com.esprit.main.R;

public class Authenti_User extends Activity {
	Button  btnConnexion;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.authenti_user);
		
		
		btnConnexion = (Button) findViewById(R.id.btn_connexion_user);
		btnConnexion.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(v.getContext(),Ctact_01_Agence.class);
				startActivityForResult(intent, 0);
				
			}
		});
		
	}

}
