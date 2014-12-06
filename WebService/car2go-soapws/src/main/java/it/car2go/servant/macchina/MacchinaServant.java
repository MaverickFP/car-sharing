package it.car2go.servant.macchina;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebService;

import it.car2go.factory.Factory;
import it.car2go.model.Macchina;
import it.car2go.persistance.common.MacchinaDAO;
import it.car2go.service.MacchinaService;

@WebService(serviceName="MacchinaService")
public class MacchinaServant implements MacchinaService {

private MacchinaDAO macchinaDao;
	
	public MacchinaServant(){
		this.macchinaDao = Factory.getIstance().getMacchinaDao();
	}

	@WebMethod
	public List<Macchina> getMacchine() {
		List<Macchina> lista = macchinaDao.getMacchine();		
		return lista;
	}

	@WebMethod
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

	@WebMethod
	public Macchina getMacchina(int id) {
		Macchina m = macchinaDao.getMacchina(id);
		return m;
	}

	@WebMethod
	public void updateMacchina(Macchina macchina) {
		macchinaDao.updateMacchina(macchina);
	}

	@WebMethod
	public void addMacchina(Macchina macchina) {
		macchinaDao.addMacchina(macchina);
	}

	@WebMethod
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

	@WebMethod
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

	@WebMethod
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
