/**
 * Copyright (c) 2015 GEC5
 * Todos os direitos reservados.
 * 
 * N�O ALTERE OU REMOVA AS INFORMA��ES DE COPYRIGHT
 * OU INFORMA��ES CONTIDAS NESTE HEADER
 * 
 */
package com.concessionaria.enumerados;

/**
 * 
 * Guarda todos os tipos poss�veis de cilindrada para um veiculo
 * 
 * enum <code>Cilindrada<code>.
 * 
 * @author Tiago Henrique
 * @author Yasmin Farias
 * @author Renan Oliveira
 * @version 2.0 (18/09/2015)
 *
 */
public enum Cilindrada {
	CEM(1, 100),
	CENTO_E_CINQUENTA(2, 150),
	DUZENTOS_E_CINQUENTA(3, 250),
	TREZENTAS(4, 300),
	QUATROCENTAS(5, 400),
	QUINHENTAS(6, 500),
	SEISCENTAS(7, 600),
	SETECENTOS_E_CINQUENTA(8, 750),
	MIL(9, 1000);
	
	private int numOpcao;
	private int numCilindradas;
	
	/**
	 * @param numOpcao
	 * @param numCilindradas
	 * 
	 * Construtor com todos os par�mentros
	 */
	private Cilindrada(int numOpcao, int numCilindradas) {
		this.numOpcao = numOpcao;
		this.numCilindradas = numCilindradas;
	}
	
	/**
	 * @return Retorna o numero da opcao
	 */
	public int getNumOpcao() {
		return numOpcao;
	}
	
	/**
	 * @return Retorna o numero das cilindradas
	 */
	public int getNumCilindradas() {
		return numCilindradas;
	}
	
	public static Cilindrada getOpcao(int opcao) {
		
		for (Cilindrada c : values()) {
			if (opcao == c.getNumOpcao()) 
				return c;
		}
		
		return null;
	}
	
	public static void exibirOpcoes() {
		
		System.out.println();
		for (Cilindrada cilindrada : Cilindrada.values()) {
			System.out.println("*Digite " + cilindrada.getNumOpcao() + " para escolher " + cilindrada.getNumCilindradas());
		}
		System.out.println();
	}
}
