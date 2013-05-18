package com.tunisair.libs;

import java.util.List;

import com.tunisair.main.R;
import com.tunisair.model.Agence;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.widget.BaseAdapter;
import android.widget.TextView;

public class AgenceAdapter extends BaseAdapter {
	private List<Agence> mAgences;
	private LayoutInflater inflater;

	
	
	
	
	public AgenceAdapter(Context context, List<Agence> mAgences) {
		
		this.mAgences = mAgences;
		this.inflater = LayoutInflater.from(context);
	
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return mAgences.size();
	}

	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return mAgences.get(position);
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		ViewHolder holder;
		if (convertView == null) {
			holder = new ViewHolder();
			
			convertView = inflater.inflate(R.layout.ctact_agence_adapter, parent,false);
			
			holder.txtPays = (TextView) convertView.findViewById(R.id.tv_agPays);
			holder.txtVille = (TextView) convertView.findViewById(R.id.tv_agVille);
			holder.txtAdresse = (TextView) convertView.findViewById(R.id.tv_agAdresse);
			holder.txtTel = (TextView) convertView.findViewById(R.id.tv_agTel);
			holder.txtFax = (TextView) convertView.findViewById(R.id.tv_agFax);
			holder.txtMail = (TextView) convertView.findViewById(R.id.tv_agMail);
			
			convertView.setTag(holder);
			
		} else {
			holder = (ViewHolder) convertView.getTag();
		}
		holder.txtPays.setText("Pays: "+mAgences.get(position).getPays());
		holder.txtVille.setText("Ville: "+mAgences.get(position).getVille());
		holder.txtAdresse.setText("Adresse:"+mAgences.get(position).getAdresse());
		holder.txtTel.setText("Tél: "+mAgences.get(position).getTel());
		holder.txtFax.setText("Fax: "+mAgences.get(position).getFax());
		holder.txtMail.setText("E-Mail: "+mAgences.get(position).getMail());
		
		
		return convertView;
	}
	
	static class ViewHolder{
		public TextView txtPays;
		public TextView txtVille;
		public TextView txtAdresse;
		public TextView txtTel;
		public TextView txtFax;
		
		public TextView txtMail;
	}

}
