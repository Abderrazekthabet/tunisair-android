package com.tunisair.main;

import java.util.HashMap;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import com.tunisair.libs.SessionManager;

@SuppressLint("NewApi")
public class Fidelys_contacteznous extends Fragment {
	 Spinner spSubject;
	 EditText etEmail;
	 Button btnEnvoyer;
	 SessionManager session;
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		View v = inflater.inflate(R.layout.fidelys_contacteznous, container, false);
		Spinner sp = (Spinner) v.findViewById(R.id.sp_ctns);
		ArrayAdapter<CharSequence> adSp = ArrayAdapter.createFromResource(this.getActivity(), R.array.Type_Reclam, android.R.layout.simple_spinner_item);
		adSp.setDropDownViewResource(android.R.layout.simple_spinner_item);
		sp.setAdapter(adSp);
		
		return v;
	}
@Override
public void onAttach(Activity activity) {
	// TODO Auto-generated method stub
	super.onAttach(activity);
}

@Override
public void onActivityCreated(Bundle savedInstanceState) {
	// TODO Auto-generated method stub
	super.onActivityCreated(savedInstanceState);
	spSubject = (Spinner) getView().findViewById(R.id.sp_ctns);
	etEmail = (EditText) getView().findViewById(R.id.et_email);
	
	btnEnvoyer = (Button) getView().findViewById(R.id.envoi);
	
	btnEnvoyer.setOnClickListener(new OnClickListener() {
		
		@Override
		public void onClick(View v) {
			session = new SessionManager(getActivity().getApplicationContext());
	        HashMap<String, String> user = session.getUserDetails();
	    	String result = user.get(SessionManager.KEY_id);	
	    	
		//		JSONObject j=j.getString("E_mail");
				
				//	j = new JSONObject(result);
					Intent intent = new Intent(Intent.ACTION_SEND); 
					   intent.setType("plain/text");
					   intent.putExtra(Intent.EXTRA_EMAIL, "bouchouchaslim@gmail.com");  
					   intent.putExtra(Intent.EXTRA_SUBJECT, "testobjet"); 
					   intent.putExtra(Intent.EXTRA_TEXT, etEmail.getText()); 
					   startActivity(Intent.createChooser(intent, "c"));
					  
		}
	});
	
	
	
}
	
	
}
