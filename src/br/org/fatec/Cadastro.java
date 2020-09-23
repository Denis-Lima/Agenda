/**
 * 
 */
package br.org.fatec;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author Denis Lima
 *
 */
public class Cadastro {
	
	private List<Cliente> cadastros = new ArrayList<>();
	private List<String> auxiliar = new ArrayList<>();
	
	public void getCadastros() {
		for (Cliente cliente : cadastros) {
			auxiliar.add(cliente.getNome());
		Collections.sort(auxiliar);
		for (String nome : auxiliar) {
			System.out.println(nome);
		}
		}
	}
	
	

}
