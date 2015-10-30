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
            var dados = new BaseDeDados(@"C:\Users\Public\game_store.xml");
            var jogo = new Jogo("Top Gear", 20, Categoria.CORRIDA);
            List<Jogo> expected = new List<Jogo>();
            expected.Add(jogo);
            var actual = dados.PesquisarJogoPorNome("Top Gear");


            Assert.IsTrue(expected[0].Equals(actual[0])); 
        }
    }
}
