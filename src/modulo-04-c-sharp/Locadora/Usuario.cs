using System;

public class Usuario
{
    public string Nome { get; set; }

    public string Senha { get; set; }

    public string Email { get; set; }

    public ICollection<Permissao> Permissoes { get; set; }

    public Usuario()
	{
	}
}
