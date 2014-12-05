package it.car2go.jms.receiver;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

public class AsyncReceiverGuasto implements MessageListener{
	
		public void onMessage(Message message){
			try {
				String sr = ((TextMessage) message).getText();
				System.out.println("Messaggio Ricevuto: " + sr);
				String[] parts = sr.split(","); 
				String guastoTxt = parts[0];
				String idMacchinaTxt = parts[1];
				int idMacchinaInt = Integer.parseInt(idMacchinaTxt);
				salvaMessaggio(guastoTxt,idMacchinaInt);
				
			} catch (JMSException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}/*fine metodo onMessage*/
		
		
		private void salvaMessaggio(String guasto, int idMacchina){
			try {
				Class.forName("com.mysql.jdbc.Driver").newInstance();
				Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/car2go","root","");	
				String sql = "INSERT INTO Guasto (nome, idMacchina) VALUES" + "(?,?)";
				PreparedStatement st = conn.prepareStatement(sql);
				st.setString(1, guasto);
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
			}catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
		
		
		
		
}
