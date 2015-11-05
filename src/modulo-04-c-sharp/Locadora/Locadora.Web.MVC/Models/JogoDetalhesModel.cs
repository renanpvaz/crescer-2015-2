using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace Locadora.Web.MVC.Models
{
    public class JogoDetalhesModel
    {

        public int Id { get; set; }
        public string Nome { get; set; }
        public decimal Preco { get; set; }
        public string Categoria { get; set; }
        public string Selo { get; set; }
        public string Descricao { get; set; }
        public string Imagem { get; set; }

        public JogoDetalhesModel(int id, string nome, decimal preco, string categoria, string selo, string descricao)
        {
            Id = id;
            Nome = nome;
            Preco = preco;
            Categoria = categoria;
            Selo = selo;
            Descricao = descricao;
        }

    }

}
