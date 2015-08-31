package com.concessionaria.veiculos;
import java.util.Map;
import java.util.Map.Entry;


public class Veiculo {
	public enum TipoVeiculo{CARRO, MOTO}
	
	private String chassi;
	private double preco;
	private Especificacoes especificacoes;
	
	public Veiculo(Especificacoes especificacoes) {
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
		return this.especificacoes.getEspecificacoes();
	}

	public void setEspecificacoes(Especificacoes especificacoes) {
		this.especificacoes = especificacoes;
	}

	public Veiculo cadastrarVeiculo() {
		
		setChassi("111");
		setPreco(100.00);
		especificacoes.cadastrarEspecificacoes();
		
		return this;
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
		String especificacoes = "\n";
		
		for (Entry<String, String> cadaEspecificacao: getEspecificacoes().entrySet()) {
			especificacoes += cadaEspecificacao.getKey() + ": " + cadaEspecificacao.getValue() + "\n";
		}
		
		return String.format("Chassi: %s%nPreco: R$ %.2f%s", getChassi(), getPreco(), especificacoes);
	}
}
