using System;
using Microsoft.VisualStudio.TestTools.UnitTesting;
using ConsoleApp;

namespace UnitTestProject1
{
    [TestClass]
    public class AgendaTeste
    {
        [TestMethod]
        public void AgendaTemUmContato()
        {
            var agenda = new Agenda();

            agenda.AdicionarContato(new Contato() { Nome = "Renan", Numero = 12355 });

            Assert.AreEqual(agenda.QuantidadeContatos, 1);


        }
    }
}
