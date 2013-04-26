package com.tunisair.main;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

import com.esprit.main.R;


public class Res_21_Aff_Reservation extends Activity  {
	TextView tv;
	
	//Bundle bundle = getIntent().getExtras();
	@Override
	public void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.res_afficher);
		
		tv = (TextView) findViewById(R.id.tab1text12);
		tv.setText("pfff");
		
	}

}
