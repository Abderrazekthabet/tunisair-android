package com.tunisair.main;

import com.tunisair.libs.SessionManager;
import com.tunisair.main.R;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

public class PN_Equipage extends Activity {
	SessionManager session;
	
	
@Override
protected void onCreate(Bundle savedInstanceState) {
	// TODO Auto-generated method stub
	super.onCreate(savedInstanceState);
	setContentView(R.layout.pn_equipage);
	session = new SessionManager(getApplicationContext());
	
	
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
