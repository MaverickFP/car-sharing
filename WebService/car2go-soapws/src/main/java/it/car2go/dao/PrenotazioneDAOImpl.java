package it.car2go.dao;

import java.sql.Connection;
import java.sql.Date;
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

public class PrenotazioneDAOImpl implements PrenotazioneDAO {
	
	private Connection conn;
	private UtenteDAO utenteDao;
	private MacchinaDAO macchinaDao;
	
	public PrenotazioneDAOImpl(Connection connection, UtenteDAO utenteDao, MacchinaDAO macchinaDao){
		this.conn = connection;
		this.utenteDao = utenteDao;
		this.macchinaDao = macchinaDao;
	}
	

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
			java.util.Date utilDate = new java.util.Date();
		    java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
			st.setDate(5, sqlDate);
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
