package br.com.cwi.crescer;

import java.util.Scanner;

public class Aplicacao {

    public static void main(String[] args) {
        
    	Scanner scanner = new Scanner(System.in);
    	
    	System.out.println("Digite 1 para lista encadeada \nOu 2 para lista duplamente encadeada");
    	int opcao = scanner.nextInt();
    	
    	if(opcao == 1) {
    		
    		LinkedList linkedList = new LinkedList();
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
		    			
		    			if(linkedList.isEmpty()) {
		    				
		    				linkedList.addFirst(valor);
		    				
		    			} else {
		    				
		    				System.out.println("Digite a posição");
			    			int index = scanner.nextInt();
			    			
			    			linkedList.add(index, valor);
		    			}
		    			
		    			break;
		    			
		    		case 2:
		    					    			
		    			if(linkedList.isEmpty()) {
		    				
		    				linkedList.removeFirst();
		    				
		    			} else {
		    				
		    				System.out.println("Digite a posição");
			    			scanner.nextLine();
			    			int index = scanner.nextInt();
		    				
			    			linkedList.remove(index);
		    			}
		    		
		    		case 3:
		    			
		    			System.err.println(linkedList.list());
	        	}
        	
        	}
    		
    		
    	} else if(opcao == 2) {
    		
    		System.out.println("Escolha uma opção");
        	int subOpcao = scanner.nextInt();
    		
        	switch(subOpcao) {
        	
        		case 1:
        			break;      		
        	}
    	}
    }

}
