package service;

import java.net.URISyntaxException;

import org.json.JSONArray;

import dao.BebidaDAO;
import model.Bebida;
import spark.Request;
import spark.Response;

public class BebidaService implements Service{
	private BebidaDAO bebidaDAO;

	public BebidaService() {
		bebidaDAO = new BebidaDAO();

	}

	@Override
	public Object add(Request request, Response response) throws URISyntaxException {
		bebidaDAO.connect();
		String nome = request.queryParams("bebidaNome");
		String descricao = request.queryParams("bebidaDescricao").trim();
		float volume = Float.parseFloat(request.queryParams("bebidaVolume"));
		int quantidade = Integer.parseInt(request.queryParams("bebidaQuantidade"));
		float preco = Float.parseFloat(request.queryParams("bebidaPreco"));
		int idFornecedor = Integer.parseInt(request.queryParams("bebidaIdFornecedor"));

		Bebida bebida = new Bebida();
		
		bebida = new Bebida(nome, descricao, volume, preco, quantidade, idFornecedor);

		bebidaDAO.add(bebida);

		response.status(201); // created
		response.redirect("/html/bebidas/estoqueBebidas.html");
		
		return bebidaDAO.getIdMax();
	}

	@Override
	public Object get(Request request, Response response) throws URISyntaxException {
		bebidaDAO.connect();
		
		int id = Integer.parseInt(request.params(":idBebida"));
		
		Bebida bebida = (Bebida) bebidaDAO.get(id);

		response.header("Content-Type", "application/json");
		response.header("Content-Encoding", "UTF-8");
		
		bebidaDAO.close();
		
		if (bebida != null) {
			return bebida.toJson();
		} else {
			response.status(404); // NOT FOUND
			response.redirect("/notfound.html");
			return null;
		}
	}

	@Override
	public Object update(Request request, Response response) throws URISyntaxException {
		bebidaDAO.connect();

		int id = Integer.parseInt(request.params(":idBebida"));

		Bebida bebida = (Bebida) bebidaDAO.get(id);

		if (bebida != null) {
			bebida.setCodigo(Integer.parseInt(request.queryParams("bebidaCodigo")));
			bebida.setNome(request.queryParams("bebidaNome"));
			bebida.setDescricao(request.queryParams("bebidaDescricao"));
			bebida.setVolume(Float.parseFloat(request.queryParams("bebidaVolume")));
			bebida.setQuantidade(Integer.parseInt(request.queryParams("bebidaQuantidade")));
			bebida.setPreco(Float.parseFloat(request.queryParams("bebidaPreco")));

			//bebida.setAlcoolico(Boolean.parseBoolean(request.queryParams("bebidaAlcoolico")));
			//bebida.setCategoria(request.queryParams("bebidaCategoria"));

			bebidaDAO.update(bebida);

			return bebida.getCodigo();
		} else {
			response.status(404); // 404 Not found
			response.redirect("/notfound.html");
			return null;
		}

	}

	@Override
	public Object remove(Request request, Response response) throws URISyntaxException {
		bebidaDAO.connect();

		int id = Integer.parseInt(request.params(":idBebida"));

		Bebida bebida = (Bebida) bebidaDAO.get(id);

		if (bebida != null) {

			bebidaDAO.delete(bebida);

			response.status(200); // success
			return bebida.getCodigo();
		} else {
			response.status(404); // 404 Not found
			response.redirect("/notfound.html");
			return null;
		}
	}

	@Override
	public Object getAll(Request request, Response response) throws URISyntaxException {				
		response.header("Content-Type", "application/json");
		response.header("Content-Encoding", "UTF-8");
		
		bebidaDAO.connect();
		
		JSONArray allProds = new JSONArray();
		
		for (Bebida b : bebidaDAO.getAll()) {
			Bebida bebida = (Bebida) b;
			allProds.put(bebida.toJson());
		}

		bebidaDAO.close();
				
		return allProds;

	}

}
