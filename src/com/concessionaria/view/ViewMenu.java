/**
 * Copyright (c) 2015 GEC5
 * Todos os direitos reservados.
 * 
 * N�O ALTERE OU REMOVA AS INFORMA��ES DE COPYRIGHT
 * OU INFORMA��ES CONTIDAS NESTE HEADER
 * 
 */
package com.concessionaria.view;

import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;

import com.concessionaria.admin.Loja;
import com.concessionaria.admin.Veiculo;
import com.concessionaria.enumerados.TipoVeiculo;
import com.concessionaria.excessoes.EstoqueVazioException;

/**
 * 
 * Classe para exibi��o do menu e seus m�todos.
 * 
 * Classe <code>ViewMenu<code>.
 * 
 * @author Tiago Henrique
 * @author Yasmin Farias
 * @author Renan Oliveira
 * 
 * @see View
 * @version 2.0 (18/09/2015)
 *
 */
public class ViewMenu extends View {
	public static final int ADICIONAR_VEICULO = 1;
	public static final int PESQUISAR_VEICULO = 2;
	public static final int BUSCAR_VEICULO = 3;
	public static final int REMOVER_VEICULO = 4;
	public static final int LISTAR_ESTOQUE_VEICULO = 5;
	public static final int SALVAR_ESTOQUE = 6;
	public static final int RECUPERAR_ESTOQUE = 7;
	public static final int SAIR = 0;
	
	private Loja loja;
	
	public ViewMenu() {
		input = new Scanner(System.in);
		loja = new Loja();
	}
	
