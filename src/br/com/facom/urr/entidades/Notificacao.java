package br.com.facom.urr.entidades;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

import br.com.facom.urr.dao.PacienteDao;
import br.com.facom.urr.dao.PlantonistaDao;
import br.com.facom.urr.dao.UpaCrsDao;
import br.com.facom.urr.dao.iface.Entidade;
import exception.DaoException;

public class Notificacao implements Entidade{

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
	
	
	@Override
	public Notificacao criarPojo(ResultSet rs) throws SQLException {
		PacienteDao pacienteDao;
		PlantonistaDao plantonistaDao;
		UpaCrsDao upaCrsDao;
		try {
			pacienteDao = new PacienteDao();
			plantonistaDao = new PlantonistaDao();
			upaCrsDao = new UpaCrsDao();
		} catch (DaoException e) {
			throw new SQLException(" erro ao criar objeto Notificação ");
		}
		
		
		this.id = rs.getInt("id");
		this.data = rs.getDate("data");
		this.tipo = rs.getString("tipo");
		this.historico = rs.getString("historico");
		this.paciente = pacienteDao.findById(rs.getInt("paciente"));
		this.plantonista = plantonistaDao.findById(rs.getInt("plantonista"));
		this.upaCrs = upaCrsDao.findById(rs.getInt("upaCrs"));
		
		return this;
	}

	

}
