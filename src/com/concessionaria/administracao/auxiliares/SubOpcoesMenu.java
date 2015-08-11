package com.concessionaria.administracao.auxiliares;


/**
 * @author Yasmin
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
		
		public static void exibirOpcoes() {
			for (Montadora montadora : Montadora.values()) {
				System.out.println("*Digite " + montadora.getNumOpcao() + " para escolher " + montadora.getNomeMontadora());
			}
		}
		
		public static String pesquisarOpcao(int opcao) {
			
			for (Montadora montadora : Montadora.values()) {
				if(opcao == montadora.getNumOpcao())
					return montadora.getNomeMontadora();
			} 
			
			return null;
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
		public String getNomeTipo() {
			return nomeTipo;
		}
		
		/**
		 * Percorre todos os valores de TipoCarro e recebe seus valores em "tipoCarro" na ordem, imprimindo as opcoes
		 */
		public static void exibirOpcoes() {
			for (TipoCarro tipoCarro : TipoCarro.values()) {
				System.out.println("*Digite " + tipoCarro.getNumOpcao() + " para escolher " + tipoCarro.getNomeTipo());
			}
		}
		
		public static String pesquisarOpcao(int opcao) {
			
			for (TipoCarro tipoCarro : TipoCarro.values()) {
				if(opcao == tipoCarro.getNumOpcao())
					return tipoCarro.getNomeTipo();
			} 
			
			return null;
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
		 * @param numOpcao
		 * @param nomeTipo
		 * 
		 * Construtor com todos os parâmentros
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
		
		public static void exibirOpcoes() {
			for (TipoMoto tipoMoto : TipoMoto.values()) {
				System.out.println("*Digite " + tipoMoto.getNumOpcao() + " para escolher " + tipoMoto.getNomeTipo());
			}
		}
		
		public static String pesquisarOpcao(int opcao) {
			
			for (TipoMoto tipoMoto : TipoMoto.values()) {
				if(opcao == tipoMoto.getNumOpcao())
					return tipoMoto.getNomeTipo();
			} 
			
			return null;
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
		 * @param numOpcao
		 * @param nomeCor
		 * 
		 * Construtor com todos os parâmentros
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
		
		public static void exibirOpcoes() {
			for (Cor cor : Cor.values()) {
				System.out.println("*Digite " + cor.getNumOpcao() + " para escolher " + cor.getNomeCor());
			}
		}
		
		public static String pesquisarOpcao(int opcao) {
			
			for (Cor cor : Cor.values()) {
				if(opcao == cor.getNumOpcao())
					return cor.getNomeCor();
			} 
			
			return null;
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
		 * @param numOpcao
		 * @param nomeCambio
		 * 
		 * Construtor com todos os parâmentros
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
		
		public static void exibirOpcoes() {
			for (Cambio cambio : Cambio.values()) {
				System.out.println("*Digite " + cambio.getNumOpcao() + " para escolher " + cambio.getNomeCambio());
			}
		}
		
		public static String pesquisarOpcao(int opcao) {
			
			for (Cambio cambio : Cambio.values()) {
				if(opcao == cambio.getNumOpcao())
					return cambio.getNomeCambio();
			} 
			
			return null;
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
		 * @param numOpcao
		 * @param numCilindradas
		 * 
		 * Construtor com todos os parâmentros
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
		
		public static void exibirOpcoes() {
			for (Cilindrada cilindrada : Cilindrada.values()) {
				System.out.println("*Digite " + cilindrada.getNumOpcao() + " para escolher " + cilindrada.getNumCilindradas());
			}
		}
		
		public static int pesquisarOpcao(int opcao) {
			
			for (Cilindrada cilindrada : Cilindrada.values()) {
				if(opcao == cilindrada.getNumOpcao())
					return cilindrada.getNumCilindradas();
			} 
			
			return 0;
		}
	}

}
