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

        public const string CAMINHO_XML_JOGOS = @"C:\Users\Public\game_store.xml";

        public void CadastrarJogo(Jogo jogo)
        {
            XElement xml = XElement.Load(CAMINHO_XML_JOGOS);

            //if(ValidaJogo)
            XElement novoJogo = new XElement("jogo", new XAttribute("id", PegarProximoIdJogo()));
            novoJogo.Add(new XElement("nome"));
            novoJogo.Add(new XElement("preco"));
            novoJogo.Add(new XElement("categoria"));
            novoJogo.Element("nome").Value = jogo.Nome;
            novoJogo.Element("preco").Value = jogo.Preco.ToString();
            novoJogo.Element("categoria").Value = jogo.Categoria.ToString();

            xml.Add(novoJogo);
            xml.Save(CAMINHO_XML_JOGOS);
        }

        public List<Jogo> PesquisarJogoPorNome(string nome)
        {
            XElement xml = XElement.Load(CAMINHO_XML_JOGOS);

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

        private int PegarProximoIdJogo()
        {
            XElement xml = XElement.Load(CAMINHO_XML_JOGOS);
            var last = xml.Elements("jogo").Last();

            return int.Parse(last.Attribute("id").Value) + 1;

        }

        public void EditarJogo<T>(int id, string campo, T arg)
        {
            var novoValor = arg.ToString();

            XDocument root = XDocument.Load(CAMINHO_XML_JOGOS);

            XElement jogo = root.Element("jogos")
                .Elements().FirstOrDefault(j => id.ToString() == j.Attribute("id").Value);

            jogo.Element(campo.ToLower()).Value = novoValor;

            root.Save(CAMINHO_XML_JOGOS);
        }

        public string ExportarRelatorio()
        {
            return null;
        }
    }
}
