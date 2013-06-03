package com.tunisair.utils;

import java.io.InputStream;
import java.util.ArrayList;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.InputSource;
import org.xml.sax.XMLReader;

import android.content.Context;
import android.content.res.AssetManager;

import com.tunisair.libs.OrderXMLHandler;
import com.tunisair.model.Agence;

public class ParseXML {
	
	public ArrayList<Agence> getParseXML(Context context) {
		 
         AssetManager assetManager = context.getAssets();
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
