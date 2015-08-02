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
			System.out.println("|        7. Remover Carro                 |");
			System.out.println("|        8. Remover Moto                 |");
			System.out.println("|        9. Listar Estoque de Carros       |");
			System.out.println("|        10. Listar Estoque de Motos        |");
			System.out.println("|        11. Sair                          |");
			System.out.println("===========================================");
			opcaoEscolhida = Keyin.inInt(" Selecione sua opcao: ");

			switch (opcaoEscolhida) {
			case 1:
				System.out.println("|       Adicionar Carro Selecionado       |");
				if (concessionaria.adicionarCarro())
					System.out.println("\nCarro Adicionado!\n");
				else
					System.out.println("\nHouve um Problema no Cadastro.\n");
				break;
			case 2:
				System.out.println("|        Adicionar Moto Selecionado       |");
				if (concessionaria.adicionarMotocicleta())
					System.out.println("\nMotocicleta Adicionado!\n");
				else
					System.out.println("\nHouve um Problema no Cadastro.\n");
				break;
			case 3:
				System.out.println("|       Pesquisar Carro Selecionado       |");
				ArrayList<Carro> searchResultCar = concessionaria.pesquisaCarro();
				concessionaria.listarArrayCarro(searchResultCar);
				break;
			case 4:
				System.out.println("|      Pesquisar Moto Seleciondado      |");
				ArrayList<Motocicleta> searchResultMoto = concessionaria.pesquisaMotocicleta();
				concessionaria.listarArrayMotoicleta(searchResultMoto);
				break;
			case 5:
				System.out.println("|        Buscar Carro Selecionado       |");
				System.out.println(" Entre com o chassi: ");
				String chassiCarro = Keyin.inString();
				Carro carroSelecionado = concessionaria.buscarCarro(chassiCarro);
				concessionaria.listarCarro(carroSelecionado);
				break;
			case 6:
				System.out.println("|         Buscar Moto  Selecionado       |");
				System.out.println(" Entre com o chassi: ");
				String chassiMoto = Keyin.inString();
				Motocicleta motocicletaSelecionada = concessionaria.buscarMoto(chassiMoto);
				concessionaria.listarMotocicleta(motocicletaSelecionada);
				break;
			case 7:
				System.out.println("|  Remover Carro do Estoque   |");
				System.out.println(" Entre com o chassi: ");
				String chassiCarroSelecionado = Keyin.inString();
				if (concessionaria.removerCarro(chassiCarroSelecionado))
					System.out.println("\nCarro Removido!\n");
				else
					System.out.println("\nHouve um Problema na Remocao do Veiculo.\n");
				break;
			case 8:
				System.out.println("|  Remover Moto do Estoque   |");
				System.out.println(" Entre com o chassi: ");
				String chassiMotoSelecionado = Keyin.inString();
				if (concessionaria.removerMotocicleta(chassiMotoSelecionado))
					System.out.println("\nMoto Removida!\n");
				else
					System.out.println("\nHouve um Problema na Remocao do Veiculo.\n");
				break;
			case 9:
				System.out.println("|  Listar Estoque de Carros Selecionado   |");
				concessionaria.listarEstoqueCarro();
				break;
			case 10:
				System.out.println("|   Listar Estoque de Motos Selecionado   |");
				concessionaria.listarEstoqueMotocicleta();
				break;
			case 11:
				System.out.println("|            Saida Selecionada             |");
				sair = true;
				break;
			default:
				System.out.println("Opcao Invalida!!");
			}
		}
	}
}

class Keyin {
	public static void imprimirMensagem(String mensagem) {
		System.out.print(mensagem + " ");
		System.out.flush();
	}

	public static void inputFlush() {
		int dummy;

		try {
			while ((System.in.available()) != 0)
				dummy = System.in.read();
		} catch (java.io.IOException e) {
			System.out.println("Input error");
		}
	}

	public static String inString() {
		int aChar;
		String s = "";
		boolean finished = false;

		while (!finished) {
			try {
				aChar = System.in.read();
				if (aChar < 0 || (char) aChar == '\n')
					finished = true;
				else if ((char) aChar != '\r')
					s = s + (char) aChar; // Enter into string
			}

			catch (java.io.IOException e) {
				System.out.println("Input error");
				finished = true;
			}
		}
		return s;
	}

	public static int inInt(String mensagem) {
		while (true) {
			inputFlush();
			imprimirMensagem(mensagem);
			try {
				return Integer.valueOf(inString().trim()).intValue();
			}

			catch (NumberFormatException e) {
				System.out.println("Nao eh um inteiro!");
			}
		}
	}

}

