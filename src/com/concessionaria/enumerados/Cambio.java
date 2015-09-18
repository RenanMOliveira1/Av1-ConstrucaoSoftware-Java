package com.concessionaria.enumerados;

public enum Cambio {
	CVT(1, "CVT"),
	AUTOMATICO(2, "Automático"),
	MANUAL_COMUM(3, "Manual Comum"),
	AUTOMATIZADO(4, "Automatizado");
	
	private int numOpcao;
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
	 * @return Retorna o numero da opcao
	 */
	public int getNumOpcao() {
		return numOpcao;
	}
	
	/**
	 * @return Retorna o nome do cambio
	 */
	public String getNomeCambio() {
		return nomeCambio;
	}
	
	public static Cambio getOpcao(int opcao) {
		
		for (Cambio c : values()) {
			if (opcao == c.getNumOpcao()) 
				return c;
		}
		
		return null;
	}
	
	public static void exibirOpcoes() {
		
		System.out.println();
		for (Cambio cambio : Cambio.values()) {
			System.out.println("*Digite " + cambio.getNumOpcao() + " para escolher " + cambio.getNomeCambio());
		}
		System.out.println();
	}
	
}
