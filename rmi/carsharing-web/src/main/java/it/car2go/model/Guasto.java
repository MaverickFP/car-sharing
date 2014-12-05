package it.car2go.model;

import java.io.Serializable;

public class Guasto implements Serializable{
	
	private int idGuasto;
	private String nome;
	private int idMacchina;
	private static final long serialVersionUID = 42L;
	
	public Guasto(){
		
	}

	public int getIdGuasto() {
		return idGuasto;
	}

	public void setIdGuasto(int idGuasto) {
		this.idGuasto = idGuasto;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getIdMacchina() {
		return idMacchina;
	}

	public void setIdMacchina(int idMacchina) {
		this.idMacchina = idMacchina;
	}
	
	

}
