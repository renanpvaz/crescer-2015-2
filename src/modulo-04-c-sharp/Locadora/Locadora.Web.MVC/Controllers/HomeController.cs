﻿using Locadora.Web.MVC.Segurança;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Mvc;

namespace Locadora.Web.MVC.Controllers
{
    public class HomeController : Controller
    {
        [Autorizador]
        public ActionResult Index()
        {
            return View();
        }
    }
}