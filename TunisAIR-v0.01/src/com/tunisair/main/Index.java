package com.tunisair.main;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

import com.esprit.main.R;
import com.tunisair.resource.ActionBarView.OnDispatchClickListener;


public class Index extends Activity implements OnDispatchClickListener  {
	Button btnAgence;
	Button btnVoljr;
	Button btnReservation;
	Button btnFidelys;
	Button btnPN;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.index);
//		mActionBar = (ActionBarView) findViewById(R.id.actionbar);
//		mActionBar.setOnDispatchClickListener(this);
		addListenerOnButton();
		
		
	}

	private void addListenerOnButton() {
		
		
		
		btnAgence = (Button) findViewById(R.id.btnagence) ;
		btnAgence.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(v.getContext(),Ctact_01_Agence.class);
				startActivityForResult(intent, 0);
			}
		});
		btnVoljr = (Button) findViewById(R.id.btnvoldujours);
		btnVoljr.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(v.getContext(), Hor_01_Voldujour.class);
				startActivityForResult(intent, 0);
			}
		});
		btnReservation = (Button) findViewById(R.id.btnreservation);
		btnReservation.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(v.getContext(), Res_01_Index.class);
				startActivityForResult(intent, 0);
				
			}
		});
		btnFidelys = (Button) findViewById(R.id.btnfidelys);
		btnFidelys.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(v.getContext(), Res_01_Index.class);
				startActivityForResult(intent, 0);
				
			}
		});
		
		btnPN = (Button) findViewById(R.id.btnpn);
		btnPN.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(v.getContext(),PN_Index.class);
				startActivityForResult(intent, 0);
			}
		});
		
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public void onDispatchClick(int id) {
		
	}

	

}
