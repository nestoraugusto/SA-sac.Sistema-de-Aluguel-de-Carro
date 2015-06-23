package br.senai.sc.ti20132n1.sa.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;



@Entity(name="tb_cidades")
public class Cidade {

	@Id
	@GeneratedValue
	private long id;
	@ManyToOne
	private Estado estado;
	private String uf;
	private String nome;
	
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getUf() {
		return uf;
	}
	public void setUf(String uf) {
		this.uf = uf;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	
	
	
	
	
	
}
