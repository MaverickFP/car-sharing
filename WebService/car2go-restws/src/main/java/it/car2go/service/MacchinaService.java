package it.car2go.service;

import it.car2go.model.Macchina;

import java.util.List;

public interface MacchinaService {	
	List<Macchina> getMacchine();
	List<Macchina> getMacchineNonPrenotate();
	Macchina getMacchina(int id);
	void updateMacchina(Macchina macchina);
	void addMacchina(Macchina macchina);
	List<Macchina> getMacchineSenzaBenzina();
	List<Macchina> getMacchineSporcheInterno();
	List<Macchina> getMacchineSporcheEsterno();
}


