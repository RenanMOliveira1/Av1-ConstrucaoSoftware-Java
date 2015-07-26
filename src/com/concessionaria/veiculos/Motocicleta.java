package com.concessionaria.veiculos;

/**
 * @author Tiago
 *
 */

public class Motocicleta extends Veiculo {
	private int cilindrada;
	private int capacidadeTanque;
	
	public Motocicleta() {
	}
	
	/**
	 * @param chassi
	 * @param montadora
	 * @param modelo
	 * @param tipo
	 * @param cor
	 * @param preco
	 * @param CapacidadedeTanque
	 * @param cilindrada
	 * 
	 * Construtor com todos os par�mentros e chamada a Super Classe Ve�culo
	 */
	public Motocicleta(String chassi, String montadora, String modelo,
			String tipo, String cor, float preco, int CapacidadedeTanque, int cilindrada) {
		
		super(chassi, montadora, modelo, tipo, cor, preco);
		
		setCapacidadeTanque(capacidadeTanque);
		setCilindrada(cilindrada);
	}
	
	/**
	 * @return Retorna o numero de Cilindrada
	 */
	public int getCilindrada() {
		return cilindrada;
	}
	
	/**
	 * @param cilindrada
	 * Se Numero for Negativo, chama uma excess�o.
	 */
	public void setCilindrada(int cilindrada) {
		
		if (cilindrada < 0) 
			throw new IllegalArgumentException("N�o se aceita N�mero Negativo.");

		this.cilindrada = cilindrada;
	}
	
	/**
	 * @return Retorna a Capacidade de Tanque
	 */
	
	public int getCapacidadeTanque() {
		return capacidadeTanque;
	}
	
	/**
	 * @param capacidadeTanque
	 * Se Numero for Negativo, chama uma excess�o.
	 */
	
	public void setCapacidadeTanque(int capacidadeTanque) {
		
		if (capacidadeTanque < 0)
			throw new IllegalArgumentException("N�o se aceita N�mero Negativo.");
		
		this.capacidadeTanque = capacidadeTanque;
	}
	
	
	
}
