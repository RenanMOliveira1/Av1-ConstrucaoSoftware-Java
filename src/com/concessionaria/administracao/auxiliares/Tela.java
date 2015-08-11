package com.concessionaria.administracao.auxiliares;

public class Tela {
	
	/**
	 * @param mensagem
	 * 
	 * Exibe uma Mensagem na tela sem quebra de Linha.
	 */
	public void exibirMsg(String mensagem) {
		System.out.print(mensagem);
	}
	
	/**
	 * @param mensagem
	 * 
	 * Exibe uma Mensagem na tela com quebra de Linha.
	 */
	public void exibirMsgLine(String mensagem) {
		System.out.println(mensagem);
	}
	
	/**
	 * @param valor
	 * 
	 * Exibe um Valor formatado na moeda real.
	 */
	public void exibirValoresReais(double valor) {
		System.out.printf("%.2f\n", valor);
	}
	
}
