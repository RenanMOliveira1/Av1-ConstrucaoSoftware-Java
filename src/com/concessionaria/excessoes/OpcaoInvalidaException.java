/**
 * Copyright (c) 2015 GEC5
 * Todos os direitos reservados.
 * 
 * NÃO ALTERE OU REMOVA AS INFORMAÇÕES DE COPYRIGHT
 * OU INFORMAÇÕES CONTIDAS NESTE HEADER
 * 
 */
package com.concessionaria.excessoes;

/**
 * 
 * Contém uma excessão caso a opção seja inválida.
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
