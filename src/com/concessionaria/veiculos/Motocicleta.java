package com.concessionaria.veiculos;

import java.util.InputMismatchException;

import com.concessionaria.administracao.auxiliares.SubOpcoesMenu.*;

/**
 * @author Tiago
 * @author Renan Oliveira
 * @author Yasmin
 *
 */

public class Motocicleta extends Veiculo {
	private int cilindrada;
	private int capacidaDeTanque;
	
	public Motocicleta() {
	}
	
	public int getCilindrada() {
		return cilindrada;
	}
	
	public void setCilindrada(int cilindrada) {
		this.cilindrada = cilindrada;
	}
	
	public int getCapacidaDeTanque() {
		return capacidaDeTanque;
	}
	
	public void setCapacidaDeTanque(int capacidadeTanque) {		
		this.capacidaDeTanque = capacidadeTanque;
	}
	
	/**
	 * Método que faz a leitura de tipo de Motocicleta a partir do teclado
	 */
	public void leTipoMoto()  throws InputMismatchException {

		System.out.println("Entre com o tipo de moto: ");
		TipoMoto.exibirOpcoes();
		int opcaoTipo = entradaDeDado.getInputInt();
		String nomeTipoEscolhido = TipoMoto.pesquisarOpcao(opcaoTipo);
		
		if (nomeTipoEscolhido.equals(null))
			throw new IllegalArgumentException("Tipo de Moto: Opção Inválida.");
		
		setTipo(nomeTipoEscolhido);	
	}
	
	/**
	 * Método que faz a leitura da cilindrada de Motocicleta a partir do teclado
	 */
	public void leCilindrada()  throws InputMismatchException {
		
		System.out.println("Entre com a cilindrada da moto: ");
		Cilindrada.exibirOpcoes();
		int opcaoCilindrada = entradaDeDado.getInputInt();
		int cilindradaEscolhida = Cilindrada.pesquisarOpcao(opcaoCilindrada);
		
		if (cilindradaEscolhida <= 0)
			throw new IllegalArgumentException("Cilindrada: Opção Inválida.");
		
		setCilindrada(cilindradaEscolhida);
	}
	
	/**
	 * Método que faz a leitura de capacidade de tanque de Motocicleta a partir do teclado
	 */
	public void leCapacidadeDeTanque()  throws InputMismatchException {
		
		System.out.println("Entre com a capacidade do tanque da moto: ");
		int capacidade = entradaDeDado.getInputInt();
		
		if(capacidade < 0)
			throw new IllegalArgumentException("Capacidade De Tanque: Numero Negativo não é Aceito.");
		
		setCapacidaDeTanque(capacidade);
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
	public void leMoto(){
		
		System.out.println("********Entre com caracteristicas para a sua moto********");

		leChassi();
		leMontadora();
		leModelo();
		leTipoMoto();
		leCor();
		lePreco();
		leCapacidadeDeTanque();
		leCilindrada();
	}
}
