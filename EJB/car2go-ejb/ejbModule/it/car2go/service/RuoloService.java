package it.car2go.service;

import java.util.List;

import javax.ejb.Remote;

import it.car2go.model.Ruolo;

@Remote
public interface RuoloService {
	
	Ruolo getRuoloById(int id);
	Ruolo getRuoloByNome(String tipoRuolo);
	void aggiornaRuolo(Ruolo ruolo);
	void salvaRuolo(Ruolo ruolo);
	void cancellaRuolo(int id);
	List<Ruolo> getRuoli();
	

}
