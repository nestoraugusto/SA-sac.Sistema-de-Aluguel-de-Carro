package br.senai.sc.ti20132n1.sa.mb;

import javax.faces.bean.ManagedBean;

@ManagedBean 
public class contatoMB {
	
	private String nome;
	private String email;
	
	
	
	public String getNome() {
		return nome;
	}



	public void setNome(String nome) {
		this.nome = nome;
	}



	public String getEmail() {
		return email;
	}



	public void setEmail(String email) {
		this.email = email;
	}



	public String enviar(){
		System.out.println("Nome: " +nome);
		System.out.println("E-mail:"+email);
		return"";
	}

}
