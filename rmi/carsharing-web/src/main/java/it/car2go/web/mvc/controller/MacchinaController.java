package it.car2go.web.mvc.controller;

import javax.inject.Inject;

import it.car2go.model.Macchina;
import it.car2go.service.MacchinaService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;



@Controller
public class MacchinaController {
	
	@Autowired
	private MacchinaService macchinaService;
	
	@Inject
	public MacchinaController(MacchinaService macchinaService){
		this.macchinaService = macchinaService;
	}
	
	
	@RequestMapping(value="/macchina/{id}")
	public String showMacchina(@PathVariable("id") int id, Model model){
		
		Macchina macchina = macchinaService.getMacchina(id);
		model.addAttribute(macchina);
		
		//in base alla benzina setto un valore		
		int benzina = macchina.getSerbatoio();
		
		if(benzina >= 50)
			model.addAttribute("livelloBenzina", "verde");
		if((benzina<50) && (benzina >= 20))
			model.addAttribute("livelloBenzina", "arancione");
		if(benzina < 20)
			model.addAttribute("livelloBenzina", "rosso");
		
		return "macchina";
	}
	
	

}
