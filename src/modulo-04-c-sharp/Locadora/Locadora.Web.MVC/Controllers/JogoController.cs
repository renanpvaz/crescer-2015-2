using Locadora.Dominio;
using Locadora.Dominio.Repositorio;
using Locadora.Web.MVC.Models;
using Locadora.Web.MVC.Segurança;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Mvc;

namespace Locadora.Web.MVC.Controllers
{
    public class JogoController : Controller
    {
        public ActionResult DetalhesJogo(int id)
        {
            IJogoRepositorio repositorio = new Repositorio.EF.JogoRepositorio();

            var jogo = repositorio.BuscarPorId(id);
            var jogoDetalhes = new JogoDetalhesModel();

            return View(jogoDetalhes.ConverterJogoParaModel(jogo));
        }

        [Autorizador(Roles = Permissao.PERMISSAO_MASTER)]
        public ActionResult Manter(int id = 0)
        {
            if (id > 0)
            {
                IJogoRepositorio repositorio = new Repositorio.EF.JogoRepositorio();

                var jogo = repositorio.BuscarPorId(id);
                var jogoEditar = new JogoDetalhesModel();              

                return View(jogoEditar.ConverterJogoParaModel(jogo));
            }

            return View();
        }

        public ActionResult Salvar(JogoDetalhesModel model)
        {
            var errors = ModelState.Values.SelectMany(v => v.Errors);

            if (ModelState.IsValid)
            {
                IJogoRepositorio repositorio = new Repositorio.EF.JogoRepositorio();
                TempData["Status"] = true;


                if (!model.Id.HasValue)
                {
                    repositorio.Criar(model.ConverterParaJogo());
                    TempData["Mensagem"] = "Jogo cadastrado.";
                }
                else
                {
                    repositorio.Atualizar(model.ConverterParaJogo());
                    TempData["Mensagem"] = "Jogo atualizado.";
                }

                return RedirectToAction("JogosDisponiveis", "Relatorio");
            }
            else
            {
                return View("Manter", model);
            }
        }
    }
}