package it.car2go.persistance.common;

import it.car2go.model.Guasto;

import java.util.List;

public interface GuastoDAO {

	public List<Guasto> getGuasti();
	public Guasto getGuastoMacchina(int idMacchina);
	public void addGuasto(String nome, int idMacchina);
	public void delGuasto(int idGuasto);
	public void delGuastoMacchina(int idMacchina);
	public List<Guasto> getTuttiGuastiMacchina(int idMacchina);
	
}
