package com.concessionaria.view.especificacoes;
import java.util.HashMap;
import java.util.Map;

import com.concessionaria.enumerados.Cilindrada;
import com.concessionaria.enumerados.Cor;
import com.concessionaria.enumerados.Montadora;
import com.concessionaria.enumerados.TipoMotocicleta;
import com.concessionaria.view.View;

import java.util.Scanner;

public class ViewEspecificacoesMotocicleta extends View implements ViewEspecificacoes {
	
	public ViewEspecificacoesMotocicleta() {
		input = new Scanner(System.in);
	}
	
	@Override
	public Map<String, String> cadastrarEspecificacoes() {
		Map<String, String> especificacoes = new HashMap<String, String>();
		
		Montadora.exibirOpcoes();
		int montadora = validarOpcao("Entre com a Montadora: ", "Op��o de Montadora Inv�lida", 1, Montadora.values().length);
		especificacoes.put("Montadora", Montadora.getOpcao(montadora).getNomeMontadora());
		
		Cor.exibirOpcoes();
		int cor = validarOpcao("Entre com a Cor: ", "Op��o de Cor Inv�lida", 1, Cor.values().length);
		especificacoes.put("Cor", Cor.getOpcao(cor).getNomeCor());
		
		especificacoes.put("Modelo", validarCampoString("Entre com o Modelo: ", "Modelo: Dados Inv�lidos."));
		
		TipoMotocicleta.exibirOpcoes();
		int tipoMotocicleta = validarOpcao("Entre com o Tipo de Motocicleta: ", "Tipo de Motocicleta Inv�lido", 1, TipoMotocicleta.values().length);
		especificacoes.put("Tipo de Motocicleta", TipoMotocicleta.getOpcao(tipoMotocicleta).getNomeTipoMotocicleta());
		
		Double motorizacao = validarCampoDouble("Entre com a Motorizacao: ", "Motorizacao: Dados Inv�lidos.");
		especificacoes.put("Motorizacao", Double.toString(motorizacao));
		
		Cilindrada.exibirOpcoes();
		int cilindradas = validarOpcao("Entre com a Cilindrada: ", "Op��o de Cilindrada Inv�lida", 1, Cilindrada.values().length);
		especificacoes.put("Cilindrada", Integer.toString(Cilindrada.getOpcao(cilindradas).getNumCilindradas()));
		
		Integer capacidadeTanque = validarCampoInteiro("Entre com a Capacidade do Tanque: ","Capacidade do Tanque: Inv�lido.");
		especificacoes.put("Capacidade do Tanque", Integer.toString(capacidadeTanque));
		
		return especificacoes;
	}
}
