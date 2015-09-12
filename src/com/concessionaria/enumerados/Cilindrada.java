package com.concessionaria.enumerados;

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
	 * Construtor com todos os parâmentros
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
}
