package model;

import java.util.ArrayList;
import java.util.List;

/**
 * Classe que descreve uma loja
 * 
 * @author diogo
 *
 * útlima atualização 6/10/2020 
 */
public class Loja {
	
	private int id;
	private static int maxId = 0;
	private int codigo;
	private String nome;
	private String cnpj;
	private String cep;
	private int idCidade;
	private List<Pedido> pedidos = new ArrayList<Pedido>();
	
	public Loja(int id, int codigo, String nome, String cnpj, String cep, List<Pedido> pedidos, int idCidade) {
		super();
		this.id = id;
		this.codigo = codigo;
		this.nome = nome;
		this.cnpj = cnpj;
		this.cep = cep;
		this.pedidos = pedidos;
		this.idCidade = idCidade;
	}
	
	@Override
	public String toString() {
		return "Loja [id=" + id + ", maxId=" + maxId + ", codigo=" + codigo + ", nome=" + nome + ", cnpj=" + cnpj
				+ ", cep=" + cep + "]";
	}	
	
	public int getIdCidade() {
		return idCidade;
	}

	public void setIdCidade(int idCidade) {
		this.idCidade = idCidade;
	}

	/**
	 * Retorna o número maximo de lojas cadastradas
	 * @return
	 */
	public static int getMaxId() {
		return maxId;
	}

	/**
	 * Muda número maximo de id de lojas cadastradas
	 * @param maxId
	 */
	public static void setMaxId(int maxId) {
		Loja.maxId = maxId;
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
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getCnpj() {
		return cnpj;
	}
	
	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}
	public String getCep() {
		return cep;
	}
	
	public void setCep(String cep) {
		this.cep = cep;
	}
	
	public List<Pedido> getPedidos() {
		return pedidos;
	}
	
	public void setPedidos(List<Pedido> pedidos) {
		this.pedidos = pedidos;
	} 	
	
}
