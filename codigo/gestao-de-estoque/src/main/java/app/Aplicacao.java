package app;

import static spark.Spark.*;
import service.*;


public class Aplicacao {
	
	private static BebidaService bebidaService = new BebidaService();
	private static UserService userService = new UserService();
	
	public static void main(String[] args) {
		port(6789);
		
		post( "/bebida",     (request, response) ->  bebidaService.add(request, response) );
		get(  "/bebida",     (request, response) ->  bebidaService.getAll(request, response) );
			
		get ( "/user:email", (request, response) ->  userService.get(request, response));
		post( "/user",       (request, response) ->  userService.add(request, response));
	}
	
}
