using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Locadora.Dominio
{
    public class Locacao
    {
        public int Id { get; set; }

        public int IdCliente { get; set; }
        public Cliente Cliente { get; set; }

        public int IdJogo { get; set; }
        public Jogo Jogo { get; set; }

        public DateTime DataLocacao { get; private set; }

        public DateTime? DataEntrega { get; private set; }
        

        public Locacao(Jogo jogo, Cliente cliente)
        {
            this.Cliente = cliente;
            this.Jogo = jogo;
            this.DataLocacao = DateTime.Now;
        }

        public Locacao(int IdJogo, int IdCliente)
        {
            this.IdCliente = IdCliente;
            this.IdJogo = IdJogo;
            this.DataLocacao = DateTime.Now;
        }

        private void RealizarEntrega()
        {
            this.DataEntrega = DateTime.Now;
        }

    }
}
