/**
 * Copyright (c) 2015 GEC5
 * Todos os direitos reservados.
 * 
 * N�O ALTERE OU REMOVA AS INFORMA��ES DE COPYRIGHT
 * OU INFORMA��ES CONTIDAS NESTE HEADER
 * 
 */
package com.concessionaria.excessoes;

/**
 * 
 * Cont�m uma excess�o caso a op��o seja inv�lida.
 * 
 * Classe <code>OpcaoInvalidaException<code>.
 * 
 * @author Tiago Henrique
 * @author Yasmin Farias
 * @author Renan Oliveira
 * @version 2.0 (18/09/2015)
 *
 */
public class OpcaoInvalidaException extends Exception {
	private static final long serialVersionUID = -838978233512648908L;

	public OpcaoInvalidaException(String msg) {
		super(msg);
	}
	
	public OpcaoInvalidaException() {
		
	}
}
