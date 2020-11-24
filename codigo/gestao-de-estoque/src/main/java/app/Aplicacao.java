package app;

import static spark.Spark.*;

import model.Pedido;
import service.BebidaService;
import service.CidadeService;
import service.FornecedorService;
import service.PedidoService;

public class Aplicacao {
	
	private static BebidaService bebidaService = new BebidaService();
	private static CidadeService cidadeService = new CidadeService();
	private static FornecedorService fornecedorService = new FornecedorService();
	private static PedidoService pedidoService = new PedidoService();
	
	public static void main(String[] args) {
		port(6789);
		
		staticFiles.externalLocation("C:\\DANNIEL\\1_Escola\\PUC_Coreu\\2020_2\\TI_2_CC\\ti2cc-estoque\\codigo\\gestao-de-estoque\\src\\main\\resources\\public");
		//staticFiles.location("/public");
		
		//HTTP Methods: Bebida
		post("/bebida", (request,response) ->  bebidaService.add(request, response) );
		get("/bebida", (request, response) -> bebidaService.getAll(request, response)); 
		get("/bebida", (request, response) -> bebidaService.get(request, response)); 
		put("/bebida/:id", (request, response) -> bebidaService.update(request, response));
		delete("/bebida/:id", (request, response) -> bebidaService.remove(request,response));
		
		//HTTP Methods: Cidade
		post("/cidade", (request,response) ->  cidadeService.add(request, response) );
		get("/cidade", (request, response) -> cidadeService.get(request, response)); 
		put("/cidade/:id", (request, response) -> cidadeService.update(request, response));
		delete("/cidade/:id", (request, response) -> cidadeService.remove(request,response));
		get("/cidade", (request, response) -> cidadeService.getAll(request, response)); 
		
		//HTTP Methods: Fornecedor
		post("/fornecedor", (request,response) ->  fornecedorService.add(request, response) );
		get("/fornecedor", (request, response) -> fornecedorService.get(request, response)); 
		put("/fornecedor/:id", (request, response) -> fornecedorService.update(request, response));
		delete("/fornecedor/:id", (request, response) -> fornecedorService.remove(request,response));
		get("/fornecedor", (request, response) -> fornecedorService.getAll(request, response));
		
		//HTTP Methods: Pedido
		post("/pedido", (request,response) ->  pedidoService.add(request, response) );
		get("/pedido", (request, response) -> pedidoService.get(request, response)); 
		put("/pedido/:id", (request, response) -> {
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
		delete("/pedido/:id", (request, response) -> pedidoService.remove(request,response));
		get("/pedido", (request, response) -> pedidoService.getAll(request, response));
		
		
	}
	
}
