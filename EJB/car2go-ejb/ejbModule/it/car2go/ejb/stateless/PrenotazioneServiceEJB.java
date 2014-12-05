package it.car2go.ejb.stateless;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import it.car2go.model.Prenotazione;
import it.car2go.persistance.common.PrenotazioneDAO;
import it.car2go.service.PrenotazioneService;

import javax.ejb.EJB;
import javax.ejb.Remote;
import javax.ejb.Stateless;

/**
 * Session Bean implementation class PrenotazioneServiceEJB
 */
@Stateless(mappedName = "PrenotazioneServiceEJB")
@Remote
public class PrenotazioneServiceEJB implements PrenotazioneService {
	
	@EJB(lookup="PrenotazioneDAOEJB")
	private PrenotazioneDAO prenotazioneDao;

    /**
     * Default constructor. 
     */
    public PrenotazioneServiceEJB() {
        // TODO Auto-generated constructor stub
    }

	@Override
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

	@Override
	public List<Prenotazione> getPrenotazioni() {
		List<Prenotazione> lista = prenotazioneDao.getPrenotazioni();
		return lista;
	}

	@Override
	public Prenotazione getPrenotazione(int idPrenotazione) {
		Prenotazione p = prenotazioneDao.getPrenotazione(idPrenotazione);
		return p;
	}

	@Override
	public void addPrenotazione(Prenotazione prenotazione) {
		prenotazioneDao.addPrenotazione(prenotazione);
		
	}

	@Override
	public void delPrenotazione(int idPrenotazione) {
		prenotazioneDao.delPrenotazione(idPrenotazione);		
	}

	@Override
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

	@Override
	public void updatePrenotazione(Prenotazione p) {
		prenotazioneDao.aggiornaPrenotazione(p);		
	}

}
