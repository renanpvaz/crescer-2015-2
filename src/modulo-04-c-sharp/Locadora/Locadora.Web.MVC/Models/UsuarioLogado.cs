using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace Locadora.Web.MVC.Models
{
    public class UsuarioLogado
    {
        public string Nome { get; set; }

        public string Email { get; set; }

        public string[] Permissoes { get; set;}

        public UsuarioLogado(string nome, string email, string[] permissoes)
        {
            this.Nome = nome;
            this.Email = email;
            this.Permissoes = permissoes;
        }
    }
}