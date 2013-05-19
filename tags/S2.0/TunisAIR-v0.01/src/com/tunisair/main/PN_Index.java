package com.tunisair.main;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;

import com.tunisair.libs.SessionManager;

@SuppressLint("NewApi")
public class PN_Index extends Fragment {
	Button btnProg;
	Button btnEquipage;
	SessionManager session;
	
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		return inflater.inflate(R.layout.pn_index,container, false);
	}
	@Override
	public void onAttach(Activity activity) {
		// TODO Auto-generated method stub
		super.onAttach(activity);
	}
	
	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onActivityCreated(savedInstanceState);
		session = new SessionManager(getActivity().getApplicationContext());
		btnProg = (Button) getView().findViewById(R.id.btn_prog);
		btnProg.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				
				Intent intent = new Intent(v.getContext(),PN_Programme.class);
                
                startActivityForResult(intent, 0);
			}
		});
		
		btnEquipage = (Button) getView().findViewById(R.id.btn_equipage);
		btnEquipage.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				PN_Equipage pnE = new PN_Equipage();
				FragmentManager fm = getFragmentManager();
				FragmentTransaction transaction =fm.beginTransaction();
				transaction.replace(R.id.index, pnE);
				transaction.commit();
				
				
			}
		});
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
