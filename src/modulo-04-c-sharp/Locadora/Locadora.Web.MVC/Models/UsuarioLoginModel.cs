using System;
using System.Collections.Generic;
using System.ComponentModel.DataAnnotations;
using System.Linq;
using System.Web;

namespace Locadora.Web.MVC.Models
{
    public class UsuarioLoginModel
    {
        [Required]
        [MaxLength(250)]
        
        public string Email { get; set; }

        [Required]
        [MaxLength(250)]
        public string Senha { get; set; }

    }
}