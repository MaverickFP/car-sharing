package it.car2go.factory;

import java.sql.Connection;
import java.sql.DriverManager;





import java.sql.SQLException;

import it.car2go.dao.MacchinaDAOImpl;
import it.car2go.dao.PrenotazioneDAOImpl;
import it.car2go.dao.RuoloDAOImpl;
import it.car2go.dao.UtenteDAOImpl;
import it.car2go.persistance.common.MacchinaDAO;
import it.car2go.persistance.common.PrenotazioneDAO;
import it.car2go.persistance.common.RuoloDAO;
import it.car2go.persistance.common.UtenteDAO;

public class Factory {
	
	//riferimento all' istanza
	private static Factory istance = null;
	
	private MacchinaDAO macchinaDao;
	private UtenteDAO utenteDao;
	private RuoloDAO ruoloDao;
	private PrenotazioneDAO prenotazioneDao;
	
	private Connection conn;
	
	
	//costruttore
    private Factory() {
    	doConnection();
    	macchinaDao = new MacchinaDAOImpl(conn);
    	ruoloDao = new RuoloDAOImpl(conn);
    	utenteDao = new UtenteDAOImpl(conn, ruoloDao);    	
    	prenotazioneDao = new PrenotazioneDAOImpl(conn, utenteDao, macchinaDao);
    }
    
    
    
    private void doConnection(){
    	String jdbc_driver = "com.mysql.jdbc.Driver";    	
    	try {
			Class.forName(jdbc_driver);
			this.conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/car2go2","root","");
		} catch (ClassNotFoundException e) {			
			e.printStackTrace();
		} catch (SQLException e) {			
			e.printStackTrace();
		}
    }/*fine metodo doConnection*/
    
    
    
    

    public static Factory getIstance() {
            if(istance==null)
                    istance = new Factory();
            return istance;
    }
    
    
    public MacchinaDAO getMacchinaDao(){
    	return macchinaDao;
    }
    
    public RuoloDAO getRuoloDao(){
    	return ruoloDao;
    }
    
    public UtenteDAO getUtenteDao(){
    	return utenteDao;
    }
    
    public PrenotazioneDAO getPrenotazioneDao(){
    	return prenotazioneDao;
    }

   


}
