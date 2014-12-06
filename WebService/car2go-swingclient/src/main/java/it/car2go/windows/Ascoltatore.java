package it.car2go.windows;

import it.car2go.model.Macchina;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.ws.rs.core.MediaType;

import org.json.simple.JSONObject;
import org.json.simple.JSONValue;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.teamdev.jxbrowser.chromium.Browser;
import com.teamdev.jxbrowser.chromium.BrowserFactory;

public class Ascoltatore implements ActionListener {
	
	int idMacchina;
	
	public Ascoltatore(int idMacchina){
		this.idMacchina = idMacchina;
	}
	

	public void actionPerformed(ActionEvent e) {
		Macchina m = getMacchina(idMacchina);		
		JFrame frame = new JFrame("Dettaglio Macchina");
		
		JPanel panelAlto = new JPanel();		
		JPanel panelInfo = new JPanel();
		panelInfo.setLayout(new GridLayout(6,1));
		
		JLabel labelCodice = new JLabel("Info Macchina " + m.getCodice());
		JLabel labelTipo = new JLabel("Tipo Macchina: " + m.getTipo());
		JLabel labelIndirizzo = new JLabel("Indirizzo " + m.getIndirizzo());
		JLabel labelBenzina = new JLabel("Benzina: " + m.getSerbatoio() + "%");
		String statoInternoString = getStringaStatoInterno(m.getInterno());
		JLabel labelStatoInterno = new JLabel("Stato interno: " + statoInternoString);
		String statoEsternoString = getStringaStatoEsterno(m.getEsterno());
		JLabel labelStatoEsterno = new JLabel("Stato esterno: " + statoEsternoString);
	
		panelInfo.add(labelCodice);
		panelInfo.add(labelTipo);
		panelInfo.add(labelIndirizzo);
		panelInfo.add(labelBenzina);
		panelInfo.add(labelStatoInterno);
		panelInfo.add(labelStatoEsterno);
		
		
		panelAlto.add(panelInfo);
		
		frame.add(panelAlto, BorderLayout.NORTH);
		
		//inserisco googleMaps
		Browser browser = BrowserFactory.create();
		
		
		frame.add(browser.getView().getComponent(), BorderLayout.CENTER);
		frame.setSize(700, 700);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
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
        	    "    center: new google.maps.LatLng("+m.getLatitudine()+","+m.getLongitudine()+")\n" +
        	    "  };\n" +
        	    "  map = new google.maps.Map(document.getElementById('map-canvas'),\n" +
        	    "      mapOptions);\n" +
        	    "  marker = new google.maps.Marker({position: new google.maps.LatLng("+m.getLatitudine()+","+m.getLongitudine()+"), map: map}); \n"+
        	    "}\n" +
        	    "\n" +
        	    "google.maps.event.addDomListener(window, 'load', initialize);\n" +
        	    "\n" +
        	    "    </script>\n" +
        	    "  </head>\n" +
        	    "  <body>\n" +
        	    "    <div id=\"map-canvas\"></div>\n" +
        	    "  </body>\n" +
        	    "</html>");
		
		
		
		
		
		
	}
	
	
	
	
	public String getStringaStatoInterno(int interno){
		String ris = "";
		 
		if(interno == 1)
			ris = "Ottimo";
		if(interno == 2)
			ris = "Sufficiente";
		if(interno == 3)
			ris = "Insufficiente";
		
		return ris;
	}
	
	
	
	public String getStringaStatoEsterno(int esterno){
		String ris = "";
		 
		if(esterno == 1)
			ris = "Ottimo";
		if(esterno == 2)
			ris = "Sufficiente";
		if(esterno == 3)
			ris = "Insufficiente";
		
		return ris;
	}
	
	
	
	public Macchina getMacchina(int idMacchina){
		Macchina m = new Macchina();
		
		Client client = Client.create();
		WebResource webResource = client.resource("http://localhost:8080/car2go-restws/api/macchina/"+idMacchina);
		ClientResponse resp = webResource.accept(MediaType.APPLICATION_JSON).get(ClientResponse.class);
		if (resp.getStatus() != 200) {
			   throw new RuntimeException("Failed : HTTP error code : "
				+ resp.getStatus());
		}
		
		String s = resp.getEntity(String.class);
		System.out.println(s);
		//ricavo le info sulla persona giunta come stringa json usando json-simple
		Object obj = JSONValue.parse(s);
		JSONObject jsonObject = (JSONObject) obj;
				
		Long idmacchina = (Long) jsonObject.get("idMacchina");
		int idMacchina1 = (int) (long) idmacchina;
		m.setIdMacchina(idMacchina1);
		
		String tipo = (String) jsonObject.get("tipo");
		m.setTipo(tipo);
		
		Long cod = (Long) jsonObject.get("codice");
		Integer codice = (int) (long) cod;
		m.setCodice(codice);
		
		Double lat = (Double) jsonObject.get("latitudine");
		float latitudine = (float) (double) lat;
		m.setLatitudine(latitudine);
		
		
		Double lng = (Double) jsonObject.get("longitudine");
		float longitudine = (float) (double) lng;
		m.setLongitudine(longitudine);
		
		String indirizzo = (String) jsonObject.get("indirizzo");
		m.setIndirizzo(indirizzo);
		
		Long internoString = (Long) jsonObject.get("interno");
		int interno = (int) (long) internoString;
		m.setInterno(interno);
		
		Long esternoString = (Long) jsonObject.get("esterno");
		int esterno = (int) (long) esternoString;
		m.setEsterno(esterno);
		
		Long serb = (Long) jsonObject.get("serbatoio");
		int serbatoio = (int) (long) serb;
		m.setSerbatoio(serbatoio);
		
		Long pnt = (Long) jsonObject.get("prenotata");
		int prenotata = (int) (long) pnt;
		m.setPrenotata(prenotata);
	
		String note = (String) jsonObject.get("note");
		m.setNote(note);		
		
		return m;
	}
	
	

}




