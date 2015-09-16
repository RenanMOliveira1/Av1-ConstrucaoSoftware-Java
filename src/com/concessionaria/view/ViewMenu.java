package com.concessionaria.view;

import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;

import com.concessionaria.admin.Loja;
import com.concessionaria.admin.Veiculo;

public class ViewMenu extends View {
	public static final int ADICIONAR_VEICULO = 1;
	public static final int PESQUISAR_VEICULO = 2;
	public static final int BUSCAR_VEICULO = 3;
	public static final int REMOVER_VEICULO = 4;
	public static final int LISTAR_ESTOQUE_VEICULO = 5;
	public static final int SAIR = 0;
	
	private Loja loja;
	
	public ViewMenu() {
		input = new Scanner(System.in);
		loja = new Loja();
	}
	
	public void menuPrincipal() {
		Veiculo veiculoTemporario = null;
		String chassiTemporario = null;
	
		int opcaoMenuPrincipal;
		boolean sair = false;
		while (!sair) {
			opcaoMenuPrincipal = exibirOpcoesPrincipais();
			
			switch (opcaoMenuPrincipal) {
				case ADICIONAR_VEICULO:
					opcaoAdicionarVeiculo();
				break;
				case PESQUISAR_VEICULO:
					opcaoPesquisarVeiculo();
				break;
				case BUSCAR_VEICULO:
					opcaoBuscarVeiculo(veiculoTemporario, chassiTemporario);
				break;
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
					System.out.println("Opção Inválida.");
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
		
		if (!this.estoqueVazio(loja)) {
			ViewPesquisar viewPesquisar = new ViewPesquisar();
			Map<String, String> novasEspecificacoes = viewPesquisar.pesquisarVeiculos(loja);
			HashSet<Veiculo> veiculosEncontrados = loja.pesquisarVeiculo(novasEspecificacoes);
			
			if (veiculosEncontrados.size() == 0)
				System.out.println("Nenhum Veículo Encontrado.");
			else {
				System.out.println("\nVeículos Encontrados: \n");
				for (Veiculo v : veiculosEncontrados) {
					System.out.println(v.toString());
				}
			}
		}
	}
	
	private void opcaoBuscarVeiculo(Veiculo veiculoEncontrado, String chassi) {
		System.out.println("|         Buscar Veiculo Selecionado         |");
		
		if (!estoqueVazio(loja)) {
			chassi = validarCampoString("Entre com o Chassi: ", "Chassi: Dados Inválidos.");
			veiculoEncontrado = loja.buscarVeiculo(chassi);
			
			if (veiculoEncontrado != null)
				System.out.println(veiculoEncontrado.toString());
			else
				System.out.println("Veículo não Encontrado.");
		}
	}
	
	private void opcaoRemoverVeiculo(String chassi) {
		System.out.println("|   Remover Veiculo do Estoque Selecionado    |");
		
		if (!estoqueVazio(loja)) {
			chassi = validarCampoString("Entre com o Chassi: ", "Chassi: Dados Inválidos.");
			if (loja.removerVeiculo(chassi))
				System.out.println("Veículo Removido Com Sucesso.");
			else
				System.out.println("Veículo não Encontrado");
		}
	}
	
	private void opcaoListarEstoqueVeiculo() {
		System.out.println("|   Listar Estoque de Veiculos Selecionado    |");
		
		if (!this.estoqueVazio(loja))
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
		
		return validarCampoInteiro("Entre com a Opção: ", "Só se Aceita Inteiros");
	}
}
