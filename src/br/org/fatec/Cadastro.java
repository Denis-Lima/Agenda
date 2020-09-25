/**
 * 
 */
package br.org.fatec;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.awt.FileDialog;
import java.awt.Frame;

/**
 * @author Denis Lima
 *
 */
@SuppressWarnings("serial")
public class Cadastro implements Serializable {
	private List<Cliente> lista = new ArrayList<>();
	public List<String> auxiliar = new ArrayList<>();
	
	public void getCadastros(Cadastro cadastros) {

		for (Cliente cliente : cadastros.lista) {
			auxiliar.add(cliente.getNome() + ' ' + cliente.getSobrenome());
		}
		
		Collections.sort(auxiliar);
		for (String nome : auxiliar) {
			System.out.println(nome);
		}
	}
	
	public void adicionarCadastro(Cliente cliente) {
		lista.add(cliente);
	}
	
	public void salvar(Cadastro cadastros) throws IOException {
		FileDialog fd = new FileDialog((Frame) null, "Salvar cadastro", FileDialog.SAVE);
        fd.setVisible(true);
        String caminho = fd.getDirectory() + fd.getFile();
        System.out.println(caminho);
        
		FileOutputStream canal = new FileOutputStream(caminho);
		ObjectOutputStream escritor = new ObjectOutputStream(canal);
		escritor.writeObject(cadastros);
		escritor.close();
		System.out.println("Cadastros de clientes salvo com sucesso!");
	}
	
	@SuppressWarnings("unchecked")
	public void carregar() throws IOException, ClassNotFoundException {
		FileDialog fd = new FileDialog((Frame) null, "Carregar cadastro", FileDialog.LOAD);
        fd.setVisible(true);
        fd.setFile("*.cad");
        String caminho = fd.getDirectory() + fd.getFile();
        System.out.println(caminho);
        
		FileInputStream canal = new FileInputStream(caminho);
		ObjectInputStream leitor = new ObjectInputStream(canal);
		lista = (List<Cliente>) leitor.readObject();
		leitor.close();
		System.out.println("Cadastros lidos com sucesso!");
	}
	
}
