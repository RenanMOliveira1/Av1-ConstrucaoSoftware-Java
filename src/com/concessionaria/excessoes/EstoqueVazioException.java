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
 * Cont�m uma excess�o caso o estoque esteja vazio.
 * 
 * Classe <code>EstoqueVaziooException<code>.
 * 
 * @author Tiago Henrique
 * @author Yasmin Farias
 * @author Renan Oliveira
 * @version 2.0 (18/09/2015)
 *
 */
public class EstoqueVazioException extends Exception {
	private static final long serialVersionUID = -6225963863128451374L;

	public EstoqueVazioException(String msg) {
		super(msg);
	}
}
