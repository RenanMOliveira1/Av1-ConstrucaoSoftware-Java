package com.concessionaria.view;

import java.util.Map;
import java.util.Scanner;

import com.concessionaria.admin.Loja;
import com.concessionaria.admin.Veiculo;

public class ViewMenu {
	public static final int ADICIONAR_VEICULO = 1;
	public static final int PESQUISAR_VEICULO = 2;
	public static final int BUSCAR_VEICULO = 3;
	public static final int REMOVER_VEICULO = 4;
	public static final int LISTAR_ESTOQUE_VEICULO = 5;
	public static final int SAIR = 0;
	
	private Scanner input;
	private Loja loja;
	
	public ViewMenu() {
		input = new Scanner(System.in);
		loja = new Loja();
	}
	
	public void menuPrincipal() {
		Veiculo veiculoTemporario = null;
		String chassiTemporario = null;
	
		int n;
		boolean sair = false;
		while (!sair) {
			n = exibirOpcoesPrincipais();
			
			switch (n) {
				case ADICIONAR_VEICULO:
					opcaoAdicionarVeiculo();
				break;
				case PESQUISAR_VEICULO:
					opcaoPesquisarVeiculo();
				break;
				case BUSCAR_VEICULO:
					opcaoBuscarVeiculo(veiculoTemporario, chassiTemporario);
				case REMOVER_VEICULO:
					opcaoRemoverVeiculo(chassiTemporario);
					break;
				case LISTAR_ESTOQUE_VEICULO:
					opcaoListarEstoqueVeiculo();
					break;
				case SAIR:
					sair = true;
				break;
				default:
					System.out.println("Inválido.");
			}
		}
	}
	
	private void opcaoAdicionarVeiculo() {
		System.out.println("|        Adicionar Veiculo Selecionado       |");
		ViewCadastro viewCadastro = new ViewCadastro();
		Veiculo veiculo = viewCadastro.cadastrarVeiculo(loja);
		loja.adicionarVeiculo(veiculo);
	}
	
	private void opcaoPesquisarVeiculo() {
		System.out.println("|        Pesquisar Veiculo Selecionado       |");
		ViewPesquisar viewPesquisar = new ViewPesquisar();
		Map<String, String> novasEspecificacoes = viewPesquisar.pesquisarVeiculos(loja);
		loja.pesquisarVeiculo(novasEspecificacoes);
	}
	
	private void opcaoBuscarVeiculo(Veiculo veiculoEncontrado, String chassi) {
		System.out.println("|         Buscar Veiculo Selecionado         |");
		System.out.println("Entre com o Chassi: ");
		chassi = input.next();
		veiculoEncontrado = loja.buscarVeiculo(chassi);
		System.out.println(veiculoEncontrado.toString());
	}
	
	private void opcaoRemoverVeiculo(String chassi) {
		System.out.println("|   Remover Veiculo do Estoque Selecionado    |");
		System.out.println("Entre com o Chassi: ");
		chassi = input.next();
		loja.removerVeiculo(chassi);
	}
	
	private void opcaoListarEstoqueVeiculo() {
		System.out.println("|   Listar Estoque de Veiculos Selecionado    |");
		loja.listarEstoque();
	}
	
	private int exibirOpcoesPrincipais() {
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
		return input.nextInt();
	}
}
