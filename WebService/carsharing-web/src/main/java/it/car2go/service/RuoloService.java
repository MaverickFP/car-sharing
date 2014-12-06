package it.car2go.service;

import it.car2go.model.Ruolo;

import java.util.List;

public interface RuoloService {
	
	Ruolo getRuoloById(int id);
	Ruolo getRuoloByNome(String tipoRuolo);
	void aggiornaRuolo(Ruolo ruolo);
	void salvaRuolo(Ruolo ruolo);
	void cancellaRuolo(int id);
	List<Ruolo> getRuoli();

}