	/**
	 * Exibe o Menu Principal com todas as Op��es da Concessionaria.
	 * 
	 */
	public void menuPrincipal() {
		Veiculo veiculoTemporario = null;
		String chassiTemporario = null;
		int opcaoMenuPrincipal;
		boolean sair = false;
		
		/*
		 * 
		 */
		while (!sair) {
			opcaoMenuPrincipal = lerOpcaoMenuPrincipal();
			
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
				case SALVAR_ESTOQUE:
					opcaoSalvarEstoqueVeiculo();
				break;
				case RECUPERAR_ESTOQUE:
					opcaoRecuperarEstoqueVeiculo();
				break;
				case SAIR:
					sair = true;
				break;
				default:
					System.out.println("Op��o Inv�lida.");
			}
		}
	}
	
	/**
	 * Op��o do Menu Adicionar Ve�culo.
	 */
	private void opcaoAdicionarVeiculo() {
		System.out.println("|        Adicionar Veiculo Selecionado       |");
		
		ViewCadastro viewCadastro = new ViewCadastro();
		Veiculo veiculo = viewCadastro.cadastrarVeiculo(loja);
		
		if (loja.adicionarVeiculo(veiculo))
			System.out.println("Ve�culo Adicionado com Sucesso");
		else
			System.err.println("Ve�culo n�o Cadastrado, Tente Novamente.");
	}
	
	/**
	 * Op��o do Menu de Pesquisar Ve�culo.
	 */
	private void opcaoPesquisarVeiculo() {
		System.out.println("|        Pesquisar Veiculo Selecionado       |");
		
		if (!this.estoqueVazio(loja)) {
			ViewPesquisar viewPesquisar = new ViewPesquisar();
			Map<String, String> novasEspecificacoes = viewPesquisar.pesquisarVeiculos(loja);
			HashSet<Veiculo> veiculosEncontrados = loja.pesquisarVeiculo(novasEspecificacoes);
			
			if (veiculosEncontrados.size() == 0)
				System.err.println("Nenhum Ve�culo Encontrado.");
			else {
				System.out.println("\nVe�culos Encontrados: \n");
				
				for (Veiculo v : veiculosEncontrados) 
					System.out.println(v.toString());
			}
		}
	}
	
	/**
	 * 
	 * Op��o Buscar Ve�culo no Estoque.
	 * 
	 * @param veiculoEncontrado Ve�culo Tempor�rio para Fazer Opera��es.
	 * @param chassi Chassi Tempor�rio para Fazer Opera��es.
	 */
	private void opcaoBuscarVeiculo(Veiculo veiculoEncontrado, String chassi) {
		System.out.println("|         Buscar Veiculo Selecionado         |");
		
		if (!estoqueVazio(loja)) {
			chassi = validarCampoString("Entre com o Chassi: ", "Chassi: Dados Inv�lidos.");
			veiculoEncontrado = loja.buscarVeiculo(chassi);
			
			if (veiculoEncontrado != null)
				System.out.println(veiculoEncontrado.toString());
			else
				System.err.println("Ve�culo n�o Encontrado.");
		}
	}
	
	/**
	 * 
	 * Op��o Remover do Menu.
	 * 
	 * @param chassi Chassi Tempor�rio para Fazer Opera��es.
	 */
	private void opcaoRemoverVeiculo(String chassi) {
		System.out.println("|   Remover Veiculo do Estoque Selecionado    |");
		
		if (!estoqueVazio(loja)) {
			chassi = validarCampoString("Entre com o Chassi: ", "Chassi: Dados Inv�lidos.");
			if (loja.removerVeiculo(chassi))
				System.out.println("Ve�culo Removido Com Sucesso.");
			else
				System.err.println("Ve�culo n�o Encontrado");
		}
	}
	
	/**
	 * Op��o de Listar Estoque.
	 */
	private void opcaoListarEstoqueVeiculo() {
		System.out.println("|   Listar Estoque de Veiculos Selecionado    |");
		
		if (!this.estoqueVazio(loja)) {
			TipoVeiculo.exibirOpcoes();
			int opcao = this.validarOpcao("Entre com o Tipo de Ve�culo: ", "Tipo de Ve�culo Inv�lido", 1, TipoVeiculo.values().length);
			String estoque = null;
			
			try {
				estoque = loja.listarEstoque(TipoVeiculo.getOpcao(opcao));
				if (estoque == "")
					throw new EstoqueVazioException("Estoque de Ve�culos est� Vazio.");
			} catch (EstoqueVazioException e) {
				System.err.println("N�o h� Ve�culos Desse Tipo Cadastrado.");
			}
		}
	}
	
	/**
	 * Op��o de Salvar Estoque de Ve�culos
	 */
	private void opcaoSalvarEstoqueVeiculo() {
		System.out.println("|        Salvar Estoque de Ve�culos Selecionado       |");
		
		if (!estoqueVazio(loja)) {
			TipoVeiculo.exibirOpcoes();
			int opcao = this.validarOpcao("Entre com o Tipo de Ve�culo: ", "Tipo de Ve�culo Inv�lido", 1, TipoVeiculo.values().length);
			
			loja.salvarEstoque(TipoVeiculo.getOpcao(opcao));
		}
	}
	
	/**
	 * Op��o de Recuperar Estoque de Ve�culos.
	 */
	private void opcaoRecuperarEstoqueVeiculo() {
		System.out.println("|        Recuperar Estoque de Ve�culos Selecionado       |");
		
		if (!estoqueVazio(loja)) {
			TipoVeiculo.exibirOpcoes();
			int opcao = this.validarOpcao("Entre com o Tipo de Ve�culo: ", "Tipo de Ve�culo Inv�lido", 1, TipoVeiculo.values().length);
			
			loja.recuperarEstoque(TipoVeiculo.getOpcao(opcao));
		}
	}
	
	/**
	 * 
	 * Exibe as Principais Op��es do Menu e Retorna um Op��o do mesmo.
	 * 
	 * @return Retorna o Inteiro referente a Op��o.
	 */
	private int lerOpcaoMenuPrincipal() {
		System.out.println("===========================================");
		System.out.println("|        Bem-vindo a Concessionaria        |");
		System.out.println("===========================================");
		System.out.println("|    Opcoes:                               |");
		System.out.println("|        1. Adicionar Veiculo              |");
		System.out.println("|        2. Pesquisar Veiculo              |");
		System.out.println("|        3. Buscar Veiculo                 |");
		System.out.println("|        4. Remover Veiculo                |");
		System.out.println("|        5. Listar Estoque de Veiculo      |");	
		System.out.println("|        6. Salvar Estoque de Veiculo      |");	
		System.out.println("|        7. Recuperar Estoque de Veiculo      |");	
		System.out.println("|        0. Sair                           |");
		System.out.println("===========================================");
		
		/*
		 * 
		 */
		return validarCampoInteiro("Entre com a Op��o: ", "S� se Aceita Inteiros");
	}
}
