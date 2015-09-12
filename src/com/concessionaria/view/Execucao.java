package com.concessionaria.view;
import java.util.Scanner;

import com.concessionaria.admin.Loja;
import com.concessionaria.admin.Veiculo;

public class Execucao {
	public static final int ADICIONAR_VEICULO = 1;
	public static final int PESQUISAR_VEICULO = 2;
	public static final int BUSCAR_VEICULO = 3;
	public static final int REMOVER_VEICULO = 4;
	public static final int LISTAR_ESTOQUE_VEICULO = 5;
	public static final int SAIR = 0;
	
	public static void main(String[] args) {
		
		Loja loja = new Loja();
		Veiculo veiculoTemporario;
		String chassiTemporario;
		ViewCadastro viewCadastro = new ViewCadastro();
		
		Scanner input = new Scanner(System.in);
		int n;
		boolean sair = false;
		while (!sair) {
			System.out.println("===========================================");
			System.out.println("|        Bem-vindo a Concessionaria        |");
			System.out.println("===========================================");
			System.out.println("|    Opcoes:                               |");
			System.out.println("|        1. Adicionar Veiculo              |");
			System.out.println("|        2. Pesquisar Veiculo              |");
			System.out.println("|        3. Buscar Veiculo                 |");
			System.out.println("|        4. Remover Veiculo                |");
			System.out.println("|        5. Listar Estoque de Veiculo      |");	
			System.out.println("|        0. Sair                           |");
			System.out.println("===========================================");
			
			System.out.print("Entre com a Opção: ");
			n = input.nextInt();
			switch (n) {
				case ADICIONAR_VEICULO:
					System.out.println("|        Adicionar Veiculo Selecionado       |");
					Veiculo veiculo = viewCadastro.cadastrarVeiculo(loja);
					loja.adicionarVeiculo(veiculo);
				break;
				case PESQUISAR_VEICULO:
					System.out.println("|        Pesquisar Veiculo Selecionado       |");
					
				break;
				case BUSCAR_VEICULO:
					System.out.println("|         Buscar Veiculo Selecionado         |");
					System.out.println("Entre com o Chassi: ");
					chassiTemporario = input.next();
					veiculoTemporario = loja.buscarVeiculo(chassiTemporario);
					System.out.println(veiculoTemporario.toString());
				case REMOVER_VEICULO:
					System.out.println("|   Remover Veiculo do Estoque Selecionado    |");
					System.out.println("Entre com o Chassi: ");
					chassiTemporario = input.next();
					loja.removerVeiculo(chassiTemporario);
					break;
				case LISTAR_ESTOQUE_VEICULO:
					System.out.println("|   Listar Estoque de Veiculos Selecionado    |");
					loja.listarEstoque();
					break;
				case SAIR:
					sair = true;
				break;
				default:
					System.out.println("Inválido.");
			}
		}
	}
}
