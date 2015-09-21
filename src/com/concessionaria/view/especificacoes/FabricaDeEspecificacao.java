/**
 * Copyright (c) 2015 GEC5
 * Todos os direitos reservados.
 * 
 * NÃO ALTERE OU REMOVA AS INFORMAÇÕES DE COPYRIGHT
 * OU INFORMAÇÕES CONTIDAS NESTE HEADER
 * 
 */
package com.concessionaria.view.especificacoes;

/**
 * 
 * Classe do tipo fábrica que cria especificações carro ou moto.
 * 
 * Classe <code>FabricaEspecificacao<code>.
 * 
 * @author Tiago Henrique
 * @author Yasmin Farias
 * @author Renan Oliveira
 * @version 2.0 (18/09/2015)
 *
 */
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
