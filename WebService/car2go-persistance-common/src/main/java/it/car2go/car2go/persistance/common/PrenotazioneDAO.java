package it.car2go.car2go.persistance.common;

import java.util.List;

import it.car2go.model.Macchina;
import it.car2go.model.Prenotazione;
import it.car2go.model.Utente;

public interface PrenotazioneDAO {
	
	void addPrenotazione(Prenotazione p);
	void delPrenotazione(int id);
	void aggiornaPrenotazione(Prenotazione p);
	Prenotazione getPrenotazione(int idPrenotazione);
	List<Prenotazione> getPrenotazioni();
	List<Prenotazione> getPrenotazioniByUtente(Utente utente);
	List<Prenotazione> getPrenotazioniByMacchina(Macchina macchina);
	

}
