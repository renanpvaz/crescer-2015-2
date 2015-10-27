using Microsoft.VisualStudio.TestTools.UnitTesting;
using DbFuncionarios;
using System;

namespace UnitTestProject1
{
    [TestClass]
    public class ProgramTeste
    {
        [TestMethod]
        public void TestMethod1()
        {
            var ordenadosPorCargo = OrdenadosPorCargo();
        }
    }
}
