/*
 * Copyright (c) 2015, GEC5 and/or its affiliates. All rights reserved.
 * INSTITUTO INFNET. Use is subject to license terms.
 * 
 * 
 * 
 */
package com.concessionaria.administracao.excessoes;

/**
 * @author Tiago Henrique
 * @since JDK 1.8
 *
 */
public class ChassiDuplicadoException extends Exception {
	private static final long serialVersionUID = -3205286034729059680L;
	
	private String msg;
	
	public ChassiDuplicadoException(String msg) {
		super(msg);
		this.msg = msg;
	}
	
	public String getMsg() {
		return msg;
	}
}
