package model;

import org.json.JSONObject;

/**
 * Classe definida para o usuário
 * 
 * @author diogo
 *
 */
public class User implements JsonFormatter {
	private int id;
	private String nome;
	private String sobrenome;
	private String cpf; 
	private String email;
	private String senha;
	private String tipo; // Se é fornecedor, ou comprador...
	private static int MAIOR_ID = 0;
	
	public User(int id, String nome, String sobrenome, String cpf, String email, String senha, String tipo) {
		super();
		this.id = id;
		this.nome = nome;
		this.sobrenome = sobrenome;
		this.cpf = cpf;
		this.email = email;
		this.senha = senha;
		this.tipo = tipo;
		MAIOR_ID++;
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

	@Override
	public String toString() {
		return "User [nome=" + nome + ", sobrenome=" + sobrenome + ", cpf=" + cpf + ", email=" + email + ", senha="
				+ senha + ", tipo=" + tipo + "]";
	}

	/**
	 * @return the nome
	 */
	public String getNome() {
		return nome;
	}
	
	/**
	 * @param nome the nome to set
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	/**
	 * @return the sobrenome
	 */
	public String getSobrenome() {
		return sobrenome;
	}
	/**
	 * @param sobrenome the sobrenome to set
	 */
	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}
	
	/**
	 * @return the cpf
	 */
	public String getCpf() {
		return cpf;
	}

	/**
	 * @param cpf the cpf to set
	 */
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}
	
	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	
	/**
	 * @return the senha
	 */
	public String getSenha() {
		return senha;
	}
	
	/**
	 * @param senha the senha to set
	 */
	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	/**
	 * @return the tipo
	 */
	public String getTipo() {
		return tipo;
	}
	
	/**
	 * @param tipo the tipo to set
	 */
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	
	/**
	 * Converte uma bebida para formato JSON
	 */
	@Override
	public JSONObject toJson() {
		JSONObject obj = new JSONObject();
		obj.put("id", this.getId());
		obj.put("nome", this.getNome());
		obj.put("sobrenome", this.getSobrenome());
		obj.put("email", this.getEmail());
		obj.put("senha", this.getSenha());
		obj.put("tipo", this.getTipo());
		return obj;
	}
	
}