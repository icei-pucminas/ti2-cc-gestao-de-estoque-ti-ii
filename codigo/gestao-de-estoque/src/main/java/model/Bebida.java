package model;

import org.json.JSONObject;

/**
 * Descrever a estrutura de uma Bebida 
 * @author diogo
 *
 * Última alteração 6/10/2020
 */
public class Bebida implements JsonFormatter {
	private int id;
	private static int maxId = 0;
	private int codigo;
	private String nome;
	private String descricao;
	private float volume;
	private int quantidade;
	private float preco;
	private int idFornecedor;
	
	public Bebida(int id, int codigo, String nome, String descricao, float volume, int quantidade, float preco, int idFornecedor) {
		super();
		this.id = id;
		this.codigo = codigo;
		this.nome = nome;
		this.descricao = descricao;
		this.volume = volume;
		this.idFornecedor = idFornecedor;
		this.preco = preco;
		this.quantidade = quantidade;
		maxId++;
	}

	@Override
	public String toString() {
		return "Bebida [id=" + id + ", codigo=" + codigo + ", nome=" + nome + ", descricao=" + descricao + ", volume="
				+ volume + ", idFornecedor=" + idFornecedor + "]";
	}

	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public static int getMaxId() {
		return maxId;
	}
	
	public static void setMaxId(int maxId) {
		Bebida.maxId = maxId;
	}
	
	public int getCodigo() {
		return codigo;
	}
	
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getDescricao() {
		return descricao;
	}
	
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	public float getVolume() {
		return volume;
	}
	
	public void setVolume(float volume) {
		this.volume = volume;
	}
	
	public int getIdFornecedor() {
		return idFornecedor;
	}
	
	public void setIdFornecedor(int idFornecedor) {
		this.idFornecedor = idFornecedor;
	} 
	
	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	public float getPreco() {
		return preco;
	}

	public void setPreco(float preco) {
		this.preco = preco;
	}

	/**
	 * Converte uma bebida para formato JSON
	 */
	@Override
	public JSONObject toJson() {
		JSONObject obj = new JSONObject();
		obj.put("id", this.getId());
		obj.put("codigo", this.getCodigo());
		obj.put("nome", this.getNome());
		obj.put("descricao", this.getDescricao());
		obj.put("volume", this.getVolume());
		obj.put("idFornecedor", this.getIdFornecedor());
		return obj;
	}
	

	
}
