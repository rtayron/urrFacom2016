package br.com.facom.urr.entidades;

import java.io.Serializable;
import java.util.Date;

public class Notificacao implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private Date data;
	private String tipo;
	private String historico;
	
	private Paciente paciente;
	private Plantonista plantonista;
	private UpaCrs upaCrs;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Date getData() {
		return data;
	}
	public void setData(Date data) {
		this.data = data;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public String getHistorico() {
		return historico;
	}
	public void setHistorico(String historico) {
		this.historico = historico;
	}
	public Paciente getPaciente() {
		return paciente;
	}
	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}
	public Plantonista getPlantonista() {
		return plantonista;
	}
	public void setPlantonista(Plantonista plantonista) {
		this.plantonista = plantonista;
	}
	public UpaCrs getUpaCrs() {
		return upaCrs;
	}
	public void setUpaCrs(UpaCrs upaCrs) {
		this.upaCrs = upaCrs;
	}
	
	/*getters and setters*/
	
	

}
