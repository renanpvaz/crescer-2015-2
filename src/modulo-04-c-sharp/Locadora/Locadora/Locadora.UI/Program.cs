using Locadora.Dominio;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Locadora.UI
{
    class Program
    {
        public const int OPC_CADASTRAR_JOGO = 1;
        public const int OPC_BUSCAR_JOGOS = 2;
        public const int OPC_EDITAR_JOGO = 3;
        public const int OPC_GERAR_RELATORIO = 4;
        public const string MSG_VOLTAR = "\nAperte qualquer botão para voltar";

        static void Main(string[] args)
        {
            int opcaoSelecionada = -1;
            var dados = new BaseDeDados();

            while (opcaoSelecionada != 0)
            {
                Console.Clear();
                Console.WriteLine("Digite um número de acordo com a opção desejada");
                Console.WriteLine("1. Cadastrar novo jogo");
                Console.WriteLine("2. Buscar jogos por nome");
                Console.WriteLine("3. Editar jogo existente");
                Console.WriteLine("4. Gerar relatório");
                Console.WriteLine("0. Sair");

                var entrada = Console.ReadLine();

                if(entrada == "")
                {
                    entrada = Console.ReadLine();
                }

                try
                {
                    opcaoSelecionada = int.Parse(entrada);
                }
                catch(System.FormatException)
                {
                    Console.Clear();                 
                    Console.WriteLine("Opção inválida!\nAperte qualquer botão para tentar novamente");
                    Console.Read();
                }

                switch (opcaoSelecionada)
                {
                    case OPC_CADASTRAR_JOGO:

                        try
                        {
                            Console.Clear();
                            Console.WriteLine("Informe o nome do novo jogo");
                            string nomeJogo = Console.ReadLine();

                            Console.WriteLine("Informe a categoria do jogo");
                            Categoria categoriaJogo = (Categoria)Enum.Parse(typeof(Categoria), Console.ReadLine().ToUpper());

                            Console.WriteLine("Informe o preço do jogo");
                            double precoJogo = Convert.ToDouble(Console.ReadLine(), System.Globalization.CultureInfo.InvariantCulture);

                            dados.CadastrarJogo(new Jogo(nomeJogo, precoJogo, categoriaJogo));

                            Console.WriteLine(MSG_VOLTAR);

                            Console.Read();
                        }
                        catch(System.FormatException)
                        {
                            Console.Clear();
                            Console.WriteLine("Opção inválida!\nAperte qualquer botão para tentar novamente");
                            Console.Read();
                        }

                        break;

                    case OPC_BUSCAR_JOGOS:

                        Console.Clear();
                        Console.WriteLine("Informe o nome do jogo à ser buscado");
                        string buscaJogo = Console.ReadLine();

                        Console.WriteLine("Resultados:");
                        foreach (var resultado in dados.PesquisarJogoPorNome(buscaJogo))
                        {
                            Console.WriteLine(resultado.ToString());
                        }

                        Console.WriteLine(MSG_VOLTAR);

                        Console.Read();

                        break;

                    case OPC_EDITAR_JOGO:

                        try
                        {

                            Console.Clear();
                            Console.WriteLine("Informe o ID do jogo à ser editado");
                            int id = int.Parse(Console.ReadLine());

                            Console.WriteLine("Digite o campo à ser alterado");
                            string campo = Console.ReadLine();

                            Console.WriteLine("Digite o novo valor para o campo " + campo);
                            string novoValor = Console.ReadLine();

                            dados.EditarJogo(id, campo, novoValor);

                            Console.WriteLine(MSG_VOLTAR);

                            Console.Read();
                        }
                        catch (System.FormatException)
                        {
                            Console.Clear();
                            Console.WriteLine("Opção inválida!\nAperte qualquer botão para tentar novamente");
                            Console.Read();
                        }

                        break;

                    case OPC_GERAR_RELATORIO:

                        Console.Clear();
                        Console.WriteLine("Relatório gerado\nCaminho: C:\\Users\\Public\\relatorio.txt");

                        Relatorio.ExportarRelatorioEmTxt();

                        Console.WriteLine(MSG_VOLTAR);

                        Console.Read();

                        break;
                }

            }

            Environment.Exit(0);
        }
    }
}
