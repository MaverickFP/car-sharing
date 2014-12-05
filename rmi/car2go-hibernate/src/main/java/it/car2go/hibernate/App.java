package it.car2go.hibernate;



import java.util.Iterator;
import java.util.List;

import it.car2go.car2go.persistance.common.MacchinaDAO;
import it.car2go.car2go.persistance.common.PrenotazioneDAO;
import it.car2go.car2go.persistance.common.RuoloDAO;
import it.car2go.car2go.persistance.common.UtenteDAO;
import it.car2go.model.Macchina;
import it.car2go.model.Prenotazione;
import it.car2go.model.Ruolo;
import it.car2go.model.Utente;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Hello world!
 *
 */
public class App 
{
	
	
	
	
	
    public static void main( String[] args )
    {
    	ApplicationContext context = new ClassPathXmlApplicationContext("spring-config.xml");
    	
    	RuoloDAO ruoloDao = (RuoloDAO) context.getBean("ruoloDao");
    	
    	//testing DAO
    	Ruolo r = new Ruolo();
    	r.setIdRuolo(1);
    	r.setNome("Admin");
    	r.setCodice(123);
    	
    	//ruoloDao.addRuolo(r);
    	
    	//Ruolo r1 = ruoloDao.getRuolo(1);
    	//System.out.println(r1.getNome());
    	
    	List<Ruolo> lista = ruoloDao.getRuoli();
    	int dim = lista.size();
    	System.out.println(dim);
    	
    	Iterator iterator = lista.iterator();
    	while(iterator.hasNext()){
    		Ruolo ri = (Ruolo) iterator.next();
    		System.out.println(ri.getNome());
    	}
    	
    	//test utente dao
    	Utente u = new Utente();
    	u.setIdUtente(1);
    	u.setNome("Francesco");
    	u.setCognome("Paris");
    	u.setNazione("Ita");
    	u.setUsername("user");
    	u.setPassword("pass");
    	u.setMail("mail@email.it");
    	u.setPin(111);
    	u.setRuolo(r);
    	
    	UtenteDAO utenteDao = (UtenteDAO) context.getBean("utenteDao");
    	//utenteDao.addUtente(u);
    	Utente user = utenteDao.getUtente(1);
    	Ruolo ru = ruoloDao.getRuolo(user.getIdRuolo());
    	System.out.println("Ruolo utente 1 " + ru.getNome());
    	
    	Utente u1 = new Utente();
    	//u1.setIdUtente(1);
    	u1.setNome("Daniel");
    	u1.setCognome("Ciofani");
    	u1.setNazione("Ita");
    	u1.setUsername("user");
    	u1.setPassword("pass");
    	u1.setMail("mail@email.it");
    	u1.setPin(111);
    	u1.setRuolo(r);
    	//utenteDao.addUtente(u1);
    	
    	
    	
    	//test prenotazioni dao
    	PrenotazioneDAO prenDao = (PrenotazioneDAO) context.getBean("prenotazioneDao");
    	List<Prenotazione> listaPren = prenDao.getPrenotazioniByUtente(u);
    	System.out.println(listaPren.size());
    	
    	
    	//test Macchina Dao
    	MacchinaDAO macchinaDao = (MacchinaDAO) context.getBean("macchinaDao");
    	List<Macchina> listaMacchine = macchinaDao.getMacchine();
    	System.out.println(listaMacchine.size());
    	
    	
    }
}
