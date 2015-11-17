package br.com.cwi.crescer;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;

import br.com.cwi.dao.ServicoDao;
import br.com.cwi.jdbc.ConnectionFactory;
import br.com.cwi.model.Servico;

public class Aplicacao {

    public static final String LINHAS_AFETADAS = "Linhas afetadas: ";

    public static void main(String[] args) throws Exception {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Opcoes:\n1 - Lista encadeada\n2 - Lista duplamente encadeada");
        int opcaoLista = scanner.nextInt();
        LinkableList lista = null;

        if (opcaoLista == 1) {

            lista = new LinkedList();

        } else if (opcaoLista == 2) {

            lista = new DoublyLinkedList();
        }
        int subOpcao = -1;

        while (subOpcao != 0) {

            System.out.println("\nEscolha:");
            System.out.println("1 - Inserir");
            System.out.println("2 - Remover");
            System.out.println("3 - Listar");
            System.out.println("4 - Exportar em .txt");
            System.out.println("0 - Sair");
            subOpcao = scanner.nextInt();

            switch (subOpcao) {

                case 1:

                    System.out.println("Digite o novo valor");
                    scanner.nextLine();
                    String valor = scanner.nextLine();

                    if (lista.isEmpty()) {

                        lista.addFirst(valor);

                    } else {

                        System.out.println("Digite a posicao");
                        int index = scanner.nextInt();

                        lista.add(index, valor);
                    }

                    break;

                case 2:

                    if (lista.isEmpty()) {

                        lista.removeFirst();

                    } else {

                        System.out.println("Digite a posicao");
                        scanner.nextLine();
                        int index = scanner.nextInt();

                        lista.remove(index);
                    }

                case 3:
                	
                	if (opcaoLista == 2) {
                		
                		System.out.println("1 - Listar\n2 - Listar inversamente");
                		
                		int opcao = scanner.nextInt();
                		
                		switch(opcao) {
                		
                			case 1:
                				
                				System.err.println(lista.list());
                				
                			case 2:
                				
                				System.err.println(((DoublyLinkedList) lista).invertedList());
                		}

                    } else {
                    	
                    	System.err.println(lista.list());
                    }

                    break;
                    
                case 4:
                	
                	imprimirLista(lista, "lista");
            }

        }

        System.exit(0);
    }

    
    public static void imprimirLista(LinkableList lista, String nomeArquivo) throws IOException {
		
		File file = new File("D:\\" + nomeArquivo + ".txt");
		
		if(!file.exists()) { 
			
			file.createNewFile();
		}

		try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {

			for (String value : lista.list()) {
				writer.write(value);
				writer.newLine();
			}
		}
	}

}
