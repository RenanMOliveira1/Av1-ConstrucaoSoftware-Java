package com.concessionaria.adminstracao;

import java.util.ArrayList;

import com.concessionaria.veiculos.*;

/**
 * 
 * @author Renan Oliveira
 *
 */

public class Loja {
	
	String endereco;
	String nome;
	ArrayList<Carro> estoqueCarro;
	ArrayList<Motocicleta> estoqueMotocicleta;
	
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public ArrayList<Carro> getEstoqueCarro() {
		return estoqueCarro;
	}
	public void setEstoqueCarro(ArrayList<Carro> estoqueCarro) {
		this.estoqueCarro = estoqueCarro;
	}
	public ArrayList<Motocicleta> getEstoqueMotocicleta() {
		return estoqueMotocicleta;
	}
	public void setEstoqueMotocicleta(ArrayList<Motocicleta> estoqueMoto) {
		this.estoqueMotocicleta = estoqueMoto;
	}	
	
	public boolean adicionarCarro(){
		Carro carro = Carro.leCarro();
		int verifica;
		
		verifica = this.getEstoqueCarro().size();
		this.getEstoqueCarro().add(carro);
		if(verifica + 1 == this.getEstoqueCarro().size()){
			return true;
		} else {
			return false;
		}	
	}
	
	public boolean adicionarMotocicleta(){
		Motocicleta moto = Motocicleta.leMoto();
		int verifica;
		
		verifica = this.getEstoqueMotocicleta().size();
		this.getEstoqueMotocicleta().add(moto);
		if(verifica + 1 == this.getEstoqueMotocicleta().size()){
			return true;
		} else {
			return false;
		}	
	}
	
	public ArrayList<Carro> pesquisaCarro(String dadosPesquisa){
		ArrayList<Carro> resultado = new ArrayList<Carro>();
		
		return resultado;
	}
	
	public ArrayList<Motocicleta> pesquisaMotocicleta(){
		ArrayList<Motocicleta> resultado  = new ArrayList<Motocicleta>();
		return resultado;
	}
	
	public Carro buscaCarro(String chassi){
		Carro carro = new Carro();
		
		for(Carro car : this.getEstoqueCarro()){
			if(chassi == car.getChassi()){
				carro = car;
				break;
			}
		}
		return carro;
	}
	
	public Motocicleta buscarMoto(String chassi){
		Motocicleta motocicleta = new Motocicleta();
		
		for(Motocicleta moto : this.getEstoqueMotocicleta()){
			if(chassi == moto.getChassi()){
				motocicleta = moto;
				break;
			}
		}
		return motocicleta;
	}
	
	public void listarEstoqueCarro(){
		
		for(Carro carro : getEstoqueCarro()){
			System.out.println(carro.getChassi());
			System.out.println(carro.getMontadora());
			System.out.println(carro.getModelo());
			System.out.println(carro.getTipo());
			System.out.println(carro.getCambio());
			System.out.println(carro.getMotolizacao());
			System.out.println(carro.getCor());
			System.out.println(carro.getPreco());
			System.out.println("-----------X------------");
		}
	}
	
	public void listarEstoqueMotocicleta(){
		for(Motocicleta moto : getEstoqueMotocicleta()){
			System.out.println(moto.getChassi());
			System.out.println(moto.getMontadora());
			System.out.println(moto.getModelo());
			System.out.println(moto.getTipo());
			System.out.println(moto.getCilindrada());
			System.out.println(moto.getCapacidadeTanque());
			System.out.println(moto.getCor());
			System.out.println(moto.getPreco());
			System.out.println("-----------X------------");
		}
	}
}
