package br.com.facom.urr.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import br.com.facom.urr.entidades.Paciente;

public class PacienteDao {
	private Connection connection;

	public PacienteDao() throws ClassNotFoundException, SQLException {
		Class.forName("org.sqlite.JDBC");
		connection = DriverManager
				.getConnection("jdbc:sqlite:/home/201519030061/Documentos/git/urrFacom2016/URR.sqlite");
	}
	

	public ArrayList<Paciente> all() throws SQLException {

		Statement st = connection.createStatement();
		ResultSet rs = st.executeQuery("SELECT * FROM Paciente");

		ArrayList<Paciente> pacientes = new ArrayList<Paciente>();

		while (rs.next()) {
			int id = rs.getInt("id");
			String nome = rs.getString("nome");
			String rg = rs.getString("rg");
			String cpf = rs.getString("cpf");
			Paciente paciente = new Paciente(id, nome, rg, cpf);

			pacientes.add(paciente);
		}

		st.close();
		rs.close();

		return pacientes;
	}
	

	public void save(Paciente paciente) throws SQLException {
		String sql = "insert into Paciente (nome, cpf, rg, endereco, dataNascimento, telefone, numeroProntuario)"
				+ " values (?,?,?,?,?,?,?)";
		PreparedStatement stmt = connection.prepareStatement(sql);
		stmt.setString(1, paciente.getNome());
		stmt.setString(2, paciente.getCpf());
		stmt.setString(3, paciente.getRg());
		stmt.setString(4, paciente.getEndereco());
		stmt.setDate(5, new Date(paciente.getDataNascimento().getTime()));
		stmt.setString(6, paciente.getEndereco());
		stmt.setString(7, paciente.getTelefone());

		stmt.execute();
		stmt.close();
	}
	

	public void altera(Paciente paciente) throws SQLException {
		String sql = "update Paciente set nome=?, cpf=?, rg=?, endereco = ?, "
				+ "dataNascimento = ?, telefone = ?, " + "numeroProntuario = ?"
				+ " where id=?";


			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setString(1, paciente.getNome());
			stmt.setString(2, paciente.getCpf());
			stmt.setString(3, paciente.getRg());
			stmt.setString(4, paciente.getEndereco());
			stmt.setDate(5, new Date(paciente.getDataNascimento().getTime()));
			stmt.setString(6, paciente.getTelefone());
			stmt.setString(7, paciente.getNumeroProntuario());
			stmt.setInt(8, paciente.getId());

			stmt.execute();
			stmt.close();

	}
	
	
	public Paciente findById(Integer idPaciente) throws SQLException{
		String sql = "select * from Paciente where id = "+idPaciente;
		Statement st = connection.createStatement();
		ResultSet rs = st.executeQuery(sql);
		
		
			Integer id = rs.getInt("id");
			String nome = rs.getString("nome");
			String rg = rs.getString("rg");
			String cpf = rs.getString("cpf");
			String endereco = rs.getString("endereco");
			java.util.Date dataNascimento = new java.util.Date(rs.getDate("dataNascimento").getTime());
			String telefone = rs.getString("telefone");
			String numeroProntuario = rs.getString("numeroProntuario");
			
			
			
			Paciente paciente = new Paciente(id, nome, rg, cpf);
			paciente.setEndereco(endereco);
			paciente.setDataNascimento(dataNascimento);
			paciente.setTelefone(telefone);
			paciente.setNumeroProntuario(numeroProntuario);
		
			st.close();
			rs.close();
			
			return paciente;		
	}

}
