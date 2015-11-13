using Locadora.Dominio;
using Locadora.Dominio.Repositorio;
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
            var repositorioJogo = FabricaDeModulos.CriarJogoRepositorio();
            var repositorioCliente = FabricaDeModulos.CriarJogoRepositorio();

            var jogo = repositorioJogo.BuscarPorId(id);

            ViewBag.Jogos = repositorioCliente.BuscarTodos();

            return View(new JogoLocacaoModel(jogo));
        }

        public ActionResult Salvar(int Id, string nomeCliente)
        {
            var repositorioCliente = FabricaDeModulos.CriarClienteRepositorio();
            var repositorioLocacao = FabricaDeModulos.CriarLocacaoRepositorio();

            var cliente = repositorioCliente.BuscarPorNome(nomeCliente).First();
            var totalDeLocacoes = repositorioLocacao.BuscarTotalDeLocacoesPorCliente(cliente.Id);

            if (totalDeLocacoes < 3)
            {
                repositorioLocacao.Criar(new Locacao(Id, cliente.Id));
            }
            else
            {
                TempData["MensagemLocação"] = "O cliente já possui três jogos locados!";
            }

            return RedirectToAction("Index", new { id = Id });
        }

        public JsonResult ClienteAutocomplete(string term)
        {
            IList<Cliente> clientesEncontrados = ObterClientesPorFiltro(term);

            var json = clientesEncontrados.Select(x => x.Nome);

            return Json(json, JsonRequestBehavior.AllowGet);
        }

        private IList<Cliente> ObterClientesPorFiltro(string nome)
        {
            var clienteRepositorio = FabricaDeModulos.CriarClienteRepositorio();

            if (string.IsNullOrEmpty(nome))
                return clienteRepositorio.BuscarTodos();
            else
                return clienteRepositorio.BuscarPorNome(nome);
        }
    }
}