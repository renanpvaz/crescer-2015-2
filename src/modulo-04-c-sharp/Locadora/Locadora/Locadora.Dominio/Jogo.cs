using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Locadora.Dominio
{
    public class Jogo
    {

        public string Categoria { get; private set; }

        public string Nome { get; private set; }

        public double Preco { get; private set; }

        public Jogo(string nome, double preco, string categoria)
        {
            Nome = nome;
            Preco = preco;
            Categoria = categoria;
        }

        public bool ValidarJogo()
        {
            return false;
        }

        public bool Equals(Jogo jogo)
        {
            return this.Nome == jogo.Nome &&
                this.Preco == jogo.Preco &&
                this.Categoria == jogo.Categoria;
        }
    }
}
