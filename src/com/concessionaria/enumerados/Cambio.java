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
 * Guarda todos os tipos possíveis de câmbio para um carro
 * 
 * enum <code>Cambio<code>.
 * 
 * @author Tiago Henrique
 * @author Yasmin Farias
 * @author Renan Oliveira
 * @version 2.0 (18/09/2015)
 *
 */
public enum Cambio {
	CVT(1, "CVT"),
	AUTOMATICO(2, "Automático"),
	MANUAL_COMUM(3, "Manual Comum"),
	AUTOMATIZADO(4, "Automatizado");
	
	/** numOpcao */
	private int numOpcao;
	
	/** nomeCambio */
	private String nomeCambio;
	
	/**
	 * @param numOpcao
	 * @param nomeCambio
	 * 
	 * Construtor com todos os parâmentros
	 */
	private Cambio(int numOpcao, String nomeCambio) {
		this.numOpcao = numOpcao;
		this.nomeCambio = nomeCambio;
	}
	
	/**
	 * Obtem numOpcao.
	 * 
	 * @return numOpcao
	 */
	public int getNumOpcao() {
		return numOpcao;
	}
	
	/**
	 * Define opcao.
	 * 
	 * @param opcao
	 * 				define opcao
	 */
	public static Cambio getOpcao(int opcao) {
		
		for (Cambio c : values()) {
			if (opcao == c.getNumOpcao()) 
				return c;
		}
		
		return null;
	}
	
	/**
	 * Obtem nomeCambio.
	 * 
	 * @return nomeCambio
	 */
	public String getNomeCambio() {
		return nomeCambio;
	}
	
	public static void exibirOpcoes() {
		
		System.out.println();
		for (Cambio cambio : Cambio.values()) {
			System.out.println("*Digite " + cambio.getNumOpcao() + " para escolher " + cambio.getNomeCambio());
		}
		System.out.println();
	}
	
}
