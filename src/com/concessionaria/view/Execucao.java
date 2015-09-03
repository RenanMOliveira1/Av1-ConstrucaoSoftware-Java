package com.concessionaria.view;
import java.util.Scanner;

import com.concessionaria.admin.Loja;
import com.concessionaria.veiculos.TipoVeiculo;
import com.concessionaria.veiculos.Veiculo;

public class Execucao {
	public static void main(String[] args) {
		Loja loja = new Loja();
		ViewCadastro viewCadastro = new ViewCadastro();
		
		Scanner input = new Scanner(System.in);
		int n;
		while ((n = input.nextInt()) != 0) {
			switch (n) {
				case 1:
					viewCadastro.cadastrarVeiculo(TipoVeiculo.Carro, loja);
					loja.listarEstoque();
				break;
				case 2:
					viewCadastro.cadastrarVeiculo(TipoVeiculo.Motocicleta, loja);
					loja.listarEstoque();
				break;
				case 3:
					System.out.println("Entre com o Chassi: ");
					String chassi = input.next();
					Veiculo veiculo = loja.buscarVeiculo(chassi);
					System.out.println(veiculo.toString());
				break;
				default:
					System.out.println("Inválido.");
			}
		}
	}
}
