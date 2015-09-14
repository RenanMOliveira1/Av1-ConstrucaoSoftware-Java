package com.concessionaria.view;

import com.concessionaria.enumerados.TipoVeiculo;
import com.concessionaria.view.especificacoes.Especificacoes;
import com.concessionaria.view.especificacoes.EspecificacoesCarro;
import com.concessionaria.view.especificacoes.EspecificacoesMotocicleta;


public class FabricaDeEspecificacao {
	
	public Especificacoes criarEspecificacoes(TipoVeiculo tipoVeiculo) {
		
		switch (tipoVeiculo) {
			case CARRO:
				return new EspecificacoesCarro();
			case MOTOCICLETA:
				return new EspecificacoesMotocicleta();
			default:
				return null;
		}
	}
}
