namespace Locadora.Repositorio.EF.Migrations
{
    using System;
    using System.Data.Entity.Migrations;
    
    public partial class AddInsertSeloECategoriaValues : DbMigration
    {
        public override void Up()
        {

            Sql("Delete from Selo");

            Sql("INSERT INTO Selo (Nome) VALUES ('Bronze'), ('Prata'), ('Ouro')");

            Sql("INSERT INTO Categoria (Descricao) VALUES ('RPG'), ('Corrida'), ('Aventura'), ('Luta'), ('Esporte')");

        }
        
        public override void Down()
        {
        }
    }
}
