package com.concessionaria.veiculos;

/**
 * @author Tiago
 *
 */

public class Carro extends Veiculo {
	private double motolizacao;
	private String cambio;
	
	public Carro() {
	}
	
	/**
	 * @param chassi
	 * @param montadora
	 * @param modelo
	 * @param tipo
	 * @param cor
	 * @param preco
	 * @param motolizacao
	 * @param cambio
	 * 
	 * Construtor com todos os par�mentros e chamada a Super Classe Ve�culo
	 */
	
	public Carro(String chassi, String montadora, String modelo, String tipo,
			String cor, float preco, float motolizacao, String cambio) {
		super(chassi, montadora, modelo, tipo, cor, preco);
		setMotolizacao(motolizacao);
		setCambio(cambio);
	}
	
	/**
	 * @return Retorna a Motoriza��o
	 */
	public double getMotolizacao() {
		return motolizacao;
	}
	
	/**
	 * @param motolizacao
	 * Se Numero for Negativo, chama uma excess�o.
	 */
	public void setMotolizacao(double motolizacao) {
		
		if (motolizacao < 0)
			throw new IllegalArgumentException("N�o se aceita N�mero Negativo.");
		
		this.motolizacao = motolizacao;
	}
	
	/**
	 * @return Retorna o C�mbio
	 */
	public String getCambio() {
		return cambio;
	}
	
	/**
	 * @param cambio
	 * Faz a Leitura do C�mbio
	 */
	public void setCambio(String cambio) {
		this.cambio = cambio;
	}
	
	
}
