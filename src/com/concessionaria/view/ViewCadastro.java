package com.concessionaria.view;

import java.util.NoSuchElementException;
import java.util.Scanner;

import com.concessionaria.admin.Loja;
import com.concessionaria.admin.Veiculo;
import com.concessionaria.enumerados.TipoVeiculo;
import com.concessionaria.excessoes.ChassiDuplicadoException;
import com.concessionaria.view.especificacoes.ViewEspecificacoes;
import com.concessionaria.view.especificacoes.FabricaDeEspecificacao;

public class ViewCadastro extends View {
	private FabricaDeEspecificacao fabricaDeEspecificacao;
	
	public ViewCadastro() {
		this.fabricaDeEspecificacao = new FabricaDeEspecificacao();
		this.input = new Scanner(System.in);
	}
	
	public Veiculo cadastrarVeiculo(Loja loja) {
		
		TipoVeiculo.exibirOpcoes();
		int tipoVeiculo = validarOpcao("Entre com o Tipo de Veiculo: ", "Tipo de Ve�culo Inv�lido.", 1, TipoVeiculo.values().length);
		
		String chassi = validaChassi(loja);
		double preco = validarCampoDouble("Entre com o Pre�o: ", "Pre�o: Dados Inv�lidos.");
		
		ViewEspecificacoes especificacoes = fabricaDeEspecificacao.criarEspecificacoes(TipoVeiculo.getOpcao(tipoVeiculo));
		
		return new Veiculo(chassi, preco, especificacoes.cadastrarEspecificacoes(), TipoVeiculo.getOpcao(tipoVeiculo));
	}
	
	private String validaChassi(Loja loja) {
		String chassi = null;
		boolean dadoInvalido = false;
		
		while (!dadoInvalido) {
			try {
				input.nextLine();
				chassi = this.validarCampoString("Entre com o Chassi: ", "Dados Inv�lidos.");
				for (Veiculo v : loja.getEstoqueVeiculos()) {
					if (chassi.equals(v.getChassi()))
						throw new ChassiDuplicadoException("Chassi Duplicado.");
				}
				dadoInvalido = true;
			} catch (NoSuchElementException e) {
				System.err.println("Chassi: Dados Inv�lidos.");
				dadoInvalido = false;
			} catch (ChassiDuplicadoException e) {
				System.err.println("J� Existe um Ve�culo com Esse Chassi, Tente Novamente.");
				dadoInvalido = false;
			}
		} 
		return chassi;
	}
}
