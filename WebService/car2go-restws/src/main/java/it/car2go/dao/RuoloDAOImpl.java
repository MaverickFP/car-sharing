package it.car2go.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import it.car2go.model.Ruolo;
import it.car2go.persistance.common.RuoloDAO;

public class RuoloDAOImpl implements RuoloDAO {
	
	private Connection conn;
	
	public RuoloDAOImpl(Connection connection){
		this.conn = connection;
	}

	@Override
	public void addRuolo(Ruolo ruolo) {
		String sql = "INSERT INTO Ruolo (nome, codice) VALUES" + "(?,?)";
		PreparedStatement st;
		try {
			st = conn.prepareStatement(sql);
			st.setString(1, ruolo.getNome());
			st.setInt(2, ruolo.getCodice());
			int result = st.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void delRuolo(int id) {
		String sql = "DELETE from Ruolo WHERE idRuolo = ?";
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
	public void updateRuolo(Ruolo ruolo) {
		String sql = "UPDATE Ruolo SET nome = ?, codice = ? WHERE idRuolo = ?";
		try {
			PreparedStatement st = conn.prepareStatement(sql);
			st.setString(1, ruolo.getNome());
			st.setInt(2, ruolo.getCodice());
			st.setInt(3, ruolo.getIdRuolo());
			int result = st.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public Ruolo getRuolo(int id) {
		Ruolo r = null;		
		Statement st;
		try {
			st = conn.createStatement();
			String query = "SELECT * from Ruolo WHERE idRuolo = " + id;
			ResultSet rs = st.executeQuery(query);			
			while(rs.next()){
				r = new Ruolo();
				r.setIdRuolo(rs.getInt(1));
				r.setNome(rs.getString(2));
				r.setCodice(rs.getInt(3));				
			}/*fine while*/			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}				
		return r;
	}

	@Override
	public List<Ruolo> getRuoli() {
		List<Ruolo> lista = new ArrayList();
		Statement st;
		try {
			st = conn.createStatement();
			String query = "SELECT * from Ruolo";
			ResultSet rs = st.executeQuery(query);			
			while(rs.next()){
				Ruolo r = new Ruolo();
				r.setIdRuolo(rs.getInt(1));
				r.setNome(rs.getString(2));
				r.setCodice(rs.getInt(3));
				
				lista.add(r);
			}/*fine while*/
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		return lista;
	}

}
