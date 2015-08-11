package com.concessionaria.adminstracao;

import java.util.ArrayList;

import com.concessionaria.administracao.auxiliares.Tela;
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
	private Tela tela;
	private ArrayList<Carro> estoqueCarro;
	private ArrayList<Motocicleta> estoqueMotocicleta;
	
	public Loja() {
		estoqueCarro = new ArrayList<Carro>();
		estoqueMotocicleta = new ArrayList<Motocicleta>();
		tela = new Tela();
	}
	
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
			tela.exibirMsgLine("\nCarro Adicionado!\n");	
			return true;
		} else {
			tela.exibirMsgLine("\nHouve um Problema no Cadastro.\n");
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
			tela.exibirMsgLine("\nMotocicleta Adicionado!\n");
			return true;
		} else {
			tela.exibirMsgLine("\nHouve um Problema no Cadastro.\n");
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
		
		tela.exibirMsgLine("Chassi: " + carro.getChassi());
		tela.exibirMsgLine("Montadora: " + carro.getMontadora());
		tela.exibirMsgLine("Modelo: " + carro.getModelo());
		tela.exibirMsgLine("Tipo: " + carro.getTipo());
		tela.exibirMsgLine("Cambio: " + carro.getCambio());
		tela.exibirMsgLine("Motorizacao: " + carro.getMotorizacao());
		tela.exibirMsgLine("Cor: " + carro.getCor());
		tela.exibirMsg("Preco: ");
		tela.exibirValoresReais(carro.getPreco());
		tela.exibirMsgLine("-----------X------------\n");
	}
	
	/**
	 * 
	 * @param motoSelecionada
	 * 
	 * imprime todas as caracteristicas de motocicleta
	 */
	
	public void listarMotocicleta(Motocicleta motoSelecionada){
		
		tela.exibirMsgLine("Chassi: " + motoSelecionada.getChassi());
		tela.exibirMsgLine("Montadora: " + motoSelecionada.getMontadora());
		tela.exibirMsgLine("Modelo: " + motoSelecionada.getModelo());
		tela.exibirMsgLine("Tipo: " + motoSelecionada.getTipo());
		tela.exibirMsgLine("Cilindrada: " + motoSelecionada.getCilindrada());
		tela.exibirMsgLine("Capacida De Tanque: " + motoSelecionada.getCapacidaDeTanque());
		tela.exibirMsgLine("Cor: " + motoSelecionada.getCor());
		tela.exibirMsg("Preco: ");
		tela.exibirValoresReais(motoSelecionada.getPreco());
		System.out.println("-----------X------------\n");
	}
}
