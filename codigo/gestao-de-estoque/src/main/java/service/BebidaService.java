package service;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;

import org.json.JSONArray;

import dao.BebidaDAO;
import model.Bebida;
import spark.Request;
import spark.Response;

public class BebidaService {
	private BebidaDAO bebidaDAO;
	
	public BebidaService() {
		bebidaDAO = new BebidaDAO();
		
	}
	
	public Object add(Request request, Response response) {
		bebidaDAO.connect();
		int codigo = Integer.parseInt(request.queryParams("bebidaCodigo"));
		String nome = request.queryParams("bebidaNome");
		String descricao = request.queryParams("bebidaDescricao");
		float volume = Float.parseFloat(request.queryParams("bebidaVolume"));
		boolean isAlcoolico = Boolean.parseBoolean(request.queryParams("bebidaAlcoolico"));
		String categoria = request.queryParams("bebidaCategoria");
		
		//Provisório
		int idFornecedor = 3;
		
		// Pesquisar id válido
		Bebida[] bebidas = bebidaDAO.getAll();
		
		// Evitar id Duplicado
		int maiorId = 0;
		if(bebidas != null) {
			for(Bebida c : bebidas) {
				if(c.getId() > maiorId) maiorId = c.getId();
			}
		}
		
		maiorId++;
		
		Bebida bebida = new Bebida(maiorId, codigo, nome, descricao, volume, isAlcoolico, categoria, idFornecedor);
		
		bebidaDAO.add(bebida);
		
		response.status(201); // created
		
		return Integer.valueOf(maiorId);
	}
	
	public Object get(Request request, Response response) {
		int id = Integer.parseInt(request.params(":idBebida"));
		
		Bebida bebida = (Bebida) bebidaDAO.get(id);
		
		response.header("Content-Type", "application/json");
	    response.header("Content-Encoding", "UTF-8");
	    
	    if(bebida != null) {
            return bebida.toJson();
	    } else {
	    	response.status(404); // NOT FOUND
	    	response.redirect("/notfound.html");
	    	return null;
	    }
		
	}
	
}
