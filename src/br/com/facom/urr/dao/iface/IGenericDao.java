package br.com.facom.urr.dao.iface;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public interface IGenericDao<T> {
		
		public ArrayList<T> all() throws SQLException;
		
		public ArrayList<T> findBy(Map<String,Object> parametros)throws SQLException;
		
		public boolean insert(Map<String,Object> valores);
	   
		public boolean remove(Map<String,Object> valores);
	   
		public boolean update(Map<String,Object> valores, Map<String,Object> atualizar);
		
		//não pedido, mas para facilitar a vida :)
		public T findById(Integer id) throws SQLException ;
	    
}
