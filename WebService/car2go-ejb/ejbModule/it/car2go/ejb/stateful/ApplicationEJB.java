package it.car2go.ejb.stateful;

import it.car2go.model.Macchina;
import it.car2go.model.Prenotazione;
import it.car2go.model.Ruolo;
import it.car2go.model.Utente;
import it.car2go.service.ApplicationEJBRemote;
import it.car2go.service.GeoService;
import it.car2go.service.MacchinaService;
import it.car2go.service.PrenotazioneService;
import it.car2go.service.RuoloService;
import it.car2go.service.UtenteService;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

import javax.ejb.EJB;
import javax.ejb.Remote;
import javax.ejb.Stateful;

import org.json.simple.parser.ParseException;

/**
 * Session Bean implementation class ApplicationEJB
 */
@Stateful(mappedName = "ApplicationEJB")
@Remote
public class ApplicationEJB implements ApplicationEJBRemote {
	
	@EJB(lookup="MacchinaServiceEJB")
	private MacchinaService macchinaService;
	
	@EJB(lookup="UtenteServiceEJB")
	private UtenteService utenteService;

	@EJB(lookup="RuoloServiceEJB")
	private RuoloService ruoloService;
	
	@EJB(lookup="PrenotazioneServiceEJB")
	private PrenotazioneService prenotazioneService;
	
	@EJB(lookup="GeoEJB")
	private GeoService geoService;
	
    /**
     * Default constructor. 
     */
    public ApplicationEJB() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public String hello() {
		Macchina m = macchinaService.getMacchina(1);
		return m.getNote();
		
	}

	@Override
	public List<Macchina> getMacchineLibere() {
		List<Macchina> lista = macchinaService.getMacchineNonPrenotate();
		return lista;
	}

	@Override
	public Macchina getMacchina(int idMacchina) {
		Macchina m = macchinaService.getMacchina(idMacchina);
		return m;
	}

	@Override
	public boolean verificaPresenzaUtente(String username) {
		boolean b = utenteService.verificaPresenzaUsername(username);
		return b;
	}

	@Override
	public void salvaNuovoUtente(Utente utente) {
		Ruolo ruolo = ruoloService.getRuoloByNome("User");
		utente.setRuolo(ruolo);
		utenteService.salvaUtente(utente);
	}

	@Override
	public Utente recuperaUtente(String username, String password) {
		Utente u = utenteService.getUtenteByUsernamePassword(username, password);
		return u;
	}

	@Override
	public Ruolo recuperaRuolo(int idRuolo) {
		Ruolo r = ruoloService.getRuoloById(idRuolo);
		return r;
	}

	@Override
	public int totaleNumPrenotazioni(int idUser) {
		int tot = 0;
		List<Prenotazione> lista = prenotazioneService.getPrenotazioniByUserId(idUser);
		if(!lista.isEmpty())
			tot = lista.size();		
		return tot;
	}

	@Override
	public int totaleTempo(int idUser) {
		int tot = 0;
		List<Prenotazione> lista = prenotazioneService.getPrenotazioniByUserId(idUser);
		Iterator iteratore = lista.iterator();
		while(iteratore.hasNext()){
			Prenotazione p = (Prenotazione) iteratore.next();
			tot = tot + p.getTempo();
		}
		return tot;
	}

	@Override
	public int totaleDistanza(int idUser) {
		int tot = 0;
		List<Prenotazione> lista = prenotazioneService.getPrenotazioniByUserId(idUser);
		Iterator iteratore = lista.iterator();
		while(iteratore.hasNext()){
			Prenotazione p = (Prenotazione) iteratore.next();
			tot = tot + p.getDistanza();
		}		
		return tot;
	}

	@Override
	public int effettuaPrenotazione(int idUtente, int idMacchina) {
		Utente utente = utenteService.getUtenteById(idUtente);
		Macchina macchina = macchinaService.getMacchina(idMacchina);
		
		//setto il bit di prenotazione della macchina
		macchina.setPrenotata(1);
		macchinaService.updateMacchina(macchina);
		
		Prenotazione p = new Prenotazione();
		p.setIdUtente(utente);
		p.setIdMacchina(macchina);
		p.setDistanza(0);
		p.setTempo(0);
		Date data = new Date();
		p.setData(data);
		
		prenotazioneService.addPrenotazione(p);
		int idPrenotazione = prenotazioneService.getLastIdPrenotazione(idUtente, idMacchina);
		return idPrenotazione;
	}

	@Override
	public void cancellaGuida(int idPrenotazione, int idMacchina) {
		Macchina macchina = macchinaService.getMacchina(idMacchina);		
		macchina.setPrenotata(0);
		macchinaService.updateMacchina(macchina);		
		prenotazioneService.delPrenotazione(idPrenotazione);		
	}

