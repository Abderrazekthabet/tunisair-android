package com.tunisair.libs;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.esprit.main.R;

import android.content.Context;
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
			holder.numVol = (TextView) convertView.findViewById(R.id.tv1_voljour);
			holder.destDepart = (TextView) convertView.findViewById(R.id.tv2_voljour);
			holder.destArrivee= (TextView) convertView.findViewById(R.id.tv3_voljour);
			convertView.setTag(holder);
		}else {
			holder = (ViewHolder) convertView.getTag();
		}
		
		try {
			jsonObject = jArray.getJSONObject(position);
			holder.numVol.setText("Num Vol: "+ jsonObject.getString("Num_vol"));
			holder.destDepart.setText("Départ: "+ jsonObject.getString("Destination_depart"));
			holder.destArrivee.setText("Arrivée: "+ jsonObject.getString("Destination_arrivee"));
			
			
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return convertView;
	}
	static class ViewHolder{
		public TextView numVol;
		public TextView destDepart;
		public TextView destArrivee;

		
	}
}
