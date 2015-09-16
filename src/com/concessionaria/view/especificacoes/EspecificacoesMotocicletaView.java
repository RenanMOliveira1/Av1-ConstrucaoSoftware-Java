package com.concessionaria.view.especificacoes;
import java.util.HashMap;
import java.util.Map;

import com.concessionaria.enumerados.Cilindrada;
import com.concessionaria.enumerados.Montadora;
import com.concessionaria.enumerados.TipoMotocicleta;
import com.concessionaria.view.View;

import java.util.Scanner;

public class EspecificacoesMotocicletaView extends View implements EspecificacoesView {
	
	public EspecificacoesMotocicletaView() {
		input = new Scanner(System.in);
	}
	
	@Override
	public Map<String, String> cadastrarEspecificacoes() {
		Map<String, String> especificacoes = new HashMap<String, String>();
		
		Montadora.exibirOpcoes();
		int montadora = validarOpcao("Entre com a Montadora: ", "Opção de Montadora Inválida", 1, 18);
		especificacoes.put("Montadora", Montadora.getOpcao(montadora).getNomeMontadora());
		
		System.out.println("Entre com o Modelo: ");
		especificacoes.put("Modelo", input.next());
		
		TipoMotocicleta.exibirOpcoes();
		int tipoMotocicleta = validarOpcao("Entre com o Tipo de Motocicleta: ", "Tipo de Motocicleta Inválido", 1, 15);
		especificacoes.put("Tipo de Motocicleta", TipoMotocicleta.getOpcao(tipoMotocicleta).getNomeTipoMotocicleta());
		
		Double motorizacao = validarCampoDouble("Entre com a Motorizacao: ", "Motorizacao: Dados Inválidos.");
		especificacoes.put("Motorizacao", Double.toString(motorizacao));
		
		Cilindrada.exibirOpcoes();
		int cilindradas = validarOpcao("Entre com a Cilindrada: ", "Opção de Cilindrada Inválida", 1, 9);
		especificacoes.put("Cilindrada", Integer.toString(Cilindrada.getOpcao(cilindradas).getNumCilindradas()));
		
		Integer capacidadeTanque = validarCampoInteiro("Entre com a Capacidade do Tanque: ","Capacidade do Tanque: Inválido.");
		especificacoes.put("Capacidade do Tanque", Integer.toString(capacidadeTanque));
		
		return especificacoes;
	}
}
