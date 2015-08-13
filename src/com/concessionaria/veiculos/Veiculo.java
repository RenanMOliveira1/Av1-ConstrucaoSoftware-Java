/*
 * Copyright (c) 2015, GEC5 and/or its affiliates. All rights reserved.
 * INSTITUTO INFNET. Use is subject to license terms.
 * 
 * 
 * 
 */
package com.concessionaria.veiculos;

import com.concessionaria.administracao.auxiliares.EntradaDeDados;
import com.concessionaria.administracao.auxiliares.Tela;
import com.concessionaria.administracao.excessoes.MenorQueZeroException;

/**
 * 
 * <p>A Classe <code>Veiculo<code> é uma Classe Abstrata usada
 * como espelho para os diversos tipos de Veículos (Carro, 
 * Motocicletas, Barcos), onde todos esses veículos deveram
 * ter obrigatoriamente dois métodos, cadastrarVeiculo e
 * exibirVeiculo. Ela não pode ser Inicializada.</p>
 * 
 * @author Yasmin
 * @author Tiago Henrique
 * @since JDK 1.8
 *
 */

public abstract class Veiculo {
	protected String chassi;
	protected String montadora;
	protected String modelo;
	protected String tipo;
	protected String cor;
	protected double preco;
	protected Tela tela;
	protected EntradaDeDados entradaDeDado;
	
	public Veiculo() {
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
	 * @return um veículo Cadastrado
	 */
	public abstract Veiculo cadastrarVeiculo();
	
	/**
	 *  Exibe os dados de um Veiculo Cadastrado.
	 */
	public abstract void exibirVeiculo();
	
	protected void tratarNumeros(int entrada) throws MenorQueZeroException {
		
		if (entrada < 0)
			throw new MenorQueZeroException("Numero Negativo não é Aceito.");
	}
	
	protected void tratarNumeros(double entrada) throws MenorQueZeroException {
		
		if (entrada < 0.0)
			throw new MenorQueZeroException("Numero Negativo não é Aceito.");
	}
}