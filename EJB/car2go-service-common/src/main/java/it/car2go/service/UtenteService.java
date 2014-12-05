package it.car2go.service;

import it.car2go.model.Ruolo;
import it.car2go.model.Utente;

import java.util.List;

public interface UtenteService {
	
	Utente getUtenteById(int id);
	Utente getUtenteByUsername(String username);
	Utente getUtenteByUsernamePassword(String username, String password);
	Ruolo getRuoloUtenteById(int id);
	void salvaUtente(Utente utente);
	void cancellaUtente(int id);
	void aggiornaUtente(Utente utente);
	List<Utente> getUtenti();
	boolean verificaPresenzaUsername(String username);
	List<Utente> elencoUtentiSemplici(int idUtente);
	

}
