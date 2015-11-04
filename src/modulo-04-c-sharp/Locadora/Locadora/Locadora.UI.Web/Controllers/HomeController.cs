﻿using Locadora.Dominio;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Mvc;

namespace Locadora.UI.Web.Controllers
{
    public class HomeController : Controller
    {
        // GET: Home
        public ActionResult Index()
        {
            return View();
        }

        public ActionResult ListaJogos()
        {
            BaseDeDados dados = new BaseDeDados();

            var jogos = dados.ToString();          

            return View(jogos);
        }

        
    }
}