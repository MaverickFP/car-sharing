package it.car2go.web.mvc.controller;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.Date;
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

import it.car2go.model.Macchina;
import it.car2go.model.Prenotazione;
import it.car2go.model.PrenotazioneView;
import it.car2go.model.Ruolo;
import it.car2go.model.Utente;
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
	 
	 
	 
	
	 	
}
