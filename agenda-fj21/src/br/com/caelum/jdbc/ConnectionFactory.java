package br.com.caelum.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
	
	
	public static Connection getConnection() {
		
		
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			return DriverManager.getConnection("jdbc:mysql://localhost/fj21", "root", "angotech");
		}
		catch (ClassNotFoundException e) 
		{
			 throw new RuntimeException(e);
		}
		catch (SQLException e) 
		{
			 throw new RuntimeException(e);
		}
	}
}
