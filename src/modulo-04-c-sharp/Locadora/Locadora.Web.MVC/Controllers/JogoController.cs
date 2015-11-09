using Locadora.Dominio;
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
            var jogoDetalhe = new JogoDetalhesModel();

            jogoDetalhe.Id = jogo.Id;
            jogoDetalhe.Nome = jogo.Nome;
            jogoDetalhe.Preco = jogo.Preco;
            jogoDetalhe.Descricao = jogo.Descricao;
            jogoDetalhe.Categoria = jogo.Categoria;
            jogoDetalhe.Imagem = jogo.Imagem;
            jogoDetalhe.Selo = jogo.Selo;

            return View(jogoDetalhe);
        }

        public ActionResult Manter(int id = 0)
        {
            if (id > 0)
            {

                IJogoRepositorio repositorio = new Repositorio.ADO.JogoRepositorio();

                var jogo = repositorio.BuscarPorId(id);
                var jogoEditar = new JogoDetalhesModel();
                
                jogoEditar.Id = jogo.Id;
                jogoEditar.Nome = jogo.Nome;
                jogoEditar.Preco = jogo.Preco;
                jogoEditar.Descricao = jogo.Descricao;
                jogoEditar.Categoria = jogo.Categoria;
                jogoEditar.Imagem = jogo.Imagem;
                jogoEditar.Selo = jogo.Selo;

                return View(jogoEditar);
            }

            return View();
        }

        public ActionResult Salvar(JogoDetalhesModel model)
        {
            var errors = ModelState.Values.SelectMany(v => v.Errors);

            if (ModelState.IsValid)
            {
                IJogoRepositorio repositorio = new Repositorio.ADO.JogoRepositorio();

                if (model.Id.HasValue)
                {
                    var jogo = new Jogo();
                    jogo.Nome = model.Nome;
                    jogo.Descricao = model.Descricao;
                    jogo.Selo = model.Selo;
                    jogo.Preco = model.Preco;
                    jogo.Categoria = model.Categoria;
                    jogo.Imagem = model.Imagem;

                    repositorio.Criar(jogo);

                    TempData["Mensagem"] = "Jogo salvo com sucesso!";
                }
                else
                {
                    var jogo = new Jogo((int)model.Id);
                    jogo.Nome = model.Nome;
                    jogo.Descricao = model.Descricao;
                    jogo.Selo = model.Selo;
                    jogo.Preco = model.Preco;
                    jogo.Categoria = model.Categoria;
                    jogo.Imagem = model.Imagem;

                    repositorio.Atualizar(jogo); 

                    TempData["Mensagem"] = "Jogo editado com sucesso!";
                }

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