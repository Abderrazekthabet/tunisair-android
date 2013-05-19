package com.tunisair.main;




import java.io.InputStream;
import java.util.ArrayList;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.InputSource;
import org.xml.sax.XMLReader;

import android.content.res.AssetManager;
import android.location.Location;
import android.location.LocationListener;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.tunisair.libs.OrderXMLHandler;
import com.tunisair.model.Agence;


public class Ctact_11_Maps extends FragmentActivity implements LocationListener {
       
        GoogleMap googlemap;
        
       
        @Override
        protected void onCreate(Bundle savedInstanceState) {
                super.onCreate(savedInstanceState);
                setContentView(R.layout.ctact_maps);
                String pays = getIntent().getExtras().getString("pays");
                             
                initMap();
                addTwittertoMap(pays);
               
        }
       
        private void initMap() {
                SupportMapFragment mf =(SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.gmap);
               
                googlemap = mf.getMap();
                googlemap.setMyLocationEnabled(true);
                googlemap.setMapType(GoogleMap.MAP_TYPE_NORMAL);
        }
       
        private void addTwittertoMap(String _pays) {
               
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
                               
                               
                        for (Agence agence : agences) {
                        	if(_pays.equals("")){
                        	double la,lon;
                            String title="";
                            String snippet="";
                            title = agence.getVille();
                            snippet = agence.getAdresse();
                            la = Double.parseDouble(agence.getLat());
                            lon = Double.parseDouble(agence.getLongi());
                            LatLng pos = new LatLng(la, lon);
                            googlemap.addMarker(new MarkerOptions()
                             .title(title)
                             .snippet(snippet)
                             .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_BLUE))
                             .position(pos));}else if(_pays.equals(agence.getPays())){
                        	double la,lon;
                            String title="";
                            String snippet="";
                            title = agence.getVille();
                            snippet = agence.getAdresse();
                            la = Double.parseDouble(agence.getLat());
                            lon = Double.parseDouble(agence.getLongi());
                            LatLng pos = new LatLng(la, lon);
                            googlemap.addMarker(new MarkerOptions()
                             .title(title)
                             .snippet(snippet)
                             .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_BLUE))
                             .position(pos));}
                                
                        }

                } catch (Exception e) {}
                       
               
        }
       
        @Override
        public void onLocationChanged(Location location) {
                // TODO Auto-generated method stub
               
        }
        @Override
        public void onProviderDisabled(String provider) {
                // TODO Auto-generated method stub
               
        }
        @Override
        public void onProviderEnabled(String provider) {
                // TODO Auto-generated method stub
               
        }
        @Override
        public void onStatusChanged(String provider, int status, Bundle extras) {
                // TODO Auto-generated method stub
               
        }
       

}
