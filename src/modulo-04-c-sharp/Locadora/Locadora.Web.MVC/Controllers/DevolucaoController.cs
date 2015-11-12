using Locadora.Web.MVC.Helpers;
using Locadora.Web.MVC.Models;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Mvc;

namespace Locadora.Web.MVC.Controllers
{
    public class DevolucaoController : Controller
    {
        // GET: Devolucao
        public ActionResult Index()
        {
            return View();
        }

        public ActionResult Devolver()
        {
            return View();
        }

        public ActionResult ExibirLocacao(string buscaLocacao)
        {
            var repositorioJogo = FabricaDeModulos.CriarJogoRepositorio();
            var repositorioLocacao = FabricaDeModulos.CriarLocacaoRepositorio();

            var jogo = repositorioJogo.BuscarPorNome(buscaLocacao).First();
            var locacao = repositorioLocacao.BuscarPorJogo(jogo);

            ViewBag.Nome = jogo.Nome;

            return View("Index", new JogoLocacaoModel(jogo, locacao));
        }
    }
}