package com.concessionaria.veiculos;

import java.util.Scanner;

/**
 * @author Tiago
 *@author Renan Oliveira
 *
 */

public class Carro extends Veiculo {
	private double motorizacao;
	private String cambio;
	Scanner input = new Scanner(System.in);
	
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
	 * Construtor com todos os parâmentros e chamada a Super Classe Veículo
	 */
	
	public Carro(String chassi, String montadora, String modelo, String tipo,
			String cor, float preco, float motolizacao, String cambio) {
		super(chassi, montadora, modelo, tipo, cor, preco);
		setMotorizacao(motolizacao);
		setCambio(cambio);
	}
	
	/**
	 * @return Retorna a Motorização
	 */
	public double getMotolizacao() {
		return motorizacao;
	}
	
	/**
	 * @param motolizacao
	 * Se Numero for Negativo, chama uma excessão.
	 */
	public void setMotorizacao(double motolizacao) {
		this.motorizacao = motolizacao;
	}
	
	/**
	 * @return Retorna o Câmbio
	 */
	public String getCambio() {
		return cambio;
	}
	
	/**
	 * @param cambio
	 * Faz a Leitura do Câmbio
	 */
	public void setCambio(String cambio) {
		this.cambio = cambio;
	}
	
	public void leCarro(){
		
		System.out.println("Entre com o chassi do carro: ");
		String chassi = input.nextLine();
		if(chassi.equals(null) == false){
			setChassi(chassi);
		} else {
			throw new IllegalArgumentException("Chassi nao deve ser nulo!");
		}
		System.out.println("Entre com a montadora do carro: ");
		String montadora = input.nextLine();
		if(montadora.equals(null) == false){
			setMontadora(montadora);
		} else {
			throw new IllegalArgumentException("Montadora nao deve ser nulo!");
		}
		System.out.println("Entre com o chassi do carro: ");
		String modelo = input.nextLine();
		if(modelo.equals(null) == false){
			setModelo(modelo);
		} else {
			throw new IllegalArgumentException("Modelo nao deve ser nulo!");
		}
		System.out.println("Entre com o tipo do carro: ");
		String tipo = input.nextLine();
		if(tipo.equals(null) == false){
			setChassi(tipo);
		} else {
			throw new IllegalArgumentException("Tipo nao deve ser nulo!");
		}
		System.out.println("Entre com o chassi do carro: ");
		String cor = input.nextLine();
		if(cor.equals(null) == false){
			setChassi(cor);
		} else {
			throw new IllegalArgumentException("Cor nao deve ser nulo!");
		}
		System.out.println("Entre com o preço do carro: ");
		Float preco = input.nextFloat();
		if(preco > 0){
			setPreco(preco);
		} else {
			throw new IllegalArgumentException("Preço deve ser numeral e positivo");
		}
		System.out.println("Entre com a motorizacao do tanque do carro: ");
		int motorizacao = input.nextInt();
		if(motorizacao > 0){
			setMotorizacao(motorizacao);
		} else {
			throw new IllegalArgumentException("Motorizacao deve ser numeral e positiva");
		}
		System.out.println("Entre com a cilindrada do carro: ");
		String cambio = input.nextLine();
		if(cambio.equals(null) == false){
			setCambio(cambio);
		} else {
			throw new IllegalArgumentException("Cambio deve ser numeral e positiva");
		}
	}
}
