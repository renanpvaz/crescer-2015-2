using System;
using Microsoft.VisualStudio.TestTools.UnitTesting;
using Locadora.Dominio;

namespace Locadora.UnitTest
{
    [TestClass]
    public class UnitTest1
    {
        [TestMethod]
        public void TestMethod1()
        {
            var dados = new BaseDeDados();
            string resultado = new Jogo("Top Gear", 20, "Categoria");

            Assert.AreEqual("Top Gear", resultado);
        }
    }
}
