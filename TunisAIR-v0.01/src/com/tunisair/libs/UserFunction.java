package com.tunisair.libs;

import java.util.ArrayList;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.util.Log;

public class UserFunction {

	
    
	String url 					= "http://192.168.1.3/TunisAIR/Index-.php";
    String tag_horaire 			= "horaire_vol";
    String tag_loginUser		= "loginUser";
    String tag_loginPerso		= "loginPerso";
    String tag_programmePerso	= "Programme_Personnele";
    String tag_upDateUser		= "upDate User";
	
	public JSONArray horair(String _de, String _a ){
			
			try {
				ArrayList<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>();
				nameValuePairs.add(new BasicNameValuePair("tag",tag_horaire));
				nameValuePairs.add(new BasicNameValuePair("depart",_de));
				nameValuePairs.add(new BasicNameValuePair("arrivee",_a));
				JSONParse j = new JSONParse();			
				JSONArray jArray;
				jArray = new JSONArray(j.getServerData(url, nameValuePairs));
				Log.i("User_Func", "t3adda");
				return jArray;
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				Log.e("USER_Erre","ErrEEEEUUUUUuuuuurrr");
				e.printStackTrace();
				return null;
			}
	}
	public JSONArray programmePerso(){
		ArrayList<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>();
		nameValuePairs.add(new BasicNameValuePair("tag",tag_programmePerso));
		//nameValuePairs.add(new BasicNameValuePair("matricule",_matricule));
		JSONParse jParse = new JSONParse();
		try {
			JSONArray jArray = new JSONArray(jParse.getServerData(url, nameValuePairs));
			return jArray;
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		
		
	}
	
	
	public JSONObject loginUser(String _email, String _password){
		
		ArrayList<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>();
		nameValuePairs.add(new BasicNameValuePair("tag",tag_loginUser));
		nameValuePairs.add(new BasicNameValuePair("depart",_email));
		nameValuePairs.add(new BasicNameValuePair("arrivee",_password));
		JSONParse j = new JSONParse();
		try {
			JSONObject jObject = new JSONObject(j.getServerData(url, nameValuePairs));
			return jObject;
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		
		
	}
	public JSONObject loginPerso(String _matricule,String _email, String _password){
		
		ArrayList<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>();
		nameValuePairs.add(new BasicNameValuePair("tag",tag_loginPerso));
		nameValuePairs.add(new BasicNameValuePair("depart",_email));
		nameValuePairs.add(new BasicNameValuePair("arrivee",_password));
		nameValuePairs.add(new BasicNameValuePair("matricule",_matricule));
		JSONParse j = new JSONParse();
		try {
			JSONObject jObject = new JSONObject(j.getServerData(url, nameValuePairs));
			return jObject;
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		
		
	}
	
	public JSONObject upDateUser(String _nom, String _prenom, String _email,String _pass){
		ArrayList<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>();
		nameValuePairs.add(new BasicNameValuePair("tag",tag_upDateUser));
		nameValuePairs.add(new BasicNameValuePair("nom",_nom));
		nameValuePairs.add(new BasicNameValuePair("prenom",_prenom));
		nameValuePairs.add(new BasicNameValuePair("email",_email));
		nameValuePairs.add(new BasicNameValuePair("pass",_pass));
		JSONParse jParse = new JSONParse();
		try {
			JSONObject jObject = new JSONObject(jParse.getServerData(url, nameValuePairs));
			return jObject;
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	

}
