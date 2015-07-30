 package com.concessionaria.veiculos;
 
 import java.util.Scanner;

import com.concessionaria.adminstracao.Enum.*;

/**
 * 
 * @author Yasmin
 * @author Tiago
 *
 */

public abstract class Veiculo {
	Scanner input = new Scanner(System.in);
	
	protected String chassi;
	protected String montadora;
	protected String modelo;
	protected String tipo;
	protected String cor;
	protected float preco;
	
	
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
	
	/**
	 * Método que faz a leitura do chassi de um veiculo a partir do teclado
	 */
	public void leChassi() {
		System.out.println("Entre com o chassi: ");
		
		String chassi = input.nextLine();
		
		if(chassi.equals(null) == false)
			setChassi(chassi);
		else 
			throw new IllegalArgumentException("Chassi nao deve ser nulo!");
	}
	
	/**
	 * Método que faz a leitura de montadora de um veiculo a partir do teclado
	 */
	public void leMontadora() {
		
		String nomeMontadoraEscolhido = null;
		
		System.out.println("Entre com a montadora: ");
		
		/**
		 * Percorre todos os valores de Montadora e recebe seus valores em "montadora" na ordem, imprimindo as opcoes
		 */
		for (Montadora montadora : Montadora.values()) {
			System.out.println("*Digite " + montadora.getNumOpcao() + " para escolher " + montadora.getNomeMontadora());
		}
		
		int opcaoMontadora = input.nextInt();
		
		/**
		 * Percorre todos os valores de Montadora e recebe seus valores em "montadora" na ordem
		 * Assim, verifica se o valor da opcao inputada confere com cada opcao de "montadora"
		 */
		for (Montadora montadora : Montadora.values()) {
			if(opcaoMontadora == montadora.getNumOpcao())
				nomeMontadoraEscolhido = montadora.getNomeMontadora();	
		} 
		
		if (nomeMontadoraEscolhido.equals(null) == false)
			setMontadora(nomeMontadoraEscolhido);
		else 
			throw new IllegalArgumentException("Opcao nao valida!");
		
	}
	
	/**
	 * Método que faz a leitura de modelo de um veiculo a partir do teclado
	 */
	public void leModelo() {
		System.out.println("Entre com o modelo: ");
		
		String modelo = input.next();
		
		if(modelo.equals(null) == false)
			setModelo(modelo);
		else 
			throw new IllegalArgumentException("Modelo nao deve ser nulo!");
	}
	
	/**
	 * Método que faz a leitura de cor de um veiculo a partir do teclado
	 */
	public void leCor() {
		
		String corEscolhida = null;
		
		System.out.println("Entre com a cor: ");
		
		/**
		 * Percorre todos os valores de Cor e recebe seus valores em "cor" na ordem, imprimindo as opcoes
		 */
		for (Cor cor : Cor.values()) {
			System.out.println("*Digite " + cor.getNumOpcao() + " para escolher " + cor.getNomeCor());
		}
		
		int opcaoCor = input.nextInt();
		
		/**
		 * Percorre todos os valores de Cor e recebe seus valores em "cor" na ordem
		 * Assim, verifica se o valor da opcao inputada confere com cada opcao de "cor"
		 */
		for (Cor cor : Cor.values()) {
			if(opcaoCor == cor.getNumOpcao())
				corEscolhida = cor.getNomeCor();	
		} 
		
		if (corEscolhida.equals(null) == false) 
			setCor(corEscolhida);
		
		else 
			throw new IllegalArgumentException("Opcao nao valida!");
		
	}
	
	/**
	 * Método que faz a leitura de capacidade de tanque de Motocicleta a partir do teclado
	 */
	public void lePreco() {
		
		System.out.println("Entre com o preço: ");
		
		Float preco = input.nextFloat();
		
		if(preco > 0)
			setPreco(preco);
		else 
			throw new IllegalArgumentException("Preço deve ser numeral e positivo");
	}
}