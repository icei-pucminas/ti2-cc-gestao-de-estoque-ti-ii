package app;

import static spark.Spark.*;

import service.BebidaService;

public class Aplicacoes {
	
	private static BebidaService bebidaService = new BebidaService();
	
	public static void main(String[] args) {
		port(6789);
		
		staticFiles.location("/public");
		
		get("/teste", (request, response) -> "Hello World!");
		
		post("/bebida", (request,response) ->  bebidaService.add(request, response) );
		
		get("/all", (request, response) -> bebidaService.getAll(request, response));
	}
	
}
