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
	
	private String endereco;
	private String nome;
	private ArrayList<Carro> estoqueCarro = new ArrayList<Carro>();
	private ArrayList<Motocicleta> estoqueMotocicleta = new ArrayList<Motocicleta>();
	
	/** 
	 * @return retorna endereco
	 */
	public String getEndereco() {
		return endereco;
	}
	
	/**
	 * @param endereco
	 */
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	
	/**
	 * @return retorna nome
	 */
	public String getNome() {
		return nome;
	}
	
	/**
	 * @param nome
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	/**
	 * @return retorna um ArrayList de carros
	 */
	public ArrayList<Carro> getEstoqueCarro() {
		return estoqueCarro;
	}
	
	/**
	 * @param estoqueCarro
	 */
	public void setEstoqueCarro(ArrayList<Carro> estoqueCarro) {
		this.estoqueCarro = estoqueCarro;
	}
	
	/**
	 * @return retorna im ArrayList de motocicletas
	 */
	public ArrayList<Motocicleta> getEstoqueMotocicleta() {
		return estoqueMotocicleta;
	}
	
	/**
	 * @param estoqueMoto
	 */
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
	
	/**
	 * 
	 * @param carList
	 * 
	 * lista as caracteristicas de todos os objetos contidos num ArrayList de carros
	 */
	
	public void listarArrayCarro(ArrayList<Carro> carList){
		for(Carro car : carList){
			this.listarCarro(car);
		}
	}
	
	/**
	 * 
	 * @param motoList
	 * 
	 * lista as caracteristicas de todos os objetos contidos num ArrayList de motocicletas
	 */
	
	public void listarArrayMotocicleta(ArrayList<Motocicleta> motoList){
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
	
	/**
	 * 
	 * @param chassi
	 * @return
	 * 
	 * remove o veiculo a partir do codigo do seu chassi
	 */
	
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
	
	/**
	 * 
	 * @param carro
	 * 
	 * imprime todas as caraacteristicas do carro
	 */
	
	public void listarCarro(Carro carro){
		
		System.out.println("Chassi: " + carro.getChassi());
		System.out.println("Montadora: " + carro.getMontadora());
		System.out.println("Modelo: " + carro.getModelo());
		System.out.println("Tipo: " + carro.getTipo());
		System.out.println("Cambio: " + carro.getCambio());
		System.out.println("Motorizacao: " + carro.getMotorizacao());
		System.out.println("Cor: " + carro.getCor());
		System.out.println("Preco: " + carro.getPreco());
		System.out.println("-----------X------------\n");
	}
	
	/**
	 * 
	 * @param motoSelecionada
	 * 
	 * imprime todas as caracteristicas de motocicleta
	 */
	
	public void listarMotocicleta(Motocicleta motoSelecionada){
		
		System.out.println("Chassi: " + motoSelecionada.getChassi());
		System.out.println("Montadora: " + motoSelecionada.getMontadora());
		System.out.println("Modelo: " + motoSelecionada.getModelo());
		System.out.println("Tipo: " + motoSelecionada.getTipo());
		System.out.println("Cilindrada: " + motoSelecionada.getCilindrada());
		System.out.println("Capacida De Tanque: " + motoSelecionada.getCapacidaDeTanque());
		System.out.println("Cor: " + motoSelecionada.getCor());
		System.out.println("Preco: " + motoSelecionada.getPreco());
		System.out.println("-----------X------------\n");
	}
}
