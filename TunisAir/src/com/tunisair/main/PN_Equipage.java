package com.tunisair.main;

import com.tunisair.libs.SessionManager;
import com.tunisair.main.R;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

@SuppressLint("NewApi")
public class PN_Equipage extends Fragment {
	SessionManager session;
	
	
	@Override
	public void onAttach(Activity activity) {
		// TODO Auto-generated method stub
		super.onAttach(activity);
	}
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		return inflater.inflate(R.layout.pn_equipage, container, false);
	}
	
	
	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onActivityCreated(savedInstanceState);
		session = new SessionManager(getActivity().getApplicationContext());
	}



public boolean onCreateOptionsMenu(Menu menu) {
	// TODO Auto-generated method stub
	getActivity().getMenuInflater().inflate(R.menu.main_quitter, menu);
    return true;
}

public boolean onMenuItemSelected(int featureId, MenuItem item) {
	session.logoutUser();
	
	return super.getActivity().onMenuItemSelected(featureId, item);
}
}
