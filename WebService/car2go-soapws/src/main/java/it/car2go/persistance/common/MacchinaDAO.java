package it.car2go.persistance.common;

import java.util.List;

import it.car2go.model.Macchina;

public interface MacchinaDAO {
	
	void addMacchina(Macchina macchina);
	void delMacchina(int id);
	void updateMacchina(Macchina macchina);
	Macchina getMacchina(int id);
	List<Macchina> getMacchine();
	

}
