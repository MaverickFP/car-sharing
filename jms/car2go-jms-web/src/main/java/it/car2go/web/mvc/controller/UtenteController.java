package it.car2go.web.mvc.controller;

import it.car2go.jms.sender.Sender;
import it.car2go.model.Macchina;
import it.car2go.model.Prenotazione;
import it.car2go.model.PrenotazioneView;
import it.car2go.model.Ruolo;
import it.car2go.model.Utente;
import it.car2go.service.MacchinaService;
import it.car2go.service.PrenotazioneService;
import it.car2go.service.RuoloService;
import it.car2go.service.UtenteService;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

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
	private MacchinaService macchinaService;
	@Autowired
	private PrenotazioneService prenotazioneService;
	@Autowired
	private Sender sender;
	
	@Inject
	public UtenteController(UtenteService utenteService, RuoloService ruoloService, MacchinaService macchinaService, PrenotazioneService prenotazioneService){
		this.utenteService = utenteService;
		this.ruoloService = ruoloService;
		this.macchinaService = macchinaService;
		this.prenotazioneService = prenotazioneService;
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
		//return "redirect:/utente/registrazioneOk";
	}
	
	
	@RequestMapping(method=RequestMethod.GET, params="login")
	public String showLoginForm(){
		return "utente/login";
	}
	
	
	 @RequestMapping(value = "/dologin", method = RequestMethod.POST)
	 public ModelAndView helloWorld(HttpServletRequest request,HttpServletResponse response) {
		 
		
		
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
		 
		 HttpSession session = request.getSession();
		 int idUser = (int) session.getAttribute("idutente");
		 
		 Utente u = utenteService.getUtenteById(idUser);
		 
		 model.put("message", "Benvenuto " + u.getNome() + " " + u.getCognome());
		 
		 return"utente/user/homeuser"; 
	 }
	 
	 
	 
	 
	 @RequestMapping("/user/costi")
	 public String showCostiUser(Map<String,Object> model, HttpServletRequest request,HttpServletResponse response){
	
		 
		 HttpSession session = request.getSession();
		 int idUser = (int) session.getAttribute("idutente");
		 
		 List<Prenotazione> lista = prenotazioneService.getPrenotazioniByUserId(idUser);
		 
		 	 
		 int totnoleggi = 0;
		 double totCosto = 0;
		 int totTempo = 0;
		 int totKm = 0;
		 Iterator iteratore = lista.iterator();
		 while(iteratore.hasNext()){
			 Prenotazione p = (Prenotazione) iteratore.next();
			 totTempo = totTempo + p.getTempo();
			 totKm = totKm + p.getDistanza();
		 }
		 //il costo e' 0.29 centesimi a minuto
		 totCosto = totTempo * 0.29;
		 
		 if(!lista.isEmpty())
			 totnoleggi = lista.size();
		 
		 model.put("nprenotazioni", totnoleggi);
		 model.put("costo", totCosto);
		 model.put("distanza", totKm);
		 
				 
		return "utente/user/costi";
		 
	 }
	 
	 
	 
	 
	 
	 
	 @RequestMapping("/user/storico")
	 public String showStoricoUser(Map<String,Object> model, HttpServletRequest request,HttpServletResponse response){
	
		 HttpSession session = request.getSession();
		 int idUser = (int) session.getAttribute("idutente");
		 
		 //per mostrare l'elenco delle prenotazioni creo un oggetto PrenotazioneView che presenta
		 // in piu' rispetto a prenotazione il costo di un viaggio e il nome della macchina usata
		 
		 List<Prenotazione> listaInput = prenotazioneService.getPrenotazioniByUserId(idUser);
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
			 //pv.setData(p.getData());
			 Date data = new Date();
			 pv.setData(data);
			 
			 listaOutput.add(pv);
			 
		 }/*fine while*/
		 
		 model.put("prenotazioni", listaOutput);
		 
		 return "utente/user/storico";
	 }
	 
	 
	 
	 
	 
	 @RequestMapping("user/prenota")
	 public String showMacchineLibereUser(Map<String,Object> model, HttpServletRequest request,HttpServletResponse response){
		
		 
		 HttpSession session = request.getSession();
		 int idUser = (int) session.getAttribute("idutente");
		 
		 List<Macchina> lista = macchinaService.getMacchineNonPrenotate();
		 
		 model.put("macchine", lista);
		 
		 return "utente/user/listaMacchine";
	 }
	 
	 
	 @RequestMapping(value = "/user/doprenotazione", method = RequestMethod.POST)
	 public String doPrenotazioneMacchina(Map<String,Object> model, HttpServletRequest request,HttpServletResponse response){
		
		 HttpSession session = request.getSession();
		 int idUtente = (int) session.getAttribute("idutente");
		 Utente utente = utenteService.getUtenteById(idUtente);
		 
		 String idmacchina = request.getParameter("idMacchina");
		 int idMacchina = Integer.parseInt(idmacchina);
		 Macchina macchina = macchinaService.getMacchina(idMacchina);
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
		 int idPren = prenotazioneService.getLastIdPrenotazione(idUtente, idMacchina);
		 
		 model.put("utente", utente);
		 model.put("macchina", macchina);
		 model.put("idPrenotazione", idPren);
		 
		 return "utente/user/guida";
	 }
	 
	 
	 
	 @RequestMapping(value = "/user/delguida", method = RequestMethod.POST)
	 public ModelAndView cancellaGuida(HttpServletRequest request,HttpServletResponse response){
		 
		
		 
		 HttpSession session = request.getSession();
		 int idUtente = (int) session.getAttribute("idutente");
		 Utente utente = utenteService.getUtenteById(idUtente);
		 
		 String idMacchina = request.getParameter("idMacchina");
		 String idPrenotazione = request.getParameter("idPrenotazione");
		 
		 int idAuto = Integer.parseInt(idMacchina);
		 int idPren = Integer.parseInt(idPrenotazione);
		 
		 //recupero la macchina e faccio in modo che non sia piu' prenotata
		 Macchina macchina = macchinaService.getMacchina(idAuto);
		 macchina.setPrenotata(0);
		 macchinaService.updateMacchina(macchina);
		 
		 //cancello la prenotazione
		 prenotazioneService.delPrenotazione(idPren);
		 
		 
		 //ripoto l'utente alla sua homepage		 
		 return new ModelAndView("utente/user/homeuser", "message", "Benvenuto " + utente.getNome() + " " + utente.getCognome());
		 
	 }
	 	
	 
	 
	 
	 @RequestMapping(value = "/user/doguida", method = RequestMethod.POST)
	 public ModelAndView doGuida(HttpServletRequest request,HttpServletResponse response){
		
		 HttpSession session = request.getSession();
		 int idUtente = (int) session.getAttribute("idutente");
		 Utente utente = utenteService.getUtenteById(idUtente);
		 
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
			 Macchina macchina = macchinaService.getMacchina(idMacchina);
			 
			 Prenotazione prenotazione = prenotazioneService.getPrenotazione(idPrenotazione);
			 
			 float latVecchia = macchina.getLatitudine();
			 float longVecchia = macchina.getLongitudine();
			 
			 //float distanza = googleService.calculateDistance(latVecchia, longVecchia, latitudine, longitudine);
			 //int distanzaInt = (int) distanza;
			 int distanzaInt = googleService.getDistanzaStradale(latVecchia, longVecchia, latitudine, longitudine);
			 
			 System.out.println("Dentro web app" + distanzaInt);
			 System.out.println(prenotazione.getIdPrenotazione());
			 prenotazione.setDistanza(distanzaInt);
			 //prenotazione.setTempo(distanzaInt*2);
			 int tempoDistanza = googleService.getTempoTragitto(latVecchia, longVecchia, latitudine, longitudine);
			 System.out.println("Dentro app web " + tempoDistanza);
			 prenotazione.setTempo(tempoDistanza);
			 prenotazioneService.updatePrenotazione(prenotazione);
			 
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
			 macchinaService.updateMacchina(macchina);
			 
			 
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
		 
		//ripoto l'utente alla sua homepage		 
		 return new ModelAndView("utente/user/homeuser", "message", "Benvenuto " + utente.getNome() + " " + utente.getCognome());
	 }
	 
	 
	 
	 @RequestMapping("/user/logout")
	 public String adminLogout(Map<String,Object> model, HttpServletRequest request,HttpServletResponse response){
		 
		 HttpSession session = request.getSession();
		 int idUser = (int) session.getAttribute("idutente");
		 
		 session.removeAttribute("idutente");
		 session.invalidate();
		 
		 return "utente/logout";
		 
		 
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
