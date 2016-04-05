package br.com.facom.urr.dao;

import java.util.HashMap;

import br.com.facom.urr.entidades.UpaCrs;
import exception.DaoException;

public class UpaCrsDao extends GenericDao<UpaCrs> {

	public UpaCrsDao() throws DaoException {
		super();
	}
	
	public static void main(String[] args) throws DaoException{
		UpaCrsDao dao = new UpaCrsDao();
		
		HashMap<String, Object> map = new HashMap<>();
		map.put("telefone", "67 00001");
		map.put("endereco", "Rua dos anzoiszz");
		
		dao.insert(map);
		
		
		System.out.println("Inserido com sucesso!");
	}

}
