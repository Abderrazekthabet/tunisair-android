package com.tunisair.main;

import com.tunisair.libs.SessionManager;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.Button;

@SuppressLint("NewApi")
public class PN_home extends Fragment {
	Button btnProg;
	Button btnEquipage;
	SessionManager session;
	
	@Override
	public void onAttach(Activity activity) {
		session = new SessionManager(getActivity().getApplicationContext());
		session.checkLogin();
		super.onAttach(activity);
	}
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		return inflater.inflate(R.layout.pn_home, container, false);
		
	}

	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onActivityCreated(savedInstanceState);
		
		session.checkLogin();
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
				transaction.replace(R.id.ll_pn_index, pnE);
				transaction.commit();
				
				
			}
		});
		
		
		
		
	}
	
}
