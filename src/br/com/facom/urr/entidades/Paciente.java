package br.com.facom.urr.entidades;

import java.io.Serializable;
import java.util.Date;

public class Paciente implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private String nome;
	private String cpf;
	private String rg;
	private String endereco;
	private Date dataNascimento;
	private String telefone;
	private String numeroProntuario;
	
	public Paciente(){	
	}

	public Paciente(int id, String nome, String rg, String cpf) {
		this.id = id;
		this.nome = nome;
		this.rg = rg;
		this.cpf = cpf;
	}

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getRg() {
		return rg;
	}
	public void setRg(String rg) {
		this.rg = rg;
	}
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	
	public Date getDataNascimento() {
		return dataNascimento;
	}
	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	public String getNumeroProntuario() {
		return numeroProntuario;
	}
	public void setNumeroProntuario(String numeroProntuario) {
		this.numeroProntuario = numeroProntuario;
	}

	@Override
	public String toString() {
		return "Paciente [nome=" + nome + ", cpf=" + cpf + "]";
	}
	
	/*getters and setters*/
	
	
	
	
	

}
