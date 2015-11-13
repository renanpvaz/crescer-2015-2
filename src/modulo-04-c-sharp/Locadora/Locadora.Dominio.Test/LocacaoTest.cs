using System;
using Microsoft.VisualStudio.TestTools.UnitTesting;

namespace Locadora.Dominio.Test
{
    [TestClass]
    public class LocacaoTest
    {
        [TestMethod]
        public void LocacaoCriadaComADataAtual()
        {
            var locacao = new Locacao(1, 1);

            Assert.AreEqual(DateTime.Now.Date, locacao.DataLocacao.Date);
        }

        [TestMethod]
        public void CriadaLocacaoComClienteEJogo()
        {
            var cliente = new Cliente(1);
            var jogo = new Jogo();

            var locacao = new Locacao(jogo, cliente);

            Assert.AreEqual(jogo, locacao.Jogo);
            Assert.AreEqual(cliente, locacao.Cliente);
        }

        [TestMethod]
        public void LocacaoEhFinalizada()
        {
            var locacao = new Locacao(1, 1);

            locacao.RealizarEntrega();

            Assert.AreEqual(DateTime.Now, locacao.DataEntrega);
        }
    }
}
