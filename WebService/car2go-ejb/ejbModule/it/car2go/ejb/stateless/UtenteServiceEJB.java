package it.car2go.ejb.stateless;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import it.car2go.model.Ruolo;
import it.car2go.model.Utente;
import it.car2go.persistance.common.UtenteDAO;
import it.car2go.service.UtenteService;

import javax.ejb.EJB;
import javax.ejb.Remote;
import javax.ejb.Stateless;

/**
 * Session Bean implementation class UtenteServiceEJB
 */
@Stateless(mappedName = "UtenteServiceEJB")
@Remote
public class UtenteServiceEJB implements UtenteService {
	
	@EJB(lookup="UtenteDAOEJB")
	private UtenteDAO utenteDao;

    /**
     * Default constructor. 
     */
    public UtenteServiceEJB() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public Utente getUtenteById(int id) {
		Utente u = utenteDao.getUtente(id);
		return u;
	}

	@Override
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
	
	

	@Override
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

	@Override
	public Ruolo getRuoloUtenteById(int id) {
		Ruolo r = utenteDao.getRuoloUtente(id);
		return r;
	}

	@Override
	public void salvaUtente(Utente utente) {
		utenteDao.addUtente(utente);
		
	}

	@Override
	public void cancellaUtente(int id) {
		utenteDao.delUtente(id);		
	}

	@Override
	public void aggiornaUtente(Utente utente) {
		utenteDao.updateUtente(utente);		
	}

	@Override
	public List<Utente> getUtenti() {
		List<Utente> lista = utenteDao.getUtenti();
		return lista;
	}

	@Override
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

	@Override
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
