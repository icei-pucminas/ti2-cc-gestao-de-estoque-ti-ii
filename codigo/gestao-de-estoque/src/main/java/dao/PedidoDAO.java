
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
 * @author Joao Atualizacao: 26-11-2020
 */

public class PedidoDAO extends Banco implements DAO<Pedido> {
	@Override
	public Pedido get(int id) {
		Pedido pedido = null;
		try {
			Statement st = connection.createStatement();
			String sql = ("SELECT * " + "FROM pedido 	" + "WHERE pedido.id = " + id);
			ResultSet rs = st.executeQuery(sql);

			pedido = new Pedido(
					rs.getInt("id"),
					rs.getDouble("precoTotal"), 
					rs.getInt("quantidade"),
					rs.getInt("idComprador"),
					rs.getInt("idBebida"),
					rs.getString("status"));

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
	
			String sql = ("INSERT INTO pedido (precoTotal, quantidade, status, idComprador, idBebida) VALUES (" + 
		    			 + pedido.getPrecoTotal()  + ", "
		    			 + pedido.getQuantidade()  + ","
		    	  + " '" + pedido.getStatus()      + "', "
		    			 + pedido.getIdComprador() + ", " 
		    			 + pedido.getIdBebida()    + "); "
					     );
			
			System.out.println("sql = " + sql);
			
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
			String sql = ("UPDATE pedido SET "
	    			+ "precoTotal = "  + pedido.getPrecoTotal()  + ", "
	    			+ "quantidade = "  + pedido.getQuantidade()  + ", "
	    			+ "status = '"     + pedido.getStatus() 	 + "', "
	    			+ "idComprador = " + pedido.getIdComprador() + ", "
	    			+ "idBebida = "    + pedido.getIdBebida()    + "); "
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
					pedidos[i] = new Pedido(
											rs.getInt("id"),
											rs.getDouble("precoTotal"), 
											rs.getInt("quantidade"),
											rs.getInt("idComprador"),
											rs.getInt("idBebida"),
											rs.getString("status")
											);
				}
			}
			st.close();
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		
		return pedidos;
	}

	@Override
	public int getIdMax() {
		// TODO Auto-generated method stub
		int id = 0;
		
		try {
			Statement st = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
			String sql = ("SELECT MAX(id) FROM pedido");
			ResultSet rs = st.executeQuery(sql);
			if (rs.next()) {
				id = rs.getInt("max");
			}
			st.close();

		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		
		return id;
	}
}
