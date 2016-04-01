package br.com.facom.urr.entidades;

import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UpaCrs implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private String telefone;
	private String endereco;
	
	/*getters and setters*/
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}


}
