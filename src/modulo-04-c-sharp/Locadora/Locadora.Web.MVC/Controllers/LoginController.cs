using Locadora.Dominio.Servicos;
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

            ServicoAutenticacao servicoAutenticacao = FabricaDeModulos.CriarServicoAutenticacao();

            var repositorio = FabricaDeModulos.CriarUsuarioRepositorio();

            var usuarioAutenticado = repositorio.BuscarPorEmail(usuario.Email);

            if (usuarioAutenticado != null && usuarioAutenticado.Senha == usuario.Senha)
            {
                var usuarioLogadoModel = new UsuarioLogado(usuarioAutenticado.Nome, usuarioAutenticado.Email, new string[] { usuarioAutenticado.Permissoes.First().Nome });

                FormsAuthentication.SetAuthCookie(usuario.Email, true);
                Session["USUARIO_LOGADO"] = usuarioLogadoModel;
            }

            return RedirectToAction("Index", "Login");
        }
    }
}