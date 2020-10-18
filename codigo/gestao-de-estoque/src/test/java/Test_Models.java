
import dao.*;
import model.*;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

/**
 * Classe para teste do banco de dados
 * @author diogo
 *
 */
public class Test_Models {
	
	public static void main (String[] args) {
		
		Scanner sc = new Scanner(System.in);
	
		int opt = 0;
		do {
			System.out.println("Input option : ");
			System.out.println("==== CIDADE ==== ");
			System.out.println("1 - Inserir cidade ");
			System.out.println("2 - Consultar cidade ");
			System.out.println("3 - Deletar cidade ");
			System.out.println("4 - Atualizar cidade ");
			System.out.println("5 - Mostrar cidades");
			System.out.println("6 - Inserir bebeida ");
			System.out.println("0 - Sair  ");
			
			opt = sc.nextInt();
			
			Cidade[] cidades;
			CidadeDAO cidadeDAO = new CidadeDAO();
			BebidaDAO bebidaDAO = new BebidaDAO();
			Cidade cidade = null;
			Bebida bebida = null;
			int id; 
			String nome;
			String uf;
			float vol;
			//String fabricante;
			String categoria;
			int cod;
			int idForn;
			boolean isAlcoolico;
			String descricao;
			//float preco;
			switch (opt) {
				case 1 :
					sc.nextLine();
					cidadeDAO.connect();
					
					System.out.println("Informe o nome : ");
					nome = sc.nextLine();
					
					System.out.println("Informe o codigo da cidade :");
					cod = sc.nextInt();
					sc.nextLine();
					
					System.out.println("Informe o uf : ");
					uf = sc.nextLine();
			
					// id provisório
					cidade = new Cidade(-1, cod, nome, uf);
					cidadeDAO.add(cidade);
					
					cidadeDAO.close();
					break;
				case 2 :
					sc.nextLine();
					cidadeDAO.connect();
					
					System.out.print("Informe o id da cidade : ");
					id = sc.nextInt();
					sc.nextLine();
					
					cidade = cidadeDAO.get(id);
					
					cidade.toString();
					
					cidadeDAO.close();
					break;
				case 3 :
					sc.nextLine();
					cidadeDAO.connect();
					
					System.out.print("Informe o id da cidade : ");
					id = sc.nextInt();
					sc.nextLine();
					
					cidades = cidadeDAO.getAll();
					
					for(Cidade c : cidades) {
						if(c.getId() == id) {
							cidade = c;
						}
					}
					
					cidadeDAO.delete(cidade);
					
					cidadeDAO.close();
				case 4 :
					sc.nextLine();
					cidadeDAO.connect();
					
					System.out.println("Informe o id : ");
					id = sc.nextInt();
					sc.nextLine();
					
					System.out.println("Informe o codigo da cidade :");
					cod = sc.nextInt();
					sc.nextLine();
					
					System.out.println("Informe o nome : ");
					nome = sc.nextLine();
					
					System.out.println("Informe o uf : ");
					uf = sc.nextLine();
			
					// id provisório
					cidade = new Cidade(id, cod, nome, uf);
					cidadeDAO.update(cidade);
					
					cidadeDAO.close();
					break;
				case 5 :
					sc.nextLine();
					cidadeDAO.connect();
					
					cidades = cidadeDAO.getAll();
					
					for(Cidade c : cidades) {
						System.out.println(c.toString());
					}
					
					cidadeDAO.close();
					break;
				case 6 :
					sc.nextLine();
					
					bebidaDAO.connect();
					
					System.out.println("Informe o volume : ");
					vol = sc.nextFloat();
					sc.nextLine();
					
					System.out.println("Is alcoolico? :");
					isAlcoolico = sc.nextBoolean();
					sc.nextLine();
					
					System.out.println("Informe a categoria:");
					categoria = sc.nextLine();
					sc.nextLine();
					
					System.out.println("Informe o codigo da bebida :");
					cod = sc.nextInt();
					sc.nextLine();
					
					//System.out.println("Informe o preco : ");
					//preco = sc.nextFloat();
					//sc.nextLine();
					
					System.out.println("Informe o nome : ");
					nome = sc.nextLine();
					
					System.out.println("Informe o id do forn : ");
					idForn = sc.nextInt();
					sc.nextLine();
					
					System.out.println("Informe o uf : ");
					descricao = sc.nextLine();
					
					bebida = new Bebida(-1, cod, nome, descricao, vol, isAlcoolico, categoria, idForn);
					
					bebidaDAO.add(bebida);
					
					bebidaDAO.close();
					break;
				case 0 :
				default :
					break;
			}
			
		} while (opt != 0);
		sc.close();
	}
}
