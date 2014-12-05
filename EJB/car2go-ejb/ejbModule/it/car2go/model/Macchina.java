package it.car2go.model;

import java.io.Serializable;

import javax.persistence.Entity;

@Entity
public class Macchina implements Serializable{
	
	private int idMacchina;
    private String tipo;
    private int codice;
    private float latitudine;
    private float longitudine;
    private String indirizzo;
    private int interno;
    private int esterno;
    private int serbatoio;
    private int prenotata;
    private String note;
    private static final long serialVersionUID = 42L;

    public Macchina() {
    }

    public Macchina(String tipo, int codice, float latitudine, float longitudine, String indirizzo, int interno, int esterno, int serbatoio, int prenotata) {
        this.tipo = tipo;
        this.codice = codice;
        this.latitudine = latitudine;
        this.longitudine = longitudine;
        this.indirizzo = indirizzo;
        this.interno = interno;
        this.esterno = esterno;
        this.serbatoio = serbatoio;
        this.prenotata = prenotata;
    }

        
    public int getIdMacchina() {
        return idMacchina;
    }

    public void setIdMacchina(int idMacchina) {
        this.idMacchina = idMacchina;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getCodice() {
        return codice;
    }

    public void setCodice(int codice) {
        this.codice = codice;
    }

    public float getLatitudine() {
        return latitudine;
    }

    public void setLatitudine(float latitudine) {
        this.latitudine = latitudine;
    }

    public float getLongitudine() {
        return longitudine;
    }

    public void setLongitudine(float longitudine) {
        this.longitudine = longitudine;
    }

    public String getIndirizzo() {
        return indirizzo;
    }

    public void setIndirizzo(String indirizzo) {
        this.indirizzo = indirizzo;
    }

    public int getInterno() {
        return interno;
    }

    public void setInterno(int interno) {
        this.interno = interno;
    }

    public int getEsterno() {
        return esterno;
    }

    public void setEsterno(int esterno) {
        this.esterno = esterno;
    }

    public int getSerbatoio() {
        return serbatoio;
    }

    public void setSerbatoio(int serbatoio) {
        this.serbatoio = serbatoio;
    }

    public int getPrenotata() {
        return prenotata;
    }

    public void setPrenotata(int prenotata) {
        this.prenotata = prenotata;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

}
