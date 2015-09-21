/**
 * Copyright (c) 2015 GEC5
 * Todos os direitos reservados.
 * 
 * N�O ALTERE OU REMOVA AS INFORMA��ES DE COPYRIGHT
 * OU INFORMA��ES CONTIDAS NESTE HEADER
 * 
 */
package com.concessionaria.enumerados;

/**
 * 
 * Guarda todos os tipos poss�veis de carro para um veiculo
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
	HATCH_MEDIO(2, "Hatch M�dio"),
	HATCH_ESPORTIVO(3, "Hatch Esportivo"),
	SEDA_COMPACTO(4, "Sed� Compacto"),
	SEDA_MEDIO(5, "Sed� M�dio"),
	SEDA_GRANDE(6, "Sed� Grande"),
	MONOVOLUME(7, "Monovolume"),
	MINIVAN(8, "Minivan"),
	PERUA(9, "Perua"),
	PICAPE(10, "Picape"),
	UTILITARIO_ESPORTIVO(11, "Utilit�rio Esportivo"),
	ESPORTIVO(12, "Esportivo"),
	CONVERSIVEL(13, "Convers�vel"),
	UTILITARIO_COMERCIAL(14, "Utilit�rio Comercial");
	
	private int numOpcao;
	private String nomeTipo;
	
	/**
	 * @param numOpcao
	 * @param nomeTipo
	 * 
	 * Construtor com todos os par�mentros
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
