/**
 * Copyright (c) 2015 GEC5
 * Todos os direitos reservados.
 * 
 * NÃO ALTERE OU REMOVA AS INFORMAÇÕES DE COPYRIGHT
 * OU INFORMAÇÕES CONTIDAS NESTE HEADER
 * 
 */

package com.concessionaria.admin;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Formatter;
import java.util.HashSet;
import java.util.Map;

import com.concessionaria.enumerados.TipoVeiculo;
import com.concessionaria.excessoes.EstoqueVazioException;
import com.concessionaria.excessoes.VeiculoJaCadastradoException;

/**
 * 
 * Concessionária de veículos
 * 
 * Classe <code>Loja<code>.
 * 
 * @author Tiago Henrique
 * @author Yasmin Farias
 * @author Renan Oliveira
 * @version 2.0 (18/09/2015)
 *
 */
public class Loja {
	
	/** nome. */
	private String nome;
	
	/** endereço. */
	private String endereco;
	
	/** estoqueVeiculos. */
	private HashSet<Veiculo> estoqueVeiculos;

	/**
	 * Construtor que define estoqueVeiculos, nome, endereco.
	 * 
	 */
	public Loja() {
		this.estoqueVeiculos = new HashSet<Veiculo>();
		this.nome = "Concessionaria GEC5";
		this.endereco = "Rua São José 140 - Centro - RJ.";
	}
	
	/**
	 * Obtem nome.
	 * 
	 * @return nome
	 */
	public String getNome() {
		return nome;
	}

	/**
	 * Define nome.
	 * 
	 * @param nome
	 * 				define nome
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}

	/**
	 * Obtem endereço.
	 * 
	 * @return endereco
	 */
	public String getEndereco() {
		return endereco;
	}

	/**
	 * Define endereço.
	 * 
	 * @param endereco
	 * 				define endereco
	 */
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	/**
	 * Obtem estoque de veículos.
	 * 
	 * @return estoqueVeiculos
	 */
	public HashSet<Veiculo> getEstoqueVeiculos() {
		return estoqueVeiculos;
	}

	/**
	 * Define estoque de veículos.
	 * 
	 * @param estoqueVeiculos
	 * 				define estoqueVeiculos
	 */
	public void setEstoqueVeiculos(HashSet<Veiculo> estoqueVeiculos) {
		this.estoqueVeiculos = estoqueVeiculos;
	}

	/**
	 * Adiciona um Veiculo no Estoque de Veiculos.
	 * 
	 * @param veiculo
	 * @return Retorna <tt>true</tt> se for adicionado, e <tt>false</tt> se não adicionar.
	 * @throws VeiculoJaCadastradoException se já tiver um Veículo, lança uma excessão.
	 */
	public boolean adicionarVeiculo(Veiculo veiculo) {
		
		try {
			if (!estoqueVeiculos.add(veiculo))
				throw new VeiculoJaCadastradoException("Veículo já Cadastrado.");
		} catch (VeiculoJaCadastradoException e) {
			e.printStackTrace();
			System.exit(1);
		}
		
		return true;
	}
	
	/**
	 * 
	 * Pesquisa um Veiculo no estoque de veículos com base no Chassi passado por Parâmetro.
	 * @param chassi o Chassi do Véiculo que se deseja Encontrar
	 * @return veiculo Retorna o Veículo Encontrado, se não, retorna null.
	 * 
	 */
	public Veiculo buscarVeiculo(String chassi) {
		
		for (Veiculo veiculo : estoqueVeiculos) {
			if (veiculo.getChassi().equals(chassi)) {
				return veiculo;
			}
		}
		
		return null;
	}
	
	/**
	 * 
	 * Pesquisa um Veículo no Estoque com Base nas especificações passadas por Parâmetro.
	 * Se uma Especificação já for igual, retorna esse Veículo.
	 * 
	 * @param novasEspecificacoes Especificações que serão pesquisadas.
	 * @return resultadoVeiculos Retorna uma Coleção HashSet de Veículos encontrados, se não
	 * retorna uma Coleção vazia.
	 *
	 */
	public HashSet<Veiculo> pesquisarVeiculo(Map<String, String> novasEspecificacoes) {
		HashSet<Veiculo> resultadoVeiculos = new HashSet<Veiculo>();
		
		for (Veiculo veiculo : estoqueVeiculos) {
			if (veiculo.existeEspecificacaoVeiculo(veiculo, novasEspecificacoes)) {
				resultadoVeiculos.add(veiculo);
			}
		}
		
		return resultadoVeiculos;
	}
	
