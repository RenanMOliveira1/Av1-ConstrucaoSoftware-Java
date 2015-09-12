package com.concessionaria.view.especificacoes;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class EspecificacoesCarro extends Especificacoes {
	
	@Override
	public Map<String, String> cadastrarEspecificacoes() {
		Scanner input = new Scanner(System.in);
		Map<String, String> especificacoes = new HashMap<String, String>();
		
		System.out.println("Entre com a Montadora: ");
		especificacoes.put("Montadora", input.next());
		
		System.out.println("Entre com o Modelo: ");
		especificacoes.put("Modelo", input.next());
		
		System.out.println("Entre com o Tipo do Carro: ");
		especificacoes.put("Tipo", input.next());
		
		System.out.println("Entre com a Motorizacao: ");
		Double motorizacao = input.nextDouble();
		especificacoes.put("Motorizacao", Double.toString(motorizacao));
		
		System.out.println("Entre com o Câmbio: ");
		especificacoes.put("Câmbio", input.next());
				
		System.out.println("Entre com a Capacidade do Tanque: ");
		Integer capTanque = input.nextInt();
		especificacoes.put("Capacidade do Tanque", Integer.toString(capTanque));
		
		return especificacoes;
	}
}
