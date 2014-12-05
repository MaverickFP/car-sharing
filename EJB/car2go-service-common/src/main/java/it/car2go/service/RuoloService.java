package it.car2go.service;

import java.util.List;

import it.car2go.model.Ruolo;

public interface RuoloService {
	
	Ruolo getRuoloById(int id);
	Ruolo getRuoloByNome(String tipoRuolo);
	void aggiornaRuolo(Ruolo ruolo);
	void salvaRuolo(Ruolo ruolo);
	void cancellaRuolo(int id);
	List<Ruolo> getRuoli();
	

}
