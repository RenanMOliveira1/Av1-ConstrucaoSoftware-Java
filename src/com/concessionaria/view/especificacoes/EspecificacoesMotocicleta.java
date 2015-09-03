package com.concessionaria.view.especificacoes;
import java.util.HashMap;
import java.util.Map;

public class EspecificacoesMotocicleta implements Especificavel {
	
	@Override
	public Map<String, String> cadastrarEspecificacoes() {
		
		Map<String, String> especificacoes = new HashMap<String, String>();
		
		especificacoes.put("Montadora", "Honda");
		especificacoes.put("Modelo", "Honda Novo");
		especificacoes.put("Tipo", "Motocicleta");
		especificacoes.put("Cor", "Vermelho");
		especificacoes.put("Motorizacao", "3.0");
		especificacoes.put("Cilindrada", "Automatico");
		especificacoes.put("Capacidade do Tanque", "30");
		
		return especificacoes;
	}
}
