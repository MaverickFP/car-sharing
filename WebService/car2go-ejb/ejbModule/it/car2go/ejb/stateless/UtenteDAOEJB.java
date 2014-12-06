package it.car2go.ejb.stateless;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import it.car2go.model.Ruolo;
import it.car2go.model.Utente;
import it.car2go.persistance.common.RuoloDAO;
import it.car2go.persistance.common.UtenteDAO;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.ejb.EJB;
import javax.ejb.Remote;
import javax.ejb.Stateless;

/**
 * Session Bean implementation class UtenteDAOEJB
 */
@Stateless(mappedName = "UtenteDAOEJB")
@Remote
public class UtenteDAOEJB implements UtenteDAO {
	
	private Connection conn;
	
	@EJB(lookup="RuoloDAOEJB")
	private RuoloDAO ruoloDao;
	

    /**
     * Default constructor. 
     */
    public UtenteDAOEJB() {
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
	public void addUtente(Utente utente) {
		String sql = "INSERT INTO Utente (nome,cognome,nazione,username,password,mail,pin,idRuolo) VALUES" + "(?,?,?,?,?,?,?,?)";
		PreparedStatement st;
		try {
			
			System.out.println(utente.getNome());
			System.out.println(utente.getCognome());
			System.out.println(utente.getIdRuolo());
			st = conn.prepareStatement(sql);
			
			st.setString(1, utente.getNome());
			st.setString(2, utente.getCognome());
			st.setString(3, utente.getNazione());
			st.setString(4, utente.getUsername());
			st.setString(5, utente.getPassword());
			st.setString(6, utente.getMail());
			st.setInt(7, utente.getPin());
			st.setInt(8, utente.getIdRuolo());
			int result = st.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public void delUtente(int id) {
		String sql = "DELETE from Utente WHERE id = ?";
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
	public void updateUtente(Utente utente) {
		String sql = "UPDATE Utente SET nome = ?, cognome = ?, nazione = ?, username = ?, password = ?, mail = ?,"
				+ " pin = ?, idRuolo = ? WHERE id = ?";
		try {
			
			PreparedStatement st = conn.prepareStatement(sql);
			st.setString(1, utente.getNome());
			st.setString(2, utente.getCognome());
			st.setString(3, utente.getNazione());
			st.setString(4, utente.getUsername());
			st.setString(5, utente.getPassword());
			st.setString(6, utente.getMail());
			st.setInt(7, utente.getPin());
			st.setInt(8, utente.getIdRuolo());
			st.setInt(9, utente.getIdUtente());
			int result = st.executeUpdate();
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public Utente getUtente(int id) {
		Utente u = null;
		Statement st;
		
		try {
			st = conn.createStatement();
			String query = "SELECT * from Utente WHERE id = " + id;
			ResultSet rs = st.executeQuery(query);
			while(rs.next()){
				
				u = new Utente();
				u.setIdUtente(rs.getInt(1));
				u.setNome(rs.getString(2));
				u.setCognome(rs.getString(3));
				u.setNazione(rs.getString(4));
				u.setUsername(rs.getString(5));
				u.setPassword(rs.getString(6));
				u.setMail(rs.getString(7));
				u.setPin(rs.getInt(8));
				int idRuolo = rs.getInt(9);
				Ruolo ruolo = ruoloDao.getRuolo(idRuolo);				
				u.setRuolo(ruolo);
				
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return u;
	}

	@Override
	public List<Utente> getUtenti() {
		List<Utente> lista = new ArrayList();
		Statement st;
		try {
			st = conn.createStatement();
			String query = "SELECT * from Utente";
			ResultSet rs = st.executeQuery(query);
			while(rs.next()){
				Utente u = new Utente();
				u.setIdUtente(rs.getInt(1));
				u.setNome(rs.getString(2));
				u.setCognome(rs.getString(3));
				u.setNazione(rs.getString(4));
				u.setUsername(rs.getString(5));
				u.setPassword(rs.getString(6));
				u.setMail(rs.getString(7));
				u.setPin(rs.getInt(8));
				int idRuolo = rs.getInt(9);
				Ruolo ruolo = ruoloDao.getRuolo(idRuolo);				
				u.setRuolo(ruolo);
				lista.add(u);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return lista;
	}
	

	@Override
	public Ruolo getRuoloUtente(int idUtente) {
		Utente u = this.getUtente(idUtente);
		Ruolo r = ruoloDao.getRuolo(u.getIdRuolo());
		return r;
	}
	
	

}
