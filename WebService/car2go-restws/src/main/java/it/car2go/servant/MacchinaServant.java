package it.car2go.servant;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import it.car2go.factory.Factory;
import it.car2go.model.Macchina;
import it.car2go.persistance.common.MacchinaDAO;
import it.car2go.service.MacchinaService;

@Path("/macchina")
public class MacchinaServant implements MacchinaService {
	
	private MacchinaDAO macchinaDao;
	
	public MacchinaServant(){
		this.macchinaDao = Factory.getIstance().getMacchinaDao();
	}
	

	/*
	 * Restituisce tutte le macchine
	 */
	@Path("/allMacchine")
	@GET	
	@Produces(MediaType.APPLICATION_JSON)
	public List<Macchina> getMacchine() {
		List<Macchina> lista = macchinaDao.getMacchine();
		return lista;
	}
	
	
	
	/*
	 * Restituisce il numero totale delle macchine
	 */
	@Path("/totaleMacchine")
	@GET	
	@Produces(MediaType.APPLICATION_JSON)
	public int getNumTotaleMacchine(){
		List<Macchina> lista = macchinaDao.getMacchine();
		int ris = lista.size();		
		return ris;
	}
	
	
	/*
	 * Restituisce il numero totale delle macchine
	 */
	@Path("/totaleMacchineNonPrenotate")
	@GET	
	@Produces(MediaType.APPLICATION_JSON)
	public int getNumTotaleMacchineNonPrenotate(){
		int ris = 0;
		List<Macchina> listaInput = macchinaDao.getMacchine();		
		Iterator iterator = listaInput.iterator();		
		while(iterator.hasNext()){
			Macchina m = (Macchina) iterator.next();
			if(m.getPrenotata() == 0){
				ris = ris + 1;
			}
		}		
		return ris;
	}
	
	

	/*
	 * Restituisce tutte le macchine non prenotate
	 */
	@Path("/allMacchineNonPrenotate")
	@GET	
	@Produces(MediaType.APPLICATION_JSON)
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

	
	
	/*
	 * Restituisce una macchina
	 */	
	@Path("/{c}")
	@GET	
	@Produces(MediaType.APPLICATION_JSON)
	public Macchina getMacchina(@PathParam("c") int i) {
		Macchina m = macchinaDao.getMacchina(i);
		System.out.println(m.getTipo());
		return m;
	}

	
	
	
	
	/*
	 * Aggiorna una macchina
	 */
	@Path("/{c}")
	@PUT	
	@Consumes(MediaType.APPLICATION_JSON)
	public void updateMacchina(Macchina macchina) {
		macchinaDao.updateMacchina(macchina);
	}
	
	
	
	

	/*
	 * Aggiunge una macchina
	 */
	@POST	
	@Consumes(MediaType.APPLICATION_JSON)
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
