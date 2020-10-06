package model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * Descreve a estrutura de um pedido seguindo
 * a documentação dos dados.
 * 
 * @author diogo
 *
 * última alteração: 6/10/2020
 */
public class Pedido {
	private int id;
	private static int maxId = 0;
	private int codigo;
	private LocalDateTime data;
	private Double preco;
	private int quantidade;
	private int idLoja; // Loja que realizou esse pedido
	List<Bebida> bebidas = new ArrayList<Bebida>();
	
	public Pedido(int id, int codigo, LocalDateTime data, Double preco, int quantidade, int idLoja) {
		super();
		this.id = id;
		this.codigo = codigo;
		this.data = data;
		this.preco = preco;
		this.quantidade = quantidade;
		this.idLoja = idLoja;
	}
	
	public List<Bebida> getBebidas() {
		return bebidas;
	}

	public void setBebidas(List<Bebida> bebidas) {
		this.bebidas = bebidas;
	}

	public int getIdLoja() {
		return idLoja;
	}

	public void setIdLoja(int idLoja) {
		this.idLoja = idLoja;
	}

	/**
	 * Retorna a quantidade de Pedidos registrados
	 * @return
	 */
	public static int getMaxId() {
		return maxId;
	}
	
	/**
	 * Altera a quantidade de pedidos registrados
	 * @param maxId
	 */
	public static void setMaxId(int maxId) {
		Pedido.maxId = maxId;
	}
	
	@Override
	public String toString() {
		return "[ id=" + id + ", codigo=" + codigo + ", data=" + data + ", preco=" + preco + ", quantidade="
				+ quantidade + " ]";
	}

	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public int getCodigo() {
		return codigo;
	}
	
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	
	public LocalDateTime getData() {
		return data;
	}
	
	public void setData(LocalDateTime data) {
		this.data = data;
	}
	
	public Double getPreco() {
		return preco;
	}
	
	public void setPreco(Double preco) {
		this.preco = preco;
	}
	
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
	
}
