package model;

import org.json.JSONObject;

/**
 * Descrever a estrutura de uma Bebida 
 * @author diogo
 *
 * Última alteração 6/10/2020
 */
public class Bebida implements JsonFormatter {
	private static int QNT_BEBIDAS = 0;
	private int codigo;
	private String nome;
	private String descricao;
	private float volume;
	private int quantidade;
	private float preco;
	private int idFornecedor;
	
	public Bebida() {
		this(0, "null", "null", 0, 0, 0, 0);
	}
	
	public Bebida(int codigo, String nome, String descricao, float volume, float preco, int quantidade, int idFornecedor) {
		super();
		this.codigo = codigo;
		this.nome = nome;
		this.descricao = descricao;
		this.volume = volume;
		this.quantidade = quantidade;
		this.preco = preco;
		this.idFornecedor = idFornecedor;
		QNT_BEBIDAS++;
	}
	
	public static int getQNT_BEBIDAS() {
		return QNT_BEBIDAS;
	}

	public static void setQNT_BEBIDAS(int qNT_BEBIDAS) {
		QNT_BEBIDAS = qNT_BEBIDAS;
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

	@Override
	public String toString() {
		return "Bebida [codigo=" + codigo + ", nome=" + nome + ", descricao=" + descricao + ", volume=" + volume
				+ ", quantidade=" + quantidade + ", preco=" + preco + ", idFornecedor=" + idFornecedor + "]";
	}

	/**
	 * Converte uma bebida para formato JSON
	 */
	@Override
	public JSONObject toJson() {
		JSONObject obj = new JSONObject();
		obj.put("codigo", this.getCodigo());
		obj.put("nome", this.getNome());
		obj.put("descricao", this.getDescricao());
		obj.put("volume", this.getVolume());
		obj.put("preco", this.getPreco());
		obj.put("quantidade", this.getQuantidade());
		obj.put("idFornecedor", this.getIdFornecedor());
		return obj;
	}
}
