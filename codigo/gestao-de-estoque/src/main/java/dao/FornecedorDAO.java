package dao;
import java.sql.*;
import java.util.List;
import java.util.ArrayList;

import model.Cidade;
import model.Fornecedor;

/**
 * Class FornecedorDAO - DAO Operates
 * @author Danniel H. C. Vieira
 * �ltima atualiza��o 17/10/2020
 */
public class FornecedorDAO implements DAO<Fornecedor>{
	
	private Connection connection;
	
	public FornecedorDAO() {
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
	public Fornecedor get(int key) {
		Fornecedor fornecedor = null;
		try {
			Statement st = connection.createStatement();
			String sql = ("SELECT * "
					    + "FROM fornecedor 	"
					    + "WHERE fornecedor.id = " + key);
			ResultSet rs = st.executeQuery(sql);
				
			fornecedor = new Fornecedor(rs.getInt("id"), 
					 		    rs.getInt("codigo"), rs.getString("nome"), rs.getInt("idCidade"));
			st.close();
			System.out.println("Success! --- " + fornecedor.toString());
		}
		catch(Exception e) {
			System.err.println(e.getMessage());
		}
		return fornecedor;
	}

	@Override
	public void add(Fornecedor fornecedor) {
		try {
			Statement st = connection.createStatement();
			
			// Pesquisar id válido
			Fornecedor[] fornecedores = getAll();
			
			// Evitar id Duplicado
			int maiorId = 0;
			for(Fornecedor c : fornecedores) {
				if(c.getId() > maiorId) maiorId = c.getId();
			}
			maiorId++;
			
			String sql = ("INSERT INTO fornecedor (id, codigo, nome, idcidade) "
					    + "VALUES (" + maiorId + ", " + fornecedor.getCodigo() + ", '" + fornecedor.getNome() + "', '" + fornecedor.getIdCidade()) + "')";
			st.executeUpdate(sql);
			System.out.println("Sucess! --- " + fornecedor.toString());
		} catch (SQLException u) {
			throw new RuntimeException(u);
		}
	}

	@Override
	public void update(Fornecedor fornecedor) {
		try {
			Statement st = connection.createStatement();
			String sql = ("UPDATE fornecedor SET codigo = " + fornecedor.getCodigo() + " , "
					     + "nome = '"+ fornecedor.getNome() +"', idCidade = '"+ fornecedor.getIdCidade() +"'"
					     + "WHERE fornecedor.id = "+ fornecedor.getId());
			st.executeUpdate(sql);
			System.out.println("Sucess! --- " + fornecedor.toString());
		} catch (SQLException u) {
			throw new RuntimeException(u);
		}
	}

	@Override
	public void delete(Fornecedor fornecedor) {
		try {
			Statement st = connection.createStatement();
			String sql = ("DELETE FROM fornecedor WHERE fornecedor.id = " + fornecedor.getId());
			st.executeUpdate(sql);
			st.close();
			System.out.println("Sucess! --- " + fornecedor.toString());
		} catch (SQLException u) {
			throw new RuntimeException(u);
		}
	}
	@Override
	public Fornecedor[] getAll() {
		Fornecedor[] fornecedores = null;
		
		try {
			Statement st = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
			String sql = ("SELECT * FROM fornecedores");
			ResultSet rs = st.executeQuery(sql);
			if(rs.next()) {
				rs.last();
				fornecedores = new Fornecedor[rs.getRow()];
				rs.beforeFirst();
				
				for(int i = 0; rs.next(); i++) {
					fornecedores[i] = new Fornecedor(rs.getInt("id"), 
				 		    rs.getInt("codigo"), rs.getString("nome"), rs.getInt("idCidade"));
				}
			}
			st.close();
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		
		return fornecedores;
	}
	
	
	
}
