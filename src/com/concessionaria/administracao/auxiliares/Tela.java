/*
 * Copyright (c) 2015, GEC5 and/or its affiliates. All rights reserved.
 * INSTITUTO INFNET. Use is subject to license terms.
 * 
 * 
 * 
 */
package com.concessionaria.administracao.auxiliares;

/**
 * @author Tiago Henrique
 * @since JDK 1.8
 *
 */
public class Tela {
	
	/**
	 * Exibe uma Mensagem na tela sem quebra de Linha.
	 * 
	 * @param mensagem
	 */
	public void exibirMsg(String mensagem) {
		System.out.print(mensagem);
	}
	
	/**
	 * Exibe uma Mensagem na tela com quebra de Linha.
	 * 
	 * @param mensagem
	 */
	public void exibirMsgLine(String mensagem) {
		System.out.println(mensagem);
	}
	
	/**
	 * Exibe um Valor formatado na moeda real.
	 * 
	 * @param valor
	 */
	public String exibirValorReais(double valor) {
		return String.format("R$ %.2f\n", valor);
	}
	
	/**
	 * Insere uma Quebra de Linha, ou seja, uma Linha Vazia.
	 */
	public void inserirQuebraDeLinha() {
		System.out.println();
	}
	
}
