package com.concessionaria.view.especificacoes;
import java.util.HashMap;
import java.util.Map;

public class EspecificacoesCarro implements Especificavel {
	
	@Override
	public Map<String, String> cadastrarEspecificacoes() {
		
		Map<String, String> especificacoes = new HashMap<String, String>();
		
		especificacoes.put("Montadora", "Toyota");
		especificacoes.put("Modelo", "Toyota Novo");
		especificacoes.put("Tipo", "Hatch");
		especificacoes.put("Cor", "Azul");
		especificacoes.put("Motorizacao", "1.0");
		especificacoes.put("Câmbio", "Automatico");
		especificacoes.put("Capacidade do Tanque", "30");
		
		return especificacoes;
	}
}
