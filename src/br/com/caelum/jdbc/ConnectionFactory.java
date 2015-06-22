package br.com.caelum.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;



public class ConnectionFactory {
	public Connection getConnection(){//Recupera o objeto Connection que foi passado para este objeto
		try {
			Class.forName("com.mysql.jdbc.Driver");
			return DriverManager.getConnection("jdbc:mysql://localhost:3306/fj21", "root", "5961");
        } catch (ClassNotFoundException e) {
        	throw new RuntimeException("Nao foi possivel obter o driver de acesso ao banco");
        } catch (SQLException e) {
        	throw new RuntimeException("Erro obtendo conexao com o banco de dados: " + e.getMessage(), e);
        }            
	}

}




