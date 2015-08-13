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
public class MenorQueZeroException extends Exception {
	private static final long serialVersionUID = 2408412099459677071L;
	
	private String msg;
	
	public MenorQueZeroException(String msg) {
		super(msg);
		this.msg = msg;
	}
	
	public String getMsg() {
		return msg;
	}
}
