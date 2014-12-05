package it.car2go.persistance.common;

import java.util.List;

import javax.ejb.Remote;

import it.car2go.model.Ruolo;

@Remote
public interface RuoloDAO {
	
	void addRuolo(Ruolo ruolo);
	void delRuolo(int id);
	void updateRuolo(Ruolo ruolo);
	Ruolo getRuolo(int id);	
	List<Ruolo> getRuoli();

}
