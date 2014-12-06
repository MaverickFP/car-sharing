package it.car2go.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;









import it.car2go.model.Macchina;
import it.car2go.persistance.common.MacchinaDAO;

public class MacchinaDAOImpl implements MacchinaDAO {
	
	private Connection conn;
	
	public MacchinaDAOImpl(Connection connection){
		this.conn = connection;
	}
	

	@Override
	public void addMacchina(Macchina macchina) {		
		try {
			
			String sql = "INSERT INTO Macchina (tipo, codice, latitudine, longitudine, indirizzo, interno, esterno, serbatoio, prenotata, note) VALUES" + "(?,?,?,?,?,?,?,?,?,?)";
			PreparedStatement st = conn.prepareStatement(sql);
			st.setString(1, macchina.getTipo());
			st.setInt(2, macchina.getCodice());
			st.setFloat(3, macchina.getLatitudine());
			st.setFloat(4, macchina.getLongitudine());
			st.setString(5, macchina.getIndirizzo());
			st.setInt(6, macchina.getInterno());
			st.setInt(7, macchina.getEsterno());
			st.setInt(8, macchina.getSerbatoio());
			st.setInt(9, macchina.getPrenotata());
			st.setString(10, macchina.getNote());
			
			int result = st.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	
	@Override
	public void delMacchina(int id) {
		try {
			String sql = "DELETE from Macchina WHERE idMacchina = ?";
			PreparedStatement st = conn.prepareStatement(sql);
			st.setInt(1, id);
			int result = st.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}
	

	@Override
	public void updateMacchina(Macchina macchina) {
		try {
			String sql = "UPDATE Macchina SET tipo = ?, codice = ?, latitudine = ?, longitudine  = ?, indirizzo = ?, interno = ?,"
					+ "esterno = ?, serbatoio = ?, prenotata = ?, note = ? WHERE idMacchina = ?";
			PreparedStatement st = conn.prepareStatement(sql);
			st.setString(1, macchina.getTipo());
			st.setInt(2, macchina.getCodice());
			st.setFloat(3, macchina.getLatitudine());
			st.setFloat(4, macchina.getLongitudine());
			st.setString(5, macchina.getIndirizzo());
			st.setInt(6, macchina.getInterno());
			st.setInt(7, macchina.getEsterno());
			st.setInt(8, macchina.getSerbatoio());
			st.setInt(9, macchina.getPrenotata());
			st.setString(10, macchina.getNote());
			st.setInt(11, macchina.getIdMacchina());
			int result = st.executeUpdate();
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public Macchina getMacchina(int id) {
		Macchina m = null;		
		try {
			Statement st = conn.createStatement();
			String query = "SELECT * from Macchina WHERE idMacchina = " + id;
			ResultSet rs = st.executeQuery(query);
			
			while(rs.next()){
				m = new Macchina();
				m.setIdMacchina(rs.getInt(1));
				m.setTipo(rs.getString(2));
				m.setCodice(rs.getInt(3));
				m.setLatitudine(rs.getFloat(4));
				m.setLongitudine(rs.getFloat(5));
				m.setIndirizzo(rs.getString(6));
				m.setInterno(rs.getInt(7));
				m.setEsterno(rs.getInt(8));
				m.setSerbatoio(rs.getInt(9));
				m.setPrenotata(rs.getInt(10));
				m.setNote(rs.getString(11));
			}			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}				
		return m;
	}
	
	

	@Override
	public List<Macchina> getMacchine() {
		List<Macchina> lista = new ArrayList<Macchina>();
		Statement st;
		try {
			st = conn.createStatement();
			String query = "SELECT * from Macchina";
			ResultSet rs = st.executeQuery(query);
			while(rs.next()){
				Macchina m = new Macchina();
				m.setIdMacchina(rs.getInt(1));
				m.setTipo(rs.getString(2));
				m.setCodice(rs.getInt(3));
				m.setLatitudine(rs.getFloat(4));
				m.setLongitudine(rs.getFloat(5));
				m.setIndirizzo(rs.getString(6));
				m.setInterno(rs.getInt(7));
				m.setEsterno(rs.getInt(8));
				m.setSerbatoio(rs.getInt(9));
				m.setPrenotata(rs.getInt(10));
				m.setNote(rs.getString(11));
				lista.add(m);
			}/*fine while*/
		} catch (SQLException e) {			
			e.printStackTrace();
		}
		return lista;
	}/*fine metodo getMacchine*/

}
