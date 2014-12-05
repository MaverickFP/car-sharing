package it.car2go.rmi.servente;

import java.util.Iterator;
import java.util.List;

import it.car2go.car2go.persistance.common.RuoloDAO;
import it.car2go.model.Ruolo;
import it.car2go.service.RuoloService;

public class RuoloServant implements RuoloService {
	
	private RuoloDAO ruoloDao;	

	public RuoloServant() {
		
	}
	
	
	
	public RuoloDAO getRuoloDao() {
		return ruoloDao;
	}



	public void setRuoloDao(RuoloDAO ruoloDao) {
		this.ruoloDao = ruoloDao;
	}



	public Ruolo getRuoloById(int id) {
		Ruolo ruolo = ruoloDao.getRuolo(id);
		return ruolo;
	}

	public void aggiornaRuolo(Ruolo ruolo) {
		// TODO Auto-generated method stub

	}

	public void salvaRuolo(Ruolo ruolo) {
		// TODO Auto-generated method stub

	}

	public void cancellaRuolo(int id) {
		// TODO Auto-generated method stub

	}

	public List<Ruolo> getRuoli() {
		// TODO Auto-generated method stub
		return null;
	}

	public Ruolo getRuoloByNome(String tipoRuolo) {
		Ruolo ris = null;
		List<Ruolo> lista = ruoloDao.getRuoli();
		Iterator iteratore = lista.iterator();
		while(iteratore.hasNext()){
			Ruolo r = (Ruolo) iteratore.next();
			String nomeRuolo = r.getNome();
			if( nomeRuolo.equals(tipoRuolo) ){
				ris = r;
			}
		}/*fine while*/		
		return ris;
	}

}
