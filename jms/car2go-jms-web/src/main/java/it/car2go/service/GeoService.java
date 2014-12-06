package it.car2go.service;

import java.io.IOException;
import java.net.MalformedURLException;

import javax.ejb.Remote;

@Remote
public interface GeoService {
	
	double generaLongitudine();
	double generaLatitudine();	
	float calcolaDistanza(double userLat, double userLng, double venueLat, double venueLng);
	public int getDistanzaStradale(double lat1, double lon1, double lat2, double lon2)throws MalformedURLException, IOException, org.json.simple.parser.ParseException;
	public int getTempoTragitto(double lat1, double lon1, double lat2, double lon2)throws MalformedURLException, IOException, org.json.simple.parser.ParseException;

}
