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

        public ActionResult Desalocar(int id)
        {
            var repositorioJogo = FabricaDeModulos.CriarJogoRepositorio();
            var repositorioLocacao = FabricaDeModulos.CriarLocacaoRepositorio();

            var jogo = repositorioJogo.BuscarPorId(id);
            var locacao = repositorioLocacao.BuscarPorId(id);

            repositorioLocacao.Desalocar(locacao);

            return View("Index");
        }

        public ActionResult ExibirLocacao(string buscaLocacao)
        {
            var repositorioLocacao = FabricaDeModulos.CriarLocacaoRepositorio();

            var locacoes = repositorioLocacao.BuscarPorNomeDoJogo(buscaLocacao);

            return View("Index", new DevolucaoModel(locacoes));
        }
    }
}