package com.concessionaria.view;

import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;

import com.concessionaria.excessoes.OpcaoInvalidaException;

public abstract class View {
	protected Scanner input;
	
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
	
	public String validarCampoString(String msgParaUsuario, String msgErro) {
		String opcao = null;
		boolean dadoInvalido = false;
		
		do {
			System.out.println(msgParaUsuario);
			try {
				opcao = input.next();
			} catch (NoSuchElementException e) {
				System.err.println(msgErro);
				dadoInvalido = true;
			}
		} while (dadoInvalido);
		
		return opcao;
	}
	
	public int validarCampoInteiro(String msgParaUsuario, String msgErro) {
		int opcao = 0;
		boolean dadoInvalido = false;
		
		while (!dadoInvalido) {
			try {
				System.out.println(msgParaUsuario);
				input.nextLine();
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
}
