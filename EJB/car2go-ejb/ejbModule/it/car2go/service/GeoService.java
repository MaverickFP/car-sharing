package it.car2go.service;


import java.io.IOException;
import java.net.MalformedURLException;

import javax.ejb.Remote;

import org.json.simple.parser.ParseException;

@Remote
public interface GeoService {
	
	double generaLongitudine();
	double generaLatitudine();	
	float calcolaDistanza(double userLat, double userLng, double venueLat, double venueLng);
	public String getAddressByGpsCoordinates(double lat, double lng);
	public int getDistanzaStradale(double lat1, double lon1, double lat2, double lon2);
	public int getTempo(double lat1, double lon1, double lat2, double lon2);

}
