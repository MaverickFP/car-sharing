package it.car2go.persistance.common;

import java.util.List;

import javax.ejb.Remote;

import it.car2go.model.Macchina;

@Remote
public interface MacchinaDAO {
	
	void addMacchina(Macchina macchina);
	void delMacchina(int id);
	void updateMacchina(Macchina macchina);
	Macchina getMacchina(int id);
	List<Macchina> getMacchine();
	

}
