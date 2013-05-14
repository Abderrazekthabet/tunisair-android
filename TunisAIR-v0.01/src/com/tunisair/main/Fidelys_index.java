package com.tunisair.main;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.widget.Button;

import com.tunisair.main.R;

public class Fidelys_index extends FragmentActivity  {
	Button btnModif;
	
	
	@Override
	protected void onCreate(Bundle arg0) {
		// TODO Auto-generated method stub
		super.onCreate(arg0);
		setContentView(R.layout.fidelys_index);
		FragmentManager fm = getSupportFragmentManager();
		FragmentTransaction transaction =fm.beginTransaction();
		Fidelys_profil fp = new Fidelys_profil();
		transaction.replace(R.id.ll_profile, fp);
		transaction.commit();
		
		
		
	}
	
	
	public void onClickV(View v){
		Fragment fr = null;
		
		fr = new Fidelys_modifProfil();
		
		
		FragmentManager fm = getSupportFragmentManager();
		FragmentTransaction transaction =fm.beginTransaction();
		transaction.setCustomAnimations(android.R.anim.slide_in_left, android.R.anim.slide_out_right);
		transaction.replace(R.id.ll_profile, fr);
		transaction.addToBackStack(null);
		transaction.commit();
		
	}
	
	

}
