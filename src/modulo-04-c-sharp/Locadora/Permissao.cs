using System;

public class Permissao
{

    public string Nome { get; set; }

    public ICollection<Usuario> Usuarios { get; set; }

    public Permissao()
	{
	}
}
