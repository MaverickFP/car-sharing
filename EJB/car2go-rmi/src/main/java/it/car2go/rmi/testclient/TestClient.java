package it.car2go.rmi.testclient;

import java.util.List;

import it.car2go.model.Macchina;
import it.car2go.model.Ruolo;
import it.car2go.model.Utente;
import it.car2go.service.MacchinaService;
import it.car2go.service.RuoloService;
import it.car2go.service.UtenteService;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestClient {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext context = new ClassPathXmlApplicationContext("spring-config-client.xml");
		
		MacchinaService macchinaService = (MacchinaService) context.getBean("macchinaService");
		List<Macchina> lista = macchinaService.getMacchineNonPrenotate();
		if(lista == null)
			System.out.println("Nessuna macchina libera");
		else
			System.out.println(lista.size());
		
		
		//provo ruolo service
		
		RuoloService ruoloService = (RuoloService) context.getBean("ruoloService");
		Ruolo r = ruoloService.getRuoloByNome("User");
		System.out.println(r.getIdRuolo());
		
		
		//provo utente service
		UtenteService utenteService = (UtenteService) context.getBean("utenteService");
		Utente utente = utenteService.getUtenteByUsernamePassword("user2", "pass2");	
		Ruolo ru = utente.getRuolo();
		System.out.println(ru.getNome());
		System.out.println(utente.getCognome());

	}

}
