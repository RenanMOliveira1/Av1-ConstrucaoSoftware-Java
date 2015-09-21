/**
 * Copyright (c) 2015 GEC5
 * Todos os direitos reservados.
 * 
 * NÃO ALTERE OU REMOVA AS INFORMAÇÕES DE COPYRIGHT
 * OU INFORMAÇÕES CONTIDAS NESTE HEADER
 * 
 */
package com.concessionaria.admin;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import com.concessionaria.enumerados.TipoVeiculo;

/**
 * 
 * Guarda as características de um veículo (carro ou motocicleta)
 * 
 * Classe <code>Veiculo<code>.
 * 
 * @author Tiago Henrique
 * @author Yasmin Farias
 * @author Renan Oliveira
 * @version 2.0 (18/09/2015)
 *
 */
public class Veiculo {
	
	/** tipoVeiculo */
	private TipoVeiculo tipoVeiculo;
	
	/** chassi */
	private String chassi;
	
	/** preco */
	private double preco;
	
	/** especificacoes */
	protected Map<String, String> especificacoes;
	
	public Veiculo() {
		this.especificacoes = new HashMap<String, String>();
	}
	
	public Veiculo (String chassi, double preco, Map<String, String> especificacoes, TipoVeiculo tipoVeiculo) {
		setChassi(chassi);
		setPreco(preco);
		setEspecificacoes(especificacoes);
		setTipoVeiculo(tipoVeiculo);
	}

	/**
	 * Obtem estoque de TipoVeiculo.
	 * 
	 * @return tipoVeiculo
	 */
	public TipoVeiculo getTipoVeiculo() {
		return tipoVeiculo;
	}

	/**
	 * Define estoque de TipoVeiculo.
	 * 
	 * @param tipoVeiculo
	 * 				define tipoVeiculo
	 */
	public void setTipoVeiculo(TipoVeiculo tipoVeiculo) {
		this.tipoVeiculo = tipoVeiculo;
	}

	/**
	 * Obtem chassi.
	 * 
	 * @return chassi
	 */
	public String getChassi() {
		return chassi;
	}
	
	/**
	 * Define chassi.
	 * 
	 * @param chassi
	 * 				define chassi
	 */
	public void setChassi(String chassi) {
		this.chassi = chassi;
	}
	
	/**
	 * Obtem preco.
	 * 
	 * @return preco
	 */
	public double getPreco() {
		return preco;
	}

	/**
	 * Define preço.
	 * 
	 * @param preco
	 * 				define preco
	 */
	public void setPreco(double preco) {
		this.preco = preco;
	}
	
	/**
	 * Obtem especificacoes.
	 * 
	 * @return especificacoes
	 */
	public Map<String, String> getEspecificacoes() {
		return especificacoes;
	}

	/**
	 * Define especificacoes.
	 * 
	 * @param especificacoes
	 * 				define especificacoes
	 */
	public void setEspecificacoes(Map<String, String> especificacoes) {
		this.especificacoes = especificacoes;
	}
	
	/*
	 * (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((especificacoes == null) ? 0 : especificacoes.hashCode());
		return result;
	}
	
	/*
	 (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object veiculo) {
		
		if (veiculo instanceof Veiculo) {
			Veiculo obj = (Veiculo) veiculo;
			return (this.getChassi().equals(obj.getChassi()));
		}
		return false;
	}
	
	/**
	 * Se o Veiculo possir uma das especificações que esta cadastrado, retorna true. Senão, retorna false.
	 * 
	 * @param veiculo
	 * @param novasEspecificacoes
	 * @return boolean
	 */
	public boolean existeVeiculo(Veiculo veiculo, Map<String, String> novasEspecificacoes) {
		int contCampos = 0;
		
		for(Entry<String, String> especificacoes: novasEspecificacoes.entrySet()) {
			if (novasEspecificacoes.containsKey(especificacoes.getKey()) && veiculo.getEspecificacoes().containsValue(especificacoes.getValue()))
				contCampos++;
		}
		return contCampos != 0;
	}
	
	/*
	 * (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		String especificacoes = "";
		
		for (Entry<String, String> cadaEspecificacao: getEspecificacoes().entrySet()) {
			especificacoes += cadaEspecificacao.getKey() + ": " + cadaEspecificacao.getValue() + "%n";
		}
		
		return String.format("Tipo de Veículo: %s%n\nChassi: %s%nPreco: R$ %.2f%n%s", getTipoVeiculo().getNomeTipoVeiculo(), getChassi(), getPreco(), especificacoes);
	}
}
