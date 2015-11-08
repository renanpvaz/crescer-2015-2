
using Locadora.Dominio;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace Locadora.Web.MVC.Models
{
    public class JogoDetalhesModel
    {

        public int? Id { get; set; }
        public string Nome { get; set; }
        public decimal Preco { get; set; }
        public Categoria Categoria { get; set; }
        public Selo Selo { get; set; }
        public string Descricao { get; set; }
        public string Imagem { get; set; }

        public JogoDetalhesModel()
        {
        }

    }

}
