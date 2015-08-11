package com.concessionaria.veiculos;

import java.util.InputMismatchException;

import com.concessionaria.administracao.auxiliares.SubOpcoesMenu.*;

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
	public void leTipoCarro()  {
		
		System.out.println("\nEntre com o tipo de carro: ");
		TipoCarro.exibirOpcoes();
		int opcaoTipo = entradaDeDado.getInputInt();
		String nomeTipoEscolhido = TipoCarro.pesquisarOpcao(opcaoTipo);
		
		if (nomeTipoEscolhido.equals(null))
			throw new IllegalArgumentException("Tipo de Carro: Opção Inválida.");
		
		setTipo(nomeTipoEscolhido);	
	}
	
	/**
	 * Método que faz a leitura de motorizacao de Carro a partir do teclado
	 */
	public void leMotorizacao()  throws InputMismatchException {
		
		System.out.println("\nEntre com a motorizacao do tanque do carro: ");
		int motorizacao = entradaDeDado.getInputInt();
		
		if(motorizacao < 0)
			throw new IllegalArgumentException("Motorização: Numero Negativo não é Aceito.");
		
		setMotorizacao(motorizacao);	
	}
	
	
	/**
	 * Método que faz a leitura de tipo de Carro a partir do teclado
	 */
	public void leCambio()  throws InputMismatchException {

		System.out.println("\nEntre com o cambio de carro: ");
		Cambio.exibirOpcoes();
		int opcaoCambio = entradaDeDado.getInputInt();
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
		
		try {
			leChassi();
			leMontadora();
			leModelo();
			leTipoCarro();
			leCor();
			lePreco();
			leMotorizacao();
			leCambio();
		} catch (InputMismatchException string) {
			System.err.println("Não se Aceita String.");
			System.exit(1);
		}
		
		
	}
}
