/**
 * 
 */
package br.org.fatec;

import java.io.IOException;

/**
 * @author Denis Lima
 *
 */
public class App {

	/**
	 * @param args
	 * @throws IOException 
	 * @throws ClassNotFoundException 
	 */
	public static void main(String[] args) throws IOException, ClassNotFoundException {
		
		Controle controle = new Controle();
		Cadastro cadastros = new Cadastro();
		Cliente cl = new Cliente("denis", "lima", "12133232", "321321321", "m");
		cadastros.adicionarCadastro(cl);
		cadastros.getCadastros(cadastros);
		int escolha = 99;
		Menu menu = new Menu();
		
		while (escolha != 0) {
			menu.mostrarMenu();
			escolha = controle.opcao();
			
			if (escolha == 1) {
				System.out.println("Por favor insira o primeiro nome do cliente:");
				String nome = controle.texto();
				System.out.println("Por favor insira o sobrenome nome do cliente:");
				String sobrenome = controle.texto();
				System.out.println("Por favor insira o telefone:");
				String telefone = controle.texto();
				System.out.println("Por favor insira a data de nascimento :");
				String nasc = controle.texto();
				System.out.println("Por favor insira o genero:");
				String genero = controle.texto();
				Cliente c = new Cliente(nome, sobrenome, telefone, nasc, genero);
				cadastros.adicionarCadastro(c);
				cadastros.getCadastros(cadastros);
			}
			if (escolha == 5) {
				cadastros.salvar(cadastros);
			}
			
			if(escolha == 6) {
				cadastros.carregar();
				cadastros.getCadastros(cadastros);
			}
		}
		
	}
	

}
