package service;

import java.net.URISyntaxException;
import java.time.LocalDateTime;
import java.util.Random;

import org.json.JSONArray;
import org.json.JSONObject;

import dao.PedidoDAO;
import dao.BebidaDAO;
import model.Bebida;
import model.Pedido;
import spark.Request;
import spark.Response;

public class PedidoService implements Service{
	private PedidoDAO pedidoDAO;
	private BebidaDAO bebidaDAO;

	public PedidoService() {
		pedidoDAO = new PedidoDAO();
		bebidaDAO = new BebidaDAO();
	}

	@Override
	public Object add(Request request, Response response) throws URISyntaxException {
		pedidoDAO.connect();
		
		int idBebida 			= Integer.parseInt(request.queryParams("idBebida"));
		int idComprador 		= Integer.parseInt(request.queryParams("idComprador"));
		//LocalDateTime data 		= LocalDateTime.parse(request.queryParams("data"));
		Double precoUnitario 	= Double.parseDouble(request.queryParams("bebidaPreco"));
		int quantidade 			= Integer.parseInt(request.queryParams("pedidoQuantidade"));
				
		Pedido pedido = new Pedido(precoUnitario, quantidade, idBebida, idComprador);

		pedidoDAO.add(pedido);

		response.status(201); // created

		return pedidoDAO.getIdMax();
	}

	@Override
	public Object get(Request request, Response response) throws URISyntaxException {
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
			pedido.setId(Integer.parseInt(request.queryParams("pedidoId")));
			pedido.setIdBebida(Integer.parseInt(request.queryParams("pedidoIdBebida")));
			pedido.setIdComprador(Integer.parseInt(request.queryParams("pedidoIdComprador")));
			pedido.setPrecoUnitario(Double.parseDouble(request.queryParams("pedidoPrecoUnitario")));
			pedido.setQuantidade(Integer.parseInt(request.queryParams("pedidoQuantidade")));
			pedido.setPrecoTotal(pedido.getQuantidade()*pedido.getPrecoUnitario());
			pedido.setStatus(request.queryParams("pedidoStatus"));

			pedidoDAO.update(pedido);
		} else {
			response.status(404); // 404 Not found
			response.redirect("/notfound.html");
			pedido = null;
		}
		
		pedidoDAO.close();
		
		return pedido.getId();
	}

	@Override
	public Object remove(Request request, Response response) throws URISyntaxException {
		pedidoDAO.connect();
	
		int id = Integer.parseInt(request.params(":idPedido"));
		System.out.println("id = " + id);

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
		
		return pedido.getId();
	}

	@Override
	public Object getAll(Request request, Response response) throws URISyntaxException {
		response.header("Content-Type", "application/json");
		response.header("Content-Encoding", "UTF-8");
		
		pedidoDAO.connect();
		
		JSONArray allProds = new JSONArray();
		
		for (Pedido p : pedidoDAO.getAll()) {
			Pedido pedido= (Pedido) p;
			allProds.put(pedido.toJson());
		}

		pedidoDAO.close();
		
		return allProds;

	}
	
	public Object getAllComprador(Request request, Response response) throws URISyntaxException {
		response.header("Content-Type", "application/json");
		response.header("Content-Encoding", "UTF-8");
		
		int id = Integer.parseInt(request.params(":idComprador"));
		
		pedidoDAO.connect();
		bebidaDAO.connect();
		
		JSONArray allProds = new JSONArray();
		
		for (Pedido p : pedidoDAO.getAllComprador(id)) {
			Pedido pedido= (Pedido) p;
	
			// Pegar informaçõe sobre a bebida
			Bebida bebida = bebidaDAO.get(pedido.getIdBebida());
			pedido.setNomeBebida(bebida.getNome());
			
			allProds.put(pedido.toJson());
		}

		pedidoDAO.close();
		bebidaDAO.close();
		
		return allProds;

	}
	
}
