package com.concessionaria.executavel;

import com.concessionaria.adminstracao.*;

/**
 * 
 * @author Yasmin
 *
 */

public class Menu {

	public static void main(String[] args) {
	    Loja concessionaria = new Loja();
	    int opcaoEscolhida;
	    boolean sair = false;

	    while(!sair) {
		    System.out.println("===========================================");
		    System.out.println("|        Bem-vindo a Concessionaria        |");
		    System.out.println("===========================================");
		    System.out.println("|    Opcoes:                               |");
		    System.out.println("|        1. Adicionar Carro                |");
		    System.out.println("|        2. Adicionar Moto                 |");
		    System.out.println("|        3. Pesquisar Carro                |");
		    System.out.println("|        4. Pesquisar Moto                 |");
		    System.out.println("|        5. Buscar Carro                   |");
		    System.out.println("|        6. Buscar Moto                    |");
		    System.out.println("|        7. Listar Estoque de Carros       |");
		    System.out.println("|        8. Listar Estoque de Motos        |");
		    System.out.println("|        9. Sair                           |");
		    System.out.println("===========================================");
		    opcaoEscolhida = Keyin.inInt(" Selecione sua opcao: ");
	
		    switch (opcaoEscolhida) {
		    case 1:
		      System.out.println("|       Adicionar Carro Selecionado      |");
		      concessionaria.adicionarCarro();
		      break;
		    case 2:
		      System.out.println("|        Adicionar Moto Selecionado      |");
		      concessionaria.adicionarMotocicleta();
		      break;
		    case 3:
		      System.out.println("|       Pesquisar Carro Selecionado      |");
		      concessionaria.pesquisaCarro();
		      break;
		    case 4:
		    	System.out.println("|      Pesquisar Moto Seleciondado     |");
		    	concessionaria.pesquisaMotocicleta();
		    	break;
		    case 5:
		    	System.out.println("|        Buscar Carro Selecionado      |");
		    	System.out.println(" Entre com o chassi: ");
		    	String chassiCarro = Keyin.inString();
		    	concessionaria.buscaCarro(chassiCarro);
		    	break;
		    case 6:
		    	System.out.println("|         Buscar Moto  Selecionado      |");
		    	System.out.println(" Entre com o chassi: ");
		    	String chassiMoto = Keyin.inString();
		    	concessionaria.buscarMoto(chassiMoto);
		    	break;
		    case 7:
		    	System.out.println("|  Listar Estoque de Carros Selecionado  |");
		    	concessionaria.listarEstoqueCarro();
		    	break;
		    case 8:
		    	System.out.println("|   Listar Estoque de Motos Selecionado  |");
		    	concessionaria.listarEstoqueMotocicleta();
		    	break;
		    case 9:
		    	System.out.println("|            Saida Selecionada            |");
		    	sair = true;
		    default:
		      System.out.println("Opcao Invalida!!");
		    }
	    }
	}
}

	class Keyin {
	  public static void imprimirMensagem(String mensagem) {
	    System.out.print(mensagem + " ");
	    System.out.flush();
	  }
	  
	  public static void inputFlush() {
		    int dummy;

		    try {
		      while ((System.in.available()) != 0)
		        dummy = System.in.read();
		    } catch (java.io.IOException e) {
		      System.out.println("Input error");
		    }
	  }
	  
	  public static String inString() {
		    int aChar;
		    String s = "";
		    boolean finished = false;

		    while (!finished) {
		      try {
		        aChar = System.in.read();
		        if (aChar < 0 || (char) aChar == '\n')
		          finished = true;
		        else if ((char) aChar != '\r')
		          s = s + (char) aChar; // Enter into string
		      }

		      catch (java.io.IOException e) {
		        System.out.println("Input error");
		        finished = true;
		      }
		    }
		    return s;
		  }
	  
	  public static int inInt(String mensagem) {
		    while (true) {
		      inputFlush();
		      imprimirMensagem(mensagem);
		      try {
		        return Integer.valueOf(inString().trim()).intValue();
		      }

		      catch (NumberFormatException e) {
		        System.out.println("Nao eh um inteiro!");
		      }
		    }
		  }

}
