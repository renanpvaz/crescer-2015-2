using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Xml;
using System.Xml.Linq;

namespace Locadora.Dominio
{
    public class BaseDeDados
    {

        public string CaminhoJogo { get; private set; }

        public BaseDeDados(string caminhoJogo)
        {
            CaminhoJogo = caminhoJogo;
        }

         public void CadastrarJogo(Jogo jogo)
        {
            //if(ValidaJogo)

        }

        public List<Jogo> PesquisarJogoPorNome(string nome)
        {
            XElement xml = XElement.Load(CaminhoJogo);

            List<Jogo> jogos = new List<Jogo>();

            IEnumerable<XElement> jogosXml = xml.Elements("jogo")
                .Where(jogo => jogo.Element("nome").Value.Contains(nome));

            foreach (var jogo in jogosXml)
            {
                jogos.Add(ConverteXElementParaJogo(jogo));
            }

            return jogos;
        }

        private Jogo ConverteXElementParaJogo(XElement jogo)
        {
            return new Jogo(jogo.Element("nome").Value,
                    Convert.ToDouble(jogo.Element("preco").Value),
                    (Categoria)Enum.Parse(typeof(Categoria), jogo.Element("categoria").Value));
        }

        void EditarJogo(Jogo jogo)
        {

        }

        public string ExportarRelatorio()
        {
            return null;
        } 
    }
}
