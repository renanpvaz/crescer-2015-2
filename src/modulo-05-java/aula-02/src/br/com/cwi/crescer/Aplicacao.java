package br.com.cwi.crescer;

import java.sql.Connection;
import java.sql.SQLException;

import br.com.cwi.dao.ServicoDao;
import br.com.cwi.jdbc.ConnectionFactory;
import br.com.cwi.model.Servico;

public class Aplicacao {

    public static final String LINHAS_AFETADAS = "Linhas afetadas: ";

    public static void main(String[] args) throws Exception {

        try {
            Connection connection = new ConnectionFactory().getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Erro sql!!!");
        }

        Servico servico = new Servico();

        servico.setIdServico(1L);
        servico.setDsServico("Lavagem normal");

        Servico servicoAtl = new Servico();

        servico.setIdServico(1L);
        servico.setDsServico("Lavagem");

        Servico servico2 = new Servico();

        servico.setIdServico(2L);
        servico.setDsServico("Lavagem a seco");

        ServicoDao servicoDao = new ServicoDao();

        System.out.println(LINHAS_AFETADAS + servicoDao.adicionar(servico));
        System.out.println(LINHAS_AFETADAS + servicoDao.adicionar(servico2));

        for (Servico s : servicoDao.listarTodos()) {
            System.out.println(s.toString());
        }

        System.out.println(LINHAS_AFETADAS + servicoDao.atualizar(servicoAtl));

        System.out.println(LINHAS_AFETADAS + servicoDao.excluir(2L));



        /*

        Scanner scanner = new Scanner(System.in);

        System.out.println("Opções:\n1 - Lista encadeada\n2 - Lista duplamente encadeada");
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
            System.out.println("3 - Listar" + (opcaoLista == 2 ? "\n4 - Listar invertidamente" : ""));

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

                        System.out.println("Digite a posição");
                        int index = scanner.nextInt();

                        lista.add(index, valor);
                    }

                    break;

                case 2:

                    if (lista.isEmpty()) {

                        lista.removeFirst();

                    } else {

                        System.out.println("Digite a posição");
                        scanner.nextLine();
                        int index = scanner.nextInt();

                        lista.remove(index);
                    }

                case 3:

                    System.err.println(lista.list());

                    break;

                case 4:

                    if (opcaoLista == 2) {

                        System.err.println(((DoublyLinkedList) lista).invertedList());
                    }
            }

        }

        System.exit(0);
    }

         */
    }

}
