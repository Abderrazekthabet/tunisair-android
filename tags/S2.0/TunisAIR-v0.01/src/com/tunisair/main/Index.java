package com.tunisair.main;

import com.tunisair.resource.MyTabListner;

import android.annotation.SuppressLint;
import android.app.ActionBar;
import android.app.Fragment;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;


public class Index extends FragmentActivity  {
       
       
        @SuppressLint("NewApi")
		@Override
        protected void onCreate(Bundle savedInstanceState) {
                super.onCreate(savedInstanceState);
                setContentView(R.layout.index);
                final ActionBar ab = getActionBar();
                ab.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);
                ab.setDisplayShowHomeEnabled(false);
                ab.setDisplayShowTitleEnabled(false);
                ab.setDisplayShowCustomEnabled(false);
                Fragment ctact_agence= new Ctact_01_Agence();
                Fragment fiDelys = new Authenti_User(); 
                Fragment pn = new Authenti_Personel();
                Fragment hv = new Hor_01_Voldujour();
                Fragment ac = new Actualite();
                
                ab.addTab(ab.newTab().setText("Actualité").setTabListener(new MyTabListner(ac)));
                ab.addTab(ab.newTab().setText("Horaire Vol").setTabListener(new MyTabListner(hv)));
                ab.addTab(ab.newTab().setText("Contactez-Nous").setTabListener(new MyTabListner(ctact_agence)));
                ab.addTab(ab.newTab().setText("Espace Fidelys").setTabListener(new MyTabListner(fiDelys)));
                ab.addTab(ab.newTab().setText("Espace PN").setTabListener(new MyTabListner(pn)));
               
        }

       
       

}
