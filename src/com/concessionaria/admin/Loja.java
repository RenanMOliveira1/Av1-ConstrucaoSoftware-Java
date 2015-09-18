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

public class Loja {
	private String nome;
	private String endereco;
	private HashSet<Veiculo> estoqueVeiculos;

	public Loja() {
		this.estoqueVeiculos = new HashSet<Veiculo>();
		this.nome = "Concessionaria GEC5";
		this.endereco = "Rua São José 140 - Centro - RJ.";
	}
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public HashSet<Veiculo> getEstoqueVeiculos() {
		return estoqueVeiculos;
	}

	public void setEstoqueVeiculos(HashSet<Veiculo> estoqueVeiculos) {
		this.estoqueVeiculos = estoqueVeiculos;
	}

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
	
	public Veiculo buscarVeiculo(String chassi) {
		
		for (Veiculo veiculo : estoqueVeiculos) {
			if (veiculo.getChassi().equals(chassi)) {
				return veiculo;
			}
		}
		
		return null;
	}
	
	public HashSet<Veiculo> pesquisarVeiculo(Map<String, String> novasEspecificacoes) {
		HashSet<Veiculo> resultadoVeiculos = new HashSet<Veiculo>();
		
		for (Veiculo veiculo : estoqueVeiculos) {
			if (veiculo.existeVeiculo(veiculo, novasEspecificacoes)) {
				resultadoVeiculos.add(veiculo);
			}
		}
		
		return resultadoVeiculos;
	}
	
	public boolean removerVeiculo(String chassi) {
		return estoqueVeiculos.remove(buscarVeiculo(chassi));
	}
	
	public String listarEstoque(TipoVeiculo tipoVeiculo) {
		String estoque = "";
		
		for (Veiculo veiculo : estoqueVeiculos) {
			if (veiculo.getTipoVeiculo().equals(tipoVeiculo))
				estoque += veiculo.toString();
		}
		
		return estoque;
	}
	
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


