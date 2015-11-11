namespace Locadora.Repositorio.EF.Migrations
{
    using System;
    using System.Data.Entity.Migrations;
    
    public partial class PopularUsuarioPermissao : DbMigration
    {
        public override void Up()
        {
            Sql(@"insert into usuario_permissao(idusuario, idpermissao) values(5002, 7);
                  insert into usuario_permissao(idusuario, idpermissao) values(5003, 8);");
        }
        
        public override void Down()
        {
        }
    }
}
