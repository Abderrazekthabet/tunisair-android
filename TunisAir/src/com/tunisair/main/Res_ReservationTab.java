package com.tunisair.main;


import android.annotation.SuppressLint;
import android.app.ActionBar;
import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.tunisair.utils.MyTabListner;



@SuppressLint("NewApi")
public class Res_ReservationTab extends Fragment{
	ActionBar ab;
	
	
	@Override
	public void onAttach(Activity activity) {
		// TODO Auto-generated method stub
		super.onAttach(activity);
	}
	
@Override
public View onCreateView(LayoutInflater inflater, ViewGroup container,
		Bundle savedInstanceState) {
	// TODO Auto-generated method stub
	return inflater.inflate(R.layout.res_tab, container, false);
}
	
	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onActivityCreated(savedInstanceState);
		ab = getActivity().getActionBar();
		ab.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);
		
		
//		ab.addTab(ab.newTab().setText("Reservation").setTabListener(new MyTabListner(new Res_Aff_Reservation())));
//		ab.addTab(ab.newTab().setText("Méteo").setTabListener(new MyTabListner(new Res_Meteo())));
//		ab.addTab(ab.newTab().setText("Conversion").setTabListener(new MyTabListner(new Res_Conversion())));
		
		
	}
	
	



}
