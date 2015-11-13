using Locadora.Dominio;
using Locadora.Dominio.Repositorio;
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
    public class LocacaoController : Controller
    {
        [Autorizador]
        public ActionResult Index(int id)
        {
            var repositorioJogo = FabricaDeModulos.CriarJogoRepositorio();
            var repositorioCliente = FabricaDeModulos.CriarJogoRepositorio();

            var jogo = repositorioJogo.BuscarPorId(id);

            ViewBag.Jogos = repositorioCliente.BuscarTodos();

            return View(new JogoLocacaoModel(jogo));
        }

        [Autorizador]
        public ActionResult Salvar(int Id, string nomeCliente)
        {
            var repositorioCliente = FabricaDeModulos.CriarClienteRepositorio();
            var repositorioLocacao = FabricaDeModulos.CriarLocacaoRepositorio();

            var cliente = repositorioCliente.BuscarPorNome(nomeCliente).First();
            var totalDeLocacoes = repositorioLocacao.BuscarTotalDeLocacoesPorCliente(cliente.Id);

            if (totalDeLocacoes < 3)
            {
                if (nomeCliente != "")
                {
                    repositorioLocacao.Criar(new Locacao(Id, cliente.Id));
                }
                else
                {
                    TempData["MensagemLocação"] = "Digite o nome de um cliente";
                }
            }
            else
            {
                TempData["MensagemLocação"] = "O cliente já possui três jogos locados!";
            }

            return RedirectToAction("Index", new { id = Id });
        }

    }
}