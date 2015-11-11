using System;
using Microsoft.VisualStudio.TestTools.UnitTesting;
using Locadora.Repositorio.Servicos;

namespace Locadora.Servicos.Test
{
    [TestClass]
    public class ServicoCriptograficaTest
    {
        [TestMethod]
        public void CriptografaSenha123()
        {
            var servicoCriptografia = new ServicoCriptografia();
            var senhaCriptografada = servicoCriptografia.CriptografarSenha("123");

            Assert.AreEqual("501C3E9279882FFB776A1D1E506D0410", senhaCriptografada);
        }

        [TestMethod]
        public void CriptografaSenha1234()
        {
            var servicoCriptografia = new ServicoCriptografia();
            var senhaCriptografada = servicoCriptografia.CriptografarSenha("1234");

            Assert.AreEqual("68ACE0CACCCF2CAF2C604BB54FDF450C", senhaCriptografada);
        }
    }
}
