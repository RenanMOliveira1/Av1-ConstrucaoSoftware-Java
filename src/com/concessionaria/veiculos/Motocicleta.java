package com.concessionaria.veiculos;

import java.util.Scanner;


/**
 * @author Tiago
 * @author Renan Oliveira
 *
 */

public class Motocicleta extends Veiculo {
	private int cilindrada;
	private int capacidadeTanque;
	Scanner input = new Scanner(System.in);
	
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
	 * Construtor com todos os parâmentros e chamada a Super Classe Veículo
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
	 * Se Numero for Negativo, chama uma excessão.
	 */
	public void setCilindrada(int cilindrada) {
		
		if (cilindrada < 0) 
			throw new IllegalArgumentException("Não se aceita Número Negativo.");

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
	 * Se Numero for Negativo, chama uma excessão.
	 */
	
	public void setCapacidadeTanque(int capacidadeTanque) {		
		this.capacidadeTanque = capacidadeTanque;
	}
	
	public void leMoto(){
		
		System.out.println("Entre com o chassi da moto: ");
		String chassi = input.nextLine();
		if(chassi.equals(null) == false) {
			setChassi(chassi);
		} else {
			throw new IllegalArgumentException("Chassi nao deve ser nulo!");
		}
		System.out.println("Entre com a montadora da moto: ");
		String montadora = input.nextLine();
		if(montadora.equals(null) == false){
			setMontadora(montadora);
		} else {
			throw new IllegalArgumentException("Montadora nao deve ser nulo!");
		}
		System.out.println("Entre com o chassi da moto: ");
		String modelo = input.nextLine();
		if(modelo.equals(null) == false){
			setModelo(modelo);
		} else {
			throw new IllegalArgumentException("Modelo nao deve ser nulo!");
		}
		System.out.println("Entre com o tipo da moto: ");
		String tipo = input.nextLine();
		if(tipo.equals(null) == false){
			setChassi(tipo);
		} else {
			throw new IllegalArgumentException("Tipo nao deve ser nulo!");
		}
		System.out.println("Entre com o chassi da moto: ");
		String cor = input.nextLine();
		if(cor.equals(null) == false){
			setChassi(cor);
		} else {
			throw new IllegalArgumentException("Cor nao deve ser nulo!");
		}
		System.out.println("Entre com o preço da moto: ");
		Float preco = input.nextFloat();
		if(preco >= 0){
			setPreco(preco);
		} else {
			throw new IllegalArgumentException("Preço deve ser numeral e positivo");
		}
		System.out.println("Entre com a capacidade do tanque da moto: ");
		int capacidade = input.nextInt();
		if(capacidade > 0){
			setCapacidadeTanque(capacidade);
		} else {
			throw new IllegalArgumentException("Capacidade deve ser numeral e positiva");
		}
		System.out.println("Entre com a cilindrada da moto: ");
		int cilindrada = input.nextInt();
		if(cilindrada > 0){
			setCapacidadeTanque(cilindrada);
		} else {
			throw new IllegalArgumentException("Cilindrada deve ser numeral e positiva");
		}
	}
}
