package br.com.caelum.jdbc.teste;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.List;

import br.com.caelum.jdbc.ConnectionFactory;
import br.com.caelum.jdbc.ContatoDao;
import br.com.caelum.jdbc.modelo.Contato;

public class TesteConexao {

	public static void main(String[] args) throws SQLException {
/*		Connection connection = new ConnectionFactory().getConnection();
		System.out.println("Conexão aberta!");
		connection.close();
*/
		Contato contato = new Contato();
		ContatoDao contatoDao = new ContatoDao();
		//contatoDao.remove();
		contato.setNome("Mauro");
		contato.setEmail("ivone@caelum.com.br");
		contato.setEndereco("Rua Santa Cruz, 958, Vila Mariana");
		//contato.setTelefone("11-944-273722");
		//contato.setDataNascimento(new java.util.Date(Calendar.getInstance().getTimeInMillis()));
		//contatoDao.adContato(contato);
		List<Contato> lista = contatoDao.getLista();
		for(Contato c: lista){
			System.out.println("Nome: "+c.getNome()+"\nEmail: "+c.getEmail()+"\nEndereco: "+c.getEndereco()+"\nNascido em: "+formataData((c.getDataNascimento())));
		}

	}
	
	static String formataData(java.util.Calendar data){  
	    return String.format("%1$td/%1$tm/%1$tY",data) ; 
	}

}
