/*
 * Copyright (c) 2015, GEC5 and/or its affiliates. All rights reserved.
 * INSTITUTO INFNET. Use is subject to license terms.
 * 
 * 
 * 
 */
package com.concessionaria.veiculos;

import java.util.InputMismatchException;

import com.concessionaria.administracao.auxiliares.SubOpcoesMenu.*;
import com.concessionaria.administracao.excessoes.MenorQueZeroException;

/**
 * @author Tiago Henrique
 * @author Yasmin Farias
 * @author Renan Oliveira
 * @see Veiculo
 * @since JDK 1.8
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
	 * Cadastra os Dados de uma nova Motocicleta e Retorna um
	 * Veiculo Preenxido.
	 * 
	 * @throws InputMismatchException se digitar alguma String
	 * quando se pede Inteiro.
	 */
	public Veiculo cadastrarVeiculo(){
		int opcaoEscolhida = 0;
		
		System.out.println("********Entre com caracteristicas para a sua moto********");
		
		tela.exibirMsg("\nEntre com o chassi: ");
		setChassi(entradaDeDado.getInputString());
		
		tela.inserirQuebraDeLinha();
		Montadora.exibirOpcoes();
		tela.exibirMsg("\nEntre com a Montadora: ");
		try {
			opcaoEscolhida = entradaDeDado.getInputInt();
			tratarNumeros(opcaoEscolhida);
		} catch (InputMismatchException string) {
			tela.exibirMsg("Não se Aceita Letras, só Números ");
			string.printStackTrace();
		} catch (MenorQueZeroException e) {
			e.printStackTrace();
		}
		setMontadora(Montadora.pesquisarOpcao(opcaoEscolhida));
		
		tela.exibirMsg("Entre com o Modelo: ");
		setModelo(entradaDeDado.getInput());
		
		
		tela.inserirQuebraDeLinha();
		TipoMoto.exibirOpcoes();
		tela.exibirMsg("Entre com o tipo de moto: ");
		try {
			opcaoEscolhida = entradaDeDado.getInputInt();
			tratarNumeros(opcaoEscolhida);
		} catch (InputMismatchException string) {
			tela.exibirMsg("Não se Aceita Letras, só Números ");
			string.printStackTrace();
		} catch (MenorQueZeroException e) {
			e.printStackTrace();
		}
		setTipo(TipoMoto.pesquisarOpcao(opcaoEscolhida));
		
		tela.inserirQuebraDeLinha();
		Cor.exibirOpcoes();
		tela.exibirMsg("Entre com a cor: ");
		try {
			opcaoEscolhida = entradaDeDado.getInputInt();
			tratarNumeros(opcaoEscolhida);
		} catch (InputMismatchException string) {
			tela.exibirMsg("Não se Aceita Letras, só Números ");
			System.exit(1);
		} catch (MenorQueZeroException e) {
			e.printStackTrace();
		}
		setCor(Cor.pesquisarOpcao(opcaoEscolhida));
		
		tela.exibirMsg("Entre com o preço: ");
		try {
			setPreco(entradaDeDado.getInputDouble());
			tratarNumeros(opcaoEscolhida);
		} catch (InputMismatchException string) {
			tela.exibirMsg("Não se Aceita Letras, só Números ");
			string.printStackTrace();
		} catch (MenorQueZeroException e) {
			e.printStackTrace();
		}
		
		tela.exibirMsg("Entre com a capacidade do tanque da moto: ");
		try {
			setCapacidaDeTanque(entradaDeDado.getInputInt());
			tratarNumeros(opcaoEscolhida);
		} catch (InputMismatchException string) {
			tela.exibirMsg("Não se Aceita Letras, só Números ");
			string.printStackTrace();
		} catch (MenorQueZeroException e) {
			e.printStackTrace();
		}
		
		tela.inserirQuebraDeLinha();
		Cilindrada.exibirOpcoes();
		tela.exibirMsg("Entre com a cilindrada da moto: ");
		try {
			opcaoEscolhida = entradaDeDado.getInputInt();
			tratarNumeros(opcaoEscolhida);
		} catch (InputMismatchException string) {
			tela.exibirMsg("Não se Aceita Letras, só Números ");
			string.printStackTrace();
		} catch (MenorQueZeroException e) {
			e.printStackTrace();
		}
		setCilindrada(Cilindrada.pesquisarOpcao(opcaoEscolhida));
		
		return this;
	}
	
		public void exibirVeiculo(){
		
		tela.exibirMsgLine("Chassi: " + getChassi());
		tela.exibirMsgLine("Montadora: " + getMontadora());
		tela.exibirMsgLine("Modelo: " + getModelo());
		tela.exibirMsgLine("Tipo: " + getTipo());
		tela.exibirMsgLine("Cilindrada: " + getCilindrada());
		tela.exibirMsgLine("Capacida De Tanque: " + getCapacidaDeTanque());
		tela.exibirMsgLine("Cor: " + getCor());
		tela.exibirMsg("Preco: " + tela.exibirValorReais(getPreco()));
		System.out.println("-----------X------------\n");
	}
}
