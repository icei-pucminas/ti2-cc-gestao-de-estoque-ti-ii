package dao;

import java.sql.*;
import java.util.List;
import java.util.ArrayList;

import model.Cidade;

/**
 * Class CidadeDAO - DAO Operates
 * @author diogo
 * Última atualização 15/10/2020
 */
public class CidadeDAO implements DAO<Cidade> {
	
	private Connection connection;
	
	public CidadeDAO() {
		connection = null;
	}
	
	/**
	 * Open connection in DB
	 * @return
	 */
	public boolean connect() {
		String driverName = "org.postgresql.Driver";
		String serverName = "localhost";
		String myDB = "estoqueti2";
		int porta = 4568;
		String url = "jdbc:postgresql://" + serverName + ":" + porta + "/" + myDB;
		String username = "estoqueti2";
		String password = "123";
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
	 * Close connection in DB
	 * @return
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
	
    @Override
	public Cidade get(int id) {
		Cidade cidade = null;
		try {
			Statement st = connection.createStatement();
			String sql = ("SELECT * "
					    + "FROM cidade 	"
					    + "WHERE cidade.id = " + id);
			ResultSet rs = st.executeQuery(sql);
				
			cidade = new Cidade(rs.getInt("id"), 
					 		    rs.getInt("codigo"), rs.getString("cidade"), rs.getString("uf"));
			st.close();
			System.out.println("Success! --- " + cidade.toString());
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		// TODO Auto-generated method stub
		return cidade;
	}

	@Override
	public void add(Cidade cidade) {
		try {
			Statement st = connection.createStatement();
			
			// Pesquisar id válido
			Cidade[] cidades = getAll();
			
			// Evitar id Duplicado
			int maiorId = 0;
			for(Cidade c : cidades) {
				if(c.getId() > maiorId) maiorId = c.getId();
			}
			
			maiorId++;
			
			String sql = ("INSERT INTO cidade (id, codigo, cidade, uf) "
					    + "VALUES (" + maiorId + ", " + cidade.getCodigo() + ", '" + cidade.getCidade() + "', '" + cidade.getUF()) + "')";
			st.executeUpdate(sql);
			System.out.println("Sucess! --- " + cidade.toString());
		} catch (SQLException u) {
			throw new RuntimeException(u);
		}
	}
	
	@Override
	public void update(Cidade cidade) {
		try {
			Statement st = connection.createStatement();
			String sql = ("UPDATE cidade SET codigo = " + cidade.getCodigo() + " , "
					     + "cidade = '"+ cidade.getCidade() +"', uf = '"+ cidade.getUF() +"'"
					     + "WHERE cidade.id = "+ cidade.getId());
			st.executeUpdate(sql);
			System.out.println("Sucess! --- " + cidade.toString());
		} catch (SQLException u) {
			throw new RuntimeException(u);
		}
	}

	@Override
	public void delete(Cidade cidade) {
		try {
			Statement st = connection.createStatement();
			String sql = ("DELETE FROM cidade WHERE cidade.id = " + cidade.getId());
			st.executeUpdate(sql);
			st.close();
			System.out.println("Sucess! --- " + cidade.toString());
		} catch (SQLException u) {
			throw new RuntimeException(u);
		}
	}

	@Override
	public Cidade[] getAll() {
		Cidade[] cidades = null;
				
		try {
			Statement st = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
			String sql = ("SELECT * FROM cidade");
			ResultSet rs = st.executeQuery(sql);
			if(rs.next()) {
				rs.last();
				cidades = new Cidade[rs.getRow()];
				rs.beforeFirst();
				
				for(int i = 0; rs.next(); i++) {
					cidades[i] = new Cidade(rs.getInt("id"), 
							rs.getInt("codigo"), rs.getString("cidade"), rs.getString("uf"));
				}
			}
			st.close();
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		
		return cidades;
	}
}
