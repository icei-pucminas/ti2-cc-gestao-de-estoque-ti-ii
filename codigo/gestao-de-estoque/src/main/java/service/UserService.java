package service;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;

import org.json.JSONArray;

import dao.UserDAO;
import model.User;
import spark.Request;
import spark.Response;
import java.util.Random;

public class UserService {
	private UserDAO userDAO;
	
	public UserService() {
		this.userDAO = new UserDAO();
	}
	
	public static int gerarId() {
		Random gerador = new Random();
		
		return gerador.nextInt(225) + User.getMAIOR_ID();
	}
	
	public Object add(Request request, Response response) {
		userDAO.connect("user");
		
		String nome       = request.queryParams("primeiroNome");
		String sobrenome  = request.queryParams("segundoNome"); 
		String cpf        = request.queryParams("cpf");
		String email      = request.queryParams("email");
		String senha      = request.queryParams("senha");
		String tipo       = request.queryParams("tipo");
		
		// Gerar Id;
		int id = gerarId();
		
		User user = new User(id, nome, sobrenome, cpf, email, senha, tipo);
		
		userDAO.add(user);
		
		response.status(201); // created
		//response.redirect("http://127.0.0.1:5500/index.html");
		
		return user.getId();
	}
	
	// Efetuar login pelo email
	public Object get(Request request, Response response) {
		userDAO.connect("user");
		
		String email = request.params(":email");
		
		User user = (User) userDAO.get(email);
		
		response.header("Content-Type", "application/json");
		response.header("Content-Encoding", "UTF-8");
			
		if (user != null) {
			return user.toJson();
		} else {
			response.status(404); // NOT FOUND
			response.redirect("/notfound.html");
			return null;
		}
	}

	
	
}
