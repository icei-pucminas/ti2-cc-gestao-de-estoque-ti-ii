package app;

import static spark.Spark.*;

import model.Pedido;
import service.*;

public class Aplicacao {
	
	private static BebidaService bebidaService = new BebidaService();
	private static UserService userService = new UserService();
	private static PedidoService pedidoService = new PedidoService();
	
	public static void main(String[] args) {
		port(6789);
		
		//staticFiles.externalLocation("C:\\DANNIEL\\1_Escola\\PUC_Coreu\\2020_2\\TI_2_CC\\ti2cc-estoque\\codigo\\gestao-de-estoque\\src\\main\\resources\\public");
		staticFiles.location("/public");
		
		//HTTP Methods: Bebida
		post("/create/bebida", (request,response) ->  bebidaService.add(request, response) );
		get("/all/bebida", (request, response) -> bebidaService.getAll(request, response)); 
		get("/get/bebida/:idBebida", (request, response) -> bebidaService.get(request, response)); 
		put("/update/bebida/:id", (request, response) -> bebidaService.update(request, response));
		delete("/delete/bebida/:idBebida", (request, response) -> bebidaService.remove(request,response));
		
		//HTTP Methods: Usuario
		post("/create/usuario",       (request,response) ->  userService.add(request, response) );
		get("/get/usuario/:email", (request,response) ->  userService.get(request, response) );
				
		//HTTP Methods: Pedido
		post("/create/pedido", (request,response) ->  pedidoService.add(request, response) );
		get("/get/pedido", (request, response) -> pedidoService.get(request, response)); 
		put("/update/pedido/:id", (request, response) -> {
			Object resp;
			try {
				resp = pedidoService.update(request, response);
			} catch (Throwable e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				resp = null;
			}
			return resp;
		});
		get("/delete/pedido/:idPedido", (request, response) -> pedidoService.remove(request,response));
		get("/all/pedido", (request, response) -> pedidoService.getAll(request, response));
		get("/all/pedido/:idComprador", (request, response) -> pedidoService.getAllComprador(request, response));
	}
	
}
