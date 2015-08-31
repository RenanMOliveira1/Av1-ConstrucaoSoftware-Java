import java.util.Scanner;

import com.concessionaria.admin.Loja;
import com.concessionaria.veiculos.Especificacoes;
import com.concessionaria.veiculos.EspecificacoesCarro;
import com.concessionaria.veiculos.EspecificacoesMotocicleta;
import com.concessionaria.veiculos.Veiculo;

public class Execucao {
	public static void main(String[] args) {
		Loja loja = new Loja();
		Especificacoes especificacoes;
		
		Scanner input = new Scanner(System.in);
		int n;
		while ((n = input.nextInt()) != 0) {
			switch (n) {
				case 1:
					especificacoes = new EspecificacoesCarro();
					loja.adicionarVeiculo(especificacoes);
					loja.listarEstoque();
				break;
				case 2:
					especificacoes = new EspecificacoesMotocicleta();
					loja.adicionarVeiculo(especificacoes);
					loja.listarEstoque();
				break;
				case 3:
					Veiculo veiculo = loja.buscarVeiculo("112");
					System.out.println(veiculo.toString());
				break;	
				default:
					System.out.println("Inválido.");
			}
		}
	}
}
