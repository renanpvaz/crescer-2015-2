﻿using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace Locadora.Web.MVC.Models
{
    public class RelatorioModel
    {

        public List<JogoModel> Jogos { get; set; }
        public int QuantidadeDeJogos { get; set; }
        public string JogoMaisCaro { get; set; }
        public string JogoMaisBarato { get; set; }
        public decimal PrecoMedio { get; set; }
        public bool EncontrouResultados{ get; set; }

        public RelatorioModel()
        {
            EncontrouResultados = false;
            Jogos = new List<JogoModel>();
        }

    }
}