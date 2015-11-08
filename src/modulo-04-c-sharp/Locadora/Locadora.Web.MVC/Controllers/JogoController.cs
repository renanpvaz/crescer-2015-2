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
            var jogoDetalhe = new JogoDetalhesModel(jogo.Id, jogo.Nome, jogo.Preco, 
                                                    (Categoria)Enum.Parse(typeof(Categoria), jogo.Categoria.ToString()), 
                                                    jogo.Selo.ToString(), jogo.Descricao);

            jogoDetalhe.Imagem = jogo.Imagem;

            return View(jogoDetalhe);
        }

        public ActionResult Manter(int id)
        {
            IJogoRepositorio repositorio = new Repositorio.ADO.JogoRepositorio();

            var jogo = repositorio.BuscarPorId(id);
            var jogoEditar = new JogoDetalhesModel(jogo.Id, jogo.Nome, jogo.Preco,
                                                    (Categoria)Enum.Parse(typeof(Categoria), jogo.Categoria.ToString()),
                                                    jogo.Selo.ToString(), jogo.Descricao);
            jogoEditar.Imagem = jogo.Imagem;

            return View(jogoEditar);
        }

        public ActionResult Salvar(JogoDetalhesModel model)
        {
            ModelState.AddModelError("", "Erro");

            //Convert.ChangeType(model, typeof(Jogo))

            if (ModelState.IsValid)
            {
                //salvar no banco
                TempData["Mensagem"] = "Jogo salvo com sucesso!";

                return RedirectToAction("JogosDisponiveis", "Relatorio");
            }
            else
            {
                //Exemplo de modificação dos dados da model antes de retornar!
                //ModelState.SetModelValue("Nome", new ValueProviderResult("Bob Esponja", "", CultureInfo.InvariantCulture));

                return View("Manter", model);
            }
        }
    }
}