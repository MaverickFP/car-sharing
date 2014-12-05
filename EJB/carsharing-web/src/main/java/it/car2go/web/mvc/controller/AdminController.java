package it.car2go.web.mvc.controller;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import it.car2go.model.Macchina;
import it.car2go.model.Ruolo;
import it.car2go.model.Utente;
import it.car2go.service.MacchinaService;
import it.car2go.service.PrenotazioneService;
import it.car2go.service.RuoloService;
import it.car2go.service.UtenteService;

import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;



@Controller
@RequestMapping("/utente/admin")
public class AdminController {
	
	@Autowired
	private UtenteService utenteService;
	@Autowired
	private RuoloService ruoloService;
	
	
	@Inject
	public AdminController(UtenteService utenteService, RuoloService ruoloService){
		this.utenteService = utenteService;
		this.ruoloService = ruoloService;
		
	}
	
	
	 @RequestMapping("/goAdminHome")
	 public  String goAdminHome(Map<String,Object> model, HttpServletRequest request,HttpServletResponse response) {
		 
		 SecurityManager sm = new MySecurityManager();
		 System.setSecurityManager(sm);
		 
		 HttpSession session = request.getSession();
		 int idUser = (int) session.getAttribute("idutente");
		 
		 Utente u = utenteService.getUtenteById(idUser);		 
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
	
	

}
