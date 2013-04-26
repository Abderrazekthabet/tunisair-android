package com.tunisair.main;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

import com.esprit.main.R;

public class PN_Index extends Activity {
	Button btnProg;
	Button btnEquipage;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.pn_index);
	
		btnProg = (Button) findViewById(R.id.btn_prog);
		btnProg.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(v.getContext(),PN_Programme.class);
				startActivityForResult(intent, 0);
				
			}
		});
		
		btnEquipage = (Button) findViewById(R.id.btn_equipage);
		btnEquipage.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(v.getContext(), PN_Equipage.class);
				startActivityForResult(intent, 0);
				
			}
		});
		
	
	}
	
	
	
	
	
}
