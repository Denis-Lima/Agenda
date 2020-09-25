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
		System.out.println("0 - Sair da agenda");
		asterisco();
	}

}
