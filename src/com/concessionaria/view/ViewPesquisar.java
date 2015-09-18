package com.concessionaria.view;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Map.Entry;

import com.concessionaria.admin.Loja;
import com.concessionaria.admin.Veiculo;
import com.concessionaria.enumerados.TipoVeiculo;

public class ViewPesquisar extends View {
	
	public ViewPesquisar() {
		input = new Scanner(System.in);
	}
	
	public Map<String, String> pesquisarVeiculos(Loja loja) {
		int cont = 1;
		
		System.out.println("\n");
		for (TipoVeiculo tv : TipoVeiculo.values()) {
			System.out.println(cont++ + " - " + tv.getNomeTipoVeiculo());
		}
		
		int opcao = validarCampoInteiro("Entre com o Tipo de Ve�culo: ", "Tipo de Veiculo: Dados Inv�lidos");
		TipoVeiculo tipoVeiculo = TipoVeiculo.getOpcao(opcao);
		
		return lerEspecificacoes(tipoVeiculoEscolhido(loja, tipoVeiculo), loja);
	}
	
	private HashSet<Veiculo> tipoVeiculoEscolhido(Loja loja, TipoVeiculo tipoVeiculo) {
		HashSet<Veiculo> estoqueTipoEscolhido = new HashSet<Veiculo>();
		
		for (Veiculo v : loja.getEstoqueVeiculos()) {
			if (v.getTipoVeiculo().equals(tipoVeiculo)) {
				estoqueTipoEscolhido.add(v);
			}
		}
		
		return estoqueTipoEscolhido;
	}
	
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
