package com.tunisair.main;

import android.annotation.SuppressLint;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;



public class Res_Index extends FragmentActivity  {
	
	
	
	
	
	@SuppressLint("NewApi")
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.res_index);
		
	

		FragmentManager fm = getFragmentManager();
		FragmentTransaction transaction =fm.beginTransaction();
		transaction.replace(R.id.ll_res_index, new Res_Home() );
		transaction.commit();
		
		
	}

	
	
	
	
}
