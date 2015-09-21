/**
 * Copyright (c) 2015 GEC5
 * Todos os direitos reservados.
 * 
 * NÃO ALTERE OU REMOVA AS INFORMAÇÕES DE COPYRIGHT
 * OU INFORMAÇÕES CONTIDAS NESTE HEADER
 * 
 */
package com.concessionaria.view;

import java.util.NoSuchElementException;
import java.util.Scanner;

import com.concessionaria.admin.Loja;
import com.concessionaria.admin.Veiculo;
import com.concessionaria.enumerados.TipoVeiculo;
import com.concessionaria.excessoes.ChassiDuplicadoException;
import com.concessionaria.view.especificacoes.ViewEspecificacoes;
import com.concessionaria.view.especificacoes.FabricaDeEspecificacao;

/**
 * 
 * Classe de validação de dados imputados de chassi e de cadastro de veículos.
 * 
 * Classe <code>ViewCadastro<code>.
 * 
 * @author Tiago Henrique
 * @author Yasmin Farias
 * @author Renan Oliveira
 * @version 2.0 (18/09/2015)
 *
 */
public class ViewCadastro extends View {
	/** */
	private FabricaDeEspecificacao fabricaDeEspecificacao;
	
	public ViewCadastro() {
		this.fabricaDeEspecificacao = new FabricaDeEspecificacao();
		this.input = new Scanner(System.in);
	}
	
	/**
	 * 
	 * @param loja
	 * @return
	 */
	public Veiculo cadastrarVeiculo(Loja loja) {
		
		TipoVeiculo.exibirOpcoes();
		/*
		 * 
		 */
		int tipoVeiculo = validarOpcao("Entre com o Tipo de Veiculo: ", "Tipo de Veículo Inválido.", 1, TipoVeiculo.values().length);
		
		String chassi = validaChassi(loja);
		/*
		 * 
		 */
		double preco = validarCampoDouble("Entre com o Preço: ", "Preço: Dados Inválidos.");
		
		ViewEspecificacoes especificacoes = fabricaDeEspecificacao.criarEspecificacoes(TipoVeiculo.getOpcao(tipoVeiculo));
		
		return new Veiculo(chassi, preco, especificacoes.cadastrarEspecificacoes(), TipoVeiculo.getOpcao(tipoVeiculo));
	}
	
	/**
	 * 
	 * @param loja
	 * @return
	 */
	private String validaChassi(Loja loja) {
		String chassi = null;
		boolean dadoInvalido = false;
		
		while (!dadoInvalido) {
			try {
				/*
				 * 
				 */
				chassi = this.validarCampoString("Entre com o Chassi: ", "Dados Inválidos.");
				for (Veiculo v : loja.getEstoqueVeiculos()) {
					if (chassi.equals(v.getChassi()))
						throw new ChassiDuplicadoException("Chassi Duplicado.");
				}
				dadoInvalido = true;
			} catch (NoSuchElementException e) {
				System.err.println("Chassi: Dados Inválidos.");
				dadoInvalido = false;
			} catch (ChassiDuplicadoException e) {
				System.err.println("Já Existe um Veículo com Esse Chassi, Tente Novamente.");
				dadoInvalido = false;
			}
		} 
		return chassi;
	}
}
