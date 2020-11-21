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
					    + "FROM user"
					    + "WHERE user.id = " + id);
			ResultSet rs = st.executeQuery(sql);
			
			user = new User(rs.getInt("id"),
							rs.getString("nome"), 
					        rs.getString("sobrenome"),
					        rs.getString("cpf"),
					        rs.getString("email"),
					        rs.getString("senha"),
					        rs.getString("tipo") );
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
			Statement st = connection.createStatement();
			String sql = ("SELECT *"
					    + "FROM user"
					    + "WHERE user.email = " + email);
			ResultSet rs = st.executeQuery(sql);
			
			user = new User(rs.getInt("id"),
						    rs.getString("nome"), 
					        rs.getString("sobrenome"),
					        rs.getString("cpf"),
					        rs.getString("email"),
					        rs.getString("senha"),
					        rs.getString("tipo") );
			System.out.println("Sucess! --- " + user.toString());
			st.close();
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		
		return user;
	}
	
	@Override
	public void add(User user) {
		String sql = ("INSERT INTO \"public\".\"user\" (id, nome, sobrenome, cpf, email, senha, tipo) values ("
			    + "  " + user.getId()        + ",  "
			    + " '" + user.getNome()      + "', "
			    + " '" + user.getSobrenome() + "', "
			    + " '" + user.getCpf()       + "',  "
	            + " '" + user.getEmail()     + "', "
	            + " '" + user.getSenha()     + "', "
	            + " '" + user.getTipo()      + "');");
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
			String sql = ("INSERT into user (id, nome, sobrenome, cpf, email, senha, tipo) values ("
					    + "  " + user.getId()        + ",  "
					    + " '" + user.getNome()      + "', "
					    + " '" + user.getSobrenome() + "', "
					    + "  " + user.getCpf()       + ",  "
			            + " '" + user.getEmail()     + "', "
			            + " '" + user.getSenha()     + "', "
			            + " '" + user.getTipo()      + "');"
			            + "WHERE cpf = " + user.getCpf());
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
					    + "FROM user "
					    + "WHERE user.id =" + user.getId());
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
					    + "FROM user");
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
