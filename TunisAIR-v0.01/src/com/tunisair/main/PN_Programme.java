package com.tunisair.main;

import java.util.HashMap;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.app.Activity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.ViewGroup.LayoutParams;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import com.tunisair.libs.SessionManager;
import com.tunisair.libs.UserFunction;

public class PN_Programme extends Activity {
		LayoutParams params;
		SessionManager session;
		TableRow  tabRow;
        @Override
        protected void onCreate(Bundle savedInstanceState) {
                // TODO Auto-generated method stub
                super.onCreate(savedInstanceState);
                setContentView(R.layout.pn_programme);
                  
                 
               
                session = new SessionManager(getApplicationContext());
       
                HashMap<String, String> user = session.getUserDetails();
            	String result = user.get(SessionManager.KEY_id);
            	try {
					JSONObject j = new JSONObject(result);
					 UserFunction u = new UserFunction();
		             JSONArray jArray = u.programmePerso(j.getString("TLC"));
				
               
               
               
                TableLayout tab;
                tab = (TableLayout) findViewById(R.id.tab_programe);
               
                for (int i=0; i<jArray.length();i++) {
                        JSONObject jObject;
                        jObject = jArray.getJSONObject(i);
                    
                    tab.addView(afficher(jObject, params));
                }
            	} catch (JSONException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
               
               
               
        }
        
        public TableRow afficher(JSONObject _jObject,LayoutParams ly) {
        	tabRow = new TableRow(this);
        	//tabRow.setLayoutParams(new LayoutParams(LayoutParams.WRAP_CONTENT,LayoutParams.WRAP_CONTENT));
        	
        	
        	try {
                tabRow.addView(generateTextView(_jObject.getString("num_vol")));
            	tabRow.addView(generateTextView(_jObject.getString("date_dep")));
            	tabRow.addView(generateTextView(_jObject.getString("temp_dep")));
            	tabRow.addView(generateTextView(_jObject.getString("date_arr")));
            	tabRow.addView(generateTextView(_jObject.getString("temp_arr")));
            	tabRow.addView(generateTextView(_jObject.getString("airport_dep")));
            	tabRow.addView(generateTextView(_jObject.getString("airprt_arr")));
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        	
        	
        	
        	return tabRow;
        }
        
        
        public TextView generateTextView(String text){
        	TextView result = new TextView(this,null ,R.style.frag1Col);
        	
        	
        	result.setText(text);
        	result.setTextSize(14);
        	
        	result.setGravity(Gravity.CENTER);
        	
        	return result;
        	
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

