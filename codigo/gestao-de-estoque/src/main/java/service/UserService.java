package service;

import java.io.IOException;
import java.net.URISyntaxException;
import java.time.LocalDate;
import java.time.LocalDateTime;

import org.json.JSONArray;

import dao.UserDAO;
import model.User;
import spark.Request;
import spark.Response;
import java.util.Random;
import javax.servlet.*;

public class UserService {
	private UserDAO userDAO;
	
	public UserService() {
		this.userDAO = new UserDAO();
	}
	
	public Object add(Request request, Response response) throws URISyntaxException {
		userDAO.connect();
		String nome       = request.queryParams("primeiroNome");
		String sobrenome  = request.queryParams("segundoNome"); 
		String cpf        = request.queryParams("cpf");
		String cnpj 	  = request.queryParams("cnpj");
		String email      = request.queryParams("email");
		String senha      = request.queryParams("senha");
		
		User user = new User(nome, sobrenome, cpf, cnpj, email, senha);
		
		userDAO.add(user);
		
		response.status(201); // created
		response.redirect("../index.html");
		
		int idMax = userDAO.getIdMax();
		
		userDAO.close();
		
		return idMax;
	}
	
	// Efetuar login pelo email
	public Object get(Request request, Response response) throws URISyntaxException {
		userDAO.connect();
		
		String email = request.params(":email");
		
		User user = (User) userDAO.get(email);
		
		userDAO.close();
		
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
