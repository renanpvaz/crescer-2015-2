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

        public int Atualizar(Jogo jogo)
        {
            return 1;
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
            return null;
        }

        public int Criar(Jogo jogo)
        {
            return 1;
        }

        public int Excluir(int id)
        {
            return 1;
        }


    }
}
