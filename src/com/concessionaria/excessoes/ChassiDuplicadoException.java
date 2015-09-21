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
 * Cont�m uma excess�o para o caso do chassi vir duplicado.
 * 
 * Classe <code>ChassiDuplicadoException<code>.
 * 
 * @author Tiago Henrique
 * @author Yasmin Farias
 * @author Renan Oliveira
 * @version 2.0 (18/09/2015)
 *
 */
public class ChassiDuplicadoException extends Exception {
	private static final long serialVersionUID = -9054496966763170985L;

	public ChassiDuplicadoException(String msg) {
		super(msg);
	}
}
