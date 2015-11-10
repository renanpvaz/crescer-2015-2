using System;
using System.Collections.Generic;
using Locadora.Dominio;

public class Permissao : EntidadeBase
{

    public string Nome { get; set; }

    public ICollection<Usuario> Usuarios { get; set; }

    public Permissao()
	{
	}
}
