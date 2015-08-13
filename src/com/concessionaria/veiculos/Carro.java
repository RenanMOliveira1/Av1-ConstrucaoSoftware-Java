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
	 * Cadastra os Dados de um Novo Carro e Retorna um
	 * Veiculo preenxido.
	 * 
	 * @throws InputMismatchException se digitar alguma String
	 * quando se pede Inteiro.
	 * 
	 */
	
	public Veiculo cadastrarVeiculo() {
		int opcaoEscolhida = 0;
		
		tela.exibirMsgLine("********Entre com Caracteristicas para o seu Carro********");
		
		tela.exibirMsg("\nEntre com o Chassi: ");
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
		Cor.exibirOpcoes();
		tela.exibirMsg("Entre com a Cor: ");
		try {
			opcaoEscolhida = entradaDeDado.getInputInt();
			tratarNumeros(opcaoEscolhida);
		} catch (InputMismatchException string) {
			tela.exibirMsg("Não se Aceita Letras, só Números ");
			string.printStackTrace();
		} catch (MenorQueZeroException e) {
			e.printStackTrace();
		}
		setCor(Cor.pesquisarOpcao(opcaoEscolhida));
		
		tela.exibirMsg("Entre com o Preço: ");
		try {
			setPreco(entradaDeDado.getInputDouble());
			tratarNumeros(opcaoEscolhida);
		} catch (InputMismatchException string) {
			tela.exibirMsg("Não se Aceita Letras, só Números ");
			string.printStackTrace();
		} catch (MenorQueZeroException e) {
			e.printStackTrace();
		}
		
		tela.inserirQuebraDeLinha();
		TipoCarro.exibirOpcoes();
		tela.exibirMsg("\nEntre com o Tipo de Carro: ");
		try {
			opcaoEscolhida = entradaDeDado.getInputInt();
			tratarNumeros(opcaoEscolhida);
		} catch (InputMismatchException string) {
			tela.exibirMsg("Não se Aceita Letras, só Números ");
			string.printStackTrace();
		} catch (MenorQueZeroException e) {
			e.printStackTrace();
		}
		setTipo(TipoCarro.pesquisarOpcao(opcaoEscolhida));
		
		tela.exibirMsg("\nEntre Com a Motorizacao do Tanque: ");
		try {
			setMotorizacao(entradaDeDado.getInputInt());
			tratarNumeros(opcaoEscolhida);
		} catch (InputMismatchException string) {
			tela.exibirMsg("Não se Aceita Letras, só Números ");
			string.printStackTrace();
		} catch (MenorQueZeroException e) {
			e.printStackTrace();
		}
		
		tela.inserirQuebraDeLinha();
		Cambio.exibirOpcoes();
		tela.exibirMsg("\nEntre com o Cambio: ");
		try {
			opcaoEscolhida = entradaDeDado.getInputInt();
			tratarNumeros(opcaoEscolhida);
		} catch (InputMismatchException string) {
			tela.exibirMsg("Não se Aceita Letras, só Números ");
			string.printStackTrace();
		} catch (MenorQueZeroException e) {
			e.printStackTrace();
		}
		setCambio(Cambio.pesquisarOpcao(opcaoEscolhida));
		
		return this;
	}
	
	public void exibirVeiculo() {
		
		tela.exibirMsgLine("Chassi: " + getChassi());
		tela.exibirMsgLine("Montadora: " + getMontadora());
		tela.exibirMsgLine("Modelo: " + getModelo());
		tela.exibirMsgLine("Tipo: " + getTipo());
		tela.exibirMsgLine("Cambio: " + getCambio());
		tela.exibirMsgLine("Motorização: " + getMotorizacao());
		tela.exibirMsgLine("Cor: " + getCor());
		tela.exibirMsg("Preço: " + tela.exibirValorReais(getPreco()));
		tela.exibirMsgLine("-----------X------------\n");
	}
	
}
