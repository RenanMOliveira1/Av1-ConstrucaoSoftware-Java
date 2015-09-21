/**
 * Copyright (c) 2015 GEC5
 * Todos os direitos reservados.
 * 
 * NÃO ALTERE OU REMOVA AS INFORMAÇÕES DE COPYRIGHT
 * OU INFORMAÇÕES CONTIDAS NESTE HEADER
 * 
 */
package com.concessionaria.view;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Map.Entry;

import com.concessionaria.admin.Loja;
import com.concessionaria.admin.Veiculo;
import com.concessionaria.enumerados.TipoVeiculo;

/**
 * 
 * Faz a leitura das especificações dos veiculos e faz a pesquisa de veículos.
 * 
 * Classe <code>ViewPesquisar<code>.
 * 
 * @author Tiago Henrique
 * @author Yasmin Farias
 * @author Renan Oliveira
 * @version 2.0 (18/09/2015)
 *
 */
public class ViewPesquisar extends View {
	
	public ViewPesquisar() {
		input = new Scanner(System.in);
	}
	
	/**
	 * 
	 * View do Pesquisar Veículo, onde retorna um Map de especificações.
	 * 
	 * @param loja loja recebe a Loja na qual está se Trabalhando.
	 * @return Retorna um Map com as Especificações a serem Procuradas.
	 */
	public Map<String, String> pesquisarVeiculos(Loja loja) {
		int cont = 1;
		
		System.out.println("\n");
		for (TipoVeiculo tv : TipoVeiculo.values()) {
			System.out.println(cont++ + " - " + tv.getNomeTipoVeiculo());
		}
		
		/**
		 * 
		 */
		int opcao = validarCampoInteiro("Entre com o Tipo de Veículo: ", "Tipo de Veiculo: Dados Inválidos");
		TipoVeiculo tipoVeiculo = TipoVeiculo.getOpcao(opcao);
		
		/**
		 */
		return lerEspecificacoes(tipoVeiculoEscolhido(loja, tipoVeiculo), loja);
	}
	
	/**
	 * 
	 * Método onde com base no tipo de veículo, retorna um HashSet somente com os Veículos
	 * associados. Facilita na Hora de Trabalhar com esses Veículos.
	 * 
	 * @param loja loja recebe a Loja na qual está se Trabalhando.
	 * @param tipoVeiculo O Tipo de Veículo a ser Pesquisado.
	 * @return retorna um HashSet somente com os Veículos associados
	 */
	private HashSet<Veiculo> tipoVeiculoEscolhido(Loja loja, TipoVeiculo tipoVeiculo) {
		HashSet<Veiculo> estoqueTipoEscolhido = new HashSet<Veiculo>();
		
		for (Veiculo v : loja.getEstoqueVeiculos()) {
			if (v.getTipoVeiculo().equals(tipoVeiculo)) {
				estoqueTipoEscolhido.add(v);
			}
		}
		
		return estoqueTipoEscolhido;
	}
	
	/**
	 * 
	 * View para Leitura das Especificações, com base no Tipo de Veículo.
	 * 
	 * @param listaVeiculos Veículos a serem pesquisados.
	 * @param loja loja recebe a Loja na qual está se Trabalhando.
	 * @return retorna um Map com os Dados Preenxidos.
	 */
	private Map<String, String> lerEspecificacoes(HashSet<Veiculo> listaVeiculos, Loja loja) {
		Veiculo veiculoModelo = null;
		Map<String, String> novasEspecificacoes = new HashMap<String, String>();
		
		if (!estoqueVazio(loja)) {
			for (Veiculo veiculo : listaVeiculos) {
				veiculoModelo = veiculo;
			}
			
			for(Entry<String, String> especificacoes: veiculoModelo.getEspecificacoes().entrySet()) {
				System.out.print(" | " + especificacoes.getKey());
			}
			System.out.println(" | ");
			System.out.println("Entre com os Dados:");
			System.out.println("Se não for preenxer, -1 para passar para o próximo Campo.\n");
			
			String dados = "";
			for(Entry<String, String> especificacoes: veiculoModelo.getEspecificacoes().entrySet()) {
				dados = this.validarCampoString(especificacoes.getKey() + ": ", "Dados Inválidos.");
				if (!dados.equals("-1")) 
					novasEspecificacoes.put(especificacoes.getKey(), dados);
			}
		}
				
		return novasEspecificacoes;
	}
}
