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

        public BaseDeDados()
        {
            CaminhoJogo = @"C:\Users\renan.vaz\Documents\crescer-2015-2\src\modulo-04-c-sharp\Locadora\game_store.xml";
        }

         void CadastrarJogo(Jogo jogo)
        {

        }

        public List<Jogo> PesquisarJogoPorNome(string nome)
        {
            XElement xml = XElement.Load(CaminhoJogo);

            IEnumerable<XElement> jogosXml =
                from j in xml.Elements("jogos")
                where j.Element("nome").Value.Contains(nome)
                select j;
            List<Jogo> jogos = new List<Jogo>();

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
                    jogo.Element("categoria").Value);
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
