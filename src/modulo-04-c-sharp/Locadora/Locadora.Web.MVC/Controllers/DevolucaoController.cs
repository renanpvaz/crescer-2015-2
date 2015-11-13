using Locadora.Web.MVC.Helpers;
using Locadora.Web.MVC.Models;
using Locadora.Web.MVC.Segurança;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Mvc;

namespace Locadora.Web.MVC.Controllers
{
    [Autorizador]
    public class DevolucaoController : Controller
    {
        // GET: Devolucao
        public ActionResult Index()
        {
            return View();
        }

        public ActionResult Desalocar(int id)
        {
            var repositorioJogo = FabricaDeModulos.CriarJogoRepositorio();
            var repositorioLocacao = FabricaDeModulos.CriarLocacaoRepositorio();

            var jogo = repositorioJogo.BuscarPorId(id);
            var locacao = repositorioLocacao.BuscarPorId(id);

            repositorioLocacao.Desalocar(locacao);

            TempData["MensagemDevolucao"] = "Jogo devolvido";

            return View("Index");
        }

        [Autorizador]
        public ActionResult ExibirLocacao(string buscaLocacao)
        {
            var repositorioLocacao = FabricaDeModulos.CriarLocacaoRepositorio();

            var locacoes = repositorioLocacao.BuscarPorNomeDoJogo(buscaLocacao);

            return View("Index", new DevolucaoModel(locacoes));
        }
    }
}