package it.car2go.test.googlemaps;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.WindowConstants;

import com.teamdev.jxbrowser.chromium.Browser;
import com.teamdev.jxbrowser.chromium.BrowserFactory;


//vedere
//http://java.dzone.com/articles/google-maps-java-swing
//http://cloud.teamdev.com.s3.amazonaws.com/downloads/jxbrowser/docs/JxBrowser-PGuide.html#installation

public class GoogleMapsSample {
	
	public static void main(String[] args) {
		Browser browser = BrowserFactory.create();
		
		JFrame frame = new JFrame("JxBrowser Google Maps");
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.add(browser.getView().getComponent(), BorderLayout.CENTER);
        frame.setSize(700, 500);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        
        
        browser.loadHTML("<!DOCTYPE html>\n" +
        	    "<html>\n" +
        	    "  <head>\n" +
        	    "    <title>Simple Map</title>\n" +
        	    "    <meta name=\"viewport\" content=\"initial-scale=1.0, user-scalable=no\">\n" +
        	    "    <meta charset=\"utf-8\">\n" +
        	    "    <style>\n" +
        	    "      html, body, #map-canvas {\n" +
        	    "        height: 100%;\n" +
        	    "        margin: 0px;\n" +
        	    "        padding: 0px\n" +
        	    "      }\n" +
        	    "    </style>\n" +
        	    "    <script src=\"https://maps.googleapis.com/maps/api/js?key=AIzaSyB7J1zsErb9_7jxNu5KU5kIENFObAQEbl0&sensor=false\"></script>\n" +
        	    "    <script>\n" +
        	    "var map;\n" +
        	    "function initialize() {\n" +
        	    "  var mapOptions = {\n" +
        	    "    zoom: 14,\n" +
        	    "    center: new google.maps.LatLng(41.9303, 12.5346)\n" +
        	    "  };\n" +
        	    "  map = new google.maps.Map(document.getElementById('map-canvas'),\n" +
        	    "      mapOptions);\n" +
        	    "  marker = new google.maps.Marker({position: new google.maps.LatLng(41.9303, 12.5346), map: map}); \n"+
        	    "}\n" +
        	    "\n" +
        	    "google.maps.event.addDomListener(window, 'load', initialize);\n" +
        	    "\n" +
        	    "    </script>\n" +
        	    "  </head>\n" +
        	    "  <body>\n" +
        	    "    <div id=\"map-canvas\"  style=\"width: 500px; height: 400px;\"></div>\n" +
        	    "  </body>\n" +
        	    "</html>");
		
	}

}
