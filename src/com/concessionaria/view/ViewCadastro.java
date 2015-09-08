package com.concessionaria.view;

import java.util.Scanner;

import com.concessionaria.admin.Loja;
import com.concessionaria.admin.VeiculoJaCadastradoException;
import com.concessionaria.veiculos.TipoVeiculo;
import com.concessionaria.view.especificacoes.Especificacoes;
import com.concessionaria.veiculos.Veiculo;

public class ViewCadastro {
	Scanner input;
	FabricaDeEspecificacao factory;
	
	public ViewCadastro() {
		factory = new FabricaDeEspecificacao();
		input = new Scanner(System.in);
	}
	
	public void cadastrarVeiculo(TipoVeiculo tipoVeiculo, Loja loja) {
		Especificacoes especificacoes;
		
		System.out.print("Entre com o Chassi: ");
		String chassi = input.next();
		System.out.println("Entre com o Preço: ");
		double preco = input.nextDouble();
		
		especificacoes = factory.criarEspecificacoes(tipoVeiculo);
		
		try {
			loja.adicionarVeiculo(new Veiculo(chassi, preco, especificacoes.cadastrarEspecificacoes(), tipoVeiculo));
		} catch (VeiculoJaCadastradoException e) {
			e.printStackTrace();
		}
	}
}
