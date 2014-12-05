package it.car2go.model;

import java.io.Serializable;

public class Utente implements Serializable{
	
	private int idUtente;
    private String nome;
    private String cognome;
    private String nazione;
    private String username;
    private String password; 
    private String mail;
    private int pin;
    private Ruolo ruolo;
    private static final long serialVersionUID = 42L;

    public Utente() {
    }

    public Utente(String nome, String cognome, String nazione, String username, String password, String mail, int pin, Ruolo ruolo) {
        this.nome = nome;
        this.cognome = cognome;
        this.nazione = nazione;
        this.username = username;
        this.password = password;
        this.mail = mail;
        this.pin = pin;
        this.ruolo = ruolo;
    }

    public int getIdUtente() {
        return idUtente;
    }

    public void setIdUtente(int idUtente) {
        this.idUtente = idUtente;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public String getNazione() {
        return nazione;
    }

    public void setNazione(String nazione) {
        this.nazione = nazione;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public int getPin() {
        return pin;
    }

    public void setPin(int pin) {
        this.pin = pin;
    }

    public Ruolo getRuolo() {
        return ruolo;
    }

    public void setRuolo(Ruolo ruolo) {
        this.ruolo = ruolo;
    }
    
    //restituisco l'id numerico del Ruolo
    public int getIdRuolo(){
    	return ruolo.getIdRuolo();
    }
	
	
	

}
