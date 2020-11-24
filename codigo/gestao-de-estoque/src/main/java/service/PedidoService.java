package service;

import java.time.LocalDateTime;
import java.util.Random;

import org.json.JSONObject;

import dao.PedidoDAO;
import model.Pedido;
import spark.Request;
import spark.Response;

public class PedidoService implements Service{
	private PedidoDAO pedidoDAO;

	public PedidoService() {
		pedidoDAO = new PedidoDAO();

	}

	public static int gerarId() {
		Random gerador = new Random();
		
		return gerador.nextInt(225) + Pedido.getMAIOR_ID();
	}
	
	@Override
	public Object add(Request request, Response response) {
		pedidoDAO.connect();
		
		int idBebida 			= Integer.parseInt(request.queryParams("idBebida"));
		int idComprador 		= Integer.parseInt(request.queryParams("idComprador"));
		LocalDateTime data 		= LocalDateTime.parse(request.queryParams("data"));
		Double precoUnitario 	= Double.parseDouble(request.queryParams("precoUnitario"));
		int quantidade 			= Integer.parseInt(request.queryParams("quantidade"));

		int idPedido = gerarId();
		
		Pedido pedido = new Pedido(idPedido, data, precoUnitario, quantidade, idBebida, idComprador);

		pedidoDAO.add(pedido);

		response.status(201); // created

		return Integer.valueOf(idPedido);
	}

	@Override
	public Object get(Request request, Response response) {
		pedidoDAO.connect();
		
		int id = Integer.parseInt(request.params(":idPedido"));

		Pedido pedido = (Pedido) pedidoDAO.get(id);

		response.header("Content-Type", "application/json");
		response.header("Content-Encoding", "UTF-8");
				
		JSONObject resp;
		
		if (pedido != null) {
			resp = pedido.toJson();
		} else {
			response.status(404); // NOT FOUND
			response.redirect("/notfound.html");
			resp = null;
		}
		
		pedidoDAO.close();
		
		return resp;

	}

	@Override
	public Object update(Request request, Response response) throws Exception, Throwable {
		pedidoDAO.connect();
		
		int id = Integer.parseInt(request.params(":idPedido"));

		Pedido pedido = (Pedido) pedidoDAO.get(id);

		if (pedido != null) {
			int idBebida 			= Integer.parseInt(request.queryParams("idBebida"));
			int idComprador 		= Integer.parseInt(request.queryParams("idComprador"));
			LocalDateTime data 		= LocalDateTime.parse(request.queryParams("data"));
			Double precoUnitario 	= Double.parseDouble(request.queryParams("precoUnitario"));
			int quantidade 			= Integer.parseInt(request.queryParams("quantidade"));

			pedidoDAO.update(pedido);
		} else {
			response.status(404); // 404 Not found
			response.redirect("/notfound.html");
			pedido = null;
		}
		
		pedidoDAO.close();
		
		return pedido;
	}

	@Override
	public Object remove(Request request, Response response) {
		pedidoDAO.connect();
		
		int id = Integer.parseInt(request.params(":idPedido"));

		Pedido pedido = (Pedido) pedidoDAO.get(id);

		if (pedido != null) {
			pedidoDAO.delete(pedido);

			response.status(200); // success
		} else {
			response.status(404); // 404 Not found
			response.redirect("/notfound.html");
			pedido = null;
		}
		
		pedidoDAO.close();
		
		return pedido;
	}

	@Override
	public Object getAll(Request request, Response response) {
		pedidoDAO.connect();
				
		StringBuffer returnValue = new StringBuffer("pedidos: [ {");
		
		for (Pedido b : pedidoDAO.getAll()) {
			Pedido pedido = (Pedido) b;
			returnValue.append(pedido.toJson()+"}, {");
		}
		returnValue.append(" } ]");
		response.header("Content-Type", "application/json");
		response.header("Content-Encoding", "UTF-8");
		
		pedidoDAO.close();
		
		return returnValue.toString();

	}
	
}
