package br.com.facom.urr.entidades;

import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import br.com.facom.urr.dao.NotificacaoDao;
import br.com.facom.urr.dao.iface.Entidade;
import exception.DaoException;

public class UpaCrs implements Entidade{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private String telefone;
	private String endereco;
	private ArrayList<Notificacao> notificacoes;
	
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
	
	public ArrayList<Notificacao> getNotificacoes() {
		return notificacoes;
	}

	@Override
	public UpaCrs criarPojo(ResultSet rs) throws SQLException {
		ArrayList<Notificacao> notificacoes;
		Map<String, Object> mapa = new HashMap<String, Object>();
		
			NotificacaoDao notificacaoDao;
			try {
				notificacaoDao = new NotificacaoDao();
			} catch (DaoException e) {
				e.printStackTrace();
				throw new SQLException("erro ao criar ResultSet ");
			}
		
		this.id = rs.getInt("id");
		this.endereco = rs.getString("endereco");
		this.telefone = rs.getString("telefone");
		
		mapa.put("upaCrs", this.id);
		this.notificacoes = notificacaoDao.findBy(mapa);
		


		return this;
	}


}
