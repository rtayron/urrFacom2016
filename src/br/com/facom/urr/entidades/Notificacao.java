package br.com.facom.urr.entidades;

import java.io.Serializable;

public class Notificacao implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private String data;
	private String tipo;
	private String historico;
	
	private Paciente paciente;
	private Plantonista plantonista;
	private UpaCrd upaCrd;
	
	/*getters and setters*/
	

}
