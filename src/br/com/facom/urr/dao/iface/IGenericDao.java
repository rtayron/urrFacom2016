package br.com.facom.urr.dao.iface;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public interface IGenericDao<T> {
		
		public List<T> all() throws SQLException;
		
		public<C,V> ArrayList<T> findBy(Map<C,V> parametros)throws SQLException;
		
		public<C,V> boolean insert(Map<C,V> valores);
	   
		public<C,V> boolean remove(Map<C,V> valores);
	   
		public<C,V> boolean update(Map<C,V> valores);
	    
}
