package com.tunisair.libs;

import java.util.ArrayList;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.util.Log;

public class UserFunction {
	JSONParse jParse;
	
    
	String url 					= "http://192.168.1.5/TunisAIR/Index-.php";
    String tag_horaire 			= "horaire_vol";
    String tag_loginUser		= "loginUser";
    String tag_loginPerso		= "loginPerso";
    String tag_programmePerso	= "Programme_Personnele";
    String tag_upDateUser		= "updateUser";
    
    public UserFunction() {
    	jParse = new JSONParse();
	}
	
    
	public JSONArray horair(String _de, String _a ){
			
			try {
				ArrayList<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>();
				nameValuePairs.add(new BasicNameValuePair("tag",tag_horaire));
				nameValuePairs.add(new BasicNameValuePair("depart",_de));
				nameValuePairs.add(new BasicNameValuePair("arrivee",_a));
							
				JSONArray jArray;
				jArray = new JSONArray(jParse.getServerData(url, nameValuePairs));
				Log.i("Funct_Horaire", "t3adda");
				return jArray;
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				Log.e("Funct_Horaire","ErrEEEEUUUUUuuuuurrr");
				e.printStackTrace();
				return null;
			}
	}
	public JSONArray programmePerso(){
		ArrayList<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>();
		nameValuePairs.add(new BasicNameValuePair("tag",tag_programmePerso));
		//nameValuePairs.add(new BasicNameValuePair("matricule",_matricule));
		
		try {
			JSONArray jArray = new JSONArray(jParse.getServerData(url, nameValuePairs));
			Log.i("Funct_Prog_PN", "t3adda");
			return jArray;
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			Log.e("Funct_Prog_PN", "ErrEuur");
			e.printStackTrace();
			return null;
		}
		
		
	}
	
	
	public JSONObject loginUser(String _email, String _password){
		try {
			ArrayList<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>();
			nameValuePairs.add(new BasicNameValuePair("tag",tag_loginUser));
			nameValuePairs.add(new BasicNameValuePair("email",_email));
			nameValuePairs.add(new BasicNameValuePair("pass",_password));
			
			Log.i("Funct_LoginUser", "t3adda");
			
			JSONObject jObject = new JSONObject(jParse.getServerData(url, nameValuePairs));
			
			return jObject;
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			Log.e("Funct_LoginUser", "Erreur");
			return null;
		}
		
		
	}
	public JSONObject loginPerso(String _matricule,String _email, String _password){
		
		
		try {
			ArrayList<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>();
			nameValuePairs.add(new BasicNameValuePair("tag",tag_loginPerso));
			nameValuePairs.add(new BasicNameValuePair("email",_email));
			nameValuePairs.add(new BasicNameValuePair("pass",_password));
			nameValuePairs.add(new BasicNameValuePair("matricule",_matricule));
			
			JSONObject jObject = new JSONObject(jParse.getServerData(url, nameValuePairs));
			Log.i("Funct_LoginPN", "t3adda");
			return jObject;
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			Log.e("Funct_LoginPN", "Erreur");
			e.printStackTrace();
			return null;
		}
		
		
	}
	
	public JSONObject upDateUser(String _nom, String _prenom, String _id){
		ArrayList<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>();
		
		try {
			nameValuePairs.add(new BasicNameValuePair("tag",tag_upDateUser));
			nameValuePairs.add(new BasicNameValuePair("id",_id));
			nameValuePairs.add(new BasicNameValuePair("nom",_nom));
			nameValuePairs.add(new BasicNameValuePair("prenom",_prenom));
			JSONObject jObject = new JSONObject(jParse.getServerData(url, nameValuePairs));
			Log.i("Funct_updateUser", "t3adda");
			return jObject;
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			Log.e("Funct_updateUser", "Erreur");
			e.printStackTrace();
			return null;
		}
	}
	
	
}
