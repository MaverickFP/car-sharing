package it.car2go.ejb.stateless;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import it.car2go.model.Macchina;
import it.car2go.persistance.common.MacchinaDAO;
import it.car2go.service.MacchinaService;

import javax.ejb.EJB;
import javax.ejb.Remote;
import javax.ejb.Stateless;

/**
 * Session Bean implementation class MacchinaServiceEJB
 */
@Stateless(mappedName = "MacchinaServiceEJB")
@Remote
public class MacchinaServiceEJB implements MacchinaService {
	
	
	
	@EJB(lookup="MacchinaDAOEJB")
	private MacchinaDAO macchinaDao;

    /**
     * Default constructor. 
     */
    public MacchinaServiceEJB() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public List<Macchina> getMacchine() {
		List<Macchina> lista = macchinaDao.getMacchine();
		return lista;
	}

	@Override
	public List<Macchina> getMacchineNonPrenotate() {
		List<Macchina> listaInput = macchinaDao.getMacchine();
		List<Macchina> listaOutput = new ArrayList<Macchina>();
		
		Iterator iterator = listaInput.iterator();
		
		while(iterator.hasNext()){
			Macchina m = (Macchina) iterator.next();
			if(m.getPrenotata() == 0){
				listaOutput.add(m);
			}
		}
		
		return listaOutput;
	}
	
	

	@Override
	public Macchina getMacchina(int id) {		
		Macchina m = macchinaDao.getMacchina(id);
		return m;
	}

	
	@Override
	public void updateMacchina(Macchina macchina) {
		macchinaDao.updateMacchina(macchina);		
	}

	@Override
	public void addMacchina(Macchina macchina) {
		macchinaDao.addMacchina(macchina);		
	}

	@Override
	public List<Macchina> getMacchineSenzaBenzina() {
		List<Macchina> listaInput = macchinaDao.getMacchine();
		List<Macchina> listaOutput = new ArrayList<Macchina>();
		
		Iterator iterator = listaInput.iterator();
		while(iterator.hasNext()){
			Macchina m = (Macchina) iterator.next();
			if(m.getSerbatoio() <= 20){
				listaOutput.add(m);				
			}
		}		
		return listaOutput;
	}

	
	@Override
	public List<Macchina> getMacchineSporcheInterno() {
		List<Macchina> listaInput = macchinaDao.getMacchine();
		List<Macchina> listaOutput = new ArrayList<Macchina>();
		
		Iterator iterator = listaInput.iterator();
		while(iterator.hasNext()){
			Macchina m = (Macchina) iterator.next();
			if(m.getInterno() == 3){
				listaOutput.add(m);				
			}
		}				
		return listaOutput;
	}
	

	@Override
	public List<Macchina> getMacchineSporcheEsterno() {
		List<Macchina> listaInput = macchinaDao.getMacchine();
		List<Macchina> listaOutput = new ArrayList<Macchina>();
		
		Iterator iterator = listaInput.iterator();
		while(iterator.hasNext()){
			Macchina m = (Macchina) iterator.next();
			if(m.getEsterno() == 3){
				listaOutput.add(m);				
			}
		}				
		return listaOutput;
	}

}
