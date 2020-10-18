package app;

import static spark.Spark.*;

import service.BebidaService;

public class Aplicacoes {
	
	private static BebidaService bebidaService = new BebidaService();
	
	public static void main(String[] args) {
		port(3214);
		
		post("/bebida", (request,response) ->  bebidaService.add(request, response) );
	}
	
}
