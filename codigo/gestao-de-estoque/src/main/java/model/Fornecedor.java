package model;

import java.util.ArrayList;
import java.util.List;

/**
 * Descrever a estrutura de um fornecedor
 * 
 * @author diogo
 *
 * Última ateração 6/10/2020
 */
public class Fornecedor {
	private int id;
	private static int maxId = 0;
	private int codigo;
	private String nome;
	private int idCidade;
	private List<Bebida> bebidas = new ArrayList<Bebida>();
	
	public Fornecedor(int id, int codigo, String nome, int idCidade, List<Bebida> bebidas) {
		super();
		this.id = id;
		this.codigo = codigo;
		this.nome = nome;
		this.idCidade = idCidade;
		this.bebidas = bebidas;
	}
	
	public static int getMaxId() {
		return maxId;
	}

	public static void setMaxId(int maxId) {
		Fornecedor.maxId = maxId;
	}

	@Override
	public String toString() {
		return "Fornecedor [id=" + id + ", codigo=" + codigo + ", nome=" + nome + ", idCidade=" + idCidade
				+ ", bebidas=" + bebidas + "]";
	}

	public List<Bebida> getBebidas() {
		return bebidas;
	}

	public void setBebidas(List<Bebida> bebidas) {
		this.bebidas = bebidas;
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
	
	public int getIdCidade() {
		return idCidade;
	}
	
	public void setIdCidade(int idCidade) {
		this.idCidade = idCidade;
	}
	
	
}
