package com.tunisair.main;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

import com.tunisair.libs.SessionManager;
import com.tunisair.main.R;

public class PN_Index extends Activity {
	Button btnProg;
	Button btnEquipage;
	SessionManager session;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.pn_index);
		session = new SessionManager(getApplicationContext());
		btnProg = (Button) findViewById(R.id.btn_prog);
		btnProg.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(v.getContext(),PN_Programme.class);
				startActivityForResult(intent, 0);
				finish();
			}
		});
		
		btnEquipage = (Button) findViewById(R.id.btn_equipage);
		btnEquipage.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(v.getContext(), PN_Equipage.class);
				startActivityForResult(intent, 0);
				finish();
				
			}
		});
		
	
	}
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// TODO Auto-generated method stub
		getMenuInflater().inflate(R.menu.main_quitter, menu);
        return true;
	}
	
	@Override
	public boolean onMenuItemSelected(int featureId, MenuItem item) {
		session.logoutUser();
		finish();
		return super.onMenuItemSelected(featureId, item);
	}
	
	
	
	
	
}
