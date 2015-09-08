package com.concessionaria.admin;
import java.util.HashSet;
import java.util.Map;
import java.util.Map.Entry;

import com.concessionaria.veiculos.Veiculo;

public class Loja {
	private HashSet<Veiculo> estoqueVeiculos;

	public Loja() {
		estoqueVeiculos = new HashSet<Veiculo>();
	}
	
	public HashSet<Veiculo> getEstoqueVeiculos() {
		return estoqueVeiculos;
	}

	public void setEstoqueVeiculos(HashSet<Veiculo> estoqueVeiculos) {
		this.estoqueVeiculos = estoqueVeiculos;
	}

	public boolean adicionarVeiculo(Veiculo veiculo) throws VeiculoJaCadastradoException {
		if (estoqueVeiculos.add(veiculo))
			return true;
		else 
			throw new VeiculoJaCadastradoException("Veículo já Cadastrado.");
	}
	
	public Veiculo buscarVeiculo(String chassi) {
		
		for (Veiculo veiculo : estoqueVeiculos) {
			if (veiculo.getChassi().equals(chassi)) {
				return veiculo;
			}
		}
		
		return null;
	}
	
	public HashSet<Veiculo> pesquisarVeiculo(Map<String, String> novasEspecificacoes) {
		HashSet<Veiculo> resultadoVeiculos = new HashSet<Veiculo>();
		
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


