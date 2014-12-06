package it.car2go.hibernatedao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import it.car2go.car2go.persistance.common.MacchinaDAO;
import it.car2go.model.Macchina;

@Repository
public class MacchinaHibernateDAO implements MacchinaDAO{
	
	private SessionFactory sessionFactory;

	@Autowired
	public MacchinaHibernateDAO(SessionFactory sessionFactory) {		
		this.sessionFactory = sessionFactory;
	}
	
	
	
	public MacchinaHibernateDAO() {
		
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

	public void addMacchina(Macchina macchina) {
		Session session = currentSession();		
		session.beginTransaction();
		session.save(macchina);
		session.getTransaction().commit();
	}

	public void delMacchina(int id) {
		Macchina m = getMacchina(id);
		Session session = currentSession();		
		session.beginTransaction();
		session.delete(m);
		session.getTransaction().commit();
	}

	public void updateMacchina(Macchina macchina) {
		Session session = currentSession();		
		session.beginTransaction();
		session.saveOrUpdate(macchina);
		session.getTransaction().commit();
	}

	public Macchina getMacchina(int id) {
		Session session = currentSession();
		session.beginTransaction();
		Macchina m = (Macchina) session.get(Macchina.class, id);
		session.getTransaction().commit();
		return m;
	}

	public List<Macchina> getMacchine() {
		Session session = currentSession();
		session.beginTransaction();
		List<Macchina> macchine = session.createCriteria(Macchina.class).setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
		session.getTransaction().commit();
		return macchine;
	}
	
	
	

}
