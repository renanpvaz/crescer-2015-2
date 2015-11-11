namespace Locadora.Repositorio.EF.Migrations
{
    using System;
    using System.Data.Entity.Migrations;
    
    public partial class PopularUsuario : DbMigration
    {
        public override void Up()
        {

            Sql(@"ALTER TABLE usuario
                  ALTER COLUMN Senha varchar(250)");

            Sql(@"insert into usuario(Nome, Senha, Email) values('Master', '501C3E9279882FFB776A1D1E506D0410', 'master@admin.com');
                  insert into usuario(Nome, Senha, Email) values('Fabricio', '68ACE0CACCCF2CAF2C604BB54FDF450C', 'fabricio@operador.com');");

            Sql(@"insert into permissao(Nome) values ('ADMIN');
                  insert into permissao(Nome) values ('OPERADOR');");

        }
        
        public override void Down()
        {
        }
    }
}
