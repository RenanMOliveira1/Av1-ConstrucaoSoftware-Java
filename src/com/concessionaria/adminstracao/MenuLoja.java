package com.concessionaria.adminstracao;

import java.util.InputMismatchException;

import com.concessionaria.administracao.auxiliares.EntradaDeDados;
import com.concessionaria.administracao.auxiliares.Tela;
import com.concessionaria.veiculos.Carro;
import com.concessionaria.veiculos.Motocicleta;

/**
 * 
 * @author Yasmin
 * @author Tiago
 *
 */
       
public class MenuLoja {
	private static final int ADICIONAR_CARRO = 1;
	private static final int ADICIONAR_MOTO = 2;
	private static final int PESQUISAR_CARRO = 3;
	private static final int PESQUISAR_MOTO = 4;
	private static final int BUSCAR_CARRO = 5;
	private static final int BUSCAR_MOTO = 6;
	private static final int REMOVER_CARRO = 7;
	private static final int REMOVER_MOTO = 8;
	private static final int LISTAR_ESTOQUE_CARROS = 9;
	private static final int LISTAR_ESTOQUE_MOTOS = 10;
	private static final int SAIR = 0;
	
	private Tela tela;
	private EntradaDeDados entradaDeDado;
	private Loja concessionaria;
	
	public MenuLoja() {
		concessionaria = new Loja();
		tela = new Tela();
		entradaDeDado = new EntradaDeDados();
	}
	
	public void iniciar() {
		boolean sair = false;
		int opcaoEscolhida = 0;
		
		while(!sair) {
			
			try {
				opcaoEscolhida = exibirMenuPrincipal();
			} catch (InputMismatchException stringException) {
				System.err.println("Não se Aceita String: " + stringException.getMessage());
				stringException.printStackTrace();
				System.exit(1);
			}
			
			switch (opcaoEscolhida) {
				case ADICIONAR_CARRO:
					tela.exibirMsgLine("|        Adicionar Carro Selecionado       |");
					concessionaria.adicionarCarro();
					break;
				case ADICIONAR_MOTO:
					tela.exibirMsgLine("|         Adicionar Moto Selecionado       |");
					concessionaria.adicionarMotocicleta();
					break;
				case PESQUISAR_CARRO:
					tela.exibirMsgLine("|        Pesquisar Carro Selecionado       |");
					concessionaria.listarArrayCarro(concessionaria.pesquisaCarro());
					break;
				case PESQUISAR_MOTO:
					tela.exibirMsgLine("|       Pesquisar Moto Seleciondado        |");
					concessionaria.listarArrayMotocicleta(concessionaria.pesquisaMotocicleta());
					break;
				case BUSCAR_CARRO:
					tela.exibirMsgLine("|         Buscar Carro Selecionado         |");
					tela.exibirMsg("Entre com o chassi: ");
					Carro carroSelecionado = concessionaria.buscarCarro(entradaDeDado.getInput());
					
					if (carroSelecionado != null)
						concessionaria.listarCarro(carroSelecionado);
					else
						tela.exibirMsgLine("\nCarro não Encontrado.\n");
					break;
				case BUSCAR_MOTO:
					tela.exibirMsgLine("|          Buscar Moto  Selecionado         |");
					tela.exibirMsg("Entre com o chassi: ");
					Motocicleta motocicletaSelecionada = concessionaria.buscarMoto(entradaDeDado.getInput());
					
					if (motocicletaSelecionada != null)
						concessionaria.listarMotocicleta(motocicletaSelecionada);
					else
						tela.exibirMsgLine("\nMoto não Encontrada.\n");
					break;
				case REMOVER_CARRO:
					tela.exibirMsgLine("|   Remover Carro do Estoque Selecionado    |");
					tela.exibirMsg("Entre com o chassi: ");
					String chassiCarroSelecionado = entradaDeDado.getInputString();
					
					if (concessionaria.removerCarro(chassiCarroSelecionado))
						tela.exibirMsgLine("\nCarro Removido!\n");
					else
						tela.exibirMsgLine("\nHouve um Problema na Remocao do Veiculo.\n");
					break;
				case REMOVER_MOTO:
					tela.exibirMsgLine("|    Remover Moto do Estoque Selecinado     |");
					tela.exibirMsg("Entre com o chassi: ");
					String chassiMotoSelecionado = entradaDeDado.getInputString();
					if (concessionaria.removerMotocicleta(chassiMotoSelecionado))
						tela.exibirMsgLine("\nMoto Removida!\n");
					else
						tela.exibirMsgLine("\nHouve um Problema na Remocao do Veiculo.\n");
					break;
				case LISTAR_ESTOQUE_CARROS:
					tela.exibirMsgLine("|   Listar Estoque de Carros Selecionado    |");
					concessionaria.listarEstoqueCarro();
					break;
				case LISTAR_ESTOQUE_MOTOS:
					tela.exibirMsgLine("|    Listar Estoque de Motos Selecionado    |");
					concessionaria.listarEstoqueMotocicleta();
					break;
				case SAIR:
					tela.exibirMsgLine("|             Saida Selecionada             |");
					sair = true;
					break;
				default:
					tela.exibirMsgLine("Opcao Invalida!!");
				}
		}
	}
	
	private int exibirMenuPrincipal() {
		
		tela.exibirMsgLine("===========================================");
		tela.exibirMsgLine("|        Bem-vindo a Concessionaria        |");
		tela.exibirMsgLine("===========================================");
		tela.exibirMsgLine("|    Opcoes:                               |");
		tela.exibirMsgLine("|        1. Adicionar Carro                |");
		tela.exibirMsgLine("|        2. Adicionar Moto                 |");
		tela.exibirMsgLine("|        3. Pesquisar Carro                |");
		tela.exibirMsgLine("|        4. Pesquisar Moto                 |");
		tela.exibirMsgLine("|        5. Buscar Carro                   |");
		tela.exibirMsgLine("|        6. Buscar Moto                    |");
		tela.exibirMsgLine("|        7. Remover Carro                  |");
		tela.exibirMsgLine("|        8. Remover Moto                   |");
		tela.exibirMsgLine("|        9. Listar Estoque de Carros       |");
		tela.exibirMsgLine("|        10. Listar Estoque de Motos       |");			
		tela.exibirMsgLine("|        0. Sair                           |");
		tela.exibirMsgLine("===========================================");
		
		tela.exibirMsg("Entre com a Opção Desejada: ");
		return entradaDeDado.getInputInt();
	}
	
	
}

