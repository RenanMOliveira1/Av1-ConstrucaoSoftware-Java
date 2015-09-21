/**
 * Copyright (c) 2015 GEC5
 * Todos os direitos reservados.
 * 
 * NÃO ALTERE OU REMOVA AS INFORMAÇÕES DE COPYRIGHT
 * OU INFORMAÇÕES CONTIDAS NESTE HEADER
 * 
 */
package com.concessionaria.view;

/**
 * 
 * Classe abstrata de validação de dados imputados.
 * 
 * Classe Abstrata <code>View<code>.
 * 
 * @author Tiago Henrique
 * @author Yasmin Farias
 * @author Renan Oliveira
 * @version 2.0 (18/09/2015)
 *
 */
import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;

import com.concessionaria.admin.Loja;
import com.concessionaria.excessoes.EstoqueVazioException;
import com.concessionaria.excessoes.OpcaoInvalidaException;

public abstract class View {
	protected Scanner input;
	
	/**
	 * 
	 * @param msgParaUsuario
	 * @param msgErro
	 * @param tamanhoInicial
	 * @param tamanhoFinal
	 * @return
	 */
	public int validarOpcao(String msgParaUsuario, String msgErro, int tamanhoInicial, int tamanhoFinal) {
		int opcao = 0;
		
		do {
			System.out.println(msgParaUsuario);
			try {
				opcao = input.nextInt();
			if (opcao < tamanhoInicial || opcao > tamanhoFinal) {
				throw new OpcaoInvalidaException();
			}	
			} catch (OpcaoInvalidaException e) {
				System.err.println(msgErro);
			}
		} while (opcao < tamanhoInicial || opcao > tamanhoFinal);
		
		return opcao;
	}
	
	/**
	 * 
	 * @param msgParaUsuario
	 * @param msgErro
	 * @return
	 */
	public String validarCampoString(String msgParaUsuario, String msgErro) {
		String opcao = null;
		boolean dadoInvalido = false;
		
		do {
			System.out.println(msgParaUsuario);
			try {
				input.nextLine();
				opcao = input.next();
			} catch (NoSuchElementException e) {
				System.err.println(msgErro);
				dadoInvalido = true;
			}
		} while (dadoInvalido);
		
		return opcao;
	}
	
	/**
	 * 
	 * @param msgParaUsuario
	 * @param msgErro
	 * @return
	 */
	public int validarCampoInteiro(String msgParaUsuario, String msgErro) {
		int opcao = 0;
		boolean dadoInvalido = false;
		
		while (!dadoInvalido) {
			try {
				System.out.println(msgParaUsuario);
				opcao = input.nextInt();
				dadoInvalido = true;
			} catch (InputMismatchException e) {
				System.err.println(msgErro);
				dadoInvalido = false;
			} catch (NoSuchElementException e) {
				System.err.println(msgErro);
				dadoInvalido = false;
			}
		} 
		
		return opcao;
	}
	
	/**
	 * 
	 * @param msgParaUsuario
	 * @param msgErro
	 * @return
	 */
	public Double validarCampoDouble(String msgParaUsuario, String msgErro) {
		Double opcao = 0.0;
		boolean dadoInvalido = false;
		
		while (!dadoInvalido) {
			try {
				System.out.println(msgParaUsuario);
				input.nextLine();
				opcao = input.nextDouble();
				dadoInvalido = true;
			} catch (InputMismatchException e) {
				System.err.println(msgErro);
				dadoInvalido = false;
			} catch (NoSuchElementException e) {
				System.err.println(msgErro);
				dadoInvalido = false;
			}
		} 
		
		return opcao;
	}
	
	/**
	 * 
	 * @param loja
	 * @return
	 */
	public boolean estoqueVazio(Loja loja) {
		
		try {
			if (loja.getEstoqueVeiculos().size() == 0)
				throw new EstoqueVazioException("Estoque de Veículos está Vazio.");
		} catch (EstoqueVazioException e) {
			System.err.println("\nNenhum Veículo Cadastrado.\n");
			return true;
		}
		return false;
	}
}
