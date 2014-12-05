package it.car2go.model;

import java.io.Serializable;

public class Ruolo implements Serializable{
	
	private int idRuolo;
    private String nome;
    private int codice;
    private static final long serialVersionUID = 42L;

    public Ruolo() {
    }

    public Ruolo(String nome, int codice) {
        this.nome = nome;
        this.codice = codice;
    }

    public int getIdRuolo() {
        return idRuolo;
    }

    public void setIdRuolo(int idRuolo) {
        this.idRuolo = idRuolo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getCodice() {
        return codice;
    }

    public void setCodice(int codice) {
        this.codice = codice;
    }

}
