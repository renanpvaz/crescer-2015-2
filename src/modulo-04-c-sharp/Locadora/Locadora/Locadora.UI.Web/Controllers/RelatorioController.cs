﻿using Locadora.UI.Web.Views.Relatorio;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Mvc;

namespace Locadora.UI.Web.Controllers
{
    public class RelatorioController : Controller
    {
        public ActionResult JogosDisponiveis()
        {
            return View(new RelatorioModel());
        }
    }
}