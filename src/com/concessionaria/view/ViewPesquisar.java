/**
 * Copyright (c) 2015 GEC5
 * Todos os direitos reservados.
 * 
 * N�O ALTERE OU REMOVA AS INFORMA��ES DE COPYRIGHT
 * OU INFORMA��ES CONTIDAS NESTE HEADER
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
 * Faz a leitura das especifica��es dos veiculos e faz a pesquisa de ve�culos.
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
	 * View do Pesquisar Ve�culo, onde retorna um Map de especifica��es.
	 * 
	 * @param loja loja recebe a Loja na qual est� se Trabalhando.
	 * @return Retorna um Map com as Especifica��es a serem Procuradas.
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
		int opcao = validarCampoInteiro("Entre com o Tipo de Ve�culo: ", "Tipo de Veiculo: Dados Inv�lidos");
		TipoVeiculo tipoVeiculo = TipoVeiculo.getOpcao(opcao);
		
		/**
		 */
		return lerEspecificacoes(tipoVeiculoEscolhido(loja, tipoVeiculo), loja);
	}
	
	/**
	 * 
	 * M�todo onde com base no tipo de ve�culo, retorna um HashSet somente com os Ve�culos
	 * associados. Facilita na Hora de Trabalhar com esses Ve�culos.
	 * 
	 * @param loja loja recebe a Loja na qual est� se Trabalhando.
	 * @param tipoVeiculo O Tipo de Ve�culo a ser Pesquisado.
	 * @return retorna um HashSet somente com os Ve�culos associados
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
	 * View para Leitura das Especifica��es, com base no Tipo de Ve�culo.
	 * 
	 * @param listaVeiculos Ve�culos a serem pesquisados.
	 * @param loja loja recebe a Loja na qual est� se Trabalhando.
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
			System.out.println("Se n�o for preenxer, -1 para passar para o pr�ximo Campo.\n");
			
			String dados = "";
			for(Entry<String, String> especificacoes: veiculoModelo.getEspecificacoes().entrySet()) {
				dados = this.validarCampoString(especificacoes.getKey() + ": ", "Dados Inv�lidos.");
				if (!dados.equals("-1")) 
					novasEspecificacoes.put(especificacoes.getKey(), dados);
			}
		}
				
		return novasEspecificacoes;
	}
}
