package com.tunisair.libs;

import java.util.ArrayList;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import com.tunisair.model.Agence;

public class OrderXMLHandler extends DefaultHandler {
	boolean currentElement = false;
	String currentValue = "";
	
	Agence agence;
	ArrayList<Agence> agences = new ArrayList<Agence>();
	
	public ArrayList<Agence> getAgences() {
		return agences;
	}
	public void setAgences(ArrayList<Agence> agences) {
		this.agences = agences;
	}
	
	@Override
	public void startElement(String uri, String localName, String qName,
			Attributes attributes) throws SAXException {
			currentElement = true;
			if (qName.equals("agence")) {
				agence = new Agence();
			}
	}
	
	@Override
	public void endElement(String uri, String localName, String qName)
			throws SAXException {
		
		currentElement = false;
		if (qName.equalsIgnoreCase("pays")) {
			agence.setPays(currentValue.trim());
		}else if (qName.equalsIgnoreCase("ville")) {
			agence.setVille(currentValue.trim());
		}else if (qName.equalsIgnoreCase("adresse")) {
			agence.setAdresse(currentValue.trim());
		}if (qName.equalsIgnoreCase("tel")) {
			agence.setTel(currentValue.trim());
		}else if (qName.equalsIgnoreCase("fax")) {
			agence.setFax(currentValue.trim());
		}if (qName.equalsIgnoreCase("mail")) {
			agence.setMail(currentValue.trim());
		}else if (qName.equalsIgnoreCase("latitude")) {
			agence.setLat(currentValue.trim());
		}if (qName.equalsIgnoreCase("longitude")) {
			agence.setLongi(currentValue.trim());
		}else if (qName.equalsIgnoreCase("agence")) {
			agences.add(agence);
		}
		
		currentValue = "";
		
		
	}
	
	@Override
	public void characters(char[] ch, int start, int length)
			throws SAXException {
		if (currentElement) {
			currentValue = currentValue + new String(ch, start, length);
		}
	}

}
