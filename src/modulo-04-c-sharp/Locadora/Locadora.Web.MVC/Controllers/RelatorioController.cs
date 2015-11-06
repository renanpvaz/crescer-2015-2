using Locadora.Dominio.Repositorio;
using Locadora.Web.MVC.Models;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Mvc;

namespace Locadora.Web.MVC.Controllers
{
    public class RelatorioController : Controller
    {
        private IJogoRepositorio repositorio = new Repositorio.ADO.JogoRepositorio();

        public ActionResult JogosDisponiveis(string busca)
        {
            var model = new RelatorioModel(); 
            var buscaJogos = repositorio.BuscarPorNome(busca);
            var jogos = buscaJogos;

            if (!string.IsNullOrWhiteSpace(busca))
            {
                if (buscaJogos.Count() != 0)
                {
                    jogos = buscaJogos;
                }
                else
                {
                    model.EncontrouResultados = false;
                }
            }
            else
            {
                jogos = repositorio.BuscarTodos();
            }
            

            foreach(var jogo in jogos)
            {
                var jogoModel = new JogoModel
                    (jogo.Id, jogo.Nome, jogo.Preco, jogo.Categoria.ToString(), jogo.Selo.ToString());
                model.Jogos.Add(jogoModel);
            }

            if(model.EncontrouResultados)
            {                      
                model.QuantidadeDeJogos = model.Jogos.Count();

                var maiorPreco = model.Jogos.Max(jogo => jogo.Preco);
                var menorPreco = model.Jogos.Min(jogo => jogo.Preco);
                model.JogoMaisCaro = model.Jogos.First(jogo => jogo.Preco == maiorPreco).Nome;
                model.JogoMaisBarato= model.Jogos.First(jogo => jogo.Preco == menorPreco).Nome;

                model.PrecoMedio = model.Jogos.Average(jogo => jogo.Preco);
            }

            return View(model);
        }
    }
}