	@Override
	public void effettuaGuida(int idUtente, int idPrenotazione, int idMacchina, int interno, int esterno, String note) {
		
		double latitudine = geoService.generaLatitudine();
		double longitudine = geoService.generaLongitudine();
		
		try {
			//String indirizzoGoogle = geoService.getAddressByGpsCoordinates(latitudine, longitudine);
			String indirizzoGoogle = "indirizzo";
			Macchina macchina = macchinaService.getMacchina(idMacchina);
			Prenotazione prenotazione = prenotazioneService.getPrenotazione(idPrenotazione);
							
			float latVecchia = macchina.getLatitudine();
			float longVecchia = macchina.getLongitudine();
			
			float distanza = geoService.calcolaDistanza(latVecchia, longVecchia, latitudine, longitudine);
			int distanzaInt = (int) distanza;
			prenotazione.setDistanza(distanzaInt);
			prenotazione.setTempo(distanzaInt*2);
			prenotazioneService.updatePrenotazione(prenotazione);
			
			 macchina.setNote(note);
			 macchina.setInterno(interno);
			 macchina.setEsterno(esterno);
			 macchina.setLatitudine((float)latitudine);
			 macchina.setLongitudine((float)longitudine);
			 macchina.setIndirizzo(indirizzoGoogle);
			 
			 //int x = (int)Math.random() * 100;
			 Random random = new Random();
			 int x = random.nextInt((100 - 1) + 1) + 1;
			 
			 int benzina = macchina.getSerbatoio() - x;
			 if(benzina < 0)
				 benzina = 0;
			 macchina.setSerbatoio(benzina);
			 macchina.setPrenotata(0); //libero la macchina dopo la guida
			 macchinaService.updateMacchina(macchina);
			
		}catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public Utente getUtenteById(int idUtente) {
		Utente u = utenteService.getUtenteById(idUtente);
		return u;
	}

	@Override
	public List<Utente> elencoUtentiSemplici(int idUtente) {
		List<Utente> lista = utenteService.elencoUtentiSemplici(idUtente);
		return lista;
	}

	@Override
	public void abilitaUtente(int idUtente) {
		
		Utente utente = utenteService.getUtenteById(idUtente);
		Ruolo ruoloAdmin = ruoloService.getRuoloByNome("Admin");
		utente.setRuolo(ruoloAdmin);
		utenteService.aggiornaUtente(utente);
		
	}

	@Override
	public void creaMacchina(String tipo, int codice) {
		
		double lat = geoService.generaLatitudine();
		double lng = geoService.generaLongitudine();
		
		try {
			//String indirizzo = geoService.getAddressByGpsCoordinates(lat, lng);
			String indirizzo = "indirizzo";
			Macchina m = new Macchina();
			m.setCodice(codice);
			m.setTipo(tipo);
			m.setInterno(1);
			m.setEsterno(1);
			m.setNote("Macchina ok");
			m.setSerbatoio(100);
			m.setPrenotata(0);
			m.setLatitudine((float)lat);
			m.setLongitudine((float)lng);
			m.setIndirizzo(indirizzo);
			
			macchinaService.addMacchina(m);
			
		}catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}

	@Override
	public List<Macchina> getMacchineSenzaBenzina() {
		List<Macchina> lista = macchinaService.getMacchineSenzaBenzina();
		return lista; 
	}

	@Override
	public void effettuaRifornimento(int idMacchina) {
		
		Macchina macchina = macchinaService.getMacchina(idMacchina);
		macchina.setSerbatoio(100);
		macchinaService.updateMacchina(macchina);
		
	}

	@Override
	public void pulisciMacchina(int idMacchina) {
		
		Macchina macchina = macchinaService.getMacchina(idMacchina);
		macchina.setInterno(1);
		macchinaService.updateMacchina(macchina);
	}

	@Override
	public void riparaMacchina(int idMacchina) {
		
		Macchina macchina = macchinaService.getMacchina(idMacchina);
		macchina.setEsterno(1);
		macchinaService.updateMacchina(macchina);		
	}

	@Override
	public List<Macchina> elencoMacchineSporcheInterno() {
		List<Macchina> lista = macchinaService.getMacchineSporcheInterno();
		return lista;
	}

	@Override
	public List<Macchina> elencoMacchineDaRiparareEsterno() {
		List<Macchina> lista = macchinaService.getMacchineSporcheEsterno();
		return lista;
	}

	@Override
	public List<Prenotazione> recuperaPrenotazioniUtente(int idUtente) {
		List<Prenotazione> lista = prenotazioneService.getPrenotazioniByUserId(idUtente);
		return lista;
	}

	@Override
	public void aggiornaMacchina(Macchina m) {
		macchinaService.updateMacchina(m);		
	}

	@Override
	public Prenotazione getPrenotazione(int idPrenotazione) {
		Prenotazione p = prenotazioneService.getPrenotazione(idPrenotazione);
		return p;
	}

	@Override
	public int calcolaDistanza(float latV, float lngV, float latN, float lngN) {
		float dist = geoService.calcolaDistanza(latV, lngV, latN, lngN);
		int ris = (int) dist;
		return ris;
	}

	@Override
	public void updatePrenotazione(Prenotazione p) {
		prenotazioneService.updatePrenotazione(p);		
	}

	
	
	
	
	
	

	
	
	
	

}

