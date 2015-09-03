package com.concessionaria.view;

import java.util.Scanner;

import com.concessionaria.admin.Loja;
import com.concessionaria.veiculos.TipoVeiculo;
import com.concessionaria.view.especificacoes.Especificavel;

public class ViewCadastro {
	FabricaDeEspecificacao factory;
	
	public ViewCadastro() {
		factory = new FabricaDeEspecificacao();
	}
	
	public void cadastrarVeiculo(TipoVeiculo tipoVeiculo, Loja loja) {
		Especificavel especificacoes;
		Scanner input = new Scanner(System.in);
		
		System.out.print("Entre com o Chassi: ");
		String chassi = input.next();
		System.out.println("Entre com o Preço: ");
		double preco = input.nextDouble();
		
		especificacoes = factory.criarEspecificacoes(tipoVeiculo);
		
		loja.adicionarVeiculo(chassi, preco, especificacoes.cadastrarEspecificacoes());
	}
}
