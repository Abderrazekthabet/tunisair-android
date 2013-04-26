package com.tunisair.main;


import android.app.TabActivity;
import android.content.Intent;
import android.widget.TabHost;
import android.widget.TabHost.OnTabChangeListener;
import android.widget.TabHost.TabSpec;

import com.esprit.main.R;



@SuppressWarnings("deprecation")
public class Res_11_ReservationTab extends TabActivity implements OnTabChangeListener{
	private TabHost tabHost;
	
	
	protected void onCreate(android.os.Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.res_mesreservation);
		tabHost = (TabHost) findViewById(android.R.id.tabhost);
		tabHost.setOnTabChangedListener(this);
		tabHost.setup();
		
		Intent intent1 = new Intent(this,Res_21_Aff_Reservation.class);
		
		addTab("Tab1", "Reservation", R.drawable.ic_avion,intent1);
		
		Intent intent2 = new Intent(this,Res_22_Meteo.class);
		addTab("Tab2", "Méteo", R.drawable.ic_meteo, intent2);
		
		Intent intent3 = new Intent(this,Res_23_Conversion.class);
		addTab("Tab3", "Convertion",R.drawable.ic_conversion, intent3);
		
	};
	
	private void addTab(String tag,String title, int icon, Intent content){
	
		TabSpec spec = tabHost.newTabSpec(tag);
		spec.setIndicator(title,getResources().getDrawable(icon));
		spec.setContent(content);
		tabHost.addTab(spec);
	}

	@Override
	public void onTabChanged(String tabId) {
		
	}



}
