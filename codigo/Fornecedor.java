public class Fornecedor{
	public static String insert = "insert into Fornecedor "
			+ "(codigoFornecedor, endereco, telefone, nome) "
			+ " values (?,?,?,?)";
	
	public static String update = "UPDATE Fornecedor SET " +
	                        "codigoFornecedor = ?," +
	                        "endereco = ?," +
			                "telefone = ?, " +
		                    "nome = ? " +
			                "WHERE codigoFornecedor = ?";
	
	public static String delete = "delete from Fornecedor " +
		                          "where codigoFornecedor = ?";
			
	public static String selectAll = "select * from Fornecedor";
			
	public static String select = "select * from Fornecedor " +
								  "where codigoFornecedor = ?";
	
}
