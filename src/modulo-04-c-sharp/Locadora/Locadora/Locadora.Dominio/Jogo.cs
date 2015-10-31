using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Locadora.Dominio
{
    public class Jogo
    {

        public Categoria Categoria { get; private set; }

        public string Nome { get; private set; }

        public double Preco { get; private set; }

        public Jogo(string nome, double preco, Categoria categoria)
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

        public string ToString()
        {
            string nome;
            string categoria = this.Categoria.ToString();
            string espacos1 = new string(' ', 17 - categoria.Length);
            string espacos2;

            if (Nome.Length > 29)
            {
                nome = Nome.Substring(0, 28) + ".";
                espacos2 = new string(' ', 30 - nome.Length);
            }
            else
            {
                nome = Nome;
                espacos2 = new string(' ', 30 - Nome.Length);
            }

            return categoria + espacos1 + nome + espacos2 + "R$ " + Preco.ToString().Replace(".", ","); 
        }
    }
}
