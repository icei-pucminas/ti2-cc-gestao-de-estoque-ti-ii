package service;

import java.time.LocalDateTime;

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

	@Override
	public Object add(Request request, Response response) {
		pedidoDAO.connect();
		
		int codigo = Integer.parseInt(request.queryParams("pedidoCodigo"));
		LocalDateTime data = LocalDateTime.parse(request.queryParams("pedidoData"));
		Double preco = Double.parseDouble(request.queryParams("pedidoPreco"));
		int quantidade = Integer.parseInt(request.queryParams("pedidoQuantidade"));
		

		// Pesquisar id válido
		Pedido[] pedidos = pedidoDAO.getAll();
		Pedido pedido = new Pedido();

		// Evitar id Duplicado
		int maxCod = pedidos[pedido.getQNT_PEDIDOS()-1].getCodigo() + 1;

		pedido = new Pedido(maxCod, data, preco, quantidade);

		pedidoDAO.add(pedido);

		response.status(201); // created

		return Integer.valueOf(maxCod);
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
			pedido.setCodigo(Integer.parseInt(request.queryParams("pedidoCodigo")));
			pedido.setData(LocalDateTime.parse(request.queryParams("pedidoData")));
			pedido.setPreco(Double.parseDouble(request.queryParams("pedidoIdCidade")));
			pedido.setQuantidade(Integer.parseInt(request.queryParams("pedidoCodigo")));

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
