

using System.Collections.Generic;
using System.Linq;

namespace ConsoleApp
{
    public class Agenda
    {
        private List<Contato> contatos = new List<Contato>();

        public int QuantidadeContatos { get { return contatos.Count; }  }

        public void AdicionarContato(Contato contato)
        {
            contatos.Add(contato);
        }

        public void RemoverContatosPorNome(string nomeContato)
        {
            var contatosASeremRemovidos = new List<Contato>();

            for (int i = 0; i < contatos.Count; i++)
            {
                if (contatos[i].Nome == nomeContato)
                    contatosASeremRemovidos.Add(contatos[i]);
            }

            foreach (var contato in contatosASeremRemovidos)
            {
                contatos.Remove(contato);
            }
        }

        public void RemoverContatoPorNumero(int numero)
        {
            foreach (var contato in contatos)
            {
                if(contato.Numero == numero)
                {
                    contatos.Remove(contato);
                    break;
                }
            }
        }

        public string ListarContatosOrdenadosPorNome()
        {
            List<Contato> contatosOrdenados = contatos.OrderBy(contato => contato.Nome).ToList();

            var lista = "";

            foreach (var contato in contatosOrdenados)
            {
                lista += contato.Nome + " - " + contato.Numero + "\n";
            }

            return lista;

        }

        public string ListaContatos()
        {
            var lista = "";

            foreach (var contato in contatos)
            {
                lista += contato.Nome + " - " + contato.Numero + "\n";
            }
            return lista;
        }

    }
}
