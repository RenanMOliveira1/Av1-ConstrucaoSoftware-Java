package com.concessionaria.veiculos;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import com.concessionaria.view.especificacoes.Especificavel;


public class Veiculo {

	private String chassi;
	private double preco;
	protected Map<String, String> especificacoes;
	
	public Veiculo() {
		this.especificacoes = new HashMap<String, String>();
	}
	
	public Veiculo (String chassi, double preco, Map<String, String> especificacoes) {
		setChassi(chassi);
		setPreco(preco);
		setEspecificacoes(especificacoes);
	}
	
	public String getChassi() {
		return chassi;
	}
	
	public void setChassi(String chassi) {
		this.chassi = chassi;
	}
	
	public double getPreco() {
		return preco;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}
	
	public Map<String, String> getEspecificacoes() {
		return especificacoes;
	}

	public void setEspecificacoes(Map<String, String> especificacoes) {
		this.especificacoes = especificacoes;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((especificacoes == null) ? 0 : especificacoes.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object veiculo) {
		
		if (veiculo instanceof Veiculo) {
			Veiculo obj = (Veiculo) veiculo;
			return (this.getChassi().equals(obj.getChassi()));
		}
		return false;
	}	
	
	@Override
	public String toString() {
		String especificacoes = "";
		
		for (Entry<String, String> cadaEspecificacao: getEspecificacoes().entrySet()) {
			especificacoes += cadaEspecificacao.getKey() + ": " + cadaEspecificacao.getValue() + "\n";
		}
		
		return String.format("Chassi: %s%nPreco: R$ %.2f\n%s", getChassi(), getPreco(), especificacoes);
	}
}
