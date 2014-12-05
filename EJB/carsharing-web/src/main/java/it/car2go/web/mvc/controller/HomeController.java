package it.car2go.web.mvc.controller;

import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import it.car2go.model.Macchina;
import it.car2go.service.ApplicationEJBRemote;
import it.car2go.service.MacchinaService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {
	
	@Autowired
	private MacchinaService macchinaService;
	
			
	@Inject
	public HomeController(MacchinaService macchinaService){
		this.macchinaService = macchinaService;
	}
	
	
	@RequestMapping({"/","/home"})
	public String showHomePage(Map<String, Object> model){
		
		SecurityManager sm = new MySecurityManager();
		System.setSecurityManager(sm);
		
		List<Macchina> lista = macchinaService.getMacchineNonPrenotate();
		int size = lista.size();
		
		
		model.put("macchine", macchinaService.getMacchineNonPrenotate());
		model.put("totaleMacchine", size);
		
		return "home";
	}
	
	
	
	@RequestMapping("/hello")
    public ModelAndView helloWorld() {
		
		SecurityManager sm = new MySecurityManager();
		System.setSecurityManager(sm);
		
		List<Macchina> lista = macchinaService.getMacchineNonPrenotate();
		int size = lista.size();
		
				
		String message = "pippo";
        return new ModelAndView("home", "message", size);
	}

}
