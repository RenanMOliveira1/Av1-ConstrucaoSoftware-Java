package com.concessionaria.veiculos;

public enum TipoVeiculo {
	Carro("Carro"), Motocicleta("Motocicleta");
	
	String nomeVeiculo;
	
	private TipoVeiculo(String nomeVeiculo) {
		this.nomeVeiculo = nomeVeiculo;
	}
	
	public String getNomeVeiculo() {
		return nomeVeiculo;
	}
}
