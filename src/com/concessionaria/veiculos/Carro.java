package com.concessionaria.veiculos;

import java.util.Scanner;

import com.concessionaria.adminstracao.Enum.*;

/**
 * @author Tiago
 *@author Renan Oliveira
 *@author Yasmin
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
	public double getMotorizacao() {
		return motorizacao;
	}
	
	/**
	 * @param motolizacao
	 */
	public void setMotorizacao(double motorizacao) {
		this.motorizacao = motorizacao;
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
	
	/**
	 * Método que faz a leitura de tipo de Carro a partir do teclado
	 */
	public void leTipoCarro() {
		String nomeTipoEscolhido = null;
		
		
		System.out.println("\nEntre com o tipo de carro: ");
		TipoCarro.exibirOpcoes();
		int opcaoTipo = input.nextInt();
		
		/**
		 * Percorre todos os valores de TipoCarro e recebe seus valores em "tipoCarro" na ordem
		 * Assim, verifica se o valor da opcao inputada confere com cada opcao de "tipoCarro"
		 */
		for (TipoCarro tipoCarro : TipoCarro.values()) {
			if(opcaoTipo == tipoCarro.getNumOpcao())
				nomeTipoEscolhido = tipoCarro.getNomeTipo();	
		} 
		
		if (!nomeTipoEscolhido.equals(null))
			setTipo(nomeTipoEscolhido);
		else 
			throw new IllegalArgumentException("Opcao nao valida!");
	}
	
	
	/**
	 * Método que faz a leitura de motorizacao de Carro a partir do teclado
	 */
	public void leMotorizacao() throws IllegalArgumentException {
		
		System.out.println("\nEntre com a motorizacao do tanque do carro: ");
		int motorizacao = input.nextInt();
		
		if(motorizacao > 0)
			setMotorizacao(motorizacao);
		else
			throw new IllegalArgumentException("Motorizacao deve ser numeral e positiva");
	}
	
	
	/**
	 * Método que faz a leitura de tipo de Carro a partir do teclado
	 */
	public void leCambio() {
		String cambioEscolhido = null;
		
		System.out.println("\nEntre com o cambio de carro: ");
		Cambio.exibirOpcoes();
		int opcaoCambio = input.nextInt();
		
		/**
		 * Percorre todos os valores de Cambio e recebe seus valores em "cambio" na ordem
		 * Assim, verifica se o valor da opcao inputada confere com cada opcao de "cambio"
		 */
		for (Cambio cambio : Cambio.values()) {
			if(opcaoCambio == cambio.getNumOpcao())
				cambioEscolhido = cambio.getNomeCambio();	
		} 
		
		if (!cambioEscolhido.equals(null))
			setCambio(cambioEscolhido);
		else 
			throw new IllegalArgumentException("Opcao nao valida!");
	}
	
	
	/**
	 * @see leChassi()
	 * @see leMontadora()
	 * @see leModelo()
	 * @see leCor()
	 * @see lePreco()
	 * 
	 * Métodos da classe abstrata Veiculo
	 */
	public void leCarro(){
		
		System.out.println("********Entre com caracteristicas para o seu carro********");
		leChassi();
		leMontadora();
		leModelo();
		leTipoCarro();
		leCor();
		lePreco();
		leMotorizacao();
		leCambio();
		
	}
}
