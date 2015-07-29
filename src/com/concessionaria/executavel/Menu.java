package com.concessionaria.executavel;

import com.concessionaria.adminstracao.*;

public class Menu {

	public static void main(String[] args) {
	    Loja concessionaria = new Loja();
	    int swValue;

	    System.out.println("===================================");
	    System.out.println("|    Bem-vindo a Concessionaria    |");
	    System.out.println("===================================");
	    System.out.println("|    Opcoes:                       |");
	    System.out.println("|        1. Adicionar Carro        |");
	    System.out.println("|        2. Adicionar Moto         |");
	    System.out.println("|        3. Saida                  |");
	    System.out.println("===================================");
	    swValue = Keyin.inInt("\n Selecione sua opcao: ");

	    switch (swValue) {
	    case 1:
	      System.out.println("Adicionando Carro: ");
	      concessionaria.adicionarCarro();
	      break;
	    case 2:
	      System.out.println("Adicionando Moto: ");
	      concessionaria.adicionarMotocicleta();
	      break;
	    case 3:
	      System.out.println("Saida selecionada");
	      break;
	    default:
	      System.out.println("Invalid selection");
	    }
	  }
	}

	class Keyin {

	  public static void printPrompt(String prompt) {
	    System.out.print(prompt + " ");
	    System.out.flush();
	  }
	  
	  public static void inputFlush() {
		    int dummy;
		    int bAvail;

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
	  
	  public static int inInt(String prompt) {
		    while (true) {
		      inputFlush();
		      printPrompt(prompt);
		      try {
		        return Integer.valueOf(inString().trim()).intValue();
		      }

		      catch (NumberFormatException e) {
		        System.out.println("Invalid input. Not an integer");
		      }
		    }
		  }

}
