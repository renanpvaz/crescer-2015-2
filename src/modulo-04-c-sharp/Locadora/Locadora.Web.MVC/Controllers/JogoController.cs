using Locadora.Dominio.Repositorio;
using Locadora.Web.MVC.Models;
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
            IJogoRepositorio repositorio = new Repositorio.ADO.JogoRepositorio();

            var jogo = repositorio.BuscarPorId(id);
            var jogoDetalhe = new JogoModel(jogo.Id, jogo.Nome, jogo.Preco, jogo.Categoria.ToString(), jogo.Selo.ToString(), jogo.Descricao);

            return View(jogoDetalhe);
        }
    }
}