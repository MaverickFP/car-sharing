package it.car2go.web.mvc.controller;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

import javax.inject.Inject;
import javax.mail.Session;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import it.car2go.jms.sender.Sender;
import it.car2go.model.Macchina;
import it.car2go.model.Prenotazione;
import it.car2go.model.PrenotazioneView;
import it.car2go.model.Ruolo;
import it.car2go.model.Utente;
import it.car2go.service.ApplicationEJBRemote;
import it.car2go.service.MacchinaService;
import it.car2go.service.PrenotazioneService;
import it.car2go.service.RuoloService;
import it.car2go.service.UtenteService;

import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;


@Controller
@RequestMapping("/utente")
public class UtenteController {
	
	@Autowired
	private UtenteService utenteService;
	@Autowired
	private RuoloService ruoloService;
	@Autowired
	private ApplicationEJBRemote applicationBean;
	@Autowired
	private Sender sender;
	
		
	
	@Inject
	public UtenteController(UtenteService utenteService, RuoloService ruoloService){
		this.utenteService = utenteService;
		this.ruoloService = ruoloService;				
	}
	
	
	@RequestMapping(method=RequestMethod.GET, params="new")
	public String createUtenteProfile(Model model){		
		model.addAttribute(new Utente());			
		return "utente/edit";		
	}
	
	
	@RequestMapping(method=RequestMethod.POST)
	public ModelAndView addUtenteFromForm(@Valid Utente utente, BindingResult bindingResult){
		
		if(bindingResult.hasErrors()){
			return new ModelAndView("utente/edit"); 			
		}
		
		Ruolo ruolo = ruoloService.getRuoloByNome("User");
		//verifico se username e' gia' presente
		String usernameInput = utente.getUsername();
		boolean b = utenteService.verificaPresenzaUsername(usernameInput);
		if(b == true){
			return new ModelAndView("utente/errorpage", "message", "username esistente"); 
		}
					
		utente.setRuolo(ruolo);
		utenteService.salvaUtente(utente);		
		return new ModelAndView("/utente/registrazioneOk"); 		
	}
	
	
	@RequestMapping(method=RequestMethod.GET, params="login")
	public String showLoginForm(){
		return "utente/login";
	}
	
	
	 @RequestMapping(value = "/dologin", method = RequestMethod.POST)
	 public ModelAndView helloWorld(HttpServletRequest request,HttpServletResponse response) {
		 
		 SecurityManager sm = new MySecurityManager();
		 System.setSecurityManager(sm);
		
		 String user = request.getParameter("username");
		 String password = request.getParameter("password");
		 
		 if( user.isEmpty() || password.isEmpty() )
			 return new ModelAndView("utente/errorpage", "message", "username o password mancanti"); 
		 else{
			 
			 Utente u = utenteService.getUtenteByUsernamePassword(user, password);			
			 
			 //se e' nullo -> dati autenticazione errati
			 if(u == null)
				 return new ModelAndView("utente/errorpage", "message", "username o password errati"); 			 
			
			 //qui significa che i dati sono giusti
			 //2 possibilita' (user semplice o admin)
			
			 int idRuolo = u.getIdRuolo();
			 Ruolo ruolo = ruoloService.getRuoloById(idRuolo);
			 
			 HttpSession session = request.getSession();
			 session.setAttribute("idutente", u.getIdUtente());
			 session.setAttribute("ruolo", ruolo.getNome());
			 
			 if(ruolo.getNome().equals("Admin"))
				return new ModelAndView("utente/admin/homeadmin", "message", "Benvenuto " + u.getNome() + " " + u.getCognome());
			 if(ruolo.getNome().equals("User"))
				return new ModelAndView("utente/user/homeuser", "message", "Benvenuto " + u.getNome() + " " + u.getCognome());
			 
		 }		 
		 return new ModelAndView("utente/errorpage", "message", "errore sconosciuto");		 
	 }
	 
	 
	 @RequestMapping("/user/goUserHome")
	 public  String goUserHome(Map<String,Object> model, HttpServletRequest request,HttpServletResponse response) {
		 
		 SecurityManager sm = new MySecurityManager();
		 System.setSecurityManager(sm);
		 
		 HttpSession session = request.getSession();
		 int idUser = (int) session.getAttribute("idutente");
		 
		 Utente u = utenteService.getUtenteById(idUser);		 
		 model.put("message", "Benvenuto " + u.getNome() + " " + u.getCognome());		 
		 return"utente/user/homeuser";		 
	 }
	 	 
	 
	 @RequestMapping("/user/logout")
	 public String adminLogout(Map<String,Object> model, HttpServletRequest request,HttpServletResponse response){
		 
		 HttpSession session = request.getSession();
		 int idUser = (int) session.getAttribute("idutente");		 
		 session.removeAttribute("idutente");
		 session.invalidate();		 
		 return "utente/logout";
	 }
	 
	 
	 @RequestMapping("/user/costi")
	 public String showCostiUser(Map<String,Object> model, HttpServletRequest request,HttpServletResponse response){
		 
		 HttpSession session = request.getSession();
		 int idUser = (int) session.getAttribute("idutente");
		 
		 int totaleNoleggi = 0;
		 double totCosto = 0;
		 int totTempo = 0;
		 int totKm = 0;
		 
		 totaleNoleggi = applicationBean.totaleNumPrenotazioni(idUser);
		 totTempo = applicationBean.totaleTempo(idUser);
		 totKm = applicationBean.totaleDistanza(idUser);
		 
		 totCosto = totTempo * 0.29;
		 
		 model.put("nprenotazioni", totaleNoleggi);
		 model.put("costo", totCosto);
		 model.put("distanza", totKm);
		 
		 return "utente/user/costi";
	 }
	 
	 
	 @RequestMapping("/user/storico")
	 public String showStoricoUser(Map<String,Object> model, HttpServletRequest request,HttpServletResponse response){
		 
		 HttpSession session = request.getSession();
		 int idUser = (int) session.getAttribute("idutente");
		 
		 List<Prenotazione> listaInput = applicationBean.recuperaPrenotazioniUtente(idUser);
		 List<PrenotazioneView> listaOutput = new ArrayList<PrenotazioneView>();
		 Iterator iteratore = listaInput.iterator();
		 while(iteratore.hasNext()){
			 Prenotazione p = (Prenotazione) iteratore.next();
			 Macchina m = p.getIdMacchina();
			 
			 PrenotazioneView pv = new PrenotazioneView();
			 pv.setIdPrenotazione(p.getIdPrenotazione());
			 pv.setIdUtente(p.getIdUtente());
			 pv.setIdMacchina(p.getIdMacchina());
			 pv.setNomeMacchina(m.getTipo());
			 pv.setDistanza(p.getDistanza());
			 pv.setTempo(p.getTempo());
			 pv.setDistanza(p.getDistanza());
			 double costo = p.getTempo() * 0.29;
			 pv.setCosto(costo);
			 pv.setData(p.getData());
			 
			 listaOutput.add(pv);
		 }/*fine while*/		 
		 model.put("prenotazioni", listaOutput);
		 return "utente/user/storico";
	 }
	 
	 
	 @RequestMapping("user/prenota")
	 public String showMacchineLibereUser(Map<String,Object> model, HttpServletRequest request,HttpServletResponse response){
		 HttpSession session = request.getSession();
		 int idUser = (int) session.getAttribute("idutente");
		 
		 List<Macchina> lista = applicationBean.getMacchineLibere();
		 model.put("macchine", lista);
		 
		 return "utente/user/listaMacchine";
	 }
	 
	 
	 @RequestMapping(value = "/user/doprenotazione", method = RequestMethod.POST)
	 public String doPrenotazioneMacchina(Map<String,Object> model, HttpServletRequest request,HttpServletResponse response){
		 
		 HttpSession session = request.getSession();
		 int idUtente = (int) session.getAttribute("idutente");
		 Utente utente = applicationBean.getUtenteById(idUtente);
		 
		 String idmacchina = request.getParameter("idMacchina");
		 int idMacchina = Integer.parseInt(idmacchina);
		 Macchina macchina = applicationBean.getMacchina(idMacchina);
		  
		 int idPrenotazione = applicationBean.effettuaPrenotazione(idUtente, idMacchina);
		 
		 model.put("utente", utente);
		 model.put("macchina", macchina);
		 model.put("idPrenotazione", idPrenotazione);
		 
		 return "utente/user/guida";
	 }
	 
	 
	 
