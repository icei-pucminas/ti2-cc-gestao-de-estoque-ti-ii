package model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONObject;

/**
 * Descreve a estrutura de um pedido seguindo
 * a documentação dos dados.
 * 
 * @author diogo
 *
 * última alteração: 6/10/2020
 */
public class Pedido implements JsonFormatter {
	private static int MAIOR_ID = 0;
	private int id;
	private LocalDateTime data;
	private Double precoUnitario;
	private Double precoTotal;
	private int quantidade;
	private int idBebida;
	private int idComprador;
	
	public Pedido(int id, LocalDateTime data, Double precoUnitario, int quantidade, int idBebida, int idComprador) { 
		super();
		this.id = id;
		this.data = data;
		this.precoUnitario = precoUnitario;
		this.quantidade = quantidade;
		this.idBebida = idBebida;
		this.idComprador = idComprador;
		setPrecoTotal();
		this.MAIOR_ID++;
	}

	private void setPrecoTotal() {
		this.precoTotal = this.quantidade * this.precoUnitario;
	}
	
	public Double getPrecoTotal() {
		return this.precoTotal;
	}
	
	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return the precoUnitario
	 */
	public Double getPrecoUnitario() {
		return precoUnitario;
	}

	/**
	 * @param precoUnitario the precoUnitario to set
	 */
	public void setPrecoUnitario(Double precoUnitario) {
		this.precoUnitario = precoUnitario;
	}

	/**
	 * @return the mAIOR_ID
	 */
	public static int getMAIOR_ID() {
		return MAIOR_ID;
	}

	/**
	 * @param mAIOR_ID the mAIOR_ID to set
	 */
	public static void setMAIOR_ID(int mAIOR_ID) {
		MAIOR_ID = mAIOR_ID;
	}
	
	/**
	 * @return the data
	 */
	public LocalDateTime getData() {
		return data;
	}

	/**
	 * @param data the data to set
	 */
	public void setData(LocalDateTime data) {
		this.data = data;
	}
	

	/**
	 * @return the idComprador
	 */
	public int getIdComprador() {
		return idComprador;
	}

	/**
	 * @param idComprador the idComprador to set
	 */
	public void setIdComprador(int idComprador) {
		this.idComprador = idComprador;
	}

	/**
	 * @return the idBebida
	 */
	public int getIdBebida() {
		return idBebida;
	}

	/**
	 * @param idBebida the idBebida to set
	 */
	public void setIdBebida(int idBebida) {
		this.idBebida = idBebida;
	}

	/**
	 * @return the quantidade
	 */
	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) throws Exception{
		// Verificação de quantidade
		if(quantidade > 0) {
			this.quantidade = quantidade;
		} else {
			throw new Exception ("Quantidade inválida");
		}
	}

	@Override
	public JSONObject toJson() {
		JSONObject obj = new JSONObject();
		obj.put("codigo", this.getId());
		obj.put("data", this.getData());
		obj.put("precoTotal", this.getPrecoTotal());
		obj.put("precoUnitario", this.getPrecoUnitario());
		obj.put("quantidade", this.getQuantidade());
		obj.put("idComprador", this.getIdComprador());
		obj.put("idBebida", this.getIdBebida());
		return obj;
	}
	
}
