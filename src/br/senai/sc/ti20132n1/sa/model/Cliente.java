package br.senai.sc.ti20132n1.sa.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;



@Entity
public class Cliente {
	
	@Id
	@GeneratedValue
	private Long id;
	private String nome;
	private String senha;
	private String cpf;
	private String telefone;
	@Column(unique = true)
	private String email;
	private String dataNascimento;
	private Double numeroHabilitacao;
	private String endereco;
	@ManyToOne
	private Cidade cidade;
	@ManyToOne
	private Estado estado;
	@ManyToOne
	private Reserva reserva;
	
	
	
	public Reserva getReserva() {
		return reserva;
	}
	public void setReserva(Reserva reserva) {
		this.reserva = reserva;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getDataNascimento() {
		return dataNascimento;
	}
	public void setDataNascimento(String dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
	public Double getNumeroHabilitacao() {
		return numeroHabilitacao;
	}
	public void setNumeroHabilitacao(Double numeroHabilitacao) {
		this.numeroHabilitacao = numeroHabilitacao;
	}
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	
	public Cidade getCidade() {
		return cidade;
	}
	public void setCidade(Cidade cidade) {
		this.cidade = cidade;
	}
	public Estado getEstado() {
		return estado;
	}
	public void setEstado(Estado estado) {
		this.estado = estado;
	}
	
	@Override
	public String toString(){
		return "\nId: " + id + "\nNome: " + nome + "\nSenha: " + senha 
				+ "\nCPF: " + "\nTelefone: " + "\nE-mail: " 
				+ "\nData de nascimento: " + dataNascimento + "\nNumero da Habilitação: " + numeroHabilitacao     
				+ "\nCidade: " + cidade + "\nEstado: " + estado;
	}
	

}
