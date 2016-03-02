package br.com.facom.urr.testes;

import java.sql.SQLException;
import java.util.Date;

import br.com.facom.urr.dao.PacienteDao;
import br.com.facom.urr.entidades.Paciente;

public class PacienteDaoTeste {
	static PacienteDao pacienteDao;
	
	public static void main(String[] args) {
		try {
			pacienteDao = new PacienteDao();
//			testeListarPacientes();
//			testeSalvaPaciente();
			testeAltera();
//			testefindById();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		
		
	}
	
	private static void testeListarPacientes() throws SQLException{
		for (Paciente paciente : pacienteDao.all()) {
			System.out.println(paciente);
		}
	}
	
	private static void testeSalvaPaciente(){
		try {
			Paciente paciente = new Paciente();
			paciente.setNome("Tolentino");
			paciente.setCpf("000.000.000-00");
			paciente.setRg("555555");
			paciente.setDataNascimento(new Date());
			paciente.setEndereco("Rua Tal");
			paciente.setTelefone("67 99999999");
			
			pacienteDao.save(paciente);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	private static void testefindById(){
		try {
			System.out.println(pacienteDao.findById(1));
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	private static void testeAltera(){
		try {
			Paciente paciente = pacienteDao.findById(1);
			paciente.setCpf("000.000.000-02");
			pacienteDao.altera(paciente);
			System.out.println(pacienteDao.findById(1));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

}
