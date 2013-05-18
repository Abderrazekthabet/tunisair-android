package com.tunisair.main;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import com.tunisair.libs.SessionManager;
import com.tunisair.libs.UserFunction;
import com.tunisair.main.R;

public class PN_Programme extends Activity {
       
		SessionManager session;
	
        @Override
        protected void onCreate(Bundle savedInstanceState) {
                // TODO Auto-generated method stub
                super.onCreate(savedInstanceState);
                setContentView(R.layout.pn_programme);
                session = new SessionManager(getApplicationContext());
       
               
               
                UserFunction u = new UserFunction();
                JSONArray jArray = u.programmePerso();
               
                TableLayout tab;
                tab = (TableLayout) findViewById(R.id.tab_programe);
       
                for (int i=0; i<jArray.length();i++) {
                        JSONObject jObject;
                        try {
                                jObject = jArray.getJSONObject(i);
                               
                                TableRow tr = new TableRow(this);
                               
                                TextView tvTLC =new TextView(this);
                                tvTLC.setText(jObject.getString("TLC"));
                                tr.addView(tvTLC);
                               
                                TextView tvSecteur =new TextView(this);
                                tvSecteur.setText(jObject.getString("secteur"));
                                tr.addView(tvSecteur);
                               
                               
                                tab.addView(tr);
                               
                        } catch (JSONException e) {
                                // TODO Auto-generated catch block
                                e.printStackTrace();
                        }
                       
                       
                               
                               
                       
                       
                       
                }
               
               
               
        }
        
        @Override
    	public boolean onCreateOptionsMenu(Menu menu) {
    		// TODO Auto-generated method stub
    		getMenuInflater().inflate(R.menu.main_quitter, menu);
            return true;
    	}
    	
    	@Override
    	public boolean onMenuItemSelected(int featureId, MenuItem item) {
    		session.logoutUser();
    		finish();
    		return super.onMenuItemSelected(featureId, item);
    	}
        
}

