package com.concessionaria.executavel;

import java.util.ArrayList;
import java.util.Scanner;

import com.concessionaria.adminstracao.Loja;
import com.concessionaria.veiculos.Carro;
import com.concessionaria.veiculos.Motocicleta;

/**
 * 
 * @author Yasmin
 *
 */

public class Menu {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		Loja concessionaria = new Loja();
		int opcaoEscolhida;
		boolean sair = false;

		while(!sair) {
			System.out.println("===========================================");
			System.out.println("|        Bem-vindo a Concessionaria        |");
			System.out.println("===========================================");
			System.out.println("|    Opcoes:                               |");
			System.out.println("|        1. Adicionar Carro                |");
			System.out.println("|        2. Adicionar Moto                 |");
			System.out.println("|        3. Pesquisar Carro                |");
			System.out.println("|        4. Pesquisar Moto                 |");
			System.out.println("|        5. Buscar Carro                   |");
			System.out.println("|        6. Buscar Moto                    |");
			System.out.println("|        7. Remover Carro                  |");
			System.out.println("|        8. Remover Moto                   |");
			System.out.println("|        9. Listar Estoque de Carros       |");
			System.out.println("|        10. Listar Estoque de Motos       |");			
			System.out.println("|        0. Sair                           |");
			System.out.println("===========================================");
			
			/**
			 * @see EntradaDeDado
			 * 
			 * Faz referencia a classe abaixo
			 */
			opcaoEscolhida = EntradaDeDado.tipoInt(" Selecione sua opcao: ");

			switch (opcaoEscolhida) {
			case 1:
				System.out.println("|        Adicionar Carro Selecionado       |");
				if (concessionaria.adicionarCarro())
					System.out.println("\nCarro Adicionado!\n");
				else
					System.out.println("\nHouve um Problema no Cadastro.\n");
				break;
			case 2:
				System.out.println("|         Adicionar Moto Selecionado       |");
				if (concessionaria.adicionarMotocicleta())
					System.out.println("\nMotocicleta Adicionado!\n");
				else
					System.out.println("\nHouve um Problema no Cadastro.\n");
				break;
			case 3:
				System.out.println("|        Pesquisar Carro Selecionado       |");
				ArrayList<Carro> searchResultCar = concessionaria.pesquisaCarro();
				concessionaria.listarArrayCarro(searchResultCar);
				break;
			case 4:
				System.out.println("|       Pesquisar Moto Seleciondado        |");
				ArrayList<Motocicleta> searchResultMoto = concessionaria.pesquisaMotocicleta();
				concessionaria.listarArrayMotocicleta(searchResultMoto);
				break;
			case 5:
				System.out.println("|         Buscar Carro Selecionado         |");
				System.out.println(" Entre com o chassi: ");
				String chassiCarro = EntradaDeDado.tipoString();
				Carro carroSelecionado = concessionaria.buscarCarro(chassiCarro);
				if (carroSelecionado != null)
					concessionaria.listarCarro(carroSelecionado);
				else
					System.out.println("\nCarro não Encontrado.\n");
				break;
			case 6:
				System.out.println("|          Buscar Moto  Selecionado         |");
				System.out.println(" Entre com o chassi: ");
				String chassiMoto = EntradaDeDado.tipoString();
				Motocicleta motocicletaSelecionada = concessionaria.buscarMoto(chassiMoto);
				if (motocicletaSelecionada != null)
					concessionaria.listarMotocicleta(motocicletaSelecionada);
				else
					System.out.println("\nMoto não Encontrada.\n");
				break;
			case 7:
				System.out.println("|   Remover Carro do Estoque Selecionado    |");
				System.out.println(" Entre com o chassi: ");
				String chassiCarroSelecionado = EntradaDeDado.tipoString();
				if (concessionaria.removerCarro(chassiCarroSelecionado))
					System.out.println("\nCarro Removido!\n");
				else
					System.out.println("\nHouve um Problema na Remocao do Veiculo.\n");
				break;
			case 8:
				System.out.println("|    Remover Moto do Estoque Selecinado     |");
				System.out.println(" Entre com o chassi: ");
				String chassiMotoSelecionado = EntradaDeDado.tipoString();
				if (concessionaria.removerMotocicleta(chassiMotoSelecionado))
					System.out.println("\nMoto Removida!\n");
				else
					System.out.println("\nHouve um Problema na Remocao do Veiculo.\n");
				break;
			case 9:
				System.out.println("|   Listar Estoque de Carros Selecionado    |");
				concessionaria.listarEstoqueCarro();
				break;
			case 10:
				System.out.println("|    Listar Estoque de Motos Selecionado    |");
				concessionaria.listarEstoqueMotocicleta();
				break;
			case 0:
				System.out.println("|             Saida Selecionada             |");
				sair = true;
				break;
			default:
				System.out.println("Opcao Invalida!!");
			}
			
			if(!sair) {
				System.out.print(" Tecle ENTER para continuar... ");
				input.nextLine();
			}
		}
	}
}

class EntradaDeDado {
	/**
	 * @param mensagem
	 * 
	 * Imprime mensagem
	 */
	public static void imprimeMensagem(String mensagem) {
		System.out.print(mensagem + " ");
		System.out.flush();
	}

	public static String tipoString() {
		
		int letra;
		String palavra = "";
		boolean leituraAcabada = false;

		/**
		 * le a entrada e adiciona letra por letra ate que leituraAcabada for true
		 */
		while (!leituraAcabada) {
			try {
				letra = System.in.read();
				if (letra < 0 || (char) letra == '\n')
					leituraAcabada = true;
				else if ((char) letra != '\r')
					palavra = palavra + (char) letra; // Enter into string
			}

			catch (java.io.IOException e) {
				System.out.println("ATENCAO: Erro na Entrada de Dados");
				leituraAcabada = true;
			}
		}
		return palavra;
	}
	
	public static void leInt() {
		int entrada;

		try {
			while ((System.in.available()) != 0)
				entrada = System.in.read();
		} catch (java.io.IOException e) {
			System.out.println("Input contem algum erro");
		}
	}

	/**
	 * 
	 * @param mensagem
	 * @return retorna o numero que foi imputado
	 */
	public static int tipoInt(String mensagem) {
		while (true) {
			leInt();
			imprimeMensagem(mensagem);
			try {
				return Integer.valueOf(tipoString().trim()).intValue();
			}

			catch (NumberFormatException e) {
				System.out.println("Nao eh um inteiro!");
			}
		}
	}

}

