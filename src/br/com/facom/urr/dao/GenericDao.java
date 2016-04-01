package br.com.facom.urr.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import br.com.facom.urr.entidades.Paciente;
import exception.DaoException;
import sun.awt.FwDispatcher;

public class GenericDao {
	
	private static Connection connection;
	private static Statement st;
	private static ResultSet rs;
	private static String banco = "jdbc:sqlite:C:\\Users\\Tayron\\git\\urrFacom2016\\URR.sqlite";
	
	public GenericDao(String base) throws  DaoException{
		try {
			Class.forName("org.sqlite.JDBC");
			connection = DriverManager.getConnection(base);
		} catch (ClassNotFoundException | SQLException e) {
			throw new DaoException(e.getMessage());
		}
		
	}
	
	
	
	
	public <T> List<T> all(){
		String sql = "Select * from";
		return null;
	}
	
	public static void main(String [] args) throws DaoException, SQLException{
		GenericDao dao = new GenericDao(banco);
		
		st = connection.createStatement();
		rs = st.executeQuery("SELECT * FROM Paciente");
		
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
	}
}
