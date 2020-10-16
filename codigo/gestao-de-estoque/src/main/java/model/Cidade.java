package model;

/**
 * Classe que descreve uma Cidade dentro do DER
 * 
 * @author diogo
 *
 * Última atualização 6/10/2020
 */
/**
 * @author diogo
 *
 */
public class Cidade {
	private int id;
	private static int maxId = 0;
	private int codigo;
	private String cidade;
	private String UF;
	
	/**
	 * @param id
	 * @param codigo
	 * @param cidade
	 * @param uF
	 */
	public Cidade(int id, int codigo, String cidade, String uF) {
		super();
		this.id = id;
		this.codigo = codigo;
		this.cidade = cidade;
		UF = uF;
		maxId++;
	}
	
	public static int getMaxId() {
		return maxId;
	}

	public static void setMaxId(int maxId) {
		Cidade.maxId = maxId;
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
	
	public String getCidade() {
		return cidade;
	}
	
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	
	public String getUF() {
		return UF;
	}
	
	public void setUF(String uF) {
		UF = uF;
	}

	@Override
	public String toString() {
		return "Cidade [id=" + id + ", codigo=" + codigo + ", cidade=" + cidade + ", UF=" + UF + "]";
	}
	
}
