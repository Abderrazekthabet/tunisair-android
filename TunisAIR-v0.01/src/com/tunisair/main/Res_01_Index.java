package com.tunisair.main;

import com.esprit.main.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class Res_01_Index extends Activity implements OnClickListener {
	EditText etNom;
	EditText etNum;
	Button btnAff;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.res_reservation);
		etNom = (EditText) findViewById(R.id.editText1);
		etNum = (EditText) findViewById(R.id.editText2);
		btnAff = (Button) findViewById(R.id.affich);
		btnAff.setOnClickListener(this);
		
		
	}
	@Override
	public void onClick(View v) {
		Intent intent = new Intent(v.getContext(),Res_11_ReservationTab.class);
		
		intent.putExtra("nom", etNom.getText());
		intent.putExtra("numreser", etNum.getText());
		startActivityForResult(intent, 0);
		
	}
	
}
