package it.car2go.servant.prenotazione;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebService;

import it.car2go.factory.Factory;
import it.car2go.model.Prenotazione;
import it.car2go.persistance.common.PrenotazioneDAO;
import it.car2go.service.PrenotazioneService;

@WebService(serviceName="PrenotazioneService")
public class PrenotazioneServant implements PrenotazioneService {

private PrenotazioneDAO prenotazioneDao;
	
	public PrenotazioneServant(){
		this.prenotazioneDao = Factory.getIstance().getPrenotazioneDao();
	}

	@WebMethod
	public List<Prenotazione> getPrenotazioniByUserId(int idUser) {
		List<Prenotazione> listaOutput = new ArrayList<Prenotazione>();
		
		List<Prenotazione> listaInput = prenotazioneDao.getPrenotazioni();
		Iterator iteratore = listaInput.iterator();
		while(iteratore.hasNext()){
			Prenotazione p = (Prenotazione) iteratore.next();
			int num = p.getIntIdUtente();
			if( num == idUser)
				listaOutput.add(p);
		}
		
		return listaOutput;
	}

	@WebMethod
	public List<Prenotazione> getPrenotazioni() {
		List<Prenotazione> lista = prenotazioneDao.getPrenotazioni();
		return lista;
	}

	@WebMethod
	public Prenotazione getPrenotazione(int idPrenotazione) {
		Prenotazione p = prenotazioneDao.getPrenotazione(idPrenotazione);
		return p;
	}

	@WebMethod
	public void addPrenotazione(Prenotazione prenotazione) {
		prenotazioneDao.addPrenotazione(prenotazione);
	}

	@WebMethod
	public void delPrenotazione(int idPrenotazione) {
		prenotazioneDao.delPrenotazione(idPrenotazione);
	}

	@WebMethod
	public int getLastIdPrenotazione(int idUser, int idMacchina) {
		int ris = 0;
		List<Prenotazione> lista = this.getPrenotazioniByUserId(idUser);
		Iterator iteratore = lista.iterator();
		while(iteratore.hasNext()){
			Prenotazione p = (Prenotazione) iteratore.next();
			int idcar = p.getIntIdMacchina();
			if(idcar == idMacchina)
				ris = p.getIdPrenotazione();
		}
		return ris;
	}
	

	@WebMethod
	public void updatePrenotazione(Prenotazione p) {
		prenotazioneDao.aggiornaPrenotazione(p);
	}

}
