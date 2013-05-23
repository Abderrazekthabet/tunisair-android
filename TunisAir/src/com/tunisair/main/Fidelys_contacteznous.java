package com.tunisair.main;

import android.os.Bundle;
import android.annotation.SuppressLint;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

@SuppressLint("NewApi")
public class Fidelys_contacteznous extends Fragment {
	 
	
	
	
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

	
	
}
