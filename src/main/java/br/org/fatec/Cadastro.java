/**
 * 
 */
package br.org.fatec;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.awt.FileDialog;
import java.awt.Frame;

/**
 * @author Denis Lima
 *
 */
@SuppressWarnings("serial")
public class Cadastro implements Serializable {
	private List<Cliente> lista = new ArrayList<Cliente>();
	public List<String> auxiliar = new ArrayList<String>();
	
	
	/* listar serviços e produtos */
	public void getProdServ(String nomeCliente) {
		for (Cliente cliente : this.lista) {
			if ((cliente.getNome() + cliente.getSobrenome()).toLowerCase().equals(nomeCliente.toLowerCase())) {
				System.out.print("Serviços: ");
				for (String serv : cliente.getServicos()) {
					System.out.print(", " + serv);
				}
				System.out.print("\nProdutos: ");
				for (String prod : cliente.getProdutos()) {
					System.out.print(", " + prod);
				}
			}
		}
	}
	
	
	/* Listar clientes que possuem algum serviço ou produto */
	public void getConsumidor() {
		for (Cliente cliente : this.lista) {
			if (cliente.getProdutos().size() != 0 || cliente.getServicos().size() != 0) {
				auxiliar.add(cliente.getNome());
			}
		}
		Collections.sort(auxiliar);
		for (String nome : auxiliar) {
			System.out.println("Cliente: " + nome);
			auxiliar = new ArrayList<String>();
		}
	}
	
	
	/* Listar clientes femininos */
	public void getFeminimo() {
		for (Cliente cliente : this.lista) {
			if (cliente.getGenero().equals("F")) {
				auxiliar.add(cliente.getNome());
			}
		}
		Collections.sort(auxiliar);
		for (String nome : auxiliar) {
			System.out.println("Cliente: " + nome);
			auxiliar = new ArrayList<String>();
		}
	}
	
	
	/* Listar clientes masculinos */
	public void getMasculino() {
		for (Cliente cliente : this.lista) {
			if (cliente.getGenero().equals("M")) {
				auxiliar.add(cliente.getNome());
			}
		}
		Collections.sort(auxiliar);
		for (String nome : auxiliar) {
			System.out.println("Cliente: " + nome);
			auxiliar = new ArrayList<String>();
		}
	}
	
	
	/* Listar todos os clientes */
	public void getCadastros() {
		for (Cliente cliente : this.lista) {
			auxiliar.add(cliente.getNome() + ' ' + cliente.getSobrenome());
		}
		
		Collections.sort(auxiliar);
		for (String nome : auxiliar) {
			System.out.println("Cliente: " + nome);
			auxiliar = new ArrayList<String>();
		}
	}
	
	/* Adiciona um novo cadastro */
	public void adicionarCadastro(Cliente cliente) {
		lista.add(cliente);
	}
	
	/* Salvar os cadastros em arquivo JSON */
	public void salvar() throws IOException {
		Gson gson = new Gson();
		String json = gson.toJson(this.lista);
		
		FileDialog fd = new FileDialog((Frame) null, "Salvar cadastro", FileDialog.SAVE);
        fd.setVisible(true);
        String caminho = fd.getDirectory() + fd.getFile();
        
        FileWriter escritor = new FileWriter(caminho);
		escritor.write(json);
		escritor.close();
		System.out.println("Cadastros de clientes salvo com sucesso!");
	}
	
	/* Carrega os cadastros que estavam salvos em JSON */
	public void carregar() throws IOException, ClassNotFoundException {
		
		FileDialog fd = new FileDialog((Frame) null, "Carregar cadastro", FileDialog.LOAD);
        fd.setVisible(true);
        String caminho = fd.getDirectory() + fd.getFile();
        BufferedReader br = new BufferedReader(new FileReader(caminho));
        
		Gson gson = new Gson();
		this.lista = gson.fromJson(br, new TypeToken<List<Cliente>>(){}.getType());
		System.out.println("Cadastros lidos com sucesso!");
	}
	
}
