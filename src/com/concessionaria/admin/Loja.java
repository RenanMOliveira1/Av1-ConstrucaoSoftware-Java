package com.concessionaria.admin;
import java.util.ArrayList;
import java.util.Map;
import java.util.Map.Entry;

import com.concessionaria.veiculos.Especificacoes;
import com.concessionaria.veiculos.Veiculo;

public class Loja {
	private ArrayList<Veiculo> estoqueVeiculos;
	private FabricaDeVeiculo factory;
	
	public Loja() {
		estoqueVeiculos = new ArrayList<Veiculo>();
		factory = new FabricaDeVeiculo();
	}
	
	public ArrayList<Veiculo> getEstoqueVeiculos() {
		return estoqueVeiculos;
	}

	public void setEstoqueVeiculos(ArrayList<Veiculo> estoqueVeiculos) {
		this.estoqueVeiculos = estoqueVeiculos;
	}

	public boolean adicionarVeiculo(Especificacoes especificacoes) {
		Veiculo veiculo = factory.criarVeiculo(especificacoes);
		veiculo.cadastrarVeiculo();
		
		return estoqueVeiculos.add(veiculo);
	}
	
	public Veiculo buscarVeiculo(String chassi) {
		
		for (Veiculo veiculo : estoqueVeiculos) {
			if (veiculo.getChassi() == chassi) {
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


