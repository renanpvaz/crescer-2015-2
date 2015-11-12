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

    }
}
