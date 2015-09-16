package com.concessionaria.view;

import com.concessionaria.enumerados.TipoVeiculo;
import com.concessionaria.view.especificacoes.EspecificacoesView;
import com.concessionaria.view.especificacoes.EspecificacoesCarroView;
import com.concessionaria.view.especificacoes.EspecificacoesMotocicletaView;


public class FabricaDeEspecificacao {
	
	public EspecificacoesView criarEspecificacoes(TipoVeiculo tipoVeiculo) {
		
		switch (tipoVeiculo) {
			case CARRO:
				return new EspecificacoesCarroView();
			case MOTOCICLETA:
				return new EspecificacoesMotocicletaView();
			default:
				return null;
		}
	}
}
