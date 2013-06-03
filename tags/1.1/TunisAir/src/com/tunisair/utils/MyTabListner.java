package com.tunisair.utils;

import android.annotation.SuppressLint;
import android.app.ActionBar;
import android.app.ActionBar.Tab;

import android.app.FragmentTransaction;
import android.app.Fragment;

import com.tunisair.main.R;


@SuppressLint("NewApi")
public class MyTabListner implements ActionBar.TabListener {
	private Fragment fragment;
	
	public MyTabListner (Fragment _fragment){
		this.fragment = _fragment;
	}
	
	@Override
	public void onTabReselected(Tab tab, FragmentTransaction ft) {
		// TODO Auto-generated method stub
		
	}

	@SuppressLint("NewApi")
	@Override
	public void onTabSelected(ActionBar.Tab tab, FragmentTransaction ft) {
		ft.replace(R.id.index, fragment);
		
	}

	@SuppressLint("NewApi")
	@Override
	public void onTabUnselected(Tab tab, FragmentTransaction ft) {
		ft.remove(fragment);
		
	}

}