	 @RequestMapping(value = "/user/delguida", method = RequestMethod.POST)
	 public ModelAndView cancellaGuida(HttpServletRequest request,HttpServletResponse response){
		 
		 HttpSession session = request.getSession();
		 int idUtente = (int) session.getAttribute("idutente");
		 Utente utente = applicationBean.getUtenteById(idUtente);
		 		 
		 String idmacchina = request.getParameter("idMacchina");
		 int idMacchina = Integer.parseInt(idmacchina);		 
		 
		 String idPrenotazione = request.getParameter("idPrenotazione");
		 int idPren = Integer.parseInt(idPrenotazione);
		 
		 applicationBean.cancellaGuida(idPren, idMacchina);
		 
		//ripoto l'utente alla sua homepage		 
		 return new ModelAndView("utente/user/homeuser", "message", "Benvenuto " + utente.getNome() + " " + utente.getCognome());
		 
	 }
	 
	 
	 @RequestMapping(value = "/user/doguida", method = RequestMethod.POST)
	 public ModelAndView doGuida(HttpServletRequest request,HttpServletResponse response){
		 HttpSession session = request.getSession();
		 int idUtente = (int) session.getAttribute("idutente");
		 Utente utente = applicationBean.getUtenteById(idUtente);
		 
		 String idmacchina = request.getParameter("idMacchina");
		 int idMacchina = Integer.parseInt(idmacchina);
		 String idprenotazione = request.getParameter("idPrenotazione");
		 int idPrenotazione = Integer.parseInt(idprenotazione);
		 System.out.println("Id Prenotazione Ricevuto " + idPrenotazione);
		 
		 String interno = request.getParameter("interno");
		 int numInterno = Integer.parseInt(interno);
		 String esterno = request.getParameter("esterno");
		 int numEsterno = Integer.parseInt(esterno);
		 //in questo caso la macchina ha problemi visibili esternamente -> comunica il guasto alla coda
		 if(numEsterno == 3){
			 String nomeGuasto = selezionaNomeGuasto();
			 String msg = nomeGuasto +","+idmacchina;
			 sender.inviaMessaggio(msg);
		 }
		 
		 
		 String testoNota = request.getParameter("note");
		 GoogleMapsService googleService = new GoogleMapsService();
		 double latitudine = googleService.generaLatitudine();
		 double longitudine = googleService.generaLongitudine();
		 try {
			 String indirizzoGoogle = googleService.getAddressByGpsCoordinates(latitudine, longitudine);
			 Macchina macchina = applicationBean.getMacchina(idMacchina);
			 
			 Prenotazione prenotazione = applicationBean.getPrenotazione(idPrenotazione);
			 
			 float latVecchia = macchina.getLatitudine();
			 float longVecchia = macchina.getLongitudine();
			 
			 //float distanza = googleService.calculateDistance(latVecchia, longVecchia, latitudine, longitudine);
			 //int distanzaInt = (int) distanza;
			 //int distanzaInt = googleService.getDistanzaStradale(latVecchia, longVecchia, latitudine, longitudine);
			 int distanzaInt = applicationBean.calcolaDistanza(latVecchia, longVecchia, (float)latitudine, (float)longitudine);
			 
			 System.out.println("Dentro web app" + distanzaInt);
			 System.out.println(prenotazione.getIdPrenotazione());
			 prenotazione.setDistanza(distanzaInt);
			 prenotazione.setTempo(distanzaInt*2);
			 //int tempoDistanza = googleService.getTempoTragitto(latVecchia, longVecchia, latitudine, longitudine);
			 //System.out.println("Dentro app web " + tempoDistanza);
			 //prenotazione.setTempo(tempoDistanza);
			 applicationBean.updatePrenotazione(prenotazione);
			
			 
			 macchina.setNote(testoNota);
			 macchina.setInterno(numInterno);
			 macchina.setEsterno(numEsterno);
			 macchina.setLatitudine((float)latitudine);
			 macchina.setLongitudine((float)longitudine);
			 macchina.setIndirizzo(indirizzoGoogle);
			 
			 
			 //int x = (int)Math.random() * 100;
			 Random random = new Random();
			 int x = random.nextInt((100 - 1) + 1) + 1;
			 
			 System.out.println("BENZINAAAA " + x);
			 int benzina = macchina.getSerbatoio() - x;
			 if(benzina < 0)
				 benzina = 0;
			 macchina.setSerbatoio(benzina);
			 macchina.setPrenotata(0); //libero la macchina dopo la guida
			 applicationBean.aggiornaMacchina(macchina);
			 
			 
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
		 
		 //riporto l'utente alla sua homepage		 
		 return new ModelAndView("utente/user/homeuser", "message", "Benvenuto " + utente.getNome() + " " + utente.getCognome());
	 }
	 
	 
	 
	 
	 /*
	  * Seleziona il nome di un guasto
	  */
	 private String selezionaNomeGuasto(){
		
		 Map guasti = new HashMap();
		 guasti.put(1, "Rotto freno");
		 guasti.put(2, "Rotto fanale");
		 guasti.put(3, "Rotto motore");
		 guasti.put(4, "Manca olio");
		 guasti.put(5, "Ruota Bucata");
		 
		 Random random = new Random();
		 int x = random.nextInt((5 - 1) + 1) + 1;
		 
		 String msg = (String) guasti.get(x);
		 
		 return msg;		 
	 }
	 
	
	 	
}
