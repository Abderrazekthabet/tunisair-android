package com.tunisair.main;






import org.json.JSONArray;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.esprit.main.R;
import com.tunisair.libs.HoraireVolAdapter;
import com.tunisair.libs.UserFunction;

public class Hor_11_voljour_Afficher extends Activity {
	TextView tv;
	String de = null ,a= null;
	TextView tvDepart, tvArrivee;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.hor_voljour_afficher);
		Bundle extra = getIntent().getExtras();
		de =extra.getString("de");
		a = extra.getString("a");
		
		tvDepart = (TextView) findViewById(R.id.tv_depart);
		tvDepart.setText("Départ: "+ de);
		tvArrivee = (TextView) findViewById(R.id.tv_arrivee);
		tvArrivee.setText("Arrivée: "+ a);
		

		UserFunction u =new UserFunction();
		JSONArray jArray = u.horair(de ,a);
		BaseAdapter adapter = new HoraireVolAdapter(getApplicationContext(), jArray);
		ListView lv = (ListView) findViewById(R.id.lvhoraire);
		lv.setAdapter(adapter);

		Log.i("TagTest", de +"---+---" +a);
		
	
		
		}
	}


	
