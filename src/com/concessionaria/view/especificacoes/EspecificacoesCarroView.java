package com.concessionaria.view.especificacoes;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import com.concessionaria.enumerados.Cambio;
import com.concessionaria.enumerados.Montadora;
import com.concessionaria.enumerados.TipoCarro;
import com.concessionaria.view.View;

public class EspecificacoesCarroView extends View implements EspecificacoesView {
	
	public EspecificacoesCarroView() {
		input = new Scanner(System.in);
	}
	
	@Override
	public Map<String, String> cadastrarEspecificacoes() {
		Map<String, String> especificacoes = new HashMap<String, String>();
		
		Montadora.exibirOpcoes();
		int montadora = validarOpcao("Entre com a Montadora: ", "Op��o de Montadora Inv�lida", 1, 18);
		especificacoes.put("Montadora", Montadora.getOpcao(montadora).getNomeMontadora());
		
		System.out.println("Entre com o Modelo: ");
		especificacoes.put("Modelo", input.next());
		
		TipoCarro.exibirOpcoes();
		int tipoCarro = validarOpcao("Entre com o Tipo do Carro: ", "Tipo de Carro Inv�lido", 1, 14);
		especificacoes.put("Tipo de Carro", TipoCarro.getOpcao(tipoCarro).getNomeTipoCarro());
		
		Double motorizacao = validarCampoDouble("Entre com a Motorizacao: ", "Motorizacao: Dados Inv�lidos.");
		especificacoes.put("Motorizacao", Double.toString(motorizacao));
		
		Cambio.exibirOpcoes();
		int cambio = validarOpcao("Entre com o C�mbio: ", "Op��o de C�mbio Inv�lida", 1, 4);
		especificacoes.put("C�mbio", Cambio.getOpcao(cambio).getNomeCambio());
				
		Integer capacidadeTanque = validarCampoInteiro("Entre com a Capacidade do Tanque: ","Capacidade do Tanque: Inv�lido.");
		especificacoes.put("Capacidade do Tanque", Integer.toString(capacidadeTanque));
		
		return especificacoes;
	}
}
