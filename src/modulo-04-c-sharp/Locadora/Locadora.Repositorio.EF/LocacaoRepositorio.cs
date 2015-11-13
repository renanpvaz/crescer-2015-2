using Locadora.Dominio;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Locadora.Repositorio.EF
{
    public class LocacaoRepositorio
    {

        public int Criar(Locacao locacao)
        {
            using (var db = new BaseDeDados())
            {
                db.Entry(locacao).State = System.Data.Entity.EntityState.Added;

                return db.SaveChanges();
            }
        }

        public Locacao BuscarPorId(int id)
        {
            using (var db = new BaseDeDados())
            {
                return db.Locacao.Find(id);
            }
        }

        public Locacao BuscarPorJogo(Jogo jogo)
        {
            using (var db = new BaseDeDados())
            {
                return db.Locacao.FirstOrDefault(l => l.IdJogo == jogo.Id);
            }
        }

        public int Desalocar(Locacao locacao)
        {
            using (var db = new BaseDeDados())
            {
                locacao.RealizarEntrega();

                db.Entry(locacao).State = System.Data.Entity.EntityState.Modified;

                return db.SaveChanges();
            }
        }

        public int BuscarTotalDeLocacoesPorCliente(int idCliente)
        {
            using (var db = new BaseDeDados())
            {
                var locacoes = db.Locacao.Count(l => l.IdCliente == idCliente);

                return locacoes;
            }
        }

        public List<Locacao> BuscarPorNomeDoJogo(string nome)
        {
            using (var db = new BaseDeDados())
            {
                var locacoes = db.Locacao.Include("Jogo").Include("Cliente").Where(l => l.Jogo.Nome.Contains(nome)).ToList();

                return locacoes;
            }
        }

    }
}