	/**
	 * 
	 * Remove um Veículo do Estoque de Veículos.
	 * 
	 * @param chassi Chassi do Veículo que será Removido
	 * @return estoqueVeiculos Retorna <tt>true</tt> se for removido
	 * e <tt>false</tt> se não for removido.
	 * 
	 */
	public boolean removerVeiculo(String chassi) {
		return estoqueVeiculos.remove(buscarVeiculo(chassi));
	}
	
	/**
	 * 
	 * Exibe Todos os Veículos Cadastrados, com Base no seu tipo (Carro, MOtocicleta, etc).
	 * 
	 * @param tipoVeiculo O Tipo de Veículo a ser Exibido.
	 * @return retorna um String Formatada com Todo o Estoque.
	 * 
	 */
	public String listarEstoque(TipoVeiculo tipoVeiculo) {
		String estoque = "";
		
		for (Veiculo veiculo : estoqueVeiculos) {
			if (veiculo.getTipoVeiculo().equals(tipoVeiculo))
				estoque += veiculo.toString();
		}
		
		return estoque;
	}
	
	/**
	 * 
	 * Salva o Estoque em um Arquivo TXT.
	 * 
	 * @param tipoVeiculo O Tipo de Veículo a ser Salvo.
	 * @return Retorna <tt>true</tt> se for Salvo, ou <tt>false</tt> se não for.
	 * 
	 * @throws SecurityException Se você não TIver Permissão, Lança essa Excessão.
	 * @throws FileNotFoundException Se Houver algum erro na Criação, Lança essa Excessão.
	 * @throws EstoqueVazioException Se não Há nenhum Carro Cadastrado, Lança essa Excessão.
	 */
	@SuppressWarnings("resource")
	public boolean salvarEstoque(TipoVeiculo tipoVeiculo) {
		Formatter arquivoEstoque = null;
		
		try {
			arquivoEstoque = new Formatter("Estoque de " + tipoVeiculo.getNomeTipoVeiculo() + "s.txt");
			
			if (listarEstoque(tipoVeiculo) == "") 
				throw new EstoqueVazioException("Estoque de Veículos está Vazio.");
			
			arquivoEstoque.format("Estoque de " + tipoVeiculo.getNomeTipoVeiculo() + "s%n%n"
					+ "=======================================================%n%n"
					+ listarEstoque(tipoVeiculo)
					+ "%n=======================================================");
			System.out.println("Estoque Salvo com Sucesso.\n");
		} catch (SecurityException ex) {
			System.err.println("Você não tem permissão para criar esse arquivo.");
			return false;
		} catch (FileNotFoundException ex) {
			System.err.println("Erro na Leitura ou Criação do Arquivo");
			return false;
		} catch (EstoqueVazioException e) {
			System.err.println("Não há Veículos Desse Tipo Cadastrado.");
			return false;
		}
		
		arquivoEstoque.close();
		return true;
	}
	
	/**
	 * 
	 * Recupera o Estoque Salvo e Exibe na Tela o Arquivo.
	 * 
	 * @param tipoVeiculo O Tipo de Veículo a ser Exibido.
	 * 
	 * @throws FileNotFoundException Se o Arquivo não for Encontrado, Lança essa Excessão.
	 *  
	 */
	public void recuperarEstoque(TipoVeiculo tipoVeiculo) {
		FileInputStream arquivoEstoque = null;
		
		try {
			arquivoEstoque = new FileInputStream("Estoque de " + tipoVeiculo.getNomeTipoVeiculo() + "s.txt");
		} catch (FileNotFoundException ex) {
			System.err.println("Erro na Abertura do Arquivo ou Arquivo não Encontrado.");
		} 
		
		InputStreamReader arquivoFormatado = new InputStreamReader(arquivoEstoque); 
		BufferedReader stringDaLinha = new BufferedReader(arquivoFormatado);
		
		String linha = null;
		try {
			linha = stringDaLinha.readLine();
			
			while(linha != null){
				System.out.println(linha);
				linha = stringDaLinha.readLine();
			}
			
			arquivoEstoque.close();
		} catch (IOException e) {
			System.err.println("Erro na manipulação do Arquivo.\n");
		}
	}
	
}


