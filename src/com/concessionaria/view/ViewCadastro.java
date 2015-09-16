package com.concessionaria.view;

import java.util.Scanner;

import com.concessionaria.admin.Loja;
import com.concessionaria.admin.Veiculo;
import com.concessionaria.enumerados.Cor;
import com.concessionaria.enumerados.TipoVeiculo;
import com.concessionaria.view.especificacoes.EspecificacoesView;

public class ViewCadastro extends View {
	private FabricaDeEspecificacao factory;
	
	public ViewCadastro() {
		factory = new FabricaDeEspecificacao();
		input = new Scanner(System.in);
	}
	
	public Veiculo cadastrarVeiculo(Loja loja) {
		
		TipoVeiculo.exibirOpcoes();
		int tipoVeiculo = validarOpcao("Entre com o Tipo de Veiculo: ", "Tipo de Veículo Inválido.", 1, 2);
		
		String chassi = validarCampoString("Entre com o Chassi: ", "Chassi: Dados Inválidos.");
		double preco = validarCampoDouble("Entre com o Preço: ", "Preço: Dados Inválidos.");
		
		EspecificacoesView especificacoes = factory.criarEspecificacoes(TipoVeiculo.getOpcao(tipoVeiculo));
		
		return new Veiculo(chassi, preco, especificacoes.cadastrarEspecificacoes(), TipoVeiculo.getOpcao(tipoVeiculo));
	}
}
