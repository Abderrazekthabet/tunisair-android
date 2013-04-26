package com.tunisair.main;



import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;

import com.esprit.main.R;

public class Hor_01_Voldujour extends Activity {
	 AutoCompleteTextView acPaysDe;
	 AutoCompleteTextView acPaysA;
	
	private Button btnRecherche;
	
	
	
@Override
protected void onCreate(Bundle savedInstanceState) {
	// TODO Auto-generated method stub
	super.onCreate(savedInstanceState);
	setContentView(R.layout.hor_vol_recherche);
	
	
	
	findViews();
	
	btnRecherche = (Button) findViewById(R.id.btnRVol);
	btnRecherche.setOnClickListener(new OnClickListener() {
		
		@Override
		public void onClick(View v) {
			
				Intent intent = new Intent(Hor_01_Voldujour.this, Hor_11_voljour_Afficher.class);
				
				intent.putExtra("de", acPaysDe.getText().toString());			
				intent.putExtra("a", acPaysA.getText().toString());
				
				Log.i("Tag_1", acPaysDe.getText() + "*****"+acPaysA.getText());
				
				startActivityForResult(intent, 0);
				
			
		}
	});
	
	
}

private void findViews() {
	acPaysDe = (AutoCompleteTextView) findViewById(R.id.acTVde);
	acPaysA = (AutoCompleteTextView) findViewById(R.id.acTVa);
	String[] pays =
	getResources().getStringArray(R.array.Liste_Pays);
	ArrayAdapter<String> adapterPays =
			new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, pays);
	acPaysDe.setAdapter(adapterPays);
	acPaysA.setAdapter(adapterPays);
}


}
