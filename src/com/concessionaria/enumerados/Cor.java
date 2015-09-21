/**
 * Copyright (c) 2015 GEC5
 * Todos os direitos reservados.
 * 
 * NÃO ALTERE OU REMOVA AS INFORMAÇÕES DE COPYRIGHT
 * OU INFORMAÇÕES CONTIDAS NESTE HEADER
 * 
 */
package com.concessionaria.enumerados;

/**
 * 
 * Guarda todos os tipos possíveis de cores para um veiculo
 * 
 * enum <code>Cor<code>.
 * 
 * @author Tiago Henrique
 * @author Yasmin Farias
 * @author Renan Oliveira
 * @version 2.0 (18/09/2015)
 *
 */
public enum Cor {
	PRETO(1, "Preto"),
	PRATA(2, "Prata"),
	BRANCO(3, "Branco"),
	VERMELHO(4, "Vermelho"),
	AMARELO(5, "Amarelo"),
	AZUL(6, "Azul"),
	VERDE(7, "Verde"),
	CHUMBO(8, "Chumbo"),
	CAMPAGNE(9, "Champagne");
	
	private int numOpcao;
	private String nomeCor;
	
	/**
	 * @param numOpcao
	 * @param nomeCor
	 * 
	 * Construtor com todos os parâmentros
	 */
	private Cor(int numOpcao, String nomeCor) {
		this.numOpcao = numOpcao;
		this.nomeCor = nomeCor;
	}
	
	/**
	 * @return Retorna o numero da opcao
	 */
	public int getNumOpcao() {
		return numOpcao;
	} 
	
	public String getNomeCor() {
		return nomeCor;
	}
	
	public static Cor getOpcao(int opcao) {
		
		for (Cor c : values()) {
			if (opcao == c.getNumOpcao()) 
				return c;
		}
		
		return null;
	}
	
	public static void exibirOpcoes() {
		
		System.out.println();
		for (Cor cor : Cor.values()) {
			System.out.println("*Digite " + cor.getNumOpcao() + " para escolher " + cor.getNomeCor());
		}
		System.out.println();
	}
	
}
