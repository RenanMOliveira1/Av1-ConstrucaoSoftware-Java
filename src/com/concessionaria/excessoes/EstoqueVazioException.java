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
 * Contém uma excessão caso o estoque esteja vazio.
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
