/**
 * Copyright (c) 2015 GEC5
 * Todos os direitos reservados.
 * 
 * NÃO ALTERE OU REMOVA AS INFORMAÇÕES DE COPYRIGHT
 * OU INFORMAÇÕES CONTIDAS NESTE HEADER
 * 
 */
package com.concessionaria.enumerados;

/**
 * 
 * Guarda todos os tipos possíveis de carro para um veiculo
 * 
 * enum <code>TipoCarro<code>.
 * 
 * @author Tiago Henrique
 * @author Yasmin Farias
 * @author Renan Oliveira
 * @version 2.0 (18/09/2015)
 *
 */
public enum TipoCarro {
	HATCH_COMPACTO(1, "Hatch Compacto"),
	HATCH_MEDIO(2, "Hatch Médio"),
	HATCH_ESPORTIVO(3, "Hatch Esportivo"),
	SEDA_COMPACTO(4, "Sedã Compacto"),
	SEDA_MEDIO(5, "Sedã Médio"),
	SEDA_GRANDE(6, "Sedã Grande"),
	MONOVOLUME(7, "Monovolume"),
	MINIVAN(8, "Minivan"),
	PERUA(9, "Perua"),
	PICAPE(10, "Picape"),
	UTILITARIO_ESPORTIVO(11, "Utilitário Esportivo"),
	ESPORTIVO(12, "Esportivo"),
	CONVERSIVEL(13, "Conversível"),
	UTILITARIO_COMERCIAL(14, "Utilitário Comercial");
	
	private int numOpcao;
	private String nomeTipo;
	
	/**
	 * @param numOpcao
	 * @param nomeTipo
	 * 
	 * Construtor com todos os parâmentros
	 */
	private TipoCarro(int numOpcao, String nomeTipo) {
		this.numOpcao = numOpcao;
		this.nomeTipo = nomeTipo;
	}
	
	/**
	 * @return Retorna o numero da opcao
	 */
	public int getNumOpcao() {
		return numOpcao;
	}
	
	/**
	 * @return Retorna o nome do tipo
	 */
	public String getNomeTipoCarro() {
		return nomeTipo;
	}
	
	public static TipoCarro getOpcao(int opcao) {
		
		for (TipoCarro c : values()) {
			if (opcao == c.getNumOpcao()) 
				return c;
		}
		
		return null;
	}
	
	public static void exibirOpcoes() {
		
		System.out.println();
		for (TipoCarro tipoCarro : TipoCarro.values()) {
			System.out.println("*Digite " + tipoCarro.getNumOpcao() + " para escolher " + tipoCarro.getNomeTipoCarro());
		}
		System.out.println();
	}
}
