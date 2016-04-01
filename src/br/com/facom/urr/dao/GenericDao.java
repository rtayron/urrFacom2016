package br.com.facom.urr.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.lang.reflect.ParameterizedType;

import br.com.facom.urr.dao.iface.Entidade;
import br.com.facom.urr.dao.iface.*;
import br.com.facom.urr.entidades.Paciente;
import exception.DaoException;


public class GenericDao<T> implements IGenericDao<T>{
	
	private static Connection connection;
	private static Statement st;
	private static ResultSet rs;
	protected static String banco = "jdbc:sqlite:/home/rtsouza/git/urrFacom2016/URR.sqlite";
	private Class<T> persistentClass;
	
	 
	public GenericDao(String base) throws  DaoException{
		try {
			Class.forName("org.sqlite.JDBC");
			connection = DriverManager.getConnection(base);
			this.persistentClass = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
		} catch (ClassNotFoundException | SQLException e) {
			throw new DaoException(e.getMessage());
		}
		
	}

	@Override
	public ArrayList<T> all() throws SQLException {
		st = connection.createStatement();
		rs = st.executeQuery("Select * from "+persistentClass.getSimpleName());
		ArrayList<T> resultado = new ArrayList<>();
		
		while (rs.next()) {
			
			resultado.add((T) rs.getMetaData().unwrap(Entidade.class));
		}
		
		return resultado;
	}
	
	


	@Override
	public <C, V> ArrayList<T> findBy(Map<C, V> parametros) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <C, V> boolean insert(Map<C, V> valores) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public <C, V> boolean remove(Map<C, V> valores) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public <C, V> boolean update(Map<C, V> valores) {
		// TODO Auto-generated method stub
		return false;
	}
	
	
	public static void main(String [] args) throws DaoException, SQLException{
		GenericDao<Paciente> dao = new GenericDao<Paciente>(banco){};
		dao.all();
		
	}
}
