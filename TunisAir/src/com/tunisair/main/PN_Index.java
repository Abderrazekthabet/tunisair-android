package com.tunisair.main;

import android.annotation.SuppressLint;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

import com.tunisair.libs.SessionManager;

@SuppressLint("NewApi")
public class PN_Index extends FragmentActivity {
	Button btnProg;
	Button btnEquipage;
	SessionManager session;
	
	@Override
	protected void onCreate(Bundle arg0) {
		// TODO Auto-generated method stub
		super.onCreate(arg0);
		setContentView(R.layout.pn_index);
		session = new SessionManager(getApplicationContext());
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
				PN_Equipage pnE = new PN_Equipage();
				FragmentManager fm = getFragmentManager();
				FragmentTransaction transaction =fm.beginTransaction();
				transaction.replace(R.id.ll_pn_index, pnE);
				transaction.commit();
				
				
			}
		});
	}
	
	
	
	
	
	
	public boolean onCreateOptionsMenu(Menu menu) {
		// TODO Auto-generated method stub
		getMenuInflater().inflate(R.menu.main_quitter, menu);
        return true;
	}
	
	public boolean onMenuItemSelected(int featureId, MenuItem item) {
		session.logoutUser();
		
		return super.onMenuItemSelected(featureId, item);
	}
	
	
	
	
	
}
