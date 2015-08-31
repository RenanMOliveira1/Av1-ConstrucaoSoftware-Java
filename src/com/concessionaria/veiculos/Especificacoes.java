package com.concessionaria.veiculos;
import java.util.Map;

/**
 * @author Tiago
 *
 */
public abstract class Especificacoes {
	protected Map<String, String> especificacoes;

	public abstract void cadastrarEspecificacoes();
	
	public Map<String, String> getEspecificacoes() {
		return especificacoes;
	}
}
