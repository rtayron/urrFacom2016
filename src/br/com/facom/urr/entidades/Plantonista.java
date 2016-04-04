package br.com.facom.urr.entidades;

import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import br.com.facom.urr.dao.NotificacaoDao;
import br.com.facom.urr.dao.iface.Entidade;
import exception.DaoException;

public class Plantonista implements Entidade{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private String nome;
	private String telefone;
	private String lotacao;
	private ArrayList<Notificacao> notificacoes;
	
	
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
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	public String getLotacao() {
		return lotacao;
	}
	public void setLotacao(String lotacao) {
		this.lotacao = lotacao;
	}
	public ArrayList<Notificacao> getNotificacoes() {
		return notificacoes;
	}
	
	@Override
	public Plantonista criarPojo(ResultSet rs) throws SQLException {
		ArrayList<Notificacao> notificacoes;
		Map<String, Object> mapa = new HashMap<String, Object>();
		mapa.put("plantonista", this.id);

			NotificacaoDao notificacaoDao;
			try {
				notificacaoDao = new NotificacaoDao();
			} catch (DaoException e) {
				e.printStackTrace();
				throw new SQLException("erro ao criar Plantonista ");
			}
			
		this.id = rs.getInt("id");
		this.lotacao = rs.getString("lotacao");
		this.nome = rs.getString("nome");
		this.telefone = rs.getString("telefone");
		this.notificacoes = notificacaoDao.findBy(mapa);
		
		return this;
	}

	

}
