package com.concessionaria.enumerados;

public enum TipoVeiculo {
	CARRO(1, "Carro"), MOTOCICLETA(2, "Motocicleta");
	
	private String nomeVeiculo;
	private int numOpcao;
	
	private TipoVeiculo(int numOpcao, String nomeVeiculo) {
		this.nomeVeiculo = nomeVeiculo;
		this.numOpcao = numOpcao;
	}
	
	public String getNomeTipoVeiculo() {
		return nomeVeiculo;
	}
	
	public int getNumOpcao() {
		return numOpcao;
	} 
	
	public static TipoVeiculo getOpcao(int opcao) {
		
		for (TipoVeiculo c : values()) {
			if (opcao == c.getNumOpcao()) 
				return c;
		}
		
		return null;
	}
	
	public static void exibirOpcoes() {
		
		System.out.println();
		for (TipoVeiculo tipoVeiculo : TipoVeiculo.values()) {
			System.out.println("*Digite " + tipoVeiculo.getNumOpcao() + " para escolher " + tipoVeiculo.getNomeTipoVeiculo());
		}
		System.out.println();
	}
}
