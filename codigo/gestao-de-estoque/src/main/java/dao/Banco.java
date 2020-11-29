package dao;
import java.net.URI;
import java.net.URISyntaxException;
import java.sql.*;
import java.util.List;
import java.util.ArrayList;


public class Banco {
	protected Connection connection;
	
	public Banco() {
		connection = null;
	}
	
	/**
	 * Retorna a conexÃ£o com o banco
	 * @return
	 */
//	public Connection getConnection() {
//		return this.connection;
//	}
	private static Connection getConnection() throws URISyntaxException, SQLException {
	    URI dbUri = new URI(System.getenv("DATABASE_URL"));

	    String username = dbUri.getUserInfo().split(":")[0];
	    String password = dbUri.getUserInfo().split(":")[1];
	    String dbUrl = "jdbc:postgresql://" + dbUri.getHost() + ':' + dbUri.getPort() + dbUri.getPath() + "?sslmode=require";

	    return DriverManager.getConnection(dbUrl, username, password);
	}
	
	/**
	 * Realiza a conexao com o postgresql
	 * @throws URISyntaxException 
	 * 
	 */
	public boolean connect() throws URISyntaxException {
//		Configuração para conexão local
	
		String driverName = "org.postgresql.Driver";
//		String serverName = "localhost";
//		String myDB = "estoqueti2";
//		String porta = "5432";
//		String url = "jdbc:postgresql://" + serverName + ":" + porta + "/" + myDB;
//		String username = "ti2cc";
//		String password = "123";
		
		boolean status = false;

		try {
			Class.forName(driverName);
			connection = Banco.getConnection();
			//connection = DriverManager.getConnection(url,username,password); // Conexão local
			status = true;
			System.out.println("Conexão efetuada com o postgres!");
		} catch (ClassNotFoundException e) {
			System.err.println("Conexão Não efetuada com o banco --- Driver não encontrado -- " + e.getMessage());
		} catch (SQLException e) {
			System.err.println("Conexão Não efetuada com o postgres -- " + e.getMessage());
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
