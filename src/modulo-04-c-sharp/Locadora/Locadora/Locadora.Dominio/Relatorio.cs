using System;
using System.Collections.Generic;
using System.IO;

namespace Locadora.Dominio
{
    public class Relatorio
    {
        public const string CAMINHO_RELATORIO = @"C:\Users\Public\relatorio.txt";
        public const string TITULO1 = "                             LOCADORA NUNES GAMES                               ";
        public const string DATA_HORA = "{0}                                                              {1}";
        public const string TITULO2 = "                              Relatório de jogos                                ";
        public const string LINHA1 =  "================================================================================";
        public const string LINHA2 =  "--------------------------------------------------------------------------------";
        public const string COLUNAS = "ID       Categoria        Nome                          Preço         Disponivel";


        public static void ExportarRelatorioEmTxt()
        {
            using (StreamWriter writer = File.AppendText(CAMINHO_RELATORIO))
            {
                var dados = new BaseDeDados();
                File.SetAttributes(CAMINHO_RELATORIO, FileAttributes.Normal);

                writer.WriteLine(TITULO1);
                writer.WriteLine(string.Format(DATA_HORA, string.Format("{0:dd/MM/yyyy}", DateTime.Now), DateTime.Now.ToString("HH:mm:ss")));
                writer.WriteLine(TITULO2);
                writer.WriteLine("");
                writer.WriteLine(LINHA1);
                writer.WriteLine(COLUNAS);

                foreach (var jogo in dados.ToString())
                {
                    writer.WriteLine(jogo);
                }

                writer.WriteLine(LINHA2);
                writer.WriteLine("Quantidade total de jogos: " + dados.BuscarTotalDeJogos());
                writer.WriteLine("Quantidade de jogos disponíveis: " + dados.BuscarTotalDeJogos());
                writer.WriteLine("Valor médio por jogo: R$ " + dados.BuscarPrecoMedio().ToString().Substring(0, 5));
                writer.WriteLine("Jogo mais caro: " + dados.BuscarJogoMaisCaro().Nome);
                writer.WriteLine("Jogo mais barato: " + dados.BuscarJogoMaisBarato().Nome);
                writer.WriteLine(LINHA1);

                writer.Close();
            }
        }

    }
}
