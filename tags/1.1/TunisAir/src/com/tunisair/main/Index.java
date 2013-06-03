package com.tunisair.main;


import java.util.List;
import java.util.Vector;

import com.tunisair.utils.MyPagerAdapter;



import android.annotation.SuppressLint;
import android.app.ActionBar;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;


public class Index extends FragmentActivity  {
		private PagerAdapter mPagerAdapter;

		ViewPager pager;
       
        @SuppressLint("NewApi")
		@Override
        protected void onCreate(Bundle savedInstanceState) {
        	
                super.onCreate(savedInstanceState);
                setContentView(R.layout.index);
                final ActionBar ab = getActionBar();
                ab.hide();
                List<Fragment> fragments = new Vector<Fragment>();

        		// Ajout des Fragments dans la liste
        		fragments.add(Fragment.instantiate(this,Ctact_01_Agence.class.getName()));
        		fragments.add(Fragment.instantiate(this,Home.class.getName()));
        		fragments.add(Fragment.instantiate(this,Authenti_Personel.class.getName()));
                
        		mPagerAdapter = new MyPagerAdapter(super.getSupportFragmentManager(), fragments);
        		
        		pager = (ViewPager) super.findViewById(R.id.pager);
        	
        		// Affectation de l'adapter au ViewPager
        		pager.setAdapter(this.mPagerAdapter);
        		pager.setCurrentItem(1);
                
               
        }
        
        public void onNext(View v){
            
     	    pager.setCurrentItem(pager.getCurrentItem()+1); 
     	   
        }
        public void onBack(View v){
            
     	    pager.setCurrentItem(pager.getCurrentItem()-1); 
     	   
        }

       
       

}
