package it.car2go.ejb.stateless;

import java.util.Iterator;
import java.util.List;

import it.car2go.model.Ruolo;
import it.car2go.persistance.common.RuoloDAO;
import it.car2go.service.RuoloService;

import javax.ejb.EJB;
import javax.ejb.Remote;
import javax.ejb.Stateless;

/**
 * Session Bean implementation class RuoloServiceEJB
 */
@Stateless(mappedName = "RuoloServiceEJB")
@Remote
public class RuoloServiceEJB implements RuoloService {
	
	@EJB(lookup="RuoloDAOEJB")
	private RuoloDAO ruoloDao;

    /**
     * Default constructor. 
     */
    public RuoloServiceEJB() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public Ruolo getRuoloById(int id) {
		Ruolo ruolo = ruoloDao.getRuolo(id);
		return ruolo;
	}

	@Override
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

	@Override
	public void aggiornaRuolo(Ruolo ruolo) {
		ruoloDao.updateRuolo(ruolo);		
	}

	@Override
	public void salvaRuolo(Ruolo ruolo) {
		ruoloDao.addRuolo(ruolo);		
	}

	@Override
	public void cancellaRuolo(int id) {
		ruoloDao.delRuolo(id);		
	}

	@Override
	public List<Ruolo> getRuoli() {
		List<Ruolo> lista = ruoloDao.getRuoli();		
		return lista;
	}

}
