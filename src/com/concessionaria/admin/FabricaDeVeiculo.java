package com.concessionaria.admin;
import com.concessionaria.veiculos.Especificacoes;
import com.concessionaria.veiculos.Veiculo;


public class FabricaDeVeiculo {

	public Veiculo criarVeiculo(Especificacoes especificacoes) {
		return new Veiculo(especificacoes);
	}
}
