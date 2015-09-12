package com.concessionaria.enumerados;

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
	
	public String nomeCor() {
		return nomeCor;
	}
	
	public static Cor getOpcao(int opcao) {
		
		for (Cor c : values()) {
			if (opcao == c.getNumOpcao()) 
				return c;
		}
		
		return null;
	}
	
}
