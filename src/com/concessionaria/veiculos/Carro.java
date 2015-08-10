package com.concessionaria.veiculos;

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
	
	public Carro() {
	}
	
	public Carro(String chassi, String montadora, String modelo, String tipo,
			String cor, float preco, float motolizacao, String cambio) {
		super(chassi, montadora, modelo, tipo, cor, preco);
		setMotorizacao(motolizacao);
		setCambio(cambio);
	}
	
	public double getMotorizacao() {
		return motorizacao;
	}
	
	public void setMotorizacao(double motorizacao) {
		this.motorizacao = motorizacao;
	}
	
	public String getCambio() {
		return cambio;
	}
	
	public void setCambio(String cambio) {
		this.cambio = cambio;
	}
	
	/**
	 * Método que faz a leitura de tipo de Carro a partir do teclado
	 */
	public void leTipoCarro() {
		
		System.out.println("\nEntre com o tipo de carro: ");
		TipoCarro.exibirOpcoes();
		int opcaoTipo = input.nextInt();
		String nomeTipoEscolhido = TipoCarro.pesquisarOpcao(opcaoTipo);
		
		if (nomeTipoEscolhido.equals(null))
			throw new IllegalArgumentException("Tipo de Carro: Opção Inválida.");
		
		setTipo(nomeTipoEscolhido);	
	}
	
	/**
	 * Método que faz a leitura de motorizacao de Carro a partir do teclado
	 */
	public void leMotorizacao() {
		
		System.out.println("\nEntre com a motorizacao do tanque do carro: ");
		int motorizacao = input.nextInt();
		
		if(motorizacao < 0)
			throw new IllegalArgumentException("Motorização: Numero Negativo não é Aceito.");
		
		setMotorizacao(motorizacao);	
	}
	
	
	/**
	 * Método que faz a leitura de tipo de Carro a partir do teclado
	 */
	public void leCambio() {

		System.out.println("\nEntre com o cambio de carro: ");
		Cambio.exibirOpcoes();
		int opcaoCambio = input.nextInt();
		String cambioEscolhido = Cambio.pesquisarOpcao(opcaoCambio);
		
		if (cambioEscolhido.equals(null))
			throw new IllegalArgumentException("Cambio: Opção Inválida.");
		
		setCambio(cambioEscolhido);
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
