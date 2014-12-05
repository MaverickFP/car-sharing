package it.car2go.rmi.servente;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import it.car2go.car2go.persistance.common.UtenteDAO;
import it.car2go.model.Ruolo;
import it.car2go.model.Utente;
import it.car2go.service.UtenteService;

public class UtenteServant implements UtenteService {
	
	private UtenteDAO utenteDao;	

	public UtenteServant() {
		
	}
	
	
	public UtenteDAO getUtenteDao() {
		return utenteDao;
	}


	public void setUtenteDao(UtenteDAO utenteDao) {
		this.utenteDao = utenteDao;
	}





	public Utente getUtenteById(int id) {
		Utente u = utenteDao.getUtente(id);
		return u;
	}

	public Ruolo getRuoloUtenteById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	public void salvaUtente(Utente utente) {
		utenteDao.addUtente(utente);
	}

	public void cancellaUtente(int id) {
		// TODO Auto-generated method stub

	}

	public void aggiornaUtente(Utente utente) {
		utenteDao.updateUtente(utente);

	}

	public List<Utente> getUtenti() {
		List<Utente> lista = utenteDao.getUtenti();
		return lista;
	}


	public Utente getUtenteByUsername(String username) {
		Utente utente = null;
		List<Utente> lista = utenteDao.getUtenti();
		Iterator iteratore = lista.iterator();
		while(iteratore.hasNext()){
			Utente u = (Utente) iteratore.next();
			if(u.getUsername().equals(username))
				utente = u;
		}
		
		return utente;
	}


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


	
	/*
	 * Elenco di tutti gli utenti di tipo User.
	 * Nell'elenco non e' presente l'id, idUtente, passato come parametro
	 * @see it.car2go.service.UtenteService#elencoUtentiSemplici(int)
	 */
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
