package com.concessionaria.excessoes;

public class VeiculoJaCadastradoException extends Exception {
	private static final long serialVersionUID = 6726086632086898107L;

	public VeiculoJaCadastradoException(String msg) {
		super(msg);
	}
}
