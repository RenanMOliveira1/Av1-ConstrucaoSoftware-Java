package com.concessionaria.excessoes;

public class OpcaoInvalidaException extends Exception {
	private static final long serialVersionUID = -838978233512648908L;

	public OpcaoInvalidaException(String msg) {
		super(msg);
	}
	
	public OpcaoInvalidaException() {
		
	}
}
