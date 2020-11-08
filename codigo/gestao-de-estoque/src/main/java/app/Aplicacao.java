package app;

import static spark.Spark.*;
import service.BebidaService;

public class Aplicacao {
	
	private static BebidaService bebidaService = new BebidaService();
	
	public static void main(String[] args) {
		port(6789);
		
		get("/bebida", (request, response) ->  bebidaService.add(request, response) );
	}
	
}
