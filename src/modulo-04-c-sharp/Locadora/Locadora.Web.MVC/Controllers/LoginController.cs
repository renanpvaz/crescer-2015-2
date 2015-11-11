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

        [Autorizador(Roles = "MASTER")]
        public ActionResult Master()
        {
            return View();
        }

        public ActionResult Login(UsuarioLoginModel usuario)
        {
            if (usuario.Email == "didi@die" && usuario.Senha == "plz")
            {
                var usuarioLogadoModel = new UsuarioLogado("Didi", "didi@die", new string[] { "MASTER" });

                FormsAuthentication.SetAuthCookie(usuario.Email, true);
                Session["USUARIO_LOGADO"] = usuarioLogadoModel;
            }

            return RedirectToAction("Index", "Login");
        }
    }
}