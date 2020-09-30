/**
 * 
 */
package br.org.fatec;

/**
 * @author Denis Lima
 *
 */
public class Menu {
	
	private void asterisco() {
		System.out.println("*****************************");
	}
	
	
	public void mostrarMenu() {
		asterisco();
		System.out.println("Bem vindo! Escolha uma op��o!");
		asterisco();
		System.out.println("1 - Cadastrar novo cliente");
		System.out.println("2 - Editar cliente");
		System.out.println("3 - Remover cliente");
		System.out.println("4 - Listar clientes");
		System.out.println("5 - Salvar cadastros");
		System.out.println("6 - Carregar cadastros");
		System.out.println("7 - Gerar relat�rio");
		System.out.println("8 - Ver produtos e servi�os");
		System.out.println("0 - Sair da agenda");
		asterisco();
	}
	
	
	public void menuListar() {
		asterisco();
		System.out.println("1 - Listar todos");
		System.out.println("2 - Listar feminino");
		System.out.println("3 - Listar masculino");
		System.out.println("4 - Listar produtos e servi�os");
	}
	
	
	public void menuProdutos() {
		System.out.println("Estes s�o os clientes que possuem algum servi�o e/ou produto consumido");
		System.out.println("Digite o nome e sobrenome do cliente para consulta: ");
	}

}
