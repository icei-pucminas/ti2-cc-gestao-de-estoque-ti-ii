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
	private boolean isAlcoolico;
	private String categoria;
	private int idFornecedor;
	
	
	public Bebida(int id, int codigo, String nome, String descricao, float volume, boolean isAlcoolico,
                  String categoria, int idFornecedor) {
		super();
		this.id = id;
		this.codigo = codigo;
		this.nome = nome;
		this.descricao = descricao;
		this.volume = volume;
		this.isAlcoolico = isAlcoolico;
		this.categoria = categoria;
		this.idFornecedor = idFornecedor;
		maxId++;
	}

	@Override
	public String toString() {
		return "Bebida [id=" + id + ", codigo=" + codigo + ", nome=" + nome + ", descricao=" + descricao + ", volume="
				+ volume + ", isAlcoolico=" + isAlcoolico + ", fabricante=" + ", categoria=" + categoria
				+ ", preco=" + ", idFornecedor=" + idFornecedor + "]";
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
	
	public boolean isAlcoolico() {
		return isAlcoolico;
	}
	
	public void setAlcoolico(boolean isAlcoolico) {
		this.isAlcoolico = isAlcoolico;
	}
	
	public String getCategoria() {
		return categoria;
	}
	
	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
	
	public int getIdFornecedor() {
		return idFornecedor;
	}
	
	public void setIdFornecedor(int idFornecedor) {
		this.idFornecedor = idFornecedor;
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
		obj.put("isAlcoolico", this.isAlcoolico());
		obj.put("categoria", this.getCategoria());
		obj.put("idFornecedor", this.getIdFornecedor());
		return obj;
	}
	
}
