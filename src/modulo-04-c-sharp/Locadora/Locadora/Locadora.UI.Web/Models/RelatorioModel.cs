using Locadora.Dominio;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace Locadora.UI.Web.Views.Relatorio
{
    public class RelatorioModel
    {
        public int QuantidadeDeJogos { get; set; }
        public double PrecoMedio { get; set; }
        public Jogo JogoMaisCaro { get; set; }
        public Jogo JogoMaisBarato { get; set; }

        BaseDeDados dados = new BaseDeDados();

        public RelatorioModel()
        {
            QuantidadeDeJogos = dados.BuscarTotalDeJogos();
            PrecoMedio = dados.BuscarPrecoMedio();
            JogoMaisCaro = dados.BuscarJogoMaisCaro();
            JogoMaisBarato = dados.BuscarJogoMaisBarato();
        }
    }
}