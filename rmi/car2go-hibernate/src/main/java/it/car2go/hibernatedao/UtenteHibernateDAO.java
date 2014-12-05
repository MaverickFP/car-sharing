package it.car2go.hibernatedao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import it.car2go.car2go.persistance.common.UtenteDAO;
import it.car2go.model.Ruolo;
import it.car2go.model.Utente;

@Repository
public class UtenteHibernateDAO implements UtenteDAO{
	
	private SessionFactory sessionFactory;

	@Autowired
	public UtenteHibernateDAO(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	

	public UtenteHibernateDAO() {
		
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

	public void addUtente(Utente utente) {
		Session session = currentSession();		
		session.beginTransaction();
		session.save(utente);
		session.getTransaction().commit();
	}

	public void delUtente(int id) {
		Utente u = getUtente(id);
		
		Session session = currentSession();		
		session.beginTransaction();
		session.delete(u);
		session.getTransaction().commit();
	}

	public void updateUtente(Utente utente) {
		Session session = currentSession();
		session.beginTransaction();
		session.saveOrUpdate(utente);
		session.getTransaction().commit();
	}

	public Utente getUtente(int id) {
		Session session = currentSession();
		session.beginTransaction();
		Utente utente = (Utente) session.get(Utente.class, id);
		session.getTransaction().commit();
		return utente;
	}

	public List<Utente> getUtenti() {
		Session session = currentSession();
		session.beginTransaction();
		List<Utente> lista = session.createCriteria(Utente.class).setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
		session.getTransaction().commit();
		return lista;
	}

	public Ruolo getRuoloUtente(int idUtente) {
		Utente u = getUtente(idUtente);
		int idruolo = u.getIdRuolo();
		
		Session session = currentSession();
		session.beginTransaction();
		
		
		Ruolo ruolo = (Ruolo) session.get(Ruolo.class, idruolo);
		session.getTransaction().commit();
		return ruolo;
	}
	
	
	
	
	
	

}
