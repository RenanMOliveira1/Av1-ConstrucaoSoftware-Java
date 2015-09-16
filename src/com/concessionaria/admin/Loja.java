package com.concessionaria.admin;
import java.util.HashSet;
import java.util.Map;
import java.util.Map.Entry;

import com.concessionaria.excessoes.VeiculoJaCadastradoException;

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

	public boolean adicionarVeiculo(Veiculo veiculo) {
		
		try {
			if (!estoqueVeiculos.add(veiculo))
				throw new VeiculoJaCadastradoException("Veículo já Cadastrado.");
		} catch (VeiculoJaCadastradoException e) {
			e.printStackTrace();
			System.exit(1);
		}
		
		return true;
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
		
		for(Entry<String, String> especificacoes: novasEspecificacoes.entrySet()) {
			if (novasEspecificacoes.containsKey(especificacoes.getKey()) && veiculo.getEspecificacoes().containsValue(especificacoes.getValue()))
				contCampos++;
		}
		return contCampos != 0;
	}
}


