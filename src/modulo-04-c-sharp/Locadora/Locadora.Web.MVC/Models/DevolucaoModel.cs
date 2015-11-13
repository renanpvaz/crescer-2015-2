using Locadora.Dominio;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace Locadora.Web.MVC.Models
{
    public class DevolucaoModel
    {
        public List<Locacao> Locacoes { get; set; }

        public DevolucaoModel(List<Locacao> locacoes)
        {
            this.Locacoes = locacoes;
        }
    }
}