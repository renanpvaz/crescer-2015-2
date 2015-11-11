using System;
using Microsoft.VisualStudio.TestTools.UnitTesting;
using Locadora.Dominio.Servicos;
using Locadora.Web.MVC.Helpers;

namespace Locadora.Dominio.Test
{
    [TestClass]
    public class ServicoAutentificacaoTest
    {
        [TestMethod]
        public void BuscaUsuarioAutenticadoExistente()
        {
            var servicoAutentificacao = FabricaDeModulos.CriarServicoAutenticacao();

            var usuarioAutenticado = servicoAutentificacao.BuscarPorAutenticacao("master@admin.com", "501C3E9279882FFB776A1D1E506D0410");

            Assert.IsNotNull(usuarioAutenticado);
        }
    }
}
