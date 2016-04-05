package br.com.facom.urr.dao;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import br.com.facom.urr.dao.iface.Entidade;
import br.com.facom.urr.dao.iface.IGenericDao;
import exception.DaoException;

public class GenericDao<T extends Entidade> implements IGenericDao<T> {

	private Connection connection;
	protected static String banco = "jdbc:sqlite:/home/rtsouza/git/urrFacom2016/URR.sqlite";
//	protected static String banco = "jdbc:sqlite:C:\\Users\\Tayron\\git\\urrFacom2016\\URR.sqlite";
	private Class<T> persistentClass;
	private T obj;

	public GenericDao(String base) throws DaoException {
		try {
			Class.forName("org.sqlite.JDBC");
			connection = DriverManager.getConnection(base);
			this.persistentClass = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
		} catch (ClassNotFoundException | SQLException e) {
			throw new DaoException(e.getMessage());
		}

	}

	public GenericDao()throws DaoException{
		try {
			Class.forName("org.sqlite.JDBC");
			connection = DriverManager.getConnection(banco);
			this.persistentClass = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
			throw new DaoException(e.getMessage());
		}
	
	}

	@Override
	public ArrayList<T> all() throws SQLException {		
		PreparedStatement st = this.connection.prepareStatement("Select * from " + persistentClass.getSimpleName());
		ResultSet rs = st.executeQuery();
		
		ArrayList<T> retorno = new ArrayList<>();

		while (rs.next()) {
			try {
				obj = persistentClass.newInstance();
				retorno.add(obj.criarPojo(rs));
			} catch (InstantiationException | IllegalAccessException e) {
				e.printStackTrace();
				throw new SQLException();
			}
			
		}
		st.close();
		return retorno;
	}

	@Override
	public ArrayList<T> findBy(Map<String, Object> parametros) throws SQLException {
		Statement stm = connection.createStatement();	
		String sql = "Select * from " + persistentClass.getSimpleName() + " where ";
		Iterator key = parametros.keySet().iterator();
		ArrayList<T> retorno = new ArrayList<>();
		while (key.hasNext()) {
			Object obj = key.next();
			sql += obj.toString() + " = " + parametros.get(obj.toString());
			sql += " and ";
		}
		sql = sql.substring(0, sql.length() - 4);
		ResultSet rs = stm.executeQuery(sql);
		while (rs.next()) {
			try {
				obj = persistentClass.newInstance();
				ResultSetMetaData metaData = rs.getMetaData();
				retorno.add(obj.criarPojo(rs));
			} catch (InstantiationException | IllegalAccessException e) {
				e.printStackTrace();
				throw new SQLException();
			}
		
		}
		stm.close();
		return retorno;
	}

	@Override
	public boolean insert(Map<String, Object> valores) {
		try {
			Iterator key = valores.keySet().iterator();
			String sql = "";
			String parametros = "", values="";
			String[] keys = new String[valores.size()];

			for (int i = 0; i < keys.length; i++) {
				Object obj = key.next();
				parametros += obj.toString()+" , ";
				values += " ? , ";
				keys[i] = obj.toString();
			}
			parametros = parametros.substring(0, parametros.length() - 2);
			values = values.substring(0, values.length() - 2);
			sql = "insert into "+persistentClass.getSimpleName()+ " ( "+parametros+")\n"
					+ "values ("+values+")";
			
			PreparedStatement st = connection.prepareStatement(sql);
			for (int i = 0 ; i < valores.size(); i++) {
				st.setObject(i+1, valores.get(keys[i]));
			}
			st.execute();
			st.close();
				   
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	@Override
	public boolean remove(Map<String, Object> valores) {
		Iterator key = valores.keySet().iterator();
		String sql = "";
		String parametros = "";
		for (int i = 0; i < valores.size(); i++) {
			Object obj = key.next();
			parametros += obj+" = ? ";
			if (i+1 != valores.size()) {
				parametros += " and ";
			}
		}
		
		sql = "delete from "+persistentClass.getSimpleName()+" where "+ parametros;
		try {
			
			
			PreparedStatement st = connection.prepareStatement(sql);
			key = valores.keySet().iterator();
			for (int i = 0; i < valores.size(); i++) {
				st.setObject(i+1, valores.get(key.next()));
			}
			
			st.execute();
			
			st.close();
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	@Override
	public boolean update(Map<String, Object> valores, Map<String, Object> atualizar) {
		Iterator key;
		String sql = "";
		String parametros = "";
		String atualiza = "";
		
		key = valores.keySet().iterator();
		for (int i = 0; i < valores.size(); i++) {
			parametros += key.next()+" = ? ";
			if (i+1 != valores.size()) {
				parametros += " and ";
			}
		}
		
		key = atualizar.keySet().iterator();
		for (int i = 0; i < atualizar.size(); i++) {
			atualiza += key.next()+" = ? ";
			if (i+1 != valores.size()) {
				atualiza += " , ";
			}
		}
		
		sql = "update "+persistentClass.getSimpleName()+" \n"
				+ "set "+ atualiza + " \n"
				+ "where "+parametros;
		try {
			
			
			PreparedStatement st = connection.prepareStatement(sql);
			key = atualizar.keySet().iterator();
			
			int cont = atualizar.size();
			for (int i = 0; i < atualizar.size(); i++) {
				st.setObject(i+1, atualizar.get(key.next()));
			}
			
			key = valores.keySet().iterator();
			for (int i = 0; i < valores.size(); i++) {
				st.setObject(cont+1, valores.get(key.next()) );
			}
			
			st.execute();
			
			st.close();
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		
		return true;
	
	}

	@Override
	public T findById(Integer id) throws SQLException {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("id", id);
		return this.findBy(map).get(0);
	}

}
