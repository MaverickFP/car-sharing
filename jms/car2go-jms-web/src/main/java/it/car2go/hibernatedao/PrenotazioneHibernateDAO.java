package it.car2go.hibernatedao;

import java.util.List;

import it.car2go.model.Macchina;
import it.car2go.model.Prenotazione;
import it.car2go.model.Utente;
import it.car2go.persistance.common.PrenotazioneDAO;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class PrenotazioneHibernateDAO implements PrenotazioneDAO{
	
private SessionFactory sessionFactory;
	
	@Autowired
	public PrenotazioneHibernateDAO(SessionFactory sessionFactory) {		
		this.sessionFactory = sessionFactory;
	}
	
	
	

	public PrenotazioneHibernateDAO() {
		
	}




	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	
	private Session currentSession(){
		return sessionFactory.getCurrentSession();
	}

	public void addPrenotazione(Prenotazione p) {
		Session session = currentSession();
		session.beginTransaction();
		session.save(p);
		session.getTransaction().commit();
	}

	public void delPrenotazione(int id) {
		Prenotazione p = getPrenotazione(id);
		Session session = currentSession();
		session.beginTransaction();
		session.delete(p);
		session.getTransaction().commit();
	}

	public void aggiornaPrenotazione(Prenotazione p) {
		Session session = currentSession();
		session.beginTransaction();
		session.saveOrUpdate(p);
		session.getTransaction().commit();		
	}

	public Prenotazione getPrenotazione(int idPrenotazione) {
		Session session = currentSession();
		session.beginTransaction();
		Prenotazione p = (Prenotazione) session.get(Prenotazione.class, idPrenotazione);
		session.getTransaction().commit();
		return p;
	}

	public List<Prenotazione> getPrenotazioni() {
		Session session = currentSession();
		session.beginTransaction();
		List<Prenotazione> lista = session.createCriteria(Prenotazione.class).setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
		session.getTransaction().commit();
		return lista;
	}

	public List<Prenotazione> getPrenotazioniByUtente(Utente utente) {
		int idUtente = utente.getIdUtente();
		
		Session session = currentSession();
		session.beginTransaction();
		
		Query q = session.createQuery("select p from Prenotazione p where p.idUtente = :fname");
		q.setString("fname",  Integer.toString(idUtente));
		List<Prenotazione> lista = q.list();
		
		session.getTransaction().commit();
		
		return lista;
	}

	public List<Prenotazione> getPrenotazioniByMacchina(Macchina macchina) {
		int idMacchina = macchina.getIdMacchina();
		
		Session session = currentSession();
		session.beginTransaction();
		
		Query q = session.createQuery("select p from Prenotazione p where p.idMacchina = :fname");
		q.setString("fname",  Integer.toString(idMacchina));
		List<Prenotazione> lista = q.list();
		
		session.getTransaction().commit();
		
		return lista;
	}
	
	

}
