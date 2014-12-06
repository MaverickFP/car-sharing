package it.car2go.web.mvc.controller;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import it.car2go.model.Guasto;
import it.car2go.model.Macchina;
import it.car2go.model.MacchinaView;
import it.car2go.model.Ruolo;
import it.car2go.model.Utente;
import it.car2go.servant.macchina.MacchinaServant;
import it.car2go.servant.macchina.MacchinaService;
import it.car2go.servant.prenotazione.PrenotazioneServant;
import it.car2go.servant.prenotazione.PrenotazioneService;
import it.car2go.servant.ruolo.RuoloServant;
import it.car2go.servant.ruolo.RuoloService;
import it.car2go.servant.utente.UtenteServant;
import it.car2go.servant.utente.UtenteService;
import it.car2go.service.GuastoService;

import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;



@Controller
@RequestMapping("/utente/admin")
public class AdminController {
	
	private UtenteServant utenteService;
	private RuoloServant ruoloService;
	private MacchinaServant macchinaService;
	private PrenotazioneServant prenotazioneService;
	@Autowired
	private GuastoService guastoService;
	
	
	
	public AdminController(){
		MacchinaService ms = new MacchinaService();
		this.macchinaService = ms.getMacchinaServantPort();
		
		RuoloService rs = new RuoloService();
		this.ruoloService = rs.getRuoloServantPort();
		
		UtenteService us = new UtenteService();
		this.utenteService = us.getUtenteServantPort();
		
		PrenotazioneService ps = new PrenotazioneService();
		this.prenotazioneService = ps.getPrenotazioneServantPort();
	}
	
	
	 @RequestMapping("/goAdminHome")
	 public  String goAdminHome(Map<String,Object> model, HttpServletRequest request,HttpServletResponse response) {
		 HttpSession session = request.getSession();
		 int idUser = (int) session.getAttribute("idutente");
		 
		 it.car2go.servant.utente.Utente u = utenteService.getUtenteById(idUser);		 
		 model.put("message", "Benvenuto " + u.getNome() + " " + u.getCognome());		 
		 return"utente/admin/homeadmin";		 
	 }
	 	 
	 
	 @RequestMapping("/logout")
	 public String adminLogout(Map<String,Object> model, HttpServletRequest request,HttpServletResponse response){
		 HttpSession session = request.getSession();
		 int idUser = (int) session.getAttribute("idutente");		 
		 session.removeAttribute("idutente");
		 session.invalidate();		 
		 return "utente/logout";
	 }
	 
	 
	 @RequestMapping("/abilitautente")
	 public String abilitaUtente(Map<String,Object> model, HttpServletRequest request,HttpServletResponse response){
		 HttpSession session = request.getSession();
		 int idUser = (int) session.getAttribute("idutente");		 
		 List<it.car2go.servant.utente.Utente> listaUtenti = utenteService.elencoUtentiSemplici(idUser);
		 model.put("utenti", listaUtenti); 
		 return "utente/admin/listaUtenti";		 
	 }
	 
	 
	 @RequestMapping(value = "/doabilita", method = RequestMethod.POST)
	 public String doAbilitaUtente(Map<String,Object> model, HttpServletRequest request,HttpServletResponse response){
		
		 HttpSession session = request.getSession();
		 int idUser = (int) session.getAttribute("idutente");
		 
		 String idUtenteDaAbilitare = request.getParameter("idUtente");
		 int intIdUtenteDaAbilitare = Integer.parseInt(idUtenteDaAbilitare);
		 it.car2go.servant.utente.Utente user = utenteService.getUtenteById(intIdUtenteDaAbilitare);
		 it.car2go.servant.ruolo.Ruolo ruoloAdmin = ruoloService.getRuoloByNome("Admin");
		 //da ruolo.ruolo a utente.ruolo
		 it.car2go.servant.utente.Ruolo ru = new it.car2go.servant.utente.Ruolo();
		 ru.setIdRuolo(ruoloAdmin.getIdRuolo());
		 ru.setNome(ruoloAdmin.getNome());
		 ru.setCodice(ruoloAdmin.getCodice());		 
		 user.setRuolo(ru);
		 utenteService.aggiornaUtente(user);
		 
		it.car2go.servant.utente.Utente u = utenteService.getUtenteById(idUser);
		model.put("message", "Benvenuto " + u.getNome() + " " + u.getCognome());
		return "utente/admin/homeadmin";		 
	 }
	 
	 	 
	 @RequestMapping("/creamacchina")
	 public String creaAuto(Map<String,Object> model, HttpServletRequest request,HttpServletResponse response){
		 HttpSession session = request.getSession();
		 int idUser = (int) session.getAttribute("idutente");
		 return "utente/admin/formCreaMacchina";
	 }
	
	 
	 
