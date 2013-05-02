package com.tunisair.main;

import com.esprit.main.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class Authenti_Personel extends Activity {
	Button  btnConnexion;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.authenti_personnel);
		btnConnexion = (Button) findViewById(R.id.btn_connexion_pers);
		btnConnexion.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(v.getContext(),PN_Index.class);
				startActivityForResult(intent, 0);
				
			}
		});
		
	}

}
