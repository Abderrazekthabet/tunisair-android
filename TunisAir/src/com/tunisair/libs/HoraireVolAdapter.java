package com.tunisair.libs;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.tunisair.main.R;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class HoraireVolAdapter extends BaseAdapter {
	private JSONArray jArray;
	private LayoutInflater layoutInflater;
	private JSONObject jsonObject;
	
	
	public HoraireVolAdapter(Context context, JSONArray mjArray) {
		this.jArray = mjArray;
		this.layoutInflater = LayoutInflater.from(context);
		
	}
	
	
	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return jArray.length();
	}

	@Override
	public Object getItem(int position) {
		
		return position;
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		ViewHolder holder;
		if (convertView ==  null) {
			
			holder = new ViewHolder();
			convertView = layoutInflater.inflate(R.layout.hor_voljour__affiche_adapter,parent, false);
			holder.numVol = (TextView) convertView.findViewById(R.id.tv_numvol);
			holder.destDepart = (TextView) convertView.findViewById(R.id.tv_depart);
			holder.destArrivee= (TextView) convertView.findViewById(R.id.arrivee);
			holder.hdepart = (TextView) convertView.findViewById(R.id.dep_prog) ;
			holder.harrivee =(TextView) convertView.findViewById(R.id.arr_prog);
			
			convertView.setTag(holder);
		}else {
			holder = (ViewHolder) convertView.getTag();
		}
		
		try {
			jsonObject = jArray.getJSONObject(position);
			holder.numVol.setText(jsonObject.getString("numero"));
			holder.destDepart.setText(jsonObject.getString("depart"));
			holder.destArrivee.setText(jsonObject.getString("arrivee"));
			holder.hdepart.setText(jsonObject.getString("dep_prog"));
			holder.harrivee.setText(jsonObject.getString("arr_prog"));
			
			
		} catch (JSONException e) {
			Log.e("Adapter VolJ", "Erreur");
			e.printStackTrace();
		}
		
		return convertView;
	}
	static class ViewHolder{
		public TextView numVol;
		public TextView destDepart;
		public TextView destArrivee;
		public TextView hdepart;
		public TextView harrivee;
		

		
	}
}
