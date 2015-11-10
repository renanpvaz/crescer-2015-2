using Locadora.Dominio;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Locadora.Repositorio.EF
{
    class JogoRepositorio
    {

        public int Atualizar(Jogo entidade)
        {
            using (var db = new BaseDeDados())
            {
                Jogo jogo = db.Jogo.Find(entidade.Id);
                db.Entry(jogo).State = System.Data.Entity.EntityState.Added;

                return db.SaveChanges();
            }
        }

        public Jogo BuscarPorId(int id)
        {
            using (var db = new BaseDeDados())
            {
                return db.Jogo.Find(id);
            }
        }

        public IList<Jogo> BuscarPorNome(string nome)
        {
            using (var db = new BaseDeDados())
            {
                return db.Jogo.Where(j => j.Nome.Contains(nome)).ToList();
            }
        }

        public IList<Jogo> BuscarTodos()
        {
            using (var db = new BaseDeDados())
            {
                return db.Jogo.ToList();
            }
        }

        public int Criar(Jogo entidade)
        {
            using (var db = new BaseDeDados())
            {
                db.Entry(entidade).State = System.Data.Entity.EntityState.Added;

                return db.SaveChanges();
            }
        }

        public int Excluir(int id)
        {
            using (var db = new BaseDeDados())
            {
                Jogo jogo = db.Jogo.Find(id);
                db.Entry(jogo).State = System.Data.Entity.EntityState.Deleted;

                return db.SaveChanges();
            }
        }


    }
}
