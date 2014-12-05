package it.car2go.service;

import it.car2go.model.Guasto;

import java.util.List;

public interface GuastoService {
	
	
	public List<Guasto> restituisciGuasti();
	public Guasto restituisciGuastoMacchina(int idMacchina);
	public void salvaGuasto(String nome, int idMacchina);

}
