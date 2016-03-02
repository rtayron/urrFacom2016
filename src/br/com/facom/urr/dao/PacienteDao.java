package br.com.facom.urr.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import br.com.facom.urr.entidades.Paciente;



public class PacienteDao {
	private Connection connection;
	private Statement st;
	private ResultSet rs;
	
	public PacienteDao() throws ClassNotFoundException, SQLException {
		Class.forName("org.sqlite.JDBC");
		connection = DriverManager.getConnection("jdbc:sqlite:/Users/sbf/Google Drive/docencia/ufms/disciplinas/apiioo/2015-02/as (p01)/trabalho_pratico/workspace/UrrListaPacientes/Urr.sqlite");
	}
	
	public ArrayList<Paciente> all() throws SQLException {
		
		st = connection.createStatement();
		rs = st.executeQuery("SELECT * FROM Pacientes");
		
		ArrayList<Paciente> pacientes = new ArrayList<Paciente>();
		
		while(rs.next()) {
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
	
	public void save(Paciente paciente){
		String sql = "insert into Paciente (nome, cpf, rg, )";
	}
}
