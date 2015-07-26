package com.concessionaria.veiculos;

/**
 * @author Tiago
 *
 */

public abstract class Veiculo {
	private String chassi;
	private String montadora;
	private String modelo;
	private String tipo;
	private String cor;
	private float preco;
	
	
	public Veiculo () {
		
	}
	
	/**
	 * @param chassi
	 * @param montadora
	 * @param modelo
	 * @param tipo
	 * @param cor
	 * @param preco
	 * 
	 * Construtor com todos os parâmentros
	 */
	
	public Veiculo(String chassi, String montadora, String modelo, String tipo, String cor, float preco) {
		setChassi(chassi);
		setMontadora(montadora);
		setModelo(modelo);
		setTipo(tipo);
		setCor(cor);
		setPreco(preco);
	}
	
	
	/**
	 * @return Retorna o Chassi do Carro
	 */
	public String getChassi() {
		return chassi;
	}
	
	/**
	 * @param chassi
	 */
	public void setChassi(String chassi) {
		this.chassi = chassi;
	}
	
	/**
	 * @return Retorna a Montadora 
	 */
	public String getMontadora() {
		return montadora;
	}
	
	/**
	 * @param montadora
	 */
	public void setMontadora(String montadora) {
		this.montadora = montadora;
	}
	
	/**
	 * @return Retorna o Modelo
	 */
	public String getModelo() {
		return modelo;
	}
	
	/**
	 * @param modelo
	 */
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	
	/**
	 * @return Retorna o Tipo do Veículo
	 */
	public String getTipo() {
		return tipo;
	}
	
	/**
	 * @param tipo
	 */
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	
	/**
	 * @return Retorna a Cor
	 */
	public String getCor() {
		return cor;
	}
	
	/**
	 * @param cor
	 */
	public void setCor(String cor) {
		this.cor = cor;
	}
	
	/**
	 * @return Retorna o Preço
	 */
	public float getPreco() {
		return preco;
	}
	
	/**
	 * @param preco
	 * 
	 * faz setPreco just quando preco é igual ou maior que zero (não é negativo)
	 */
	public void setPreco(float preco) {
		
		if (preco < 0)
			throw new IllegalArgumentException("Não se aceita Número Negativo.");
		this.preco = preco;
	}
	
}
