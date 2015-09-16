package com.concessionaria.excessoes;

public class EstoqueVazioException extends Exception {
	private static final long serialVersionUID = -6225963863128451374L;

	public EstoqueVazioException(String msg) {
		super(msg);
	}
}
