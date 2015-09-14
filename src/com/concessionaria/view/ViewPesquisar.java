package com.concessionaria.view;

import java.util.Scanner;

import com.concessionaria.admin.Loja;
import com.concessionaria.enumerados.TipoVeiculo;

public class ViewPesquisar extends View {
	
	public ViewPesquisar() {
		input = new Scanner(System.in);
	}
	
	public void pesquisarVeiculos(Loja loja) {
		boolean sair = false;
		
		int i = 1;
		
		System.out.println("\n");
		
		for (TipoVeiculo tv : TipoVeiculo.values()) {
			System.out.println(i++ + " - " + tv.getNomeVeiculo());
		}
		System.out.println("Entre com o Tipo de Veículo: ");
		TipoVeiculo tipoVeiculo = TipoVeiculo.getOpcao(input.nextInt());
		
		switch (tipoVeiculo) {
			case CARRO:
				
				break;
		}
	}
}
