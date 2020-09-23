/**
 * 
 */
package br.org.fatec;


/**
 * @author Denis Lima
 *
 */
public class App {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int escolha = 99;
		Menu menu = new Menu();
		Cadastro cadastros = new Cadastro();
		
		
		while (escolha != 0) {
			menu.mostrarMenu();
			escolha = 0;
		}
		
	}
	

}
