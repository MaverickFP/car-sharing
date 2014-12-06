package it.car2go.windows;

import it.car2go.model.Macchina;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import javax.ws.rs.core.MediaType;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

public class MacchineFrame extends JFrame{

	private JLabel titolo;
	
	public MacchineFrame(){
		super("Elenco Macchine");
		this.setSize(800, 400);
		
		creaTitolo();
		creaElencoMacchine();
		
		
	}
	
	
	public void creaTitolo(){
		titolo = new JLabel("Elenco Macchine");
		titolo.setFont(new Font("Serif", Font.BOLD, 24));		
		titolo.setHorizontalAlignment(JLabel.CENTER);
		this.add(titolo, BorderLayout.NORTH);
	}
	
	
	public void creaElencoMacchine(){
		
		JPanel macchinePanel = new JPanel();
		System.out.println("Numero totale delle macchine: " + getNumeroMacchine());
		int totMacchine = getNumeroMacchine();
		macchinePanel.setLayout(new GridLayout(totMacchine,1));
		List<Macchina> list = getMacchine();
		Iterator iteratore = list.iterator();
		while(iteratore.hasNext()){
			Macchina m = (Macchina) iteratore.next();
			JPanel panel = new JPanel();
			String stringa = "MACCHINA: " + m.getTipo() + " INDIRIZZO: " + m.getIndirizzo();
			ImageIcon image = new ImageIcon("/Users/francescoparis/Documents/workspace2/car2go-swingclient/src/main/java/car.png");
			JLabel img = new JLabel(image);			
			JLabel label = new JLabel(stringa);
			JButton button = new JButton("Vedi");	
			panel.add(img);
			panel.add(label);
			panel.add(button);
			panel.setBorder(new TitledBorder(new EtchedBorder(),"Dati Macchina " + "#" + m.getIdMacchina()));
			button.addActionListener(new Ascoltatore(m.getIdMacchina()));
			macchinePanel.add(panel);
			
		}/*fine while*/
		
		
		add(macchinePanel, BorderLayout.CENTER);
		
	}
	
	
	
	public List<Macchina> getMacchine(){
		List<Macchina> listaOutput = new ArrayList();
		Client client = Client.create();
		WebResource webResource = client.resource("http://localhost:8080/car2go-restws/api/macchina/allMacchineNonPrenotate");
		ClientResponse resp = webResource.accept(MediaType.APPLICATION_JSON).get(ClientResponse.class);
		if (resp.getStatus() != 200) {
			   throw new RuntimeException("Failed : HTTP error code : "
				+ resp.getStatus());
		}
		
		String s = resp.getEntity(String.class);
		System.out.println(s);
		Object obj = JSONValue.parse(s);
		JSONArray a = (JSONArray) obj;
		
		for (Object o : a){
			
			JSONObject car = (JSONObject) o;
			
			Macchina m = new Macchina();
			
			Long idcar = (Long) car.get("idMacchina");
			Integer idMacchina = (int) (long) idcar;					
			m.setIdMacchina(idMacchina);			
			
			String tipo = (String) car.get("tipo");
			m.setTipo(tipo);
			
			Long cod = (Long) car.get("codice");
			Integer codice = (int) (long) cod;
			m.setCodice(codice);
			
			Double lat = (Double) car.get("latitudine");
			float latitudine = (float) (double) lat;
			m.setLatitudine(latitudine);
			
			
			Double lng = (Double) car.get("longitudine");
			float longitudine = (float) (double) lng;
			m.setLongitudine(longitudine);
			
			String indirizzo = (String) car.get("indirizzo");
			m.setIndirizzo(indirizzo);
			
			Long internoString = (Long) car.get("interno");
			int interno = (int) (long) internoString;
			m.setInterno(interno);
			
			Long esternoString = (Long) car.get("esterno");
			int esterno = (int) (long) esternoString;
			m.setEsterno(esterno);
			
			Long serb = (Long) car.get("serbatoio");
			int serbatoio = (int) (long) serb;
			m.setSerbatoio(serbatoio);
			
			Long pnt = (Long) car.get("prenotata");
			int prenotata = (int) (long) pnt;
			m.setPrenotata(prenotata);
		
			String note = (String) car.get("note");
			m.setNote(note);		
			
			listaOutput.add(m);
			
		}/*fine for*/		
		
		return listaOutput;
	}
	
	
	
	public int getNumeroMacchine(){
		Client client = Client.create();		
		WebResource webResource = client.resource("http://localhost:8080/car2go-restws/api/macchina/totaleMacchineNonPrenotate");
		ClientResponse resp = webResource.accept(MediaType.APPLICATION_JSON).get(ClientResponse.class);		
		if (resp.getStatus() != 200) {
			   throw new RuntimeException("Failed : HTTP error code : "
				+ resp.getStatus());
		}				
		String output = resp.getEntity(String.class);						
		//metto nella variabile tot il totale delle macchine
		int tot = Integer.parseInt(output);
		return tot;
	}
	
	
	
	
}
