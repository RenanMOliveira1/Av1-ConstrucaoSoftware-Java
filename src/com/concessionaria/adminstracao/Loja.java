package com.concessionaria.adminstracao;

import java.util.ArrayList;

import com.concessionaria.veiculos.Carro;
import com.concessionaria.veiculos.Motocicleta;

/**
 * 
 * @author Renan Oliveira
 * @author Tiago Henrique
 *
 */

public class Loja {
	
	String endereco;
	String nome;
	ArrayList<Carro> estoqueCarro = new ArrayList<Carro>();
	ArrayList<Motocicleta> estoqueMotocicleta = new ArrayList<Motocicleta>();
	
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
	
	/**
	 * @return Retorna True se o Carro for Cadastrado com sucesso, e false se ocorrer algum problema
	 */
	public boolean adicionarCarro(){
		Carro carro = new Carro();
		int verifica = 0;
		
		carro.leCarro();
		if (this.getEstoqueCarro() != null)
			verifica = this.getEstoqueCarro().size();
		this.getEstoqueCarro().add(carro);
		if(verifica + 1 == this.getEstoqueCarro().size()){
			return true;
		} else {
			return false;
		}	
	}
	
	/**
	 * @return Retorna True se a Motocicleta for Cadastrado com sucesso, e false se ocorrer algum problema
	 */
	public boolean adicionarMotocicleta(){
		Motocicleta moto = new Motocicleta();
		int verifica;
		
		moto.leMoto();
		verifica = this.getEstoqueMotocicleta().size();
		this.getEstoqueMotocicleta().add(moto);
		if(verifica + 1 == this.getEstoqueMotocicleta().size()){
			return true;
		} else {
			return false;
		}	
	}
	
	public ArrayList<Carro> pesquisaCarro(){
		return getEstoqueCarro();
	}
	
	public ArrayList<Motocicleta> pesquisaMotocicleta(){
		return getEstoqueMotocicleta();
	}
	
	/**
	 * @param chassi
	 * @return Retorna o Carro com o Chassi correspondente
	 */
	public Carro buscarCarro(String chassi){
		
		for(Carro car : this.getEstoqueCarro()){
			if(car.getChassi().equals(chassi)){
				return car;
			}
		}
		return null;
	}
	
	/**
	 * @param chassi
	 * @return Retorna a Motocicleta com o Chassi correspondente
	 */
	public Motocicleta buscarMoto(String chassi){
		
		for(Motocicleta moto : this.getEstoqueMotocicleta()){
			if(moto.getChassi().equals(chassi)){
				return moto;
			}
		}
		return null;
	}
	
	public void listarArrayCarro(ArrayList<Carro> carList){
		for(Carro car : carList){
			this.listarCarro(car);
		}
	}
	
	public void listarArrayMotoicleta(ArrayList<Motocicleta> motoList){
		for(Motocicleta moto : motoList){
			this.listarMotocicleta(moto);
		}
	}
	
	public void listarEstoqueMotocicleta(){
		for(Motocicleta moto : getEstoqueMotocicleta()){
			this.listarMotocicleta(moto);
		}
	}
	
	public void listarEstoqueCarro(){
		for(Carro car : getEstoqueCarro()){
			this.listarCarro(car);
		}
	}
	
	public boolean removerCarro(String chassi) {
		Carro carroSelecionado = buscarCarro(chassi);
		
		if (carroSelecionado != null) {
			getEstoqueCarro().remove(carroSelecionado);
			return true;
		} 
		
		return false;
	}
	
	public boolean removerMotocicleta(String chassi) {
		Motocicleta motoSelecionada = buscarMoto(chassi);
		
		if (motoSelecionada != null) {
			getEstoqueMotocicleta().remove(motoSelecionada);
			return true;
		} 
		
		return false;
	}
	
	public void listarCarro(Carro carro){
		
		System.out.print("Chassi: ");
		System.out.println(carro.getChassi());
		System.out.print("Montadora: ");
		System.out.println(carro.getMontadora());
		System.out.print("Modelo: ");
		System.out.println(carro.getModelo());
		System.out.print("Tipo: ");
		System.out.println(carro.getTipo());
		System.out.print("Cambio: ");
		System.out.println(carro.getCambio());
		System.out.print("Motorizacao: ");
		System.out.println(carro.getMotorizacao());
		System.out.print("Cor: ");
		System.out.println(carro.getCor());
		System.out.print("Preco: ");
		System.out.println(carro.getPreco());
		System.out.println("-----------X------------");
		System.out.println();
	}
	
	public void listarMotocicleta(Motocicleta motoSelecionada){
		
		System.out.print("Chassi: ");
		System.out.println(motoSelecionada.getChassi());
		System.out.print("Montadora: ");
		System.out.println(motoSelecionada.getMontadora());
		System.out.print("Modelo: ");
		System.out.println(motoSelecionada.getModelo());
		System.out.print("Tipo: ");
		System.out.println(motoSelecionada.getTipo());
		System.out.print("Cilindrada: ");
		System.out.println(motoSelecionada.getCilindrada());
		System.out.print("Capacida De Tanque: ");
		System.out.println(motoSelecionada.getCapacidaDeTanque());
		System.out.print("Cor: ");
		System.out.println(motoSelecionada.getCor());
		System.out.print("Preco: ");
		System.out.println(motoSelecionada.getPreco());
		System.out.println("-----------X------------");
		System.out.println();
	}
}
