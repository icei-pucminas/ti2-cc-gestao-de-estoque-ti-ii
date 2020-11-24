package dao;

import model.User;
import java.sql.*;

public class UserDAO extends Banco implements DAO<User> {
	
	// Generic get
	@Override
	public User get(int id) {
		User user = null;
		try {
			Statement st = connection.createStatement();
			String sql = ("SELECT *"
					    + "FROM  \"public\".\"usuario\""
					    + "WHERE Usuario.id = " + id);
			ResultSet rs = st.executeQuery(sql);
			
			user = new User(
								rs.getInt("id"),
								rs.getString("nome"), 
						        rs.getString("sobrenome"),
						        rs.getString("cpf"),
						        rs.getString("email"),
						        rs.getString("senha"),
						        rs.getString("tipo") 
					        );
			System.out.println("Sucess! --- " + user.toString());
			st.close();
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		
		return user;
	}
	
	/**
	 * Get a partir do email
	 * @param email
	 * @return
	 */
	public User get(String email) {
		User user = null;
		try {
			Statement st = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
			String sql = (
							"SELECT *"
						    + "FROM \"public\".\"usuario\" "
						    + "WHERE usuario.email = '" + email + "';"
					     );
			ResultSet rs = st.executeQuery(sql);
			
			if(rs.next()) {
				rs.beforeFirst();
				rs.next();
				user = new User(
									rs.getInt("id"),
									rs.getString("nome"), 
								    rs.getString("sobrenome"),
								    rs.getString("cpf"),
								    rs.getString("cnpj"),
								    rs.getString("email"),
								    rs.getString("senha")
							    );
				
				System.out.println("Sucess! --- " + user.toString());
			}
			st.close();
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		
		return user;
	}
	
	@Override
	public void add(User user) {
		String sql = ("INSERT into usuario (id, nome, sobrenome, cpf, cnpj, email, senha) values ("
					    + "  " + user.getId()        + ",  "
					    + " '" + user.getNome()      + "', "
					    + " '" + user.getSobrenome() + "', "
					    + " '" + user.getCpf()       + "', "
					    + " '" + user.getCnpj()      + "', "
			            + " '" + user.getEmail()     + "', "
			            + " '" + user.getSenha()     + "');"
			          );
		try {
			Statement st = connection.createStatement();
			st.executeUpdate(sql);
			System.out.println("Sucess! --- " + user.toString());
			st.close();
		} catch (Exception e) {
			System.err.println(e.getMessage());
			System.err.println(sql);
		}
	}

	@Override
	public void update(User user) {
		try {
			Statement st = connection.createStatement();
			String sql = ("UPDATE Usuario SET (id, nome, sobrenome, cpf, cnpj, email, senha, tipo) values ("
						    + " id = "         + user.getId()        + ",  "
						    + " nome = '"      + user.getNome()      + "', "
						    + " sobrenome = '" + user.getSobrenome() + "', "
						    + " cpf = '"       + user.getCpf()       + "',  "
						    + " cnpj = '"      + user.getCnpj()       + "',  "
				            + " email = '"     + user.getEmail()     + "', "
				            + " senha = '"     + user.getSenha()     + "', "
				            + "WHERE cpf = " + user.getCpf()
						  );
			st.executeUpdate(sql);	
			System.out.println("Sucess! --- " + user.toString());
			st.close();
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		
	}
	
	@Override
	public void delete(User user) {
		try {
			Statement st = connection.createStatement();
			String sql = ("DELETE "
					    + "FROM Usuario "
					    + "WHERE Usuario.id =" + user.getId());
			st.executeUpdate(sql);
			System.out.println("Sucess! --- " + user.toString());
			st.close();
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		
	}

	@Override
	public User[] getAll() {
		User[] users = null; 
		
		try {
			Statement st = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
			String sql = ("SELECT *"
					    + "FROM Usuario");
			ResultSet rs = st.executeQuery(sql);
			
			if(rs.next()) {
				rs.last();
				users = new User[rs.getRow()];
				rs.beforeFirst();
				
				for(int i = 0; rs.next(); i++) {
					users[i] = new User(
							rs.getInt("id"),
							rs.getString("nome"), 
					        rs.getString("sobrenome"),
					        rs.getString("cpf"),
					        rs.getString("email"),
					        rs.getString("senha"),
					        rs.getString("tipo") );
				}
			}
			st.close();
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		return users;
	}
		
}
