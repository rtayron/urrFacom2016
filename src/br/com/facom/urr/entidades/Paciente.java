package br.com.facom.urr.entidades;



import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import br.com.facom.urr.dao.NotificacaoDao;
import br.com.facom.urr.dao.iface.Entidade;
import exception.DaoException;


public class Paciente implements Entidade{

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
	private ArrayList<Notificacao> notificacoes;
	
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
	
	public ArrayList<Notificacao> getNotificacoes() {
		return notificacoes;
	}

	@Override
	public Paciente criarPojo(ResultSet rs) throws SQLException {
		ArrayList<Notificacao> notificacoes;
		Map<String, Object> mapa = new HashMap<String, Object>();
		mapa.put("paciente", this.id);

			NotificacaoDao notificacaoDao;
			try {
				notificacaoDao = new NotificacaoDao();
			} catch (DaoException e) {
				e.printStackTrace();
				throw new SQLException("erro ao criar Paciente ");
			}
		
			this.setId(rs.getInt("id"));
			this.setCpf(rs.getString("cpf"));
			this.setDataNascimento(rs.getDate("dataNascimento"));
			this.setEndereco(rs.getString("endereco"));
			this.setNome(rs.getString("nome"));
			this.setNumeroProntuario(rs.getString("numeroProntuario"));
			this.setTelefone(rs.getString("telefone"));
			this.notificacoes = notificacaoDao.findBy(mapa);

		return this;
	}

	@Override
	public String toString() {
		return "Paciente [id=" + id + ", nome=" + nome + ", cpf=" + cpf + ", rg=" + rg + ", endereco=" + endereco
				+ ", dataNascimento=" + dataNascimento + ", telefone=" + telefone + ", numeroProntuario="
				+ numeroProntuario + "]";
	}
	
	

}
