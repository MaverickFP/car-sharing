package it.car2go.hibernatedao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import it.car2go.model.Guasto;
import it.car2go.persistance.common.GuastoDAO;

public class GuastoHibernateDAO implements GuastoDAO{
	
	public GuastoHibernateDAO(){
		
	}
	
	
	public List<Guasto> getGuasti(){
		List<Guasto> lista = new ArrayList();
		
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/car2go","root","");	
			Statement st;
			st = conn.createStatement();
			String query = "SELECT * from Guasto";
			ResultSet rs = st.executeQuery(query);
			
			while(rs.next()){
				
				Guasto g = new Guasto();
				g.setIdGuasto(rs.getInt(1));
				g.setNome(rs.getString(2));
				g.setIdMacchina(rs.getInt(3));
				lista.add(g);
				
			}/*fine while*/
			
			conn.close();
		
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return lista;		
	}
	
	
	
	
	public Guasto getGuastoMacchina(int idMacchina){
		Guasto g = null;
		
		try {
			
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/car2go","root","");	
			
			Statement st = conn.createStatement();
			String query = "SELECT * from Guasto WHERE idMacchina = " + idMacchina;
			ResultSet rs = st.executeQuery(query);
			
			while(rs.next()){
				g = new Guasto();
				g.setIdGuasto(rs.getInt(1));
				g.setNome(rs.getString(2));
				g.setIdMacchina(rs.getInt(3));
			}
			
			conn.close();
			
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return g;		
	}


	@Override
	public void addGuasto(String nome, int idMacchina) {
		
		try {
			
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/car2go","root","");	
			
			String sql = "INSERT INTO Guasto (nome, idMacchina) VALUES" + "(?,?)";
			PreparedStatement st = conn.prepareStatement(sql);
			st.setString(1, nome);
			st.setInt(2, idMacchina);
			int result = st.executeUpdate();
			
			conn.close();
			
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}


	@Override
	public void delGuasto(int idGuasto) {
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/car2go","root","");	
			
			String sql = "DELETE from Guasto WHERE idGuasto = ?";
			PreparedStatement st = conn.prepareStatement(sql);
			st.setInt(1, idGuasto);
			int result = st.executeUpdate();
			
			conn.close();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}


	@Override
	public void delGuastoMacchina(int idMacchina) {
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/car2go","root","");	
			
			String sql = "DELETE from Guasto WHERE idMacchina = ?";
			PreparedStatement st = conn.prepareStatement(sql);
			st.setInt(1, idMacchina);
			int result = st.executeUpdate();
			
			conn.close();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}


	@Override
	public List<Guasto> getTuttiGuastiMacchina(int idMacchina) {
		List<Guasto> lista = new ArrayList();
		
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/car2go","root","");	
			Statement st;
			st = conn.createStatement();
			String query = "SELECT * from Guasto WHERE idMacchina = " + idMacchina;
			ResultSet rs = st.executeQuery(query);
			
			while(rs.next()){
				
				Guasto g = new Guasto();
				g.setIdGuasto(rs.getInt(1));
				g.setNome(rs.getString(2));
				g.setIdMacchina(rs.getInt(3));
				lista.add(g);
				
			}/*fine while*/
			
			conn.close();
		
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return lista;
	}
	
	
	

}
