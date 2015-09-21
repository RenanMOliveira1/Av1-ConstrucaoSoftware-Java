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
 * Cont�m uma excess�o caso o ve�culo j� esteja cadastrado.
 * 
 * Classe <code>VeiculoJaCadastradoException<code>.
 * 
 * @author Tiago Henrique
 * @author Yasmin Farias
 * @author Renan Oliveira
 * @version 2.0 (18/09/2015)
 *
 */
public class VeiculoJaCadastradoException extends Exception {
	private static final long serialVersionUID = 6726086632086898107L;

	public VeiculoJaCadastradoException(String msg) {
		super(msg);
	}
}
