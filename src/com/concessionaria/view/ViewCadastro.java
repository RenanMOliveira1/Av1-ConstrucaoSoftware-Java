package com.concessionaria.view;

import java.util.Scanner;

import com.concessionaria.admin.Loja;
import com.concessionaria.admin.Veiculo;
import com.concessionaria.enumerados.Cor;
import com.concessionaria.enumerados.TipoVeiculo;
import com.concessionaria.view.especificacoes.Especificacoes;

public class ViewCadastro extends View {
	private FabricaDeEspecificacao factory;
	
	public ViewCadastro() {
		factory = new FabricaDeEspecificacao();
		input = new Scanner(System.in);
	}
	
	public Veiculo cadastrarVeiculo(Loja loja) {

		int tVeiculo = validarEntradaDados("Entre com o Tipo de Veiculo: ", "Op��o de Cor Inv�lida", 1, 2);
		
		System.out.print("Entre com o Chassi: ");
		String chassi = input.next();
		
		System.out.println("Entre com o Pre�o: ");
		double preco = input.nextDouble();
		
		int cor = validarEntradaDados("Entre com a Cor: ", "Op��o de Cor Inv�lida", 1, 9);
		Especificacoes especificacoes = factory.criarEspecificacoes(TipoVeiculo.getOpcao(tVeiculo));
		
		return new Veiculo(chassi, preco, Cor.getOpcao(cor), especificacoes.cadastrarEspecificacoes(), TipoVeiculo.getOpcao(tVeiculo));
	}
}
