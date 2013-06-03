package com.tunisair.main;




import java.util.ArrayList;

import android.annotation.SuppressLint;
import android.app.ActionBar;
import android.location.Location;
import android.location.LocationListener;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.tunisair.model.Agence;
import com.tunisair.utils.ParseXML;


public class Ctact_11_Maps extends FragmentActivity implements LocationListener {
       
        GoogleMap googlemap;
        ActionBar ab;
       
        @SuppressLint("NewApi")
		@Override
        protected void onCreate(Bundle savedInstanceState) {
                super.onCreate(savedInstanceState);
                setContentView(R.layout.ctact_maps);
                String pays = getIntent().getExtras().getString("pays");
                             
                initMap();
                addTwittertoMap(pays);
                ab = getActionBar();
                ab.hide();
               
        }
       
        private void initMap() {
                SupportMapFragment mf =(SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.gmap);
               
                googlemap = mf.getMap();
                googlemap.setMyLocationEnabled(true);
                googlemap.setMapType(GoogleMap.MAP_TYPE_NORMAL);
        }
       
        private void addTwittertoMap(String _pays) {
               
               
                        ParseXML pXML = new ParseXML();
                        
                        ArrayList<Agence> agences = pXML.getParseXML(getApplicationContext());
                               
                               
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
