package br.com.facom.urr.dao.iface;

import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;


public interface Entidade extends Serializable{
	
	public Serializable getId();
	
	public <T> T criarPojo(ResultSet rs)  throws SQLException;

}
