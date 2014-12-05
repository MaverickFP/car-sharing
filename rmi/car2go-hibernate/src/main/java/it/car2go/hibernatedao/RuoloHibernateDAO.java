package it.car2go.hibernatedao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import it.car2go.car2go.persistance.common.RuoloDAO;
import it.car2go.model.Ruolo;

@Repository
public class RuoloHibernateDAO implements RuoloDAO{
	
	private SessionFactory sessionFactory;
	
	@Autowired
	public RuoloHibernateDAO(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	
	
	
	public RuoloHibernateDAO() {
		
	}




	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	private Session currentSession(){
		return sessionFactory.getCurrentSession();
	}
	
	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}



	
	public void addRuolo(Ruolo ruolo) {
		//currentSession().save(ruolo);
		Session session = currentSession();		
		session.beginTransaction();
		session.save(ruolo);
		session.getTransaction().commit();
	}
	
	

	public void delRuolo(int id) {
		Ruolo r = this.getRuolo(id);		
		//currentSession().delete(r);
		Session session = currentSession();
		session.beginTransaction();
		session.delete(r);
		session.getTransaction().commit();
	}

	public void updateRuolo(Ruolo ruolo) {
		Session session = currentSession();
		session.beginTransaction();
		//session.update(ruolo);
		session.saveOrUpdate(ruolo);
		session.getTransaction().commit();
		
	}

	public Ruolo getRuolo(int id) {
		Session session = currentSession();
		session.beginTransaction();
		Ruolo r = (Ruolo) session.get(Ruolo.class, id);
		session.getTransaction().commit();
		return r;
	}

	public List<Ruolo> getRuoli() {
		Session session = currentSession();
		session.beginTransaction();
		List<Ruolo> lista = session.createCriteria(Ruolo.class).setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();		
		session.getTransaction().commit();
		return lista;
	}
	

}
