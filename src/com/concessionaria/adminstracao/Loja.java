/*
 * Copyright (c) 2015, GEC5 and/or its affiliates. All rights reserved.
 * INSTITUTO INFNET. Use is subject to license terms.
 * 
 * 
 * 
 */
package com.concessionaria.adminstracao;

import java.util.ArrayList;

import com.concessionaria.administracao.auxiliares.Tela;
import com.concessionaria.veiculos.Carro;
import com.concessionaria.veiculos.Motocicleta;
import com.concessionaria.veiculos.Veiculo;

/**
 * <p>A Classe <code>Loja<code> contém todos os métodos 
 * disponiveis em um estoque de veículos.</p>
 * 
 * @author Renan Oliveira
 * @author Tiago Henrique
 * @since JDK 1.8
 *
 */

public class Loja {
	private String endereco;
	private String nome;
	private Tela tela;
	private ArrayList<Veiculo> estoqueVeiculos;
	
	public Loja() {
		estoqueVeiculos = new ArrayList<Veiculo>();
		tela = new Tela();
	}
	
	public String getEndereco() {
		return endereco;
	}
	
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public ArrayList<Veiculo> getEstoqueVeiculos() {
		return estoqueVeiculos;
	}

	public void setEstoqueVeiculos(ArrayList<Veiculo> estoqueVeiculos) {
		this.estoqueVeiculos = estoqueVeiculos;
	}

	/**
	 * Adiciona um Carro no Estoque
	 * 
	 * @return Retorna <tt>true</tt> se o Carro for Cadastrado com sucesso, e <tt>false</tt> se ocorrer algum problema
	 */
	public boolean adicionarCarro(){
		Veiculo veiculo = new Carro();
		
		if(getEstoqueVeiculos().add(veiculo.cadastrarVeiculo())) {
			tela.exibirMsgLine("\nCarro Adicionado!\n");	
			return true;
		} else {
			tela.exibirMsgLine("\nHouve um Problema no Cadastro.\n");
			return false;
		}	
	}
	
	/**
	 * Adiciona uma Motocicleta no Estoque
	 * 
	 * @return Retorna <tt>true</tt> se a Motocicleta for Cadastrado com sucesso, e <tt>false</tt> se ocorrer algum problema
	 */
	public boolean adicionarMotocicleta(){
		Veiculo veiculo = new Motocicleta();
		
		if(getEstoqueVeiculos().add(veiculo.cadastrarVeiculo())){
			tela.exibirMsgLine("\nMotocicleta Adicionado!\n");
			return true;
		} else {
			tela.exibirMsgLine("\nHouve um Problema no Cadastro.\n");
			return false;
		}	
	}
	
	/**
	 * Busca um Carro no Estoque e Retorna o Objeto do Veiculo.
	 * 
	 * @param chassi O Chassi do Veículo que deseja Procurar
	 * @return Retorna o Carro com o Chassi correspondente
	 */
	public Veiculo buscarCarro(String chassi){
		
		for(Veiculo carro : getEstoqueVeiculos()){
			if(carro.getChassi().equals(chassi)){
				return carro;
			}
		}
		return null;
	}
	
	/**
	 * Busca um Carro no Estoque e Retorna o Objeto do Veiculo.
	 * 
	 * @param chassi O Chassi do Veículo que deseja Procurar
	 * @return Retorna a Motocicleta com o Chassi correspondente
	 */
	public Veiculo buscarMoto(String chassi){
		
		for(Veiculo moto : getEstoqueVeiculos()){
			if(moto.getChassi().equals(chassi)){
				return moto;
			}
		}
		return null;
	}
	
	public void listarEstoqueMotocicleta(){
		for(Veiculo moto : getEstoqueVeiculos()){
			moto.exibirVeiculo();
		}
	}
	
	public void listarEstoqueCarro(){
		for(Veiculo carro : getEstoqueVeiculos()){
			carro.exibirVeiculo();
		}
	}
	
	/**
	 * Remove um Carro do Estoque.
	 * 
	 * @param chassi O Chassi do Veículo que deseja Remover
	 * @return True se o Carro foi Removido com Sucesso, e False se não.
	 */
	
	public boolean removerCarro(String chassi) {
		Veiculo carroSelecionado = buscarCarro(chassi);
		
		if (carroSelecionado != null) {
			getEstoqueVeiculos().remove(carroSelecionado);
			return true;
		} 
		
		return false;
	}
	
	/**
	 * Remove uma Motocicleta do Estoque.
	 * 
	 * @param chassi O Chassi do Veículo que deseja Remover
	 * @return True se a Motocicleta foi Removida com Sucesso, e False se não.
	 */
	public boolean removerMotocicleta(String chassi) {
		Veiculo motoSelecionada = buscarMoto(chassi);
		
		if (motoSelecionada != null) {
			getEstoqueVeiculos().remove(motoSelecionada);
			return true;
		} 
		
		return false;
	}
}
