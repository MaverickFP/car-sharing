package it.car2go.servant.ruolo;

import java.util.Iterator;
import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebService;

import it.car2go.factory.Factory;
import it.car2go.model.Ruolo;
import it.car2go.persistance.common.RuoloDAO;
import it.car2go.service.RuoloService;

@WebService(serviceName="RuoloService")
public class RuoloServant implements RuoloService {
	
	private RuoloDAO ruoloDao;
	
	public RuoloServant(){
		this.ruoloDao = Factory.getIstance().getRuoloDao();
	}

	@WebMethod
	public Ruolo getRuoloById(int id) {
		Ruolo ruolo = ruoloDao.getRuolo(id);
		return ruolo;
	}

	@WebMethod
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

	@WebMethod
	public void aggiornaRuolo(Ruolo ruolo) {
		ruoloDao.updateRuolo(ruolo);
	}

	@WebMethod
	public void salvaRuolo(Ruolo ruolo) {
		ruoloDao.addRuolo(ruolo);
	}

	@WebMethod
	public void cancellaRuolo(int id) {
		ruoloDao.delRuolo(id);
	}

	@WebMethod
	public List<Ruolo> getRuoli() {
		List<Ruolo> lista = ruoloDao.getRuoli();		
		return lista;
	}

}
