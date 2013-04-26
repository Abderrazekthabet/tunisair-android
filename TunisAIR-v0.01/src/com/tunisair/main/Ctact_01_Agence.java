package com.tunisair.main;

import java.io.InputStream;
import java.util.ArrayList;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.InputSource;
import org.xml.sax.XMLReader;

import android.app.Activity;
import android.content.Intent;
import android.content.res.AssetManager;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.Spinner;

import com.esprit.main.R;
import com.tunisair.libs.AgenceAdapter;
import com.tunisair.libs.OrderXMLHandler;
import com.tunisair.model.Agence;


public class Ctact_01_Agence extends Activity {
	ImageButton imgbtn;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.ctact_agence);
		imgbtn = (ImageButton) findViewById(R.id.imgcarte);
		imgbtn.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(v.getContext(),Ctact_11_Maps.class);
				startActivityForResult(intent, 0);
			}
		});
		ArrayList<Agence> _agences = getParseXML();
		final ArrayList<String> _magences = new ArrayList<String>();
		_magences.add(_agences.get(0).getPays());
		int i =0;
		for (Agence agence : _agences ) {
			
			
				for (String agence0 : _magences) {
					if (agence0.equals(agence.getPays())) {
						i=1;
					}	
				}
				if(i==0){
					_magences.add(agence.getPays());
				}
				i=0;	
			}
		
		
		
		Spinner spiPays = (Spinner) findViewById(R.id.spPays);
		ArrayAdapter<CharSequence> 	adapterSpi = new ArrayAdapter<CharSequence>(getApplicationContext(), android.R.layout.simple_spinner_item);
									adapterSpi.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
									for(String agence : _magences){																		
										adapterSpi.add(agence);
									}
								
									spiPays.setAdapter(adapterSpi);
		spiPays.setOnItemSelectedListener(new OnItemSelectedListener() {

			@Override
			public void onItemSelected(AdapterView<?> arg0, View arg1,
					int position, long arg3) {
				ListView lv = (ListView) findViewById(R.id.lvListeagence);

				
				
				ArrayList<Agence> agences = getParseXML();
				ArrayList<Agence> magences = new ArrayList<Agence>();
				
				for (Agence agence : agences ) {
					if(agence.getPays().equals(_magences.get(position)) ){
						magences.add(agence);
					}
				}	
				BaseAdapter adapter = new AgenceAdapter(getApplicationContext(), magences);
				lv.setAdapter(adapter);
			}

			@Override
			public void onNothingSelected(AdapterView<?> arg0) {
				// TODO Auto-generated method stub
				
			}
		});
									
									
		
		
	}

	private ArrayList<Agence> getParseXML() {
		AssetManager assetManager = getBaseContext().getAssets();
		try {
			InputStream is = assetManager.open("agence-tu.xml");
			SAXParserFactory spf = SAXParserFactory.newInstance();
			SAXParser sp = spf.newSAXParser();
			XMLReader xr = sp.getXMLReader();
			
			OrderXMLHandler myXMLHandler = new OrderXMLHandler();
			xr.setContentHandler(myXMLHandler);
			InputSource inStream = new InputSource(is);
			xr.parse(inStream);
			ArrayList<Agence> agences = myXMLHandler.getAgences();
			return agences;
	
		} catch (Exception e) {
			return null;
		}
	}
	
	

}
