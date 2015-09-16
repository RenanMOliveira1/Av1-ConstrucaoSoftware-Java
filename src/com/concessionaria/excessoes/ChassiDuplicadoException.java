package com.concessionaria.excessoes;

public class ChassiDuplicadoException extends Exception {
	private static final long serialVersionUID = -9054496966763170985L;

	public ChassiDuplicadoException(String msg) {
		super(msg);
	}
}
