/**
 * Copyright (c) 2015 GEC5
 * Todos os direitos reservados.
 * 
 * N�O ALTERE OU REMOVA AS INFORMA��ES DE COPYRIGHT
 * OU INFORMA��ES CONTIDAS NESTE HEADER
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
 * Concession�ria de ve�culos
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
	
	/** endere�o. */
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
		this.endereco = "Rua S�o Jos� 140 - Centro - RJ.";
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
	 * Obtem endere�o.
	 * 
	 * @return endereco
	 */
	public String getEndereco() {
		return endereco;
	}

	/**
	 * Define endere�o.
	 * 
	 * @param endereco
	 * 				define endereco
	 */
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	/**
	 * Obtem estoque de ve�culos.
	 * 
	 * @return estoqueVeiculos
	 */
	public HashSet<Veiculo> getEstoqueVeiculos() {
		return estoqueVeiculos;
	}

	/**
	 * Define estoque de ve�culos.
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
	 * @return Retorna <tt>true</tt> se for adicionado, e <tt>false</tt> se n�o adicionar.
	 * @throws VeiculoJaCadastradoException se j� tiver um Ve�culo, lan�a uma excess�o.
	 */
	public boolean adicionarVeiculo(Veiculo veiculo) {
		
		try {
			if (!estoqueVeiculos.add(veiculo))
				throw new VeiculoJaCadastradoException("Ve�culo j� Cadastrado.");
		} catch (VeiculoJaCadastradoException e) {
			e.printStackTrace();
			System.exit(1);
		}
		
		return true;
	}
	
	/**
	 * 
	 * Pesquisa um Veiculo no estoque de ve�culos com base no Chassi passado por Par�metro.
	 * @param chassi o Chassi do V�iculo que se deseja Encontrar
	 * @return veiculo Retorna o Ve�culo Encontrado, se n�o, retorna null.
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
	 * Pesquisa um Ve�culo no Estoque com Base nas especifica��es passadas por Par�metro.
	 * Se uma Especifica��o j� for igual, retorna esse Ve�culo.
	 * 
	 * @param novasEspecificacoes Especifica��es que ser�o pesquisadas.
	 * @return resultadoVeiculos Retorna uma Cole��o HashSet de Ve�culos encontrados, se n�o
	 * retorna uma Cole��o vazia.
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
	 * Remove um Ve�culo do Estoque de Ve�culos.
	 * 
	 * @param chassi Chassi do Ve�culo que ser� Removido
	 * @return estoqueVeiculos Retorna <tt>true</tt> se for removido
	 * e <tt>false</tt> se n�o for removido.
	 * 
	 */
	public boolean removerVeiculo(String chassi) {
		return estoqueVeiculos.remove(buscarVeiculo(chassi));
	}
	
	/**
	 * 
	 * Exibe Todos os Ve�culos Cadastrados, com Base no seu tipo (Carro, MOtocicleta, etc).
	 * 
	 * @param tipoVeiculo O Tipo de Ve�culo a ser Exibido.
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
	 * @param tipoVeiculo O Tipo de Ve�culo a ser Salvo.
	 * @return Retorna <tt>true</tt> se for Salvo, ou <tt>false</tt> se n�o for.
	 * 
	 * @throws SecurityException Se voc� n�o TIver Permiss�o, Lan�a essa Excess�o.
	 * @throws FileNotFoundException Se Houver algum erro na Cria��o, Lan�a essa Excess�o.
	 * @throws EstoqueVazioException Se n�o H� nenhum Carro Cadastrado, Lan�a essa Excess�o.
	 */
	@SuppressWarnings("resource")
	public boolean salvarEstoque(TipoVeiculo tipoVeiculo) {
		Formatter arquivoEstoque = null;
		
		try {
			arquivoEstoque = new Formatter("Estoque de " + tipoVeiculo.getNomeTipoVeiculo() + "s.txt");
			
			if (listarEstoque(tipoVeiculo) == "") 
				throw new EstoqueVazioException("Estoque de Ve�culos est� Vazio.");
			
			arquivoEstoque.format("Estoque de " + tipoVeiculo.getNomeTipoVeiculo() + "s%n%n"
					+ "=======================================================%n%n"
					+ listarEstoque(tipoVeiculo)
					+ "%n=======================================================");
			System.out.println("Estoque Salvo com Sucesso.\n");
		} catch (SecurityException ex) {
			System.err.println("Voc� n�o tem permiss�o para criar esse arquivo.");
			return false;
		} catch (FileNotFoundException ex) {
			System.err.println("Erro na Leitura ou Cria��o do Arquivo");
			return false;
		} catch (EstoqueVazioException e) {
			System.err.println("N�o h� Ve�culos Desse Tipo Cadastrado.");
			return false;
		}
		
		arquivoEstoque.close();
		return true;
	}
	
	/**
	 * 
	 * Recupera o Estoque Salvo e Exibe na Tela o Arquivo.
	 * 
	 * @param tipoVeiculo O Tipo de Ve�culo a ser Exibido.
	 * 
	 * @throws FileNotFoundException Se o Arquivo n�o for Encontrado, Lan�a essa Excess�o.
	 *  
	 */
	public void recuperarEstoque(TipoVeiculo tipoVeiculo) {
		FileInputStream arquivoEstoque = null;
		
		try {
			arquivoEstoque = new FileInputStream("Estoque de " + tipoVeiculo.getNomeTipoVeiculo() + "s.txt");
		} catch (FileNotFoundException ex) {
			System.err.println("Erro na Abertura do Arquivo ou Arquivo n�o Encontrado.");
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
			System.err.println("Erro na manipula��o do Arquivo.\n");
		}
	}
	
}


