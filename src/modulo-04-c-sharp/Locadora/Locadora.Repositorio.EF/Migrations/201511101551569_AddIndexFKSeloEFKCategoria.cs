namespace Locadora.Repositorio.EF.Migrations
{
    using System;
    using System.Data.Entity.Migrations;
    
    public partial class AddIndexFKSeloEFKCategoria : DbMigration
    {
        public override void Up()
        {
            Sql("CREATE INDEX IX_IDSelo ON Jogo (IDSelo)");

            Sql("CREATE INDEX IX_IdCategoria ON Jogo (IdCategoria)");

            Sql("INSERT INTO Selo (Nome) VALUES ('Bronze'), ('Prata'), ('Ouro')");

            Sql("INSERT INTO Selo (Nome) VALUES ('RPG'), ('Corrida'), ('Aventura'), ('Luta'), ('Esporte')");
        }
        
        public override void Down()
        {
        }
    }
}
