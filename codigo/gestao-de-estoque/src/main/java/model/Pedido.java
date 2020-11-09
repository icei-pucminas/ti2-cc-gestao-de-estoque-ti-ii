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
	private static int QNT_PEDIDOS = 0;
	private int codigo;
	private LocalDateTime data;
	private Double preco;
	private int quantidade;
	//private int idLoja; // Loja que realizou esse pedido
	Bebida[] bebidas;
	
	public Pedido(int codigo, LocalDateTime data, Double preco, int quantidade) { //, int idLoja) {
		super();
		this.codigo = codigo;
		this.data = data;
		this.preco = preco;
		this.quantidade = quantidade;
	}

	/**
	 * @return the qNT_PEDIDOS
	 */
	public static int getQNT_PEDIDOS() {
		return QNT_PEDIDOS;
	}


	/**
	 * @param qNT_PEDIDOS the qNT_PEDIDOS to set
	 */
	public static void setQNT_PEDIDOS(int qNT_PEDIDOS) {
		QNT_PEDIDOS = qNT_PEDIDOS;
	}

	/**
	 * @return the codigo
	 */
	public int getCodigo() {
		return codigo;
	}

	/**
	 * @param codigo the codigo to set
	 */
	public void setCodigo(int codigo) {
		this.codigo = codigo;
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
	 * @return the preco
	 */
	public Double getPreco() {
		return preco;
	}


	/**
	 * @param preco the preco to set
	 */
	public void setPreco(Double preco) {
		this.preco = preco;
	}

	/**
	 * @return the bebidas
	 */
	public Bebida[] getBebidas() {
		return bebidas;
	}

	/**
	 * @param bebidas the bebidas to set
	 */
	public void setBebidas(Bebida[] bebidas) {
		this.bebidas = bebidas;
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
		obj.put("codigo", this.getCodigo());
		obj.put("data", this.getData());
		obj.put("preco", this.getPreco());
		obj.put("quantidade", this.getQuantidade());
		obj.put("bebidas", this.getBebidas());
		return obj;
	}
	
}
