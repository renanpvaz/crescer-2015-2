using Locadora.Web.MVC.Helpers;
using Locadora.Web.MVC.Models;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Mvc;

namespace Locadora.Web.MVC.Controllers
{
    public class LocacaoController : Controller
    {
        // GET: Locacao
        public ActionResult Index(int id)
        {
            var repositorio = FabricaDeModulos.CriarJogoRepositorio();

            var jogo = repositorio.BuscarPorId(id);

            return View(new JogoDetalhesModel(jogo));
        }
    }
}