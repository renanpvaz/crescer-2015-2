package br.com.cwi.crescer;

import java.util.Scanner;

public class Aplicacao {

    public static void main(String[] args) {
        
    	Scanner scanner = new Scanner(System.in);
    	
    	System.out.println("Opções:\n1 - Lista encadeada\n2 - Lista duplamente encadeada");
    	int opcaoLista = scanner.nextInt();
    	LinkableList lista;

    	if(opcaoLista == 1) {   		
    		
    		lista = new LinkedList();
    		
    	} else {
    		
    		lista = new DoublyLinkedList();
    	}
    		int subOpcao = -1;
        	
        	while(subOpcao != 0) {
        		
        		System.out.println("Escolha:");
        		System.out.println("1 - Inserir");
        		System.out.println("2 - Remover");
        		System.out.println("3 - Listar");
        		System.out.println("0 - Sair");
            	subOpcao = scanner.nextInt();
        		   	
	        	switch(subOpcao) {
	        	
		    		case 1:
		    			
		    			System.out.println("Digite o novo valor");
		    			scanner.nextLine();
		    			String valor = scanner.nextLine();
		    			
		    			if(lista.isEmpty()) {
		    				
		    				lista.addFirst(valor);
		    				
		    			} else {
		    				
		    				System.out.println("Digite a posição");
			    			int index = scanner.nextInt();
			    			
			    			lista.add(index, valor);
		    			}
		    			
		    			break;
		    			
		    		case 2:
		    					    			
		    			if(lista.isEmpty()) {
		    				
		    				lista.removeFirst();
		    				
		    			} else {
		    				
		    				System.out.println("Digite a posição");
			    			scanner.nextLine();
			    			int index = scanner.nextInt();
		    				
			    			lista.remove(index);
		    			}
		    		
		    		case 3:
		    			
		    			System.err.println(lista.list());
	        	}
        	
        	}
        	
        	System.exit(0);    		
    }

}
