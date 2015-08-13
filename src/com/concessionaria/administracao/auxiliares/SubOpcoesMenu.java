/*
 * Copyright (c) 2015, GEC5 and/or its affiliates. All rights reserved.
 * INSTITUTO INFNET. Use is subject to license terms.
 * 
 * 
 * 
 */
package com.concessionaria.administracao.auxiliares;


/**
 * @author Yasmin Farias
 * @author Tiago Henrique
 * @since JDK 1.8
 *
 */
public class SubOpcoesMenu {

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
		 * Construtor com todos os parâmentros
		 * 
		 * @param numOpcao O Numero da Montadora desejada no Menu
		 * @param nomeMontadora O Nome da Montadora desejada no Menu
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
		
		/**
		 * Exibe Todas as Opções Formatadas em String.
		 */
		public static void exibirOpcoes() {
			for (Montadora montadora : Montadora.values()) {
				System.out.println(montadora.getNumOpcao() + " - " + montadora.getNomeMontadora());
			}
		}
		
		/**
		 * Pesquisa no Enumerodo a Opção desejada pelo Usuário.
		 * 
		 * @param opcao O Numero da Montadora desejada no Menu
		 * @return Retorna o Nome da Montadora Escolhida, se não Lança um Excessão.
		 * 
		 * @throws IllegalArgumentException Caso Digite uma Opção Incorreta.
		 */
		public static String pesquisarOpcao(int opcao) {
			
			for (Montadora montadora : Montadora.values()) {
				if(opcao == montadora.getNumOpcao())
					return montadora.getNomeMontadora();
			} 
			
			throw new IllegalArgumentException("Opção Incorreta");
		}
	}
	
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
		 * Construtor com todos os parâmentros
		 * 
		 * @param numOpcao O Numero do Tipo de Carro desejado no Menu
		 * @param nomeTipo O Nome do Tipo de Carro desejado no Menu
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
		public String getNomeTipo() {
			return nomeTipo;
		}
		
		/**
		 * Exibe Todas as Opções Formatadas em String.
		 */
		public static void exibirOpcoes() {
			for (TipoCarro tipoCarro : TipoCarro.values()) {
				System.out.println(tipoCarro.getNumOpcao() + " - " + tipoCarro.getNomeTipo());
			}
		}
		
		/**
		 * Pesquisa no Enumerodo a Opção desejada pelo Usuário.
		 * 
		 * @param opcao O Numero do Tipo de Carro desejado no Menu
		 * @return Retorna o Nome do Tipo de Carro Escolhido, se não Lança um Excessão.
		 * 
		 * @throws IllegalArgumentException Caso Digite uma Opção Incorreta.
		 */
		public static String pesquisarOpcao(int opcao) {
			
			for (TipoCarro tipoCarro : TipoCarro.values()) {
				if(opcao == tipoCarro.getNumOpcao())
					return tipoCarro.getNomeTipo();
			} 
			
			throw new IllegalArgumentException("Opção Incorreta");
		}
	}
	
	public enum TipoMoto{	
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
		 * Construtor com todos os parâmentros
		 * 
		 * @param numOpcao O Numero do Tipo do Motor desejado no Menu
		 * @param nomeTipo O Nome do Tipo do Motor desejado no Menu
		 */
		private TipoMoto(int numOpcao, String nomeTipo) {
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
		public String getNomeTipo() {
			return nomeTipo;
		}
		
		/**
		 * Exibe Todas as Opções Formatadas em String.
		 */
		public static void exibirOpcoes() {
			for (TipoMoto tipoMoto : TipoMoto.values()) {
				System.out.println(tipoMoto.getNumOpcao() + " - " + tipoMoto.getNomeTipo());
			}
		}
		
		/**
		 * Pesquisa no Enumerodo a Opção desejada pelo Usuário.
		 * 
		 * @param opcao O Numero do Tipo do Motor desejado no Menu
		 * @return Retorna o Nome do Tipo do Motor Escolhido, se não Lança um Excessão.
		 * 
		 * @throws IllegalArgumentException Caso Digite uma Opção Incorreta.
		 */
		public static String pesquisarOpcao(int opcao) {
			
			for (TipoMoto tipoMoto : TipoMoto.values()) {
				if(opcao == tipoMoto.getNumOpcao())
					return tipoMoto.getNomeTipo();
			} 
			
			throw new IllegalArgumentException("Opção Incorreta");
		}
	}

	public enum Cor {	
		PRETO(1, "Preto"),
		PRATA(2, "Prata"),
		BRANCO(3, "Branco"),
		VERMELHO(4, "Vermelho"),
		AMARELO(5, "Amarelo"),
		AZUL(6, "Azul"),
		VERDE(7, "Verde"),
		CHUMBO(8, "Chumbo"),
		CAMPAGNE(9, "Champagne");
		
		private int numOpcao;
		private String nomeCor;
		
		/**
		 * Construtor com todos os parâmentros
		 * 
		 * @param numOpcao O Numero da Cor desejada no Menu
		 * @param nomeCor O Nome da Cor desejada no Menu
		 */
		private Cor(int numOpcao, String nomeCor) {
			this.numOpcao = numOpcao;
			this.nomeCor = nomeCor;
		}
		
		/**
		 * @return Retorna o numero da opcao
		 */
		public int getNumOpcao() {
			return numOpcao;
		}
		
		/**
		 * @return Retorna o nome da cor
		 */
		public String getNomeCor() {
			return nomeCor;
		}
		
		/**
		 * Exibe Todas as Opções Formatadas em String.
		 */
		public static void exibirOpcoes() {
			for (Cor cor : Cor.values()) {
				System.out.println(cor.getNumOpcao() + " - " + cor.getNomeCor());
			}
		}
		
		/**
		 * Pesquisa no Enumerodo a Opção desejada pelo Usuário.
		 * 
		 * @param opcao O Numero da Cor desejada no Menu
		 * @return Retorna o Nome da Cor Escolhida, se não Lança um Excessão.
		 * 
		 * @throws IllegalArgumentException Caso Digite uma Opção Incorreta.
		 */
		public static String pesquisarOpcao(int opcao) {
			
			for (Cor cor : Cor.values()) {
				if(opcao == cor.getNumOpcao())
					return cor.getNomeCor();
			} 
			
			throw new IllegalArgumentException("Opção Incorreta");
		}
	}

	public enum Cambio {
		CVT(1, "CVT"),
		AUTOMATICO(2, "Automático"),
		MANUAL_COMUM(3, "Manual Comum"),
		AUTOMATIZADO(4, "Automatizado");
		
		private int numOpcao;
		private String nomeCambio;
		
		/**
		 * Construtor com todos os parâmentros
		 * 
		 * @param numOpcao O Numero do Cambio desejado no Menu
		 * @param nomeCambio O Nome do Cambio desejado no Menu
		 */
		private Cambio(int numOpcao, String nomeCambio) {
			this.numOpcao = numOpcao;
			this.nomeCambio = nomeCambio;
		}
		
		/**
		 * @return Retorna o numero da opcao
		 */
		public int getNumOpcao() {
			return numOpcao;
		}
		
		/**
		 * @return Retorna o nome do cambio
		 */
		public String getNomeCambio() {
			return nomeCambio;
		}
		
		/**
		 * Exibe Todas as Opções Formatadas em String.
		 */
		public static void exibirOpcoes() {
			for (Cambio cambio : Cambio.values()) {
				System.out.println(cambio.getNumOpcao() + " - " + cambio.getNomeCambio());
			}
		}
		
		/**
		 * Pesquisa no Enumerodo a Opção desejada pelo Usuário.
		 * 
		 * @param opcao O Numero do Cambio desejado no Menu
		 * @return Retorna o Nome do Cambio Escolhido, se não Lança um Excessão.
		 * 
		 * @throws IllegalArgumentException Caso Digite uma Opção Incorreta.
		 */
		public static String pesquisarOpcao(int opcao) {
			
			for (Cambio cambio : Cambio.values()) {
				if(opcao == cambio.getNumOpcao())
					return cambio.getNomeCambio();
			} 
			
			throw new IllegalArgumentException("Opção Incorreta");
		}
	}

	public enum Cilindrada {
		CEM(1, 100),
		CENTO_E_CINQUENTA(2, 150),
		DUZENTOS_E_CINQUENTA(3, 250),
		TREZENTAS(4, 300),
		QUATROCENTAS(5, 400),
		QUINHENTAS(6, 500),
		SEISCENTAS(7, 600),
		SETECENTOS_E_CINQUENTA(8, 750),
		MIL(9, 1000);
		
		private int numOpcao;
		private int numCilindradas;
		
		/**
		 * Construtor com todos os parâmentros
		 * 
		 * @param numOpcao O Numero da Cilindrada desejada no Menu
		 * @param numCilindradas O Numero da Cilindrada Formatada desejada no Menu
		 */
		private Cilindrada(int numOpcao, int numCilindradas) {
			this.numOpcao = numOpcao;
			this.numCilindradas = numCilindradas;
		}
		
		/**
		 * @return Retorna o numero da opcao
		 */
		public int getNumOpcao() {
			return numOpcao;
		}
		
		/**
		 * @return Retorna o numero das cilindradas
		 */
		public int getNumCilindradas() {
			return numCilindradas;
		}
		
		/**
		 * Exibe Todas as Opções Formatadas em String.
		 */
		public static void exibirOpcoes() {
			for (Cilindrada cilindrada : Cilindrada.values()) {
				System.out.println(cilindrada.getNumOpcao() + " - " + cilindrada.getNumCilindradas());
			}
		}
		
		/**
		 * Pesquisa no Enumerodo a Opção desejada pelo Usuário.
		 * 
		 * @param opcao O Numero da Cilindrada desejada no Menu
		 * @return Retorna o Nome da Cilindrada Escolhida, se não Lança um Excessão.
		 * 
		 * @throws IllegalArgumentException Caso Digite uma Opção Incorreta.
		 */
		public static int pesquisarOpcao(int opcao) {
			
			for (Cilindrada cilindrada : Cilindrada.values()) {
				if(opcao == cilindrada.getNumOpcao())
					return cilindrada.getNumCilindradas();
			} 
			
			throw new IllegalArgumentException("Opção Incorreta");
		}
	}

}
