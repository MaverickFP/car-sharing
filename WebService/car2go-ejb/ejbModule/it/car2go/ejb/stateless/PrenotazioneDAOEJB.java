package it.car2go.ejb.stateless;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import it.car2go.model.Macchina;
import it.car2go.model.Prenotazione;
import it.car2go.model.Utente;
import it.car2go.persistance.common.MacchinaDAO;
import it.car2go.persistance.common.PrenotazioneDAO;
import it.car2go.persistance.common.UtenteDAO;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.ejb.EJB;
import javax.ejb.Remote;
import javax.ejb.Stateless;

/**
 * Session Bean implementation class PrenotazioneDAOEJB
 */
@Stateless(mappedName = "PrenotazioneDAOEJB")
@Remote
public class PrenotazioneDAOEJB implements PrenotazioneDAO {

	
	private Connection conn;
	
	@EJB(lookup="MacchinaDAOEJB")
	private MacchinaDAO macchinaDao;
	
	@EJB(lookup="UtenteDAOEJB")
	private UtenteDAO utenteDao;
	
    /**
     * Default constructor. 
     */
    public PrenotazioneDAOEJB() {
        // TODO Auto-generated constructor stub
    }
    
    @PostConstruct   
    public void inizializza(){
    	System.out.println("Inizializzo");
    	try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			this.conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/car2go","root","");			
			
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    }/*fine di inizializza*/
   
   
   
   @PreDestroy
   public void rilascia(){
	   
	   if(conn != null){
		   try {
			conn.close();
			System.out.println("Disconnessione effettuata con successo!!!");
		   }catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		   }		  
	   }
	   
   }/*fine metodo rilascia*/
    
    

	@Override
	public void addPrenotazione(Prenotazione p) {
		String sql = "INSERT INTO Prenotazione (idUtente, idMacchina, distanza, tempo, data) VALUES" + "(?,?,?,?,?)";
		PreparedStatement st;
		try {
			st = conn.prepareStatement(sql);
			st.setInt(1, p.getIntIdUtente());
			st.setInt(2, p.getIntIdMacchina());
			st.setInt(3, p.getDistanza());
			st.setInt(4, p.getTempo());
			java.util.Date dataArr = p.getData();
			java.sql.Date dataSql = new java.sql.Date(dataArr.getTime());
			st.setDate(5, dataSql);
			int result = st.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}

	@Override
	public void delPrenotazione(int id) {
		String sql = "DELETE from Prenotazione WHERE idPrenotazione = ?";
		PreparedStatement st;
		try {
			st = conn.prepareStatement(sql);
			st.setInt(1, id);
			int result = st.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public void aggiornaPrenotazione(Prenotazione p) {
		String sql = "UPDATE Prenotazione SET idUtente = ?, idMacchina = ?, distanza = ?, tempo = ?, data = ? WHERE idPrenotazione = ?";
		try {
			
			PreparedStatement st = conn.prepareStatement(sql);
			st.setInt(1, p.getIntIdUtente());
			st.setInt(2, p.getIntIdMacchina());
			st.setInt(3, p.getDistanza());
			st.setInt(4, p.getTempo());
			st.setDate(5, (Date) p.getData());
			st.setInt(6, p.getIdPrenotazione());
			int result = st.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public Prenotazione getPrenotazione(int idPrenotazione) {
		Prenotazione p = null;
		Statement st;
		try {
			st = conn.createStatement();
			String query = "SELECT * from Prenotazione WHERE idPrenotazione = " + idPrenotazione;
			ResultSet rs = st.executeQuery(query);
			while(rs.next()){
				p = new Prenotazione();
				p.setIdPrenotazione(rs.getInt(1));
				
				int idUtente = rs.getInt(2);
				int idMacchina = rs.getInt(3);
				
				Utente utente = utenteDao.getUtente(idUtente);
				Macchina macchina = macchinaDao.getMacchina(idMacchina);
				
				p.setIdUtente(utente);
				p.setIdMacchina(macchina);				
				p.setDistanza(rs.getInt(4));
				p.setTempo(rs.getInt(5));
				p.setData(rs.getDate(6));
				
			}/*fine while*/
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
				
		return p;
	}

	@Override
	public List<Prenotazione> getPrenotazioni() {
		List<Prenotazione> lista = new ArrayList();
		Statement st;
		try {
			st = conn.createStatement();
			String query = "SELECT * from Prenotazione";
			ResultSet rs = st.executeQuery(query);
			while(rs.next()){
				Prenotazione p = new Prenotazione();
				p.setIdPrenotazione(rs.getInt(1));
				
				int idUtente = rs.getInt(2);
				int idMacchina = rs.getInt(3);
				
				Utente utente = utenteDao.getUtente(idUtente);
				Macchina macchina = macchinaDao.getMacchina(idMacchina);
				
				p.setIdUtente(utente);
				p.setIdMacchina(macchina);				
				p.setDistanza(rs.getInt(4));
				p.setTempo(rs.getInt(5));
				p.setData(rs.getDate(6));
				
				lista.add(p);
				
				
			}/*fine while*/
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return lista;
	}

	
	@Override
	public List<Prenotazione> getPrenotazioniByUtente(Utente utente) {
		List<Prenotazione> lista = new ArrayList();
		Statement st;
		int idutente = utente.getIdUtente();
		try {
			st = conn.createStatement();
			String query = "SELECT * from Prenotazione WHERE idUtente = " + idutente;
			ResultSet rs = st.executeQuery(query);
			
			while(rs.next()){
				Prenotazione p = new Prenotazione();
				p.setIdPrenotazione(rs.getInt(1));
				
				int idUtente = rs.getInt(2);
				int idMacchina = rs.getInt(3);
				
				Utente user = utenteDao.getUtente(idUtente);
				Macchina macchina = macchinaDao.getMacchina(idMacchina);
				
				p.setIdUtente(user);
				p.setIdMacchina(macchina);				
				p.setDistanza(rs.getInt(4));
				p.setTempo(rs.getInt(5));
				p.setData(rs.getDate(6));
				
				lista.add(p);
				
				
			}/*fine while*/
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return lista;
	}

	@Override
	public List<Prenotazione> getPrenotazioniByMacchina(Macchina macchina) {
		List<Prenotazione> lista = new ArrayList();
		int idMacchina = macchina.getIdMacchina();
		Statement st;
		
		try {
			st = conn.createStatement();
			String query = "SELECT * from Prenotazione WHERE idMacchina = " + idMacchina;
			ResultSet rs = st.executeQuery(query);
			
			while(rs.next()){
				Prenotazione p = new Prenotazione();
				p.setIdPrenotazione(rs.getInt(1));
				
				int idUtente = rs.getInt(2);
				int idmacchina = rs.getInt(3);
				
				Utente user = utenteDao.getUtente(idUtente);
				Macchina auto = macchinaDao.getMacchina(idmacchina);
				
				p.setIdUtente(user);
				p.setIdMacchina(auto);				
				p.setDistanza(rs.getInt(4));
				p.setTempo(rs.getInt(5));
				p.setData(rs.getDate(6));
				
				lista.add(p);				
				
			}/*fine while*/
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return lista;
	}

}
