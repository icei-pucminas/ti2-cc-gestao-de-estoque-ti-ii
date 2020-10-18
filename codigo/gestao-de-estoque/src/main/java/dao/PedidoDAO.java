
package dao;

import java.sql.*;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.List;
import java.util.ArrayList;

import model.*;

/**
 * Class PedidoaDAO - DAO classe
 * 
 * @author < \ - Joao - / > Atualizacao: 17-10-2020
 */

public class PedidoDAO implements DAO<Pedido> {
	private Connection connection;

	public PedidoDAO() {
		connection = null;
	}

	/**
	 * Realiza a conexao com o postgresql
	 * 
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
			System.out.println("ConexÃ£o efetuada com o postgres!");
		} catch (ClassNotFoundException e) {
			System.err.println(
					"ConexÃ£o NÃƒO efetuada com o banco --- Driver nÃ£o encontrado -- " + e.getMessage());
		} catch (SQLException e) {
			System.err.println("ConexÃ£o NÃƒO efetuada com o postgres -- " + e.getMessage());
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

	@Override
	public Pedido get(int id) {
		Pedido pedido = null;
		try {
			Statement st = connection.createStatement();
			String sql = ("SELECT * " + "FROM pedido 	" + "WHERE pedido.id = " + id);
			ResultSet rs = st.executeQuery(sql);

			pedido = new Pedido(rs.getInt("id"), rs.getInt("codigo"),
					LocalDateTime.ofInstant(rs.getDate("data").toInstant(), ZoneId.systemDefault()),
					rs.getDouble("preco"), rs.getInt("quantidade"));

			st.close();
			System.out.println("Success! --- " + pedido.toString());
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}

		return pedido;
	}

	@Override
	public void add(Pedido pedido) {
		try {
			Statement st = connection.createStatement();
			
			// Pesquisar id vÃ¡lido
			Pedido[] pedidos = getAll();
			
			// Evitar id Duplicado
			int maiorId = 0;
			for(Pedido c : pedidos) {
				if(c.getId() > maiorId) maiorId = c.getId();
			}
			
			maiorId++;
			
			String sql = ("INSERT INTO pedido (id, codigo, data, preco, quantidade)"
					    + "VALUES (" + maiorId + pedido.getCodigo() + Date.from(pedido.getData().atZone(ZoneId.systemDefault()).toInstant()) 
					    +  pedido.getPreco() + pedido.getQuantidade() + ")");
			st.executeUpdate(sql);
			System.out.println("Sucess! --- " + pedido.toString());
		} catch (SQLException u) {
			throw new RuntimeException(u);
		}
	}

	@Override
	public void update(Pedido pedido) {
		try {
			Statement st = connection.createStatement();
			String sql = ("UPDATE pedido SET codigo = " + pedido.getCodigo() + " , " 
					+ "data = '" + Date.from(pedido.getData().atZone(ZoneId.systemDefault()).toInstant())
					+ "', preco = '" + pedido.getPreco() + "'" + " quantidade = '" + pedido.getQuantidade() + "'"
				    + "WHERE pedido.id = " + pedido.getId());
			st.executeUpdate(sql);
			System.out.println("Sucess! --- " + pedido.toString());
		} catch (SQLException u) {
			throw new RuntimeException(u);
		}
	}

	@Override
	public void delete(Pedido pedido) {
		try {
			Statement st = connection.createStatement();
			String sql = ("DELETE FROM pedido WHERE pedido.id = " + pedido.getId());
			st.executeUpdate(sql);
			st.close();
			System.out.println("Sucess! --- " + pedido.toString());
		} catch (SQLException u) {
			throw new RuntimeException(u);
		}
	}

	@Override
	public Pedido[] getAll() {
		Pedido[] pedidos = null;
					
		try {
			Statement st = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
			String sql = ("SELECT * FROM pedido");
			ResultSet rs = st.executeQuery(sql);
			if(rs.next()) {
				rs.last();
				pedidos = new Pedido[rs.getRow()];
				rs.beforeFirst();
				
				for(int i = 0; rs.next(); i++) {
					pedidos[i] = new Pedido(rs.getInt("id"),
				 		    rs.getInt("codigo"), LocalDateTime.ofInstant(rs.getDate("data").toInstant(), ZoneId.systemDefault()), 
				 		    rs.getDouble("preco"),rs.getInt("quantidade"));
				}
			}
			st.close();
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		
		return pedidos;
	}

}
