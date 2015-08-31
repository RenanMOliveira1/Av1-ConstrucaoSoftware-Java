package com.concessionaria.veiculos;
import java.util.HashMap;

public class EspecificacoesMotocicleta extends Especificacoes {
	
	public EspecificacoesMotocicleta() {
		this.especificacoes = new HashMap<String, String>();
	}
	
	@Override
	public void cadastrarEspecificacoes() {
		
		especificacoes.put("Montadora", "Honda");
		especificacoes.put("Modelo", "Honda Novo");
		especificacoes.put("Tipo", "Motocicleta");
		especificacoes.put("Cor", "Vermelho");
		especificacoes.put("Motorizacao", "3.0");
		especificacoes.put("Cilindrada", "Automatico");
		especificacoes.put("Capacidade do Tanque", "30");
	}
}
