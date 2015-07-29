package com.concessionaria.veiculos;

import com.concessionaria.adminstracao.Enum.*;

import java.util.Scanner;


/**
 * @author Tiago
 * @author Renan Oliveira
 * @author Yasmin
 *
 */

public class Motocicleta extends Veiculo {
	private int cilindrada;
	private int capacidaDeTanque;
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
	 * @param CapacidadeDeTanque
	 * @param cilindrada
	 * 
	 * Construtor com todos os parâmentros e chamada a Super Classe Veículo
	 */
	public Motocicleta(String chassi, String montadora, String modelo,
			String tipo, String cor, float preco, int CapacidadeDeTanque, int cilindrada) {
		
		super(chassi, montadora, modelo, tipo, cor, preco);
		
		setCapacidaDeTanque(capacidaDeTanque);
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
	public int getCapacidaDeTanque() {
		return capacidaDeTanque;
	}
	
	/**
	 * @param capacidadeTanque
	 * Se Numero for Negativo, chama uma excessão.
	 */
	public void setCapacidaDeTanque(int capacidadeTanque) {		
		this.capacidaDeTanque = capacidadeTanque;
	}
	
	/**
	 * Método que faz a leitura de tipo de Motocicleta a partir do teclado
	 */
	public void leTipoMoto() {
		
		String nomeTipoEscolhido = null;
		
		/**
		 * Percorre todos os valores de TipoMoto e recebe seus valores em "tipoMoto" na ordem, imprimindo as opcoes
		 */
		System.out.println("Entre com o tipo de moto: ");
		for (TipoMoto tipoMoto : TipoMoto.values()) {
			System.out.println("*Digite " + tipoMoto.getNumOpcao() + " para escolher " + tipoMoto.getNomeTipo());
		}
		
		int opcaoTipo = input.nextInt();
		
		/**
		 * Percorre todos os valores de TipoMoto e recebe seus valores em "tipoMoto" na ordem
		 * Assim, verifica se o valor da opcao inputada confere com cada opcao de "tipoMoto"
		 */
		for (TipoMoto tipoMoto : TipoMoto.values()) {
			if(opcaoTipo == tipoMoto.getNumOpcao())
				nomeTipoEscolhido = tipoMoto.getNomeTipo();	
		} 
		
		if (nomeTipoEscolhido.equals(null) == false)
			setTipo(nomeTipoEscolhido);
		else 
			throw new IllegalArgumentException("Opcao nao valida!");
		
	}
	
	/**
	 * Método que faz a leitura da cilindrada de Motocicleta a partir do teclado
	 */
	public void leCilindrada() {
		
		int cilindradaEscolhida = 0;
		
		/**
		 * Percorre todos os valores de Cilindrada e recebe seus valores em "cilindrada" na ordem, imprimindo as opcoes
		 */
		System.out.println("Entre com a cilindrada da moto: ");
		for (Cilindrada cilindrada : Cilindrada.values()) {
			System.out.println("*Digite " + cilindrada.getNumOpcao() + " para escolher " + cilindrada.getNumCilindradas());
		}
		
		int opcaoCilindrada = input.nextInt();
		
		/**
		 * Percorre todos os valores de Cilindrada e recebe seus valores em "cilindrada" na ordem
		 * Assim, verifica se o valor da opcao inputada confere com cada opcao de "cilindrada"
		 */
		for (Cilindrada cilindrada : Cilindrada.values()) {
			if(opcaoCilindrada == cilindrada.getNumOpcao())
				cilindradaEscolhida = cilindrada.getNumCilindradas();	
		} 
		
		if (cilindradaEscolhida > 0)
			setCilindrada(cilindradaEscolhida);
		else 
			throw new IllegalArgumentException("Opcao nao valida!");
		
	}
	
	/**
	 * Método que faz a leitura de capacidade de tanque de Motocicleta a partir do teclado
	 */
	public void leCapacidadeDeTanque() {
		System.out.println("Entre com a capacidade do tanque da moto: ");
		
		int capacidade = input.nextInt();
		
		if(capacidade > 0)
			setCapacidaDeTanque(capacidade);
		else 
			throw new IllegalArgumentException("Capacidade deve ser numeral e positiva");
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
