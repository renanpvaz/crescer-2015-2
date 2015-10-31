using System;
using Microsoft.VisualStudio.TestTools.UnitTesting;
using Locadora.Dominio;
using System.Collections.Generic;

namespace Locadora.UnitTest
{
    [TestClass]
    public class BaseDeDadosTest
    {
        [TestMethod]
        public void PesquisaPorJogoComUmResultado()
        {
            var dados = new BaseDeDados();
            var jogo = new Jogo("Top Gear", 20, Categoria.CORRIDA);
            List<Jogo> expected = new List<Jogo>();
            expected.Add(jogo);
            var actual = dados.PesquisarJogoPorNome("Top Gear");

            Assert.IsTrue(expected[0].Equals(actual[0])); 
        }

        [TestMethod]
        public void AdicionaJogoEPesquisaPeloMesmo()
        {
            var dados = new BaseDeDados();
            var jogo = new Jogo("Metal Slug X", 25, Categoria.AVENTURA);
            dados.CadastrarJogo(jogo);
            var actual = dados.PesquisarJogoPorNome("Metal Slug X");

            Assert.IsTrue(jogo.Equals(actual[0]));
        }

        [TestMethod]
        public void EditaJogoEPesquisaPeloMesmo()
        {
            var dados = new BaseDeDados();
            dados.EditarJogo(21, "categoria", Categoria.AVENTURA);

            Assert.AreEqual(Categoria.AVENTURA, dados.PesquisarJogoPorNome("Metal Slug 3")[0].Categoria);
        }
    }
}
