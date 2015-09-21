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
 * Guarda todos os tipos possíveis de motocicleta para um veiculo
 * 
 * enum <code>TipoMotocicleta<code>.
 * 
 * @author Tiago Henrique
 * @author Yasmin Farias
 * @author Renan Oliveira
 * @version 2.0 (18/09/2015)
 *
 */
public enum TipoMotocicleta {
	CICLOMOTOR(1, "Ciclomotor"),
	MOTOCICLO(2, "Motociclo"),
	SCOOTER(3, "Scooter"),
	ESPORTIVA(4, "Esportiva"),
	CUSTOM(5, "Custom"),
	ROADSTER(6, "Roadster"),
	CHOPPER(7, "Chopper"),
	NAKED(8, "Naked"),
	OFF_ROAD(9, "Off-road"),
	MOTARD(10, "Motard"),
	SUPERMOTARD(11, "Supermotard"),
	POCKETBIKE(12, "Pocketbike"),
	STREET(13, "Street"),
	UNDERBONE(14, "Underbone"),
	BABY(15, "Baby");
	
	private int numOpcao;
	private String nomeTipo;
	
	/**
	 * @param numOpcao
	 * @param nomeTipo
	 * 
	 * Construtor com todos os parâmentros
	 */
	private TipoMotocicleta(int numOpcao, String nomeTipo) {
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
	public String getNomeTipoMotocicleta() {
		return nomeTipo;
	}
	
	public static TipoMotocicleta getOpcao(int opcao) {
		
		for (TipoMotocicleta c : values()) {
			if (opcao == c.getNumOpcao()) 
				return c;
		}
		
		return null;
	}
	
	public static void exibirOpcoes() {
		
		System.out.println();
		for (TipoMotocicleta tipoMotocicleta : TipoMotocicleta.values()) {
			System.out.println("*Digite " + tipoMotocicleta.getNumOpcao() + " para escolher " + tipoMotocicleta.getNomeTipoMotocicleta());
		}
		System.out.println();
	}
}
