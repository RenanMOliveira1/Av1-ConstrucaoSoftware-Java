/**
 * Copyright (c) 2015 GEC5
 * Todos os direitos reservados.
 * 
 * N�O ALTERE OU REMOVA AS INFORMA��ES DE COPYRIGHT
 * OU INFORMA��ES CONTIDAS NESTE HEADER
 * 
 */
package com.concessionaria.view.especificacoes;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import com.concessionaria.enumerados.Cambio;
import com.concessionaria.enumerados.Cor;
import com.concessionaria.enumerados.Montadora;
import com.concessionaria.enumerados.TipoCarro;
import com.concessionaria.view.View;

/**
 * 
 * Cadastra as especifica��es de um carro.
 * 
 * Classe <code>ViewEspecificacoesCarro<code>.
 * 
 * @author Tiago Henrique
 * @author Yasmin Farias
 * @author Renan Oliveira
 * @version 2.0 (18/09/2015)
 *
 */
public class ViewEspecificacoesCarro extends View implements ViewEspecificacoes {
	
	public ViewEspecificacoesCarro() {
		input = new Scanner(System.in);
	}
	
	/*
	 * (non-Javadoc)
	 * @see com.concessionaria.view.especificacoes.ViewEspecificacoes#cadastrarEspecificacoes()
	 */
	@Override
	public Map<String, String> cadastrarEspecificacoes() {
		Map<String, String> especificacoes = new HashMap<String, String>();
		
		Montadora.exibirOpcoes();
		int montadora = validarOpcao("Entre com a Montadora: ", "Op��o de Montadora Inv�lida", 1, Montadora.values().length);
		especificacoes.put("Montadora", Montadora.getOpcao(montadora).getNomeMontadora());
		
		Cor.exibirOpcoes();
		int cor = validarOpcao("Entre com a Cor: ", "Op��o de Cor Inv�lida", 1, Cor.values().length);
		especificacoes.put("Cor", Cor.getOpcao(cor).getNomeCor());
		
		especificacoes.put("Modelo", validarCampoString("Entre com o Modelo: ", "Modelo: Dados Inv�lidos."));
		
		TipoCarro.exibirOpcoes();
		int tipoCarro = validarOpcao("Entre com o Tipo do Carro: ", "Tipo de Carro Inv�lido", 1, TipoCarro.values().length);
		especificacoes.put("Tipo de Carro", TipoCarro.getOpcao(tipoCarro).getNomeTipoCarro());
		
		Double motorizacao = validarCampoDouble("Entre com a Motorizacao: ", "Motorizacao: Dados Inv�lidos.");
		especificacoes.put("Motorizacao", Double.toString(motorizacao));
		
		Cambio.exibirOpcoes();
		int cambio = validarOpcao("Entre com o C�mbio: ", "Op��o de C�mbio Inv�lida", 1, Cambio.values().length);
		especificacoes.put("C�mbio", Cambio.getOpcao(cambio).getNomeCambio());
				
		Integer capacidadeTanque = validarCampoInteiro("Entre com a Capacidade do Tanque: ","Capacidade do Tanque: Inv�lido.");
		especificacoes.put("Capacidade do Tanque", Integer.toString(capacidadeTanque));
		
		return especificacoes;
	}
}
