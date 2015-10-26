using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ConsoleApp
{
    public class Contato
    {
        public Contato(string nome, int numero)
        {
            this.Nome = nome;
            this.Numero = numero;
        }

        public int Numero { get; set; }
        public string Nome { get; set; }
    }
}
