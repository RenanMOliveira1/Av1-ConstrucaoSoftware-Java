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
 * Guarda todos os tipos possíveis de montadoras para um veiculo
 * 
 * enum <code>Montadora<code>.
 * 
 * @author Tiago Henrique
 * @author Yasmin Farias
 * @author Renan Oliveira
 * @version 2.0 (18/09/2015)
 *
 */
public enum Montadora {
	TOYOTA(1, "Toyota"),
	BMW(2, "BMW"),
	VOLKSWAGEN(3, "Volkswagen"),
	MERCEDES_BENZ(4, "Mercedes-Benz"),
	HONDA(5, "Honda"),
	NISSAN(6, "Nissan"),
	FORD(7, "Ford"),
	PORSCHE(8, "Porsche"),
	HYUNDAI(9, "Hyundai"),
	RENAULT(10, "Renault"),
	DUCATI(11, "Ducati"),
	SUZUKI(12, "Suzuki"),
	YAMAHA(13, "Yamaha"),
	HOLLISTER_EXCITE(14, "Hollister Excite"),
	KAWASAKI(15, "Kawasaki"),
	APRILIA_TUONO(16, "Aprilia Tuono"),
	VYRUS(17, "Vyrus"),
	ICON_SHENE(18, "ICON_SHENE");
	
	private int numOpcao;
	private String nomeMontadora;
	
	/**
	 * @param numOpcao
	 * @param nomeMontadora
	 * 
	 * Construtor com todos os parâmentros
	 */
	private Montadora(int numOpcao, String nomeMontadora) {
		this.numOpcao = numOpcao;
		this.nomeMontadora = nomeMontadora;
	}
	
	/**
	 * @return Retorna o numero da opcao
	 */
	public int getNumOpcao() {
		return this.numOpcao;
	}
	
	/**
	 * @return Retorna o nome da montadora
	 */
	public String getNomeMontadora() {
		return this.nomeMontadora;
	}
	
	public static Montadora getOpcao(int opcao) {
		
		for (Montadora c : values()) {
			if (opcao == c.getNumOpcao()) 
				return c;
		}
		
		return null;
	}
	
	public static void exibirOpcoes() {
		
		System.out.println();
		for (Montadora montadora : Montadora.values()) {
			System.out.println("*Digite " + montadora.getNumOpcao() + " para escolher " + montadora.getNomeMontadora());
		}
		System.out.println();
	}
}
