package dao;
import java.sql.*;
import java.util.List;
import java.util.ArrayList;


public class Banco {
	protected Connection connection;
	
	public Banco() {
		connection = null;
	}
	
	/**
	 * Retorna a conexão com o banco
	 * @return
	 */
	public Connection getConnection() {
		return this.connection;
	}
	
	/**
	 * Realiza a conexao com o postgresql
	 * 
	 */
	public boolean connect() {
		String driverName = "org.postgresql.Driver";
		String serverName = "localhost";
		String myDB = "estoqueti2";
		int porta = 3214;
		String url = "jdbc:postgresql://" + serverName + ":" + porta + "/" + myDB;
		String username = "ti2cc";
		String password = "ti@cc";
		boolean status = false;

		try {
			Class.forName(driverName);
			connection = DriverManager.getConnection(url, username, password);
			System.out.println("Conexão efetuada com o postgres!");
		} catch (ClassNotFoundException e) {
			System.err.println("Conexão NÃO efetuada com o banco --- Driver não encontrado -- " + e.getMessage());
		} catch (SQLException e) {
			System.err.println("Conexão NÃO efetuada com o postgres -- " + e.getMessage());
		}	
		
		return status;
	}
	
	/**
	 * Fecha conexao com banco de dados
	 * 
	 */
	public boolean close() {
		boolean status = false;
		
		try {
			connection.close();
			status = true;
		} catch (SQLException e) {
			System.err.println(e.getMessage());
		}
		
		return status;
	}
}
