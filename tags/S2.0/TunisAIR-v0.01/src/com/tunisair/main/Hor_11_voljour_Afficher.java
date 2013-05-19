package com.tunisair.main;






import org.json.JSONArray;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.tunisair.libs.HoraireVolAdapter;
import com.tunisair.libs.UserFunction;

@SuppressLint("NewApi")
public class Hor_11_voljour_Afficher extends Fragment {
	TextView tv;
	String de = null ,a= null;
	TextView tvDepart, tvArrivee, tvDate;
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		return inflater.inflate(R.layout.hor_voljour_afficher, container,false);
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
//		Bundle bd = new Bundle();
//		de =bd.getString("de");
//		a = bd.getString("a");
		de = "TUN";
		a= "IST";
		tvDepart = (TextView) getView().findViewById(R.id.tv_depart);
		tvDepart.setText(de);
		tvArrivee = (TextView) getView().findViewById(R.id.tv_arrivee);
		tvArrivee.setText(a);
		tvDate = (TextView) getView().findViewById(R.id.tv_dat);
		
		
		UserFunction u 		= new UserFunction();
		
		JSONArray jArray 	= u.horair(de ,a);
		
		BaseAdapter adapter = new HoraireVolAdapter(getActivity().getApplicationContext(), jArray);
		
		ListView lv = (ListView) getView().findViewById(R.id.lvhoraire);
		lv.setAdapter(adapter);

		
		
	
		
		}
	}




	