	 @RequestMapping(value="/doCreaMacchina", method = RequestMethod.POST)
	 public String doCreaMacchina(Map<String,Object> model, HttpServletRequest request,HttpServletResponse response){
		
		 HttpSession session = request.getSession();
		 int idUser = (int) session.getAttribute("idutente");
		 
		 String tipo = request.getParameter("tipo");
		 String codice = request.getParameter("codice");
		 int intCodice = Integer.parseInt(codice);
		 
		 GoogleMapsService gms = new GoogleMapsService();
		 
		 double lat = gms.generaLatitudine();
		 double lng = gms.generaLongitudine();
		 try {
			String indirizzo = gms.getAddressByGpsCoordinates(lat, lng);
			it.car2go.servant.macchina.Macchina m = new it.car2go.servant.macchina.Macchina();
			m.setCodice(intCodice);
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
		 
		it.car2go.servant.utente.Utente u = utenteService.getUtenteById(idUser);
		model.put("message", "Benvenuto " + u.getNome() + " " + u.getCognome());
		return "utente/admin/homeadmin";		 
	 }
	 
	 
	 
	 @RequestMapping("/rifornisci")
	 public String rifornisciAuto(Map<String,Object> model, HttpServletRequest request,HttpServletResponse response){
		 		
		 HttpSession session = request.getSession();
		 int idUser = (int) session.getAttribute("idutente");		

		 List<it.car2go.servant.macchina.Macchina> lista = macchinaService.getMacchineSenzaBenzina();
		 model.put("macchine", lista);
		 
		 return "utente/admin/rifornisciMacchina";		 
	 }
	 
	 
	 @RequestMapping(value="/doRifornimento", method = RequestMethod.POST)
	 public String doRifornimento(Map<String,Object> model, HttpServletRequest request,HttpServletResponse response){
		 
		 HttpSession session = request.getSession();
		 int idUser = (int) session.getAttribute("idutente");
		 
		 String idmacchina = request.getParameter("idMacchina");
		 int idMacchina = Integer.parseInt(idmacchina);
		 
		 it.car2go.servant.macchina.Macchina m = macchinaService.getMacchina(idMacchina);
		 m.setSerbatoio(100);
		 macchinaService.updateMacchina(m);		 
		 
		 it.car2go.servant.utente.Utente u = utenteService.getUtenteById(idUser);
		 model.put("message", "Benvenuto " + u.getNome() + " " + u.getCognome());
		 return "utente/admin/homeadmin";
	 }
	 
	 
	 
	 
	 @RequestMapping("/pulisci")
	 public String pulisciInternoAuto(Map<String,Object> model, HttpServletRequest request,HttpServletResponse response){
		 
		 HttpSession session = request.getSession();
		 int idUser = (int) session.getAttribute("idutente");
		 
		 List<it.car2go.servant.macchina.Macchina> lista = macchinaService.getMacchineSporcheInterno();
		 System.out.println(lista.size());
		 model.put("macchine", lista);
		 
		 return "utente/admin/pulisciInternoAuto";		 
	 }
	 
	 
	 @RequestMapping(value="/doPulisciInterno", method = RequestMethod.POST)
	 public String doPulisciInternoAuto(Map<String,Object> model, HttpServletRequest request,HttpServletResponse response){
				
		 HttpSession session = request.getSession();
		 int idUser = (int) session.getAttribute("idutente");
		 
		 String idmacchina = request.getParameter("idMacchina");
		 int idMacchina = Integer.parseInt(idmacchina);
		 
		 it.car2go.servant.macchina.Macchina m = macchinaService.getMacchina(idMacchina);
		 m.setInterno(1);
		 macchinaService.updateMacchina(m);
		 		 	 
		 it.car2go.servant.utente.Utente u = utenteService.getUtenteById(idUser);
		 model.put("message", "Benvenuto " + u.getNome() + " " + u.getCognome());
		 return "utente/admin/homeadmin";
	 }
	 
	 
	 @RequestMapping("/ripara")
	 public String riparaEsternoAuto(Map<String,Object> model, HttpServletRequest request,HttpServletResponse response){
		 HttpSession session = request.getSession();
		 int idUser = (int) session.getAttribute("idutente");
		 
		 List<it.car2go.servant.macchina.Macchina> lista = macchinaService.getMacchineSporcheEsterno();
		 List<MacchinaView> listaOutput = new ArrayList();
		 Iterator iteratore = lista.iterator();
		 
		 while(iteratore.hasNext()){
			 it.car2go.servant.macchina.Macchina m = (it.car2go.servant.macchina.Macchina) iteratore.next();
			 //Guasto guasto =  guastoService.restituisciGuastoMacchina(m.getIdMacchina());
			 //String nomeGuasto = guasto.getNome();
			 
			 String nomeGuasto = "";
			 List<Guasto> listaGuasti = guastoService.restituisciTuttiGuastiMacchina(m.getIdMacchina());
			 Iterator iterator = listaGuasti.iterator();
			 while(iterator.hasNext()){
				 Guasto g = (Guasto) iterator.next();
				 nomeGuasto = nomeGuasto + " " + g.getNome();
			 }/*fine while sui guasti*/
			 
			
			 //creo un oggetto MacchinaView
			 MacchinaView mv = new MacchinaView();
			 mv.setIdMacchina(m.getIdMacchina());
			 mv.setCodice(m.getCodice());
			 mv.setTipo(m.getTipo());
			 mv.setInterno(m.getInterno());
			 mv.setEsterno(m.getEsterno());
			 mv.setNote(m.getNote());
			 mv.setSerbatoio(m.getSerbatoio());
			 mv.setPrenotata(m.getPrenotata());
			 mv.setLatitudine(m.getLatitudine());
			 mv.setLongitudine(m.getLongitudine());
			 mv.setIndirizzo(m.getIndirizzo());
			 mv.setGuasto(nomeGuasto);
			 
			 listaOutput.add(mv);
			 
		 }/*fine while*/
		 
		 
		 //System.out.println(lista.size());
		 //model.put("macchine", lista);
		 model.put("macchine", listaOutput);
		 return "utente/admin/riparaEsternoAuto";	
	 }
	 
	 
	 
	 @RequestMapping(value="/doRiparaEsterno", method = RequestMethod.POST)
	 public String doRiparaEsternoAuto(Map<String,Object> model, HttpServletRequest request,HttpServletResponse response){
		 		
		 HttpSession session = request.getSession();
		 int idUser = (int) session.getAttribute("idutente");
		 
		 String idmacchina = request.getParameter("idMacchina");
		 int idMacchina = Integer.parseInt(idmacchina);
		 
		 it.car2go.servant.macchina.Macchina m = macchinaService.getMacchina(idMacchina);
		 m.setEsterno(1);
		 macchinaService.updateMacchina(m);
		 
		//cancello Guasti
		 guastoService.cancellaGuastiMacchina(idMacchina);
		 		 	 
		 it.car2go.servant.utente.Utente u = utenteService.getUtenteById(idUser);
		 model.put("message", "Benvenuto " + u.getNome() + " " + u.getCognome());
		 return "utente/admin/homeadmin";
	 }
	 
	

}
