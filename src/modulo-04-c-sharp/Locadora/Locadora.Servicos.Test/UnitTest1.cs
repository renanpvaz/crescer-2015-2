using System;
using Microsoft.VisualStudio.TestTools.UnitTesting;

namespace Locadora.Servicos.Test
{
    [TestClass]
    public class ServicoCriptograficaTest
    {
        [TestMethod]
        public void CriptografaSenha123()
        {
            var servicoCriptografia = new ServicoCriptografia();

            Assert.AreEqual("501C3E9279882FFB776A1D1E506D0410", servicoCriptografia.CriptografarSenha("123"));
        }
    }
}
