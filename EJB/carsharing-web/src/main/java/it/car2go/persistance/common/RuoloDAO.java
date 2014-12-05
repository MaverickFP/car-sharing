package it.car2go.persistance.common;

import it.car2go.model.Ruolo;

import java.util.List;

public interface RuoloDAO {
	
	void addRuolo(Ruolo ruolo);
	void delRuolo(int id);
	void updateRuolo(Ruolo ruolo);
	Ruolo getRuolo(int id);	
	List<Ruolo> getRuoli();

}
