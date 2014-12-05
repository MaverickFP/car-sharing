package it.car2go.model;

import java.io.Serializable;
import java.util.Date;

public class PrenotazioneView implements Serializable{
	
	private int idPrenotazione;
    private Utente idUtente;
    private Macchina idMacchina;
    private String nomeMacchina;
    private int distanza;
    private int tempo;
    private double costo;
    private Date data;    
    private static final long serialVersionUID = 42L;

    public PrenotazioneView() {
    }

    
    
    
    
    public double getCosto() {
		return costo;
	}





	public void setCosto(double costo) {
		this.costo = costo;
	}





	public int getIdPrenotazione() {
		return idPrenotazione;
	}





	public void setIdPrenotazione(int idPrenotazione) {
		this.idPrenotazione = idPrenotazione;
	}





	public Utente getIdUtente() {
		return idUtente;
	}





	public void setIdUtente(Utente idUtente) {
		this.idUtente = idUtente;
	}





	public Macchina getIdMacchina() {
		return idMacchina;
	}





	public void setIdMacchina(Macchina idMacchina) {
		this.idMacchina = idMacchina;
	}





	public String getNomeMacchina() {
		return nomeMacchina;
	}





	public void setNomeMacchina(String nomeMacchina) {
		this.nomeMacchina = nomeMacchina;
	}





	public int getDistanza() {
		return distanza;
	}





	public void setDistanza(int distanza) {
		this.distanza = distanza;
	}





	public int getTempo() {
		return tempo;
	}





	public void setTempo(int tempo) {
		this.tempo = tempo;
	}





	public Date getData() {
		return data;
	}





	public void setData(Date data) {
		this.data = data;
	}





	//metodi inseriti per gestire gli id numerici
    public int getIntIdMacchina(){
    	return idMacchina.getIdMacchina();
    }
    
    public int getIntIdUtente(){
    	return idUtente.getIdUtente();
    }

}
