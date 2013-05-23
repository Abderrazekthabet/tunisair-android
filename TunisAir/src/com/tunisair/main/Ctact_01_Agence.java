package com.tunisair.main;

import java.io.InputStream;
import java.util.ArrayList;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.InputSource;
import org.xml.sax.XMLReader;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.content.res.AssetManager;
import android.os.Bundle;

import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.BaseAdapter;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.Spinner;

import com.tunisair.libs.AgenceAdapter;
import com.tunisair.libs.OrderXMLHandler;
import com.tunisair.model.Agence;


@SuppressLint("NewApi")
public class Ctact_01_Agence extends Fragment {
        ImageButton imgbtn;
        AutoCompleteTextView acPays;
        Spinner spiPays;
        ArrayList<Agence> agences; 
        String paysIntent = "" ;
        
        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
        	Bundle savedInstanceState) {
        	
        // TODO Auto-generated method stub
        return inflater.inflate(R.layout.ctact_agence,container, false);
        }
        @SuppressLint("NewApi")
		@Override
        public void onAttach(Activity activity) {
        // TODO Auto-generated method stub
        super.onAttach(activity);
        }
        @SuppressLint("NewApi")
		@Override
        public void onActivityCreated(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onActivityCreated(savedInstanceState);
        findView();
        }
        
        
                
                
                
               
                        
        

        private ArrayList<Agence> getParseXML() {
                AssetManager assetManager = getActivity().getBaseContext().getAssets();
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
  
        private void findView(){
        	agences = getParseXML();
        	
        	
        	imgbtn = (ImageButton) getView().findViewById(R.id.imgcarte);
            imgbtn.setOnClickListener(new OnClickListener() {
                   
                    @Override
                    public void onClick(View v) {
                            Intent intent = new Intent(v.getContext(),Ctact_11_Maps.class);
                            intent.putExtra("pays", "");
                            startActivityForResult(intent, 0);
                    }
            });
        	
            final ArrayList<String> agencesPays = new ArrayList<String>();
            
            int i =0;
        	for (Agence agence : agences ) {
                
                
                for (String agence0 : agencesPays) {
                        if (agence0.equals(agence.getPays())) {
                                i=1;
                        }      
                }
                if(i==0){
                	agencesPays.add(agence.getPays());
                }
                i=0; 
        	}
        	
        	
        	acPays = (AutoCompleteTextView) getView().findViewById(R.id.ac_pays);
        	ArrayAdapter<String> adapterPays =
        			new ArrayAdapter<String>(this.getActivity(), android.R.layout.simple_list_item_1, agencesPays);
        	acPays.setAdapter(adapterPays);
        	
        
        	
        	acPays.setOnItemClickListener(new OnItemClickListener() {

				@Override
				public void onItemClick(AdapterView<?> arg0, View arg1,
						int position, long arg3) {
                  // paysIntent = agencesPays.get(position);
                   final ArrayList<String> agencesVilles = new ArrayList<String>();
                   paysIntent = acPays.getText().toString();
                   int i =0;
               	for (Agence agence : agences ) {
                       
                       
                       for (String agence0 : agencesVilles) {
                               if (agence0.equals(agence.getVille())) {
                                       i=1;
                               }      
                       }
                       if(i==0 && agence.getPays().equals(paysIntent)){
                    	   agencesVilles.add(agence.getVille());
                       }
                       i=0; 
               	}
               	
               	imgbtn.setOnClickListener(new OnClickListener() {
                    
                    @Override
                    public void onClick(View v) {
                            Intent intent = new Intent(v.getContext(),Ctact_11_Maps.class);
                            intent.putExtra("pays", paysIntent);
                            startActivityForResult(intent, 0);
                    }
            });
               	   
                	spiPays = (Spinner) getView().findViewById(R.id.sp_Ville);
                	spiPays.setVisibility(1);
                	ArrayAdapter<CharSequence>      adapterSpi = new ArrayAdapter<CharSequence>(getActivity().getApplicationContext(), android.R.layout.simple_spinner_item);
                                                                          adapterSpi.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                                                                          for(String agence : agencesVilles){                                                                                                                                        
                                                                                  adapterSpi.add(agence);
                                                                          }
                                                                 
                                                                          spiPays.setAdapter(adapterSpi);
                  spiPays.setOnItemSelectedListener(new OnItemSelectedListener() {
  
                          @Override
                          public void onItemSelected(AdapterView<?> arg0, View arg1,
                                          int position, long arg3) {
                                  ListView lv = (ListView) getView().findViewById(R.id.lvListeagence);
  
                                 
                                 
                                 
                                  ArrayList<Agence> magences = new ArrayList<Agence>();
                                 
                                  for (Agence agence : agences ) {
                                          if(agence.getVille().equals(agencesVilles.get(position)) ){
                                                  magences.add(agence);
                                          }
                                  }      
                                  BaseAdapter adapter = new AgenceAdapter(getActivity().getApplicationContext(), magences);
                                  lv.setAdapter(adapter);
                          }
  
                          @Override
                          public void onNothingSelected(AdapterView<?> arg0) {
                                  // TODO Auto-generated method stub
                                 
                          }
                  });
					
				}
			});
        }
       
       

}
