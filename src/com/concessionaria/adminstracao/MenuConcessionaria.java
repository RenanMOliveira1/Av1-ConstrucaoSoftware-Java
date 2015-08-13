/*
 * Copyright (c) 2015, GEC5 and/or its affiliates. All rights reserved.
 * INSTITUTO INFNET. Use is subject to license terms.
 * 
 * 
 * 
 */
package com.concessionaria.adminstracao;

import java.util.InputMismatchException;

import com.concessionaria.administracao.auxiliares.EntradaDeDados;
import com.concessionaria.administracao.auxiliares.Tela;
import com.concessionaria.veiculos.Veiculo;

/**
 * @author Yasmin Farias
 * @author Tiago Henrique
 * @since JDK 1.8
 *
 */
       
public class MenuConcessionaria {
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
	
	public MenuConcessionaria() {
		concessionaria = new Loja();
		tela = new Tela();
		entradaDeDado = new EntradaDeDados();
	}
	
	/**
	 * Inicia o Programa Concessionaria, com o Menu e suas Respectivas Opções.
	 * 
	 * @throws InputMismatchException se digitar alguma String
	 * quando se pede Inteiro.
	 */
	public void iniciar() {
		boolean sair = false;
		int opcaoEscolhida = 0;
		
		while(!sair) {
			
			try {
				opcaoEscolhida = exibirMenuPrincipal();
			} catch (InputMismatchException stringException) {
				System.err.println("Não se Aceita Letras, só Números.");
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
					//concessionaria.listarArrayCarro(concessionaria.pesquisaCarro());
					break;
				case PESQUISAR_MOTO:
					tela.exibirMsgLine("|       Pesquisar Moto Seleciondado        |");
					//concessionaria.listarArrayMotocicleta(concessionaria.pesquisaMotocicleta());
					break;
				case BUSCAR_CARRO:
					tela.exibirMsgLine("|         Buscar Carro Selecionado         |");
					tela.exibirMsg("Entre com o Chassi: ");
					Veiculo carroSelecionado = concessionaria.buscarCarro(entradaDeDado.getInput());
					
					if (carroSelecionado != null)
						carroSelecionado.exibirVeiculo();
					else
						tela.exibirMsgLine("\nCarro não Encontrado.\n");
					break;
				case BUSCAR_MOTO:
					tela.exibirMsgLine("|          Buscar Moto  Selecionado         |");
					tela.exibirMsg("Entre com o Chassi: ");
					Veiculo motocicletaSelecionada = concessionaria.buscarMoto(entradaDeDado.getInput());
					
					if (motocicletaSelecionada != null)
						motocicletaSelecionada.exibirVeiculo();
					else
						tela.exibirMsgLine("\nMoto não Encontrada.\n");
					break;
				case REMOVER_CARRO:
					tela.exibirMsgLine("|   Remover Carro do Estoque Selecionado    |");
					tela.exibirMsg("Entre com o Chassi: ");
					
					if (concessionaria.removerCarro(entradaDeDado.getInputString()))
						tela.exibirMsgLine("\nCarro Removido!\n");
					else
						tela.exibirMsgLine("\nHouve um Problema na Remocao do Veiculo.\n");
					break;
				case REMOVER_MOTO:
					tela.exibirMsgLine("|    Remover Moto do Estoque Selecinado     |");
					tela.exibirMsg("Entre com o Chassi: ");
					
					if (concessionaria.removerMotocicleta(entradaDeDado.getInputString()))
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
					tela.exibirMsgLine("Opcao Invalida!");
				}
		}
	}
	
	/**
	 * Exibi o Menu e Pede ao Usuário a Opção Desejada.
	 * 
	 * @return a Opção do Menu que o Usuário deseja
	 */
	private int exibirMenuPrincipal() {
		
		tela.exibirMsgLine("===========================================\n"
		                 + "|        Bem-vindo a Concessionaria        |\n"
                         + "===========================================\n"
                         + "|    Opcoes:                               |\n"
                         + "|        1. Adicionar Carro                |\n"
                         + "|        2. Adicionar Moto                 |\n"
                         + "|        3. Pesquisar Carro                |\n"
                         + "|        4. Pesquisar Moto                 |\n"
                         + "|        5. Buscar Carro                   |\n"
                         + "|        6. Buscar Moto                    |\n"
                         + "|        7. Remover Carro                  |\n"
                         + "|        8. Remover Moto                   |\n"
                         + "|        9. Listar Estoque de Carros       |\n"
                         + "|        10. Listar Estoque de Motos       |\n"		
                         + "|        0. Sair                           |\n"
                         + "===========================================");
		
		tela.exibirMsg("Entre com a Opção Desejada: ");
		return entradaDeDado.getInputInt();
	}
	
	
}

