using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ConsoleApp
{
    class Program
    {
        static void Main(string[] args)
        {
            

            var agenda = new Agenda();
            string nome;
            int numero;
            int resposta = 0;

            Console.WriteLine(
                "\nDigite 1 para adicionar contato" +
                "\n2 para remover contatos por nome" +
                "\n3 para remover por numero" +
                "\n4 para listar contatos" +
                "\n5 para listar ordenados por nome" +
                "\n6 para sair");


            while(resposta != 6)
            {
                resposta = int.Parse(Console.ReadLine());

                switch (resposta)
                {

                    case 1:
                        Console.WriteLine("Digite o nome do contato");
                        nome = Console.ReadLine();
                        Console.WriteLine("Digite o numero do contato");
                        numero = int.Parse(Console.ReadLine());
                        agenda.AdicionarContato(new Contato(nome, numero));
                        Console.WriteLine("Contato adicionado");                      
                        break;

                    case 2:
                        Console.WriteLine("Digite o nome dos contatos a serem removidos");
                        nome = Console.ReadLine();
                        agenda.RemoverContatosPorNome(nome);
                        Console.WriteLine("Contato(s) removido(s)");
                        break;

                    case 3:
                        Console.WriteLine("Digite o numero dos contatos a serem removidos");
                        numero = int.Parse(Console.ReadLine());
                        agenda.RemoverContatoPorNumero(numero);
                        Console.WriteLine("Contato(s) removido(s)");
                        break;

                    case 4:
                        Console.WriteLine(agenda.ListaContatos());
                        break;

                    case 5:
                        agenda.ListarContatosOrdenadosPorNome();
                        break;

                }

                resposta = 0;
                numero = 0;
                nome = "";

                Console.WriteLine("Escolha uma opção");
            }
            

        }
    }
}
