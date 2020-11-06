package dao;

import java.sql.*;
import java.util.List;
import java.util.Properties;
import java.util.ArrayList;

import model.Bebida;

/**
 * Class BebidaDAO - DAO classe
 * 
 * @author < \ - Joao - / > Atualizacao: 17-10-2020
 */

public class BebidaDAO implements DAO<Bebida> {
	private Connection connection;

	public Connection getConnection() {
		return connection;
	}

	public void setConnection(Connection connection) {
		this.connection = connection;
	}

	public BebidaDAO() {
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
		String porta = "6789";
		String url = "jdbc:postgresql://" + serverName + ":" + porta + "/" + myDB; // + "?gssEncMode=disable&ssl=false"
		String username = "ti2cc";
		String password = "ti@cc";
		boolean status = false;

		try {
			Class.forName(driverName);
			connection = DriverManager.getConnection(url, username, password);
			status = true;
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

	@Override
	public Bebida get(int id) {
		Bebida bebida = null;
		try {
			Statement st = connection.createStatement();
			String sql = ("SELECT * " + "FROM bebida 	" + "WHERE bebida.id = " + id);
			ResultSet rs = st.executeQuery(sql);

			bebida = new Bebida(rs.getInt("id"), rs.getInt("codigo"), rs.getString("nome"), rs.getString("descricao"),
					rs.getFloat("volume"), rs.getBoolean("isAlcoolico"), rs.getString("categoria"),
					rs.getInt("idFornecedor"));
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
					+ "VALUES (" + bebida.getId() + ", " + bebida.getCodigo() + ", '" + bebida.getNome() + "', '"
					+ bebida.getDescricao() + "', " + bebida.getVolume() + ", " + bebida.isAlcoolico() + ", '"
					+ bebida.getCategoria() + "', " + bebida.getIdFornecedor() + ")");
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
			String sql = ("UPDATE bebida SET codigo = " + bebida.getCodigo() + " , " + "nome = '" + bebida.getNome()
					+ "', descricao = '" + bebida.getDescricao() + "'" + " volume = '" + bebida.getVolume()
					+ "' isAlcoolico = '" + bebida.isAlcoolico() + " categoria = '" + bebida.getCategoria() + "'"
					+ " idFornecedor = " + bebida.getIdFornecedor() + "WHERE bebida.id = " + bebida.getId());
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
			String sql = ("DELETE FROM bebida WHERE bebida.id = " + bebida.getId());
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
			Statement st = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			String sql = ("SELECT * FROM bebida");
			ResultSet rs = st.executeQuery(sql);
			if (rs.next()) {
				rs.last();
				bebida = new Bebida[rs.getRow()];
				rs.beforeFirst();

				for (int i = 0; rs.next(); i++) {
					bebida[i] = new Bebida(rs.getInt("id"), rs.getInt("codigo"), rs.getString("nome"),
							rs.getString("descricao"), rs.getFloat("volume"), rs.getBoolean("isAlcoolico"),
							rs.getString("categoria"), rs.getInt("idFornecedor"));
				}
			}
			st.close();

		} catch (Exception e) {
			System.err.println(e.getMessage());
		}

		return bebida;
	}

}
