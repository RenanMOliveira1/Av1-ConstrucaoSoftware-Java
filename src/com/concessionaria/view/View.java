package com.concessionaria.view;

import java.util.Scanner;

import com.concessionaria.excessoes.OpcaoInvalidaException;

public abstract class View {
	protected Scanner input;
	
	public int validarEntradaDados(String msg, String msgErro, int tamanhoInicial, int tamanhoFinal) {
		int opcao = 0;
		
		do {
			System.out.println(msg);
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
}
