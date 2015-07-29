package com.concessionaria.adminstracao;


/**
 * @author Yasmin
 *
 */
public class Enum {

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
	}
	
	public enum Motorizacao {
		
		UM_PONTO_ZERO(1, 1.0),
		UM_PONTO_QUATRO(2, 1.4),
		UM_PONTO_SEIS(3, 1.6),
		UM_PONTO_OITO(4, 1.8),
		DOIS_PONTO_ZERO(5, 2.0);
		
		private int numOpcao;
		private double numMotorizacao;
		
		/**
		 * @param numOpcao
		 * @param numMotorizacao
		 * 
		 * Construtor com todos os parâmentros
		 */
		private Motorizacao(int numOpcao, double numMotorizacao) {
			this.numOpcao = numOpcao;
			this.numMotorizacao = numMotorizacao;
		}
		
		/**
		 * @return Retorna o numero da opcao
		 */
		public int getNumOpcao() {
			return numOpcao;
		}
		
		/**
		 * @return Retorna o numero da motorizacao
		 */
		public double getNumMotorizacao() {
			return numMotorizacao;
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
	}

	public enum Cilindrada {
		CENTO_E_CINQUENTA(1, 100),
		DUZENTOS_E_CINQUENTA(1, 250),
		TREZENTAS(2, 300),
		QUATROCENTAS(3, 400),
		QUINHENTAS(4, 500),
		SEISCENTAS(5, 600),
		SETECENTOS_E_CINQUENTA(6, 750),
		MIL(7, 1000);
		
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
	}

}
