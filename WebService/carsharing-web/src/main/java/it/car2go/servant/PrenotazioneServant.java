package it.car2go.servant;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import it.car2go.persistance.common.PrenotazioneDAO;
import it.car2go.model.Prenotazione;
import it.car2go.service.PrenotazioneService;

public class PrenotazioneServant implements PrenotazioneService{
	
	private PrenotazioneDAO prenotazioneDao;
	

	public PrenotazioneServant() {
		
	}
	
	

	public PrenotazioneDAO getPrenotazioneDao() {
		return prenotazioneDao;
	}




	public void setPrenotazioneDao(PrenotazioneDAO prenotazioneDao) {
		this.prenotazioneDao = prenotazioneDao;
	}




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

	
	
	public List<Prenotazione> getPrenotazioni() {
		List<Prenotazione> lista = prenotazioneDao.getPrenotazioni();
		return lista;
	}

	public Prenotazione getPrenotazione(int idPrenotazione) {
		Prenotazione p = prenotazioneDao.getPrenotazione(idPrenotazione);
		return p;
	}

	public void addPrenotazione(Prenotazione prenotazione) {
		prenotazioneDao.addPrenotazione(prenotazione);
		
	}



	public void delPrenotazione(int idPrenotazione) {
		prenotazioneDao.delPrenotazione(idPrenotazione);
		
	}



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



	public void updatePrenotazione(Prenotazione p) {
		prenotazioneDao.aggiornaPrenotazione(p);
		
	}


}
