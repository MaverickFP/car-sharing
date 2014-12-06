package it.car2go.persistance.common;

import it.car2go.model.Macchina;

import java.util.List;

public interface MacchinaDAO {
	
	void addMacchina(Macchina macchina);
	void delMacchina(int id);
	void updateMacchina(Macchina macchina);
	Macchina getMacchina(int id);
	List<Macchina> getMacchine();

}
