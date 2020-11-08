package service;

import org.json.JSONObject;

import dao.FornecedorDAO;
import model.Fornecedor;
import spark.Request;
import spark.Response;

public class FornecedorService implements Service{

	private FornecedorDAO fornecedorDAO;

	public FornecedorService() {
		fornecedorDAO = new FornecedorDAO();

	}

	@Override
	public Object add(Request request, Response response) {
		fornecedorDAO.connect();
		
		int codigo = Integer.parseInt(request.queryParams("fornecedorCodigo"));
		String nome = request.queryParams("fornecedorNome");
		int idCidade = Integer.parseInt(request.queryParams("fornecedorIdCidade"));

		// Pesquisar id válido
		Fornecedor[] fornecedores = fornecedorDAO.getAll();

		// Evitar id Duplicado
		int maiorId = 0;
		if (fornecedores != null) {
			for (Fornecedor c : fornecedores) {
				if (c.getId() > maiorId)
					maiorId = c.getId();
			}
		}
		maiorId++;

		Fornecedor fornecedor = new Fornecedor(maiorId, codigo, nome, idCidade);

		fornecedorDAO.add(fornecedor);

		response.status(201); // created

		return Integer.valueOf(maiorId);
	}

	@Override
	public Object get(Request request, Response response) {
		fornecedorDAO.connect();
		
		int id = Integer.parseInt(request.params(":idFornecedor"));

		Fornecedor fornecedor = (Fornecedor) fornecedorDAO.get(id);

		response.header("Content-Type", "application/json");
		response.header("Content-Encoding", "UTF-8");
				
		JSONObject resp;
		
		if (fornecedor != null) {
			resp = fornecedor.toJson();
		} else {
			response.status(404); // NOT FOUND
			response.redirect("/notfound.html");
			resp = null;
		}
		
		fornecedorDAO.close();
		
		return resp;

	}

	@Override
	public Object update(Request request, Response response) {
		fornecedorDAO.connect();
		
		int id = Integer.parseInt(request.params(":idFornecedor"));

		Fornecedor fornecedor = (Fornecedor) fornecedorDAO.get(id);

		if (fornecedor != null) {
			fornecedor.setCodigo(Integer.parseInt(request.queryParams("fornecedorCodigo")));
			fornecedor.setNome(request.queryParams("fornecedorNome"));
			fornecedor.setIdCidade(Integer.parseInt(request.queryParams("fornecedorIdCidade")));

			fornecedorDAO.update(fornecedor);
		} else {
			response.status(404); // 404 Not found
			response.redirect("/notfound.html");
			fornecedor = null;
		}
		
		fornecedorDAO.close();
		
		return fornecedor;
	}

	@Override
	public Object remove(Request request, Response response) {
		fornecedorDAO.connect();
		
		int id = Integer.parseInt(request.params(":idFornecedor"));

		Fornecedor fornecedor = (Fornecedor) fornecedorDAO.get(id);

		if (fornecedor != null) {

			fornecedorDAO.delete(fornecedor);

			response.status(200); // success
		} else {
			response.status(404); // 404 Not found
			response.redirect("/notfound.html");
			fornecedor = null;
		}
		
		fornecedorDAO.close();
		
		return fornecedor;
	}

	@Override
	public Object getAll(Request request, Response response) {
		fornecedorDAO.connect();
				
		StringBuffer returnValue = new StringBuffer("fornecedores: [ {");
		
		for (Fornecedor b : fornecedorDAO.getAll()) {
			Fornecedor fornecedor = (Fornecedor) b;
			returnValue.append(fornecedor.toJson()+"}, {");
		}
		returnValue.append(" } ]");
		response.header("Content-Type", "application/json");
		response.header("Content-Encoding", "UTF-8");
		
		fornecedorDAO.close();
		
		return returnValue.toString();

	}
	
}
