using System;
using Microsoft.VisualStudio.TestTools.UnitTesting;

namespace Locadora.Dominio.Test
{
    [TestClass]
    public class UsuarioTest
    {
        [TestMethod]
        public void UsuarioPossuiPermissaoAdicionada()
        {
            var permissao = new Permissao();
            var usuario = new Usuario();

            permissao.Nome = "PERMISSAO_QUE_PODE_TUDO";
            usuario.Permissoes.Add(permissao);

            Assert.IsTrue(usuario.Permissoes.Contains(permissao));
        }

        [TestMethod]
        public void UsuarioPossuiAmbasPermissoesAdicionadas()
        {
            var permissao1 = new Permissao();
            var permissao2 = new Permissao();
            var usuario = new Usuario();

            permissao1.Nome = "PERMISSAO_QUE_PODE_TUDO";
            permissao2.Nome = "PERMISSAO_DO_FABRICIO_OPERADOR";
            usuario.Permissoes.Add(permissao1);
            usuario.Permissoes.Add(permissao2);

            Assert.AreEqual(2, usuario.Permissoes.Count);
        }
    }
}
