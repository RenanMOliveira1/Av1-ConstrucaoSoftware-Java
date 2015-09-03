package com.concessionaria.view;

import com.concessionaria.veiculos.TipoVeiculo;
import com.concessionaria.view.especificacoes.Especificavel;
import com.concessionaria.view.especificacoes.EspecificacoesCarro;
import com.concessionaria.view.especificacoes.EspecificacoesMotocicleta;


public class FabricaDeEspecificacao {
	
	public Especificavel criarEspecificacoes(TipoVeiculo tipoVeiculo) {
		
		switch (tipoVeiculo) {
			case Carro:
				return new EspecificacoesCarro();
			case Motocicleta:
				return new EspecificacoesMotocicleta();
			default:
				return null;
		}
	}
}
