package com.concessionaria.view.especificacoes;

import com.concessionaria.enumerados.TipoVeiculo;


public class FabricaDeEspecificacao {
	
	public ViewEspecificacoes criarEspecificacoes(TipoVeiculo tipoVeiculo) {
		
		switch (tipoVeiculo) {
			case CARRO:
				return new ViewEspecificacoesCarro();
			case MOTOCICLETA:
				return new ViewEspecificacoesMotocicleta();
			default:
				return null;
		}
	}
}
