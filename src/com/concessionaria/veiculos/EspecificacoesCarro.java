package com.concessionaria.veiculos;
import java.util.HashMap;

public class EspecificacoesCarro extends Especificacoes {
	
	public EspecificacoesCarro() {
		this.especificacoes = new HashMap<String, String>();
	}
	
	@Override
	public void cadastrarEspecificacoes() {

		especificacoes.put("Montadora", "Toyota");
		especificacoes.put("Modelo", "Toyota Novo");
		especificacoes.put("Tipo", "Hatch");
		especificacoes.put("Cor", "Azul");
		especificacoes.put("Motorizacao", "1.0");
		especificacoes.put("Câmbio", "Automatico");
		especificacoes.put("Capacidade do Tanque", "30");
	}
}
