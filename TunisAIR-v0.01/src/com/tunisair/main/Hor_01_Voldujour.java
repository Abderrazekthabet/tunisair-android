package com.tunisair.main;



import org.json.JSONArray;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.Toast;

import com.tunisair.libs.UserFunction;
import com.tunisair.main.R;

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
			String de = acPaysDe.getText().toString();
			String a = acPaysA.getText().toString();
			if(isOnline() == false){
				Toast.makeText(getBaseContext(), "Probleme de Cnx", Toast.LENGTH_SHORT).show();
			}else{
					if(de.equals("") || a.equals("")){
						Toast.makeText(getBaseContext(), "Veuillez remplir tous les champs", Toast.LENGTH_SHORT).show();
					}else {
						UserFunction u = new UserFunction();
						JSONArray j = u.horair(de, a);
						if(j != null){
							Intent intent = new Intent(Hor_01_Voldujour.this, Hor_11_voljour_Afficher.class);
							intent.putExtra("de",de);			
							intent.putExtra("a", a);
							startActivityForResult(intent, 0);
						}else {
							Toast.makeText(getBaseContext(), "Destination non prise en charge par TunisAIR", Toast.LENGTH_SHORT).show();
						}
						}
			}
				}
				
		
	});
	
	
}
public boolean isOnline() {
	ConnectivityManager cm = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
    // test for connection
    if (cm.getActiveNetworkInfo() != null
            && cm.getActiveNetworkInfo().isAvailable()
            && cm.getActiveNetworkInfo().isConnected()) {
    	Log.i("isOnline()", "ok");
        return true;
    } else {
    	Log.e("isOnline()", "No");
        return false;
    }  
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
