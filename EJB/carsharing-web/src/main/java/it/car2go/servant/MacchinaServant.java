package it.car2go.servant;

import it.car2go.persistance.common.MacchinaDAO;
import it.car2go.service.MacchinaService;
import it.car2go.model.Macchina;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class MacchinaServant implements MacchinaService{
	
private MacchinaDAO macchinaDao;
	
	

	public MacchinaServant() {
		
	}
	
	

	public MacchinaDAO getMacchinaDao() {
		return macchinaDao;
	}



	public void setMacchinaDao(MacchinaDAO macchinaDao) {
		this.macchinaDao = macchinaDao;
	}





	public List<Macchina> getMacchine() {
		List<Macchina> lista = macchinaDao.getMacchine();
		//System.out.println(lista.size());
		return lista;
	}



	public List<Macchina> getMacchineNonPrenotate() {
		List<Macchina> listaInput = macchinaDao.getMacchine();
		List<Macchina> listaOutput = new ArrayList<Macchina>();
		
		Iterator iterator = listaInput.iterator();
		while(iterator.hasNext()){
			Macchina m = (Macchina) iterator.next();
			if(m.getPrenotata() == 0){
				listaOutput.add(m);
				
			}	
		}//fine while
		
		
		return listaOutput;
	}
	
	
	
	public Macchina getMacchina(int id){
		Macchina macchina = macchinaDao.getMacchina(id);
		return macchina;
	}



	public void updateMacchina(Macchina macchina) {
		macchinaDao.updateMacchina(macchina);
		
	}



	public void addMacchina(Macchina macchina) {
		macchinaDao.addMacchina(macchina);
		
	}



	public List<Macchina> getMacchineSenzaBenzina() {
		List<Macchina> listaInput = macchinaDao.getMacchine();
		List<Macchina> listaOutput = new ArrayList();
		
		Iterator iteratore = listaInput.iterator();
		while(iteratore.hasNext()){
			Macchina m = (Macchina) iteratore.next();
			if(m.getSerbatoio() <= 20)
				listaOutput.add(m);
		}/*fine while*/
		
		return listaOutput;
	}



	public List<Macchina> getMacchineSporcheInterno() {
		List<Macchina> listaInput = macchinaDao.getMacchine();
		List<Macchina> listaOutput = new ArrayList();
		
		Iterator iteratore = listaInput.iterator();
		while(iteratore.hasNext()){
			Macchina m = (Macchina) iteratore.next();
			if(m.getInterno() == 3)
				listaOutput.add(m);
		}/*fine while*/
		
		return listaOutput;
	}



	public List<Macchina> getMacchineSporcheEsterno() {
		List<Macchina> listaInput = macchinaDao.getMacchine();
		List<Macchina> listaOutput = new ArrayList();
		
		Iterator iteratore = listaInput.iterator();
		while(iteratore.hasNext()){
			Macchina m = (Macchina) iteratore.next();
			if(m.getEsterno() == 3)
				listaOutput.add(m);
		}/*fine while*/
		
		return listaOutput;
	}

}
