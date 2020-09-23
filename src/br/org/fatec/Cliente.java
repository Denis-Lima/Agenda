/**
 * 
 */
package br.org.fatec;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Denis Lima
 *
 */
public class Cliente {
	
	public Cliente(String nome, String sobrenome, String telefone, String nasc, String genero) {
		this.nome = nome;
		this.sobrenome = sobrenome;
		this.telefone = telefone;
		this.nasc = nasc;
		this.genero = genero;
	}
	
	private String nome;
	private String sobrenome;
	private String telefone;
	private String nasc;
	private String genero;
	private List<String> produtos = new ArrayList<>();
	private List<String> servicos = new ArrayList<>();
	
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getSobrenome() {
		return sobrenome;
	}
	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	public String getNasc() {
		return nasc;
	}
	public void setNasc(String nasc) {
		this.nasc = nasc;
	}
	public String getGenero() {
		return genero;
	}
	public void setGenero(String genero) {
		this.genero = genero;
	}
	public List<String> getProdutos() {
		return produtos;
	}
	public List<String> getServicos() {
		return servicos;
	}
	
	public void adicionarProduto(String novoProduto) {
		this.produtos.add(novoProduto);
	}
	public void adicionarServico(String novoServico) {
		this.servicos.add(novoServico);
	}
	public void removerProduto(String produtoRemovido) {
		this.produtos.remove(produtoRemovido);
	}
	public void removerServico(String servicoRemovido) {
		this.servicos.remove(servicoRemovido);
	}

}
