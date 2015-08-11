 package com.concessionaria.veiculos;
 
 import java.util.InputMismatchException;
import java.util.Scanner;

import com.concessionaria.administracao.auxiliares.EntradaDeDados;
import com.concessionaria.administracao.auxiliares.Tela;
import com.concessionaria.administracao.auxiliares.SubOpcoesMenu.*;

/**
 * 
 * @author Yasmin
 * @author Tiago
 *
 */

public abstract class Veiculo {
	protected String chassi;
	protected String montadora;
	protected String modelo;
	protected String tipo;
	protected String cor;
	protected double preco;
	protected Scanner input;
	protected Tela tela;
	protected EntradaDeDados entradaDeDado;
	
	public Veiculo () {
		tela = new Tela();
		entradaDeDado = new EntradaDeDados();
	}
	
	public String getChassi() {
		return chassi;
	}
	
	public void setChassi(String chassi) {
		this.chassi = chassi;
	}
	
	public String getMontadora() {
		return montadora;
	}
	
	public void setMontadora(String montadora) {
		this.montadora = montadora;
	}
	
	public String getModelo() {
		return modelo;
	}
	
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	
	public String getTipo() {
		return tipo;
	}
	
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	
	public String getCor() {
		return cor;
	}
	
	public void setCor(String cor) {
		this.cor = cor;
	}
	
	public double getPreco() {
		return preco;
	}
	
	public void setPreco(double preco) {
		this.preco = preco;
	}
	
	/**
	 * Método que faz a leitura do chassi de um veiculo a partir do teclado
	 */
	public void leChassi() {
		System.out.println("\nEntre com o chassi: ");
		
		String chassi = entradaDeDado.getInputString();
		
		if(chassi.equals(null) == false)
			setChassi(chassi);
		else 
			throw new IllegalArgumentException("Chassi nao deve ser nulo!");
	}
	
	/**
	 * Método que faz a leitura de montadora de um veiculo a partir do teclado
	 */
	public void leMontadora() throws InputMismatchException {

		System.out.println("\nEntre com a montadora: ");
		Montadora.exibirOpcoes();
		int opcaoMontadora = entradaDeDado.getInputInt();
		String nomeMontadoraEscolhido = Montadora.pesquisarOpcao(opcaoMontadora);
		
		if (nomeMontadoraEscolhido.equals(null))
			throw new IllegalArgumentException("Montadora: Opção Inválida.");
		
		setMontadora(nomeMontadoraEscolhido);	
	}
	
	/**
	 * Método que faz a leitura de modelo de um veiculo a partir do teclado
	 */
	public void leModelo() {
		System.out.println("Entre com o modelo: ");
		String modelo = entradaDeDado.getInput();
		
		if(modelo.equals(null))
			throw new IllegalArgumentException("Modelo: Opção Inválida.");
		
		setModelo(modelo);	
	}
	
	/**
	 * Método que faz a leitura de cor de um veiculo a partir do teclado
	 */
	public void leCor() throws InputMismatchException {

		System.out.println("Entre com a cor: ");
		Cor.exibirOpcoes();
		int opcaoCor = entradaDeDado.getInputInt();
		String corEscolhida = Cor.pesquisarOpcao(opcaoCor);
		
		if (corEscolhida.equals(null)) 
			throw new IllegalArgumentException("Cor: Opção Inválida.");
		
		setCor(corEscolhida);
		
	}
	
	/**
	 * Método que faz a leitura de capacidade de tanque de Motocicleta a partir do teclado
	 */
	public void lePreco()  throws InputMismatchException {
		
		System.out.println("Entre com o preço: ");
		double preco = entradaDeDado.getInputDouble();
		
		if(preco < 0)
			throw new IllegalArgumentException("Preço: Numero Negativo não é Aceito.");
		
		setPreco(preco);
	}
}