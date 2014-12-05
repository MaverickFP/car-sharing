package it.car2go.service;

import it.car2go.model.Macchina;
import it.car2go.model.Prenotazione;
import it.car2go.model.Ruolo;
import it.car2go.model.Utente;

import java.util.List;

import javax.ejb.Remote;

@Remote
public interface ApplicationEJBRemote {
	
	/*
     * Operazioni relative a Macchina
     */	
	public Macchina getMacchina(int idMacchina);
	public List<Macchina> getMacchineLibere();
	public void creaMacchina(String tipo, int codice);
	public List<Macchina> getMacchineSenzaBenzina();
	public void effettuaRifornimento(int idMacchina);
	public void pulisciMacchina(int idMacchina);
	public void riparaMacchina(int idMacchina);
	public List<Macchina> elencoMacchineSporcheInterno();
	public List<Macchina> elencoMacchineDaRiparareEsterno();
	public void aggiornaMacchina(Macchina m);
	
	/*
     * Operazioni relative a Utente
     */	
	public Utente getUtenteById(int idUtente);
	public boolean verificaPresenzaUtente(String username);
	public void salvaNuovoUtente(Utente utente);
	public Utente recuperaUtente(String username, String password);
	public int totaleNumPrenotazioni(int idUser);
	public int totaleTempo(int idUser);
	public int totaleDistanza(int idUser);
	public List<Utente> elencoUtentiSemplici(int idUtente);
	public void abilitaUtente(int idUtente);
	public List<Prenotazione> recuperaPrenotazioniUtente(int idUtente);
	
	/*
     * Operazioni relative a Prenotazione
     */	
	public int effettuaPrenotazione(int idUtente, int idMacchina);
	public void cancellaGuida(int idPrenotazione, int idMacchina);
	public void effettuaGuida(int idUtente, int idPrenotazione, int idMacchina, int interno, int esterno, String note);
	public Prenotazione getPrenotazione(int idPrenotazione);
	public int calcolaDistanza(float latV, float lngV, float latN, float lngN);
	public void updatePrenotazione(Prenotazione p);
	
	/*
     * Operazioni relative a Ruolo
     * 
     */	
	public Ruolo recuperaRuolo(int idRuolo);
	
	/*
     * Operazioni relative a test
     */	
	public String hello();

}
