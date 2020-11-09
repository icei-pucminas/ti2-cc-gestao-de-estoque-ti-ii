package dao;
import java.sql.*;
import java.util.List;
import java.util.ArrayList;

import model.Bebida;


/**
 * Class BebidaDAO - DAO classe
 * @author < \ - Joao - / >
 * Atualizacao: 17-10-2020
 */

public class BebidaDAO extends Banco implements DAO<Bebida> {
	
    @Override
	public Bebida get(int codigo) {
		Bebida bebida = null;
		try {
			Statement st = connection.createStatement();
			String sql = ("SELECT * "
					    + "FROM bebida 	"
					    + "WHERE bebida.codigo = " + codigo);
			ResultSet rs = st.executeQuery(sql);
				
			bebida = new Bebida(rs.getInt("codigo"), rs.getString("nome"), rs.getString("descricao"),
					 		    rs.getFloat("volume"), rs.getInt("quantidade"), rs.getInt("idFornecedor"));
			
			st.close();
			System.out.println("Success! --- " + bebida.toString());
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		// TODO Auto-generated method stub
		return bebida;
	}

	@Override
	public void add(Bebida bebida) {
		try {
			Statement st = connection.createStatement();
			
			String sql = ("INSERT INTO bebida (id, codigo, nome, descricao, volume, isAlcoolico,  categoria, idFornecedor)"
					    + "VALUES (" 
					    + bebida.getCodigo() + ", " 
					    + bebida.getNome() +"', '"
					    + bebida.getDescricao() + "', " 
					    + bebida.getVolume() + ", "
					    + bebida.getQuantidade() + ", "
					    + bebida.getIdFornecedor() +");");
			st.executeUpdate(sql);
			System.out.println("Sucess! --- " + bebida.toString());
		} catch (SQLException u) {
			throw new RuntimeException(u);
		}
	}
	
	@Override
	public void update(Bebida bebida) {
		try {
			Statement st = connection.createStatement();
			String sql = ("UPDATE bebida SET "
					     + "codigo = " + bebida.getCodigo() + ", "
					     + "nome = '"+ bebida.getNome() + "', "
					     + "descricao = '"+ bebida.getDescricao() +"', " 
					     + "volume = " + bebida.getVolume() + ", "
					     + "quatidade = " + bebida.getQuantidade() + ", "
					     + " idFornecedor = " + bebida.getIdFornecedor()
					     + "WHERE bebida.codigo = "+ bebida.getCodigo());
			st.executeUpdate(sql);
			System.out.println("Sucess! --- " + bebida.toString());
		} catch (SQLException u) {
			throw new RuntimeException(u);
		}
	}

	@Override
	public void delete(Bebida bebida) {
		try {
			Statement st = connection.createStatement();
			String sql = ("DELETE FROM bebida WHERE bebida.codigo = " + bebida.getCodigo());
			st.executeUpdate(sql);
			st.close();
			System.out.println("Sucess! --- " + bebida.toString());
		} catch (SQLException u) {
			throw new RuntimeException(u);
		}
	}

	@Override
	public Bebida[] getAll() {
		Bebida[] bebida = null;
		
		try {
			Statement st = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
			String sql = ("SELECT * FROM bebida");
			ResultSet rs = st.executeQuery(sql);
			System.out.println(rs.toString());
			if(rs.next()) {
				rs.last();
				bebida = new Bebida[rs.getRow()];
				rs.beforeFirst();
				
				for(int i = 0; rs.next(); i++) {
					bebida[i] = new Bebida(rs.getInt("codigo"), 
							 rs.getString("nome"), 
							 rs.getString("descricao"),
				 		     rs.getFloat("volume"),
				 		     rs.getInt("quantidade"),  
				 		     rs.getInt("idFornecedor"));
				}
			}
			st.close();
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		
		return bebida;
	}

}
