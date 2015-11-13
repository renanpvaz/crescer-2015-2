using Locadora.Dominio.Servicos;
using Locadora.Repositorio.Servicos;
using Locadora.Web.MVC.Helpers;
using Locadora.Web.MVC.Models;
using Locadora.Web.MVC.Segurança;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Mvc;
using System.Web.Security;

namespace Locadora.Web.MVC.Controllers
{
    public class LoginController : Controller
    {
        public ActionResult Index()
        {
            ViewBag.UsuarioLogado = Session["USUARIO_LOGADO"];
            return View();
        }

        [Autorizador(Roles = Permissao.PERMISSAO_MASTER)]
        public ActionResult Master()
        {
            return View();
        }

        public ActionResult Login(UsuarioLoginModel usuario)
        {
            if (ModelState.IsValid)
            {
                var repositorio = FabricaDeModulos.CriarUsuarioRepositorio();

                var criptografia = FabricaDeModulos.CriarServicoCriptografia();

                var usuarioAutenticado = repositorio.BuscarPorEmail(usuario.Email);

                var senha = criptografia.CriptografarSenha(usuario.Senha);

                if (usuarioAutenticado != null && usuarioAutenticado.Senha == senha)
                {
                    var usuarioLogadoModel = new UsuarioLogado(usuarioAutenticado.Nome, usuarioAutenticado.Email, usuarioAutenticado.Permissoes.Select(x => x.Nome).ToArray());

                    FormsAuthentication.SetAuthCookie(usuario.Email, true);
                    Session["USUARIO_LOGADO"] = usuarioLogadoModel;
                }
                else
                {
                    TempData["MensagemErro"] = "Email ou senha incorretos.";
                }

                return RedirectToAction("Index", "Login");
            }

            return View("Index");
        }
    }
}