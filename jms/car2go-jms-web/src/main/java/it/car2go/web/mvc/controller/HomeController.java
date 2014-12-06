package it.car2go.web.mvc.controller;

import it.car2go.ejb.stateful.ApplicationEJBRemote;
import it.car2go.jms.sender.Sender;
import it.car2go.model.Macchina;
import it.car2go.service.GeoService;
import it.car2go.service.MacchinaService;

import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.jms.Message;
import javax.jms.MessageListener;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


//https://www.youtube.com/watch?v=Jm-2UMGhwhE   min 30
//http://www.nurkiewicz.com/2013/03/deferredresult-asynchronous-processing.html
//https://netbeans.org/kb/docs/javaee/javaee-entapp-ejb.html

@Controller
public class HomeController implements MessageListener {
	
	
	@Autowired
	private MacchinaService macchinaService;
	@Autowired
	private Sender sender;
	
	@Inject
	public HomeController(MacchinaService macchinaService){
		this.macchinaService = macchinaService;
		
		
	}
	
	
	@RequestMapping({"/","/home"})
	public String showHomePage(Map<String, Object> model){
		
		List<Macchina> lista = macchinaService.getMacchineNonPrenotate();
		int size = lista.size();		
		
		model.put("macchine", macchinaService.getMacchineNonPrenotate());
		model.put("totaleMacchine", size);
		
		return "home";
	}
	
	
	
	@RequestMapping("/hello")
    public ModelAndView helloWorld() {
		
		
		
		List<Macchina> lista = macchinaService.getMacchineNonPrenotate();
		int size = lista.size();
		
		
		
		String message = "pippo";
        return new ModelAndView("home", "message", message);
	}


	@Override
	public void onMessage(Message arg0) {
		// TODO Auto-generated method stub
		
	}
	

}
