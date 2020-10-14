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
		System.out.println("Bem vindo! Escolha uma opção!");
		asterisco();
		System.out.println("1 - Cadastrar novo cliente");
		System.out.println("2 - Editar cliente");
		System.out.println("3 - Remover cliente");
		System.out.println("4 - Listar clientes");
		System.out.println("5 - Salvar cadastros");
		System.out.println("6 - Carregar cadastros");
		System.out.println("7 - Gerar relatório");
		System.out.println("8 - Adicionar ou remover produtos e serviços");
		System.out.println("0 - Sair da agenda");
		asterisco();
	}
	
	
	public void menuListar() {
		asterisco();
		System.out.println("1 - Listar todos");
		System.out.println("2 - Listar feminino");
		System.out.println("3 - Listar masculino");
		System.out.println("4 - Listar produtos e serviços");
	}
	
	
	public void menuProdutos() {
		System.out.println("Estes são os clientes acima são os que possuem algum serviço e/ou produto consumido");
		System.out.println("Digite o nome e sobrenome do cliente para consulta: ");
	}
	
	public void editar() {
		asterisco();
		System.out.println("O que deseja editar?");
		System.out.println("1 - Nome");
		System.out.println("2 - Sobrenome");
		System.out.println("3 - Telefone");
		System.out.println("4 - Data de nascimento");
		System.out.println("5 - Sexo");
		System.out.println("0 - Sair");
	}
	
	public void servAlterar() {
		asterisco();
		System.out.println("1 - Adicionar produto ou serviço");
		System.out.println("2 - Remover produto ou serviço");
		System.out.println("3 - Sair");
	}
	
	public void add() {
		asterisco();
		System.out.println("10 - Adicionar produto");
		System.out.println("11 - Adicionar serviço");
	}
	
	public void remove() {
		asterisco();
		System.out.println("10 - Remover produto");
		System.out.println("11 - Remover serviço");
	}

}
