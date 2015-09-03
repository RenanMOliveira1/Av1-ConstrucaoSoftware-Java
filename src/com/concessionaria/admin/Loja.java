package com.concessionaria.admin;
import java.util.ArrayList;
import java.util.Map;
import java.util.Map.Entry;

import com.concessionaria.veiculos.Veiculo;
import com.concessionaria.view.especificacoes.Especificacoes;

public class Loja {
	private ArrayList<Veiculo> estoqueVeiculos;

	public Loja() {
		estoqueVeiculos = new ArrayList<Veiculo>();
	}
	
	public ArrayList<Veiculo> getEstoqueVeiculos() {
		return estoqueVeiculos;
	}

	public void setEstoqueVeiculos(ArrayList<Veiculo> estoqueVeiculos) {
		this.estoqueVeiculos = estoqueVeiculos;
	}

	public boolean adicionarVeiculo(String chassi, double preco, Map<String, String> especificacoes) {
		return estoqueVeiculos.add(new Veiculo(chassi, preco, especificacoes));
	}
	
	public Veiculo buscarVeiculo(String chassi) {
		
		for (Veiculo veiculo : estoqueVeiculos) {
			if (veiculo.getChassi().equals(chassi)) {
				return veiculo;
			}
		}
		
		return null;
	}
	
	public ArrayList<Veiculo> pesquisarVeiculo(Map<String, String> novasEspecificacoes) {
		ArrayList<Veiculo> resultadoVeiculos = new ArrayList<Veiculo>();
		
		for (Veiculo veiculo : estoqueVeiculos) {
			if (existeVeiculo(veiculo, novasEspecificacoes)) {
				resultadoVeiculos.add(veiculo);
			}
		}
		
		return resultadoVeiculos;
	}
	
	public boolean removerVeiculo(String chassi) {
		return estoqueVeiculos.remove(buscarVeiculo(chassi));
	}
	
	public void listarEstoque() {
		
		for (Veiculo veiculo : estoqueVeiculos) {
			System.out.println(veiculo.toString());
		}
	}
	
	private boolean existeVeiculo(Veiculo veiculo, Map<String, String> novasEspecificacoes) {
		int contCampos = 0;
		
		for(Entry<String, String> especificacoes: veiculo.getEspecificacoes().entrySet()) {
			if (especificacoes.getValue() == novasEspecificacoes.get(especificacoes.getKey()))
				contCampos++;
		}
		
		return contCampos != 0;
	}
}


