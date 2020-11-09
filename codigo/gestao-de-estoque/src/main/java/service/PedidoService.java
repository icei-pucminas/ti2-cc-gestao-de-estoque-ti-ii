package service;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;

import org.json.JSONArray;

import dao.PedidoDAO;
import model.Bebida;
import model.Pedido;
import spark.Request;
import spark.Response;

public class PedidoService {
	private PedidoDAO pedidoDAO;
	
	public PedidoService() {
		pedidoDAO = new PedidoDAO();
	}
	
	public Object add(Request request, Response response) {
		pedidoDAO.connect();
		String codigo = request.queryParams("bebidaCodigo);
		String nome = request.queryParams("bebidaNome");
		String descricao = request.queryParams("bebidaDescricao");
		float volume = Float.parseFloat(request.queryParams("bebidaVolume"));
		int quantidade = Integer.parseInt(request.queryParams("bebidaQuantidade"));
		//int idFornecedor = Integer.parseInt(request.queryParams("idFornecedor"));
		
		// Provisório
		int idFornecedor = 3;
		
		Bebida bebida = new Bebida(codigo, nome, descricao, volume, quantidade, idFornecedor);

		bebidaDAO.add(bebida);

		response.status(201); // created

		return Integer.valueOf(maxCod);
	}
}
