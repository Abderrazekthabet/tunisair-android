package com.tunisair.utils;

import java.util.List;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class MyPagerAdapter extends FragmentPagerAdapter {

	private final List<Fragment> fragments;

	//On fournit � l'adapter la liste des fragments � afficher
	public MyPagerAdapter(FragmentManager fm, List<Fragment> fragments) {
		super(fm);
		this.fragments = fragments;
	}

	public Fragment getItem(int position) {
		
		return this.fragments.get(position);
	}

	public int getCount() {
		return this.fragments.size();
	}
	
	
	


}
