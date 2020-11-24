package service;

import org.json.JSONObject;

import dao.CidadeDAO;
import model.Cidade;
import spark.Request;
import spark.Response;

public class CidadeService implements Service {
	private CidadeDAO cidadeDAO;
	
	public CidadeService() {
		cidadeDAO = new CidadeDAO();

	}

	@Override
	public Object add(Request request, Response response) {
		cidadeDAO.connect();
		
		int codigo = Integer.parseInt(request.queryParams("cidadeCodigo"));
		String cidade = request.queryParams("cidadeCidade");
		String uf = request.queryParams("cidadeUf");

		// Pesquisar id válido
		Cidade[] cidades = cidadeDAO.getAll();

		// Evitar id Duplicado
		int maiorId = 0;
		if (cidades != null) {
			for (Cidade c : cidades) {
				if (c.getId() > maiorId)
					maiorId = c.getId();
			}
		}
		maiorId++;

		Cidade cidadeObj = new Cidade(maiorId, codigo, cidade, uf);

		cidadeDAO.add(cidadeObj);

		response.status(201); // created
		
		cidadeDAO.close();
		
		return Integer.valueOf(maiorId);
	}

	@Override
	public Object get(Request request, Response response) {
		cidadeDAO.connect();
		
		int id = Integer.parseInt(request.params(":idCidade"));

		Cidade cidade = (Cidade) cidadeDAO.get(id);

		response.header("Content-Type", "application/json");
		response.header("Content-Encoding", "UTF-8");
				
		JSONObject resp;
		
		if (cidade != null) {
			resp = cidade.toJson();
		} else {
			response.status(404); // NOT FOUND
			response.redirect("/notfound.html");
			resp = null;
		}
		
		cidadeDAO.close();
		
		return resp;

	}

	@Override
	public Object update(Request request, Response response) {
		cidadeDAO.connect();
		
		int id = Integer.parseInt(request.params(":idCidade"));

		Cidade cidade = (Cidade) cidadeDAO.get(id);

		if (cidade != null) {
			cidade.setCodigo(Integer.parseInt(request.queryParams("cidadeCodigo")));
			cidade.setCidade(request.queryParams("cidadeCidade"));
			cidade.setUF(request.queryParams("cidadeUf"));

			cidadeDAO.update(cidade);
		} else {
			response.status(404); // 404 Not found
			response.redirect("/notfound.html");
			cidade = null;
		}
		
		cidadeDAO.close();
		
		return cidade;
	}

	@Override
	public Object remove(Request request, Response response) {
		cidadeDAO.connect();
		
		int id = Integer.parseInt(request.params(":idCidade"));

		Cidade cidade = (Cidade) cidadeDAO.get(id);

		if (cidade != null) {

			cidadeDAO.delete(cidade);

			response.status(200); // success
		} else {
			response.status(404); // 404 Not found
			response.redirect("/notfound.html");
			cidade = null;
		}
		
		cidadeDAO.close();
		
		return cidade;
	}

	@Override
	public Object getAll(Request request, Response response) {
		cidadeDAO.connect();
				
		StringBuffer returnValue = new StringBuffer("cidades: [ {");

		for (Cidade b : cidadeDAO.getAll()) {
			Cidade cidade = (Cidade) b;
			returnValue.append(cidade.toJson()+"}, {");
		}
		returnValue.append(" } ]");
		response.header("Content-Type", "application/json");
		response.header("Content-Encoding", "UTF-8");
		
		cidadeDAO.close();
		
		return returnValue.toString();

	}
}
