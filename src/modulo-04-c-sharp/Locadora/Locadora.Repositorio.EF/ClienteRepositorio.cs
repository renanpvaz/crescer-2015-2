using Locadora.Dominio;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Locadora.Repositorio.EF
{
    public class ClienteRepositorio
    {

        public Cliente BuscarPorId(int id)
        {
            using (var db = new BaseDeDados())
            {
                return db.Cliente.Find(id);
            }
        }

        public IList<Cliente> BuscarPorNome(string nome)
        {
            using (var db = new BaseDeDados())
            {
                var jogos = db.Cliente.Where(j => j.Nome.Contains(nome)).ToList();

                return jogos;
            }
        }

        public IList<Cliente> BuscarTodos()
        {
            using (var db = new BaseDeDados())
            {
                return db.Cliente.ToList();
            }
        }

    }
}
