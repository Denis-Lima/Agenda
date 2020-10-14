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
import java.util.Calendar;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

	
	/* pegar o ano da data de nascimento */
	public int pegarAno(Cliente cliente) {
		String nasc = cliente.getNasc();
		String ano = nasc.substring(nasc.length()-4, nasc.length());
		return Integer.parseInt(ano);
	}
	
	
	/* Relatório */
	public void relatório() {
		int media_idade = 0;
		int ano;
		int idade;
		Map<String, Integer> servicos = new HashMap<String, Integer>();
		int qtd;
		System.out.println("*************************");
		Calendar cal = Calendar.getInstance();
		int ano_atual = cal.get(Calendar.YEAR);
		for (Cliente cliente : this.lista) {
			ano = pegarAno(cliente);
			idade = ano_atual - ano;
			media_idade += idade;
		}
		media_idade = Math.round(media_idade / lista.size());
		System.out.println("Média de idade dos cliente: " + media_idade);
		int qtd_fem = 0;
		int qtd_masc = 0;
		media_idade = 0;
		int media_masc = 0;
		for (Cliente cliente : lista) {
			if (cliente.getGenero().equals("F")) {
				ano = pegarAno(cliente);
				qtd_fem++;
				idade = ano_atual - ano;
				media_idade += idade;
			} else {
				ano = pegarAno(cliente);
				qtd_masc++;
				idade = ano_atual - ano;
				media_masc += idade;
			}
		}
		media_idade = Math.round(media_idade / qtd_fem);
		System.out.println("Média de idade dos cliente femininos: " + media_idade);
		media_masc = Math.round(media_masc / qtd_masc);
		System.out.println("Média de idade dos cliente masculinos: " + media_masc);
		for (Cliente cliente : this.lista) {
			if (cliente.getServicos().size() > 0) {
				auxiliar = cliente.getServicos();
				for (String serv : auxiliar) {
					if (servicos.containsKey(serv)) {
						qtd = servicos.get(serv);
						qtd++;
						servicos.put(serv, qtd);
					} else {
						servicos.put(serv, 1);
					}
				}
			}
		}
		int maior_qtd = 0;
		String maior = "";
		for (Map.Entry<String, Integer> serv : servicos.entrySet()) {
			if (serv.getValue() > maior_qtd) {
				maior = serv.getKey();
			}
		}
		auxiliar = new ArrayList<String>();
		List<Cliente> masc = new ArrayList<Cliente>();
		List<Cliente> fem = new ArrayList<Cliente>();
		System.out.println("Serviços mais utilidado: " + maior);
		servicos = new HashMap<String, Integer>();
		maior_qtd = 0;
		maior = "";
		for (Cliente cliente : this.lista) {
			if (cliente.getGenero().equals("F")) {
				fem.add(cliente);
			} else {
				masc.add(cliente);
			}
		}
		for (Cliente cliente : fem) {
			if (cliente.getServicos().size() > 0) {
				auxiliar = cliente.getServicos();
				for (String serv : auxiliar) {
					if (servicos.containsKey(serv)) {
						qtd = servicos.get(serv);
						qtd++;
						servicos.put(serv, qtd);
					} else {
						servicos.put(serv, 1);
					}
				}
			}
		}
		for (Map.Entry<String, Integer> serv : servicos.entrySet()) {
			if (serv.getValue() > maior_qtd) {
				maior = serv.getKey();
			}
		}
		auxiliar = new ArrayList<String>();
		System.out.println("Serviços mais utilidado pelo gênero feminino: " + maior);
		servicos = new HashMap<String, Integer>();
		maior_qtd = 0;
		maior = "";
		for (Cliente cliente : masc) {
			if (cliente.getServicos().size() > 0) {
				auxiliar = cliente.getServicos();
				for (String serv : auxiliar) {
					if (servicos.containsKey(serv)) {
						qtd = servicos.get(serv);
						qtd++;
						servicos.put(serv, qtd);
					} else {
						servicos.put(serv, 1);
					}
				}
			}
		}
		for (Map.Entry<String, Integer> serv : servicos.entrySet()) {
			if (serv.getValue() > maior_qtd) {
				maior = serv.getKey();
			}
		}
		auxiliar = new ArrayList<String>();
		System.out.println("Serviços mais utilidado pelo gênero masculino: " + maior);
	}
	
	
	/* listar serviços e produtos */
	public void getProdServ(String nomeCliente) {
		for (Cliente cliente : this.lista) {
			if ((cliente.getNome() + " " + cliente.getSobrenome()).toLowerCase().equals(nomeCliente.toLowerCase())) {
				System.out.print("Serviços: ");
				for (String serv : cliente.getServicos()) {
					System.out.print(serv + ", ");
				}
				System.out.print("\nProdutos: ");
				for (String prod : cliente.getProdutos()) {
					System.out.print(prod + ", ");
				}
				System.out.println("");
				return;
			}
		}
		System.out.println("Não encontrado.");
	}
	
	
	/* Listar clientes que possuem algum serviço ou produto */
	public void getConsumidor() {
		for (Cliente cliente : this.lista) {
			if (cliente.getProdutos().size() != 0 || cliente.getServicos().size() != 0) {
				auxiliar.add(cliente.getNome() + " " + cliente.getSobrenome());
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
		fd.setFile("*.json");
        fd.setVisible(true);
        String caminho = fd.getDirectory() + fd.getFile();
        BufferedReader br = new BufferedReader(new FileReader(caminho));
        
		Gson gson = new Gson();
		this.lista = gson.fromJson(br, new TypeToken<List<Cliente>>(){}.getType());
		System.out.println("Cadastros lidos com sucesso!");
	}
	
	/* Remover um cadastro existente */
	public void remover(String nome) {
		int index = -1;
		for (Cliente cliente : lista) {
			if ((cliente.getNome() + cliente.getSobrenome()).toLowerCase().equals(nome.toLowerCase())) {
				index = lista.indexOf(cliente);
				break;
			}
		}
		if (index == -1) {
			System.out.println("Cliente não encontrado");
			return;
		}
		lista.remove(lista.get(index));
		System.out.println("Cliente removido com sucesso!");
	}
	
	/* Editar um cadastro existente */
	public void editar(String nome_completo) {
		int index = -1;
		for (Cliente cliente : lista) {
			if ((cliente.getNome() + " " + cliente.getSobrenome()).toLowerCase().equals(nome_completo.toLowerCase())) {
				index = lista.indexOf(cliente);
				break;
			}
		}
		if (index == -1) {
			System.out.println("Cliente não encontrado");
			return;
		}
		Controle controle = new Controle();
		int escolha = 99;
		Menu menu = new Menu();
		while (escolha != 0) {
			menu.editar();
			escolha = controle.opcao();
			if (escolha == 1) {
				System.out.println("Digite o novo nome: ");
				String nome = controle.texto();
				lista.get(index).setNome(nome);
			}
			if (escolha == 2) {
				System.out.println("Digite o novo Sobrenome: ");
				String sobrenome = controle.texto();
				lista.get(index).setSobrenome(sobrenome);
			}
			if (escolha == 3) {
				System.out.println("Digite o novo Telefone: ");
				String telefone = controle.texto();
				lista.get(index).setTelefone(telefone);
			}
			if (escolha == 4) {
				System.out.println("Digite a nova Data de Nascimento: ");
				String data = controle.texto();
				lista.get(index).setNasc(data);
			}
			if (escolha == 5) {
				System.out.println("Digite o Sexo: ");
				String sexo = controle.texto();
				lista.get(index).setGenero(sexo);
			}
		}
	}
	
	/* Adicionar ou remover produto/serviço */
	public void alterarProdServ(String nome_completo) {
		int index = -1;
		for (Cliente cliente : lista) {
			if ((cliente.getNome() + " " + cliente.getSobrenome()).toLowerCase().equals(nome_completo.toLowerCase())) {
				index = lista.indexOf(cliente);
				break;
			}
		}
		if (index == -1) {
			System.out.println("Cliente não encontrado");
			return;
		}
		Menu menu = new Menu();
		Controle controle = new Controle();
		int opcao = 99;
		String coisa = "";
		while (opcao != 3) {
			menu.servAlterar();
			opcao = controle.opcao();
			
			if (opcao == 1) {
				menu.add();
				opcao = controle.opcao();
				if (opcao == 10) {
					System.out.println("Digite o nome do produto a ser adicionado: ");
					coisa = controle.texto();
					if (!(coisa.isEmpty())) {
						lista.get(index).adicionarProduto(coisa.toLowerCase());
					}
					
				}
				if (opcao == 11) {
					System.out.println("Digite o nome do serviço a ser adicionado: ");
					coisa = controle.texto();
					if (!(coisa.isEmpty())) {
						lista.get(index).adicionarServico(coisa.toLowerCase());
					}
					
				}
			}
			
			if (opcao == 2) {
				System.out.println("Esses são os clientes que possuem algum serviço ou produto");
				this.getConsumidor();
				System.out.println("Escolha um: ");
				String name = controle.texto();	// nome do cliente
				getProdServ(name);
				menu.remove();
				opcao = controle.opcao();
				
				if (opcao == 10) {
					System.out.println("Digite o nome do produto a ser removido: ");
					coisa = controle.texto();
					if (!(coisa.isEmpty())) {
						for (Cliente cliente : lista) {
							if ((cliente.getNome() + " " + cliente.getSobrenome()).toLowerCase().equals(name.toLowerCase())) {
								cliente.removerProduto(coisa.toLowerCase());
								break;
							}
						}
						
					} else {
						System.out.println("Campo em branco detectado!");
					}
					
				}
				if (opcao == 11) {
					System.out.println("Digite o nome do serviço a ser removido: ");
					coisa = controle.texto();
					if (!(coisa.isEmpty())) {
						for (Cliente cliente : lista) {
							if ((cliente.getNome() + " " + cliente.getSobrenome()).toLowerCase().equals(name.toLowerCase())) {
								cliente.removerServico(coisa.toLowerCase());
								break;
							}
						}
						
					} else {
						System.out.println("Campo em branco detectado!");
					}
					
				}
				
			}
			}	
	}
}
