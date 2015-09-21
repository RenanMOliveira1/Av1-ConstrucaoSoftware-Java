/**
 * Copyright (c) 2015 GEC5
 * Todos os direitos reservados.
 * 
 * N�O ALTERE OU REMOVA AS INFORMA��ES DE COPYRIGHT
 * OU INFORMA��ES CONTIDAS NESTE HEADER
 * 
 */
package com.concessionaria.view;

/**
 * 
 * Classe abstrata de valida��o de dados imputados.
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
	 * Valida uma Entrada se For em Op��o ENUMERADA.
	 * 
	 * @param msgParaUsuario Mensagem A ser Exibida ao Usu�rio para Entrar com os Dados.
	 * @param msgErro Mensagem de Erro Caso N�o for Correta a Entrada de Dados.
	 * @param tamanhoInicial Tamanho Inicial de Op��es no Enumerados.
	 * @param tamanhoFinal Tamanho Total (Final) de Op��es no Enumerados.
	 * @return Retorna o Numero referente a Op��o no Enumerado
	 * 
	 * @throws OpcaoInvalidaException Se a Op��o Entrada n�o for V�lida, Lan�a essa Excess�o.
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
	 * Valida um Campo String.
	 * 
	 * @param msgParaUsuario Mensagem A ser Exibida ao Usu�rio para Entrar com os Dados.
	 * @param msgErro Mensagem de Erro Caso N�o for Correta a Entrada de Dados.
	 * @return Retorna a String j� validada.
	 * 
	 * @throws NoSuchElementException Se Houver Algum Erro referente a String, Lan�a uma Excess�o.
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
	 * Valida Um campo Inteiro.
	 * 
	 * @param msgParaUsuario Mensagem A ser Exibida ao Usu�rio para Entrar com os Dados.
	 * @param msgErro Mensagem de Erro Caso N�o for Correta a Entrada de Dados.
	 * @return Retorna o N�mero Inteiro Formatado.
	 * 
	 * @throws InputMismatchException Se N�o For um Inteiro, Lan�a essa Excess�o.
	 * @throws NoSuchElementException Se Houver Algum Erro referente ao Inteiro, Lan�a uma Excess�o.
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
	 * Validar um campo Double.
	 * 
	 * @param msgParaUsuario Mensagem A ser Exibida ao Usu�rio para Entrar com os Dados.
	 * @param msgErro Mensagem de Erro Caso N�o for Correta a Entrada de Dados.
	 * @return retorna um Double Formatado.
	 * 
	 * @throws InputMismatchException Se N�o For um Double, Lan�a essa Excess�o.
	 * @throws NoSuchElementException Se Houver Algum Erro referente ao Double, Lan�a uma Excess�o.
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
	 * Verifica se o Ve�culo Est� Vazio.
	 * 
	 * @param loja
	 * @return Retorna <tt>true</tt> se Estiver Vazio, e <tt>false</tt> se n�o estiver Vazio.
	 */
	public boolean estoqueVazio(Loja loja) {
		
		try {
			if (loja.getEstoqueVeiculos().size() == 0)
				throw new EstoqueVazioException("Estoque de Ve�culos est� Vazio.");
		} catch (EstoqueVazioException e) {
			System.err.println("\nNenhum Ve�culo Cadastrado.\n");
			return true;
		}
		return false;
	}
}
