package it.car2go.servant.utente;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebService;

import it.car2go.factory.Factory;
import it.car2go.model.Ruolo;
import it.car2go.model.Utente;
import it.car2go.persistance.common.UtenteDAO;
import it.car2go.service.UtenteService;

@WebService(serviceName="UtenteService")
public class UtenteServant implements UtenteService {

private UtenteDAO utenteDao;
	
	public UtenteServant(){
		this.utenteDao = Factory.getIstance().getUtenteDao();
	}

	@WebMethod
	public Utente getUtenteById(int id) {
		Utente u = utenteDao.getUtente(id);
		return u;
	}

	@WebMethod
	public Utente getUtenteByUsername(String username) {
		Utente utente = null;		
		List<Utente> lista = new ArrayList();
		Iterator iteratore = lista.iterator();		
		while(iteratore.hasNext()){			
			Utente u = (Utente) iteratore.next();
			if(u.getUsername().equals(username))
				utente = u;
		}		
		return utente;
	}

	@WebMethod
	public Utente getUtenteByUsernamePassword(String username, String password) {
		Utente utente = null;
		List<Utente> lista = utenteDao.getUtenti();
		Iterator iteratore = lista.iterator();
		while(iteratore.hasNext()){
			Utente u = (Utente) iteratore.next();
			if(u.getUsername().equals(username)){
				if(u.getPassword().equals(password))
						utente = u;
			}
		}/*fine while*/		
		return utente;
	}

	@WebMethod
	public Ruolo getRuoloUtenteById(int id) {
		Ruolo r = utenteDao.getRuoloUtente(id);
		return r;
	}

	@WebMethod
	public void salvaUtente(Utente utente) {
		utenteDao.addUtente(utente);
	}

	@WebMethod
	public void cancellaUtente(int id) {
		utenteDao.delUtente(id);
	}

	@WebMethod
	public void aggiornaUtente(Utente utente) {
		utenteDao.updateUtente(utente);	
	}

	@WebMethod
	public List<Utente> getUtenti() {
		List<Utente> lista = utenteDao.getUtenti();
		return lista;
	}

	@WebMethod
	public boolean verificaPresenzaUsername(String username) {
		boolean b = false;
		List<Utente> lista = utenteDao.getUtenti();
		Iterator iteratore = lista.iterator();
		while(iteratore.hasNext()){
			Utente u = (Utente) iteratore.next();
			if(u.getUsername().equals(username))
				b = true;
		}		
		return b;
	}

	@WebMethod
	public List<Utente> elencoUtentiSemplici(int idUtente) {
		List<Utente> listaInput = utenteDao.getUtenti();
		List<Utente> listaOutput = new ArrayList();
		
		Iterator iteratore = listaInput.iterator();
		while(iteratore.hasNext()){
			Utente u = (Utente) iteratore.next();
			Ruolo ru = u.getRuolo();			
			if(ru.getNome().equals("User"))
				if(u.getIdUtente() != idUtente)
					listaOutput.add(u);
		}/*fine while*/
		return listaOutput;
	}

}
