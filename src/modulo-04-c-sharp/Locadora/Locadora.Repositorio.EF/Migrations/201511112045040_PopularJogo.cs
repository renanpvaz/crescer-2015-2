namespace Locadora.Repositorio.EF.Migrations
{
    using System;
    using System.Data.Entity.Migrations;
    
    public partial class PopularJogo : DbMigration
    {
        public override void Up()
        {

            Sql(@"INSERT INTO dbo.Jogo(Nome, Preco, IdCategoria, IDSelo, Descricao, Imagem) VALUES ('Chrono Trigger', 60, 1, 14, 'Sem descricao', 'Sem imagem')
                INSERT INTO dbo.Jogo(Nome, Preco, IdCategoria, IDSelo, Descricao, Imagem) VALUES ('Top Gear', 20, 2, 12, 'Sem descricao', 'Sem imagem')
                INSERT INTO dbo.Jogo(Nome, Preco, IdCategoria, IDSelo, Descricao, Imagem) VALUES ('Megaman X', 40, 3, 13, 'Sem descricao', 'Sem imagem')
                INSERT INTO dbo.Jogo(Nome, Preco, IdCategoria, IDSelo, Descricao, Imagem) VALUES ('Super Metroid', 35, 3, 12, 'Sem descricao', 'Sem imagem')
                INSERT INTO dbo.Jogo(Nome, Preco, IdCategoria, IDSelo, Descricao, Imagem) VALUES ('Donkey Kong Country', 25, 3, 12, 'Sem descricao', 'Sem imagem')
                INSERT INTO dbo.Jogo(Nome, Preco, IdCategoria, IDSelo, Descricao, Imagem) VALUES ('Super Mario Kart', 40, 2, 13, 'Sem descricao', 'Sem imagem')
                INSERT INTO dbo.Jogo(Nome, Preco, IdCategoria, IDSelo, Descricao, Imagem) VALUES ('Super Street Fighter', 25, 4, 12, 'Sem descricao', 'Sem imagem')
                INSERT INTO dbo.Jogo(Nome, Preco, IdCategoria, IDSelo, Descricao, Imagem) VALUES ('Mortal Kombat 2', 37, 4, 12, 'Sem descricao', 'Sem imagem')
                INSERT INTO dbo.Jogo(Nome, Preco, IdCategoria, IDSelo, Descricao, Imagem) VALUES ('Killer Instinct', 18, 4, 12, 'Sem descricao', 'Sem imagem')
                INSERT INTO dbo.Jogo(Nome, Preco, IdCategoria, IDSelo, Descricao, Imagem) VALUES ('Final Fight', 12, 3, 12, 'Sem descricao', 'Sem imagem')
                INSERT INTO dbo.Jogo(Nome, Preco, IdCategoria, IDSelo, Descricao, Imagem) VALUES ('Super Mario 1', 70, 1, 14, 'Sem descricao', 'Sem imagem')
                INSERT INTO dbo.Jogo(Nome, Preco, IdCategoria, IDSelo, Descricao, Imagem) VALUES ('Aladdin', 16, 3, 12, 'Sem descricao', 'Sem imagem')
                INSERT INTO dbo.Jogo(Nome, Preco, IdCategoria, IDSelo, Descricao, Imagem) VALUES ('Rock ''n Roll Racing', 22, 2, 12, 'Sem descricao', 'Sem imagem')
                INSERT INTO dbo.Jogo(Nome, Preco, IdCategoria, IDSelo, Descricao, Imagem) VALUES ('Zelda: A link to the past', 110, 3, 14, 'Sem descricao', 'Sem imagem')
                INSERT INTO dbo.Jogo(Nome, Preco, IdCategoria, IDSelo, Descricao, Imagem) VALUES ('Final Fantasy VI', 30.5, 1, 12, 'Sem descricao', 'Sem imagem')
                INSERT INTO dbo.Jogo(Nome, Preco, IdCategoria, IDSelo, Descricao, Imagem) VALUES ('International Super Star Soccer Deluxe', 45, 5, 13, 'Sem descricao', 'Sem imagem')
                INSERT INTO dbo.Jogo(Nome, Preco, IdCategoria, IDSelo, Descricao, Imagem) VALUES ('Contra III', 28, 3, 12, 'Sem descricao', 'Sem imagem')
                INSERT INTO dbo.Jogo(Nome, Preco, IdCategoria, IDSelo, Descricao, Imagem) VALUES ('Sunset Riders', 37.9, 3, 12, 'Sem descricao', 'Sem imagem')
                INSERT INTO dbo.Jogo(Nome, Preco, IdCategoria, IDSelo, Descricao, Imagem) VALUES ('Goof Troop', 41.9, 3, 13, 'Sem descricao', 'Sem imagem')
                INSERT INTO dbo.Jogo(Nome, Preco, IdCategoria, IDSelo, Descricao, Imagem) VALUES ('Mickey to Donald: Magical Adventure 3', 32.9, 3, 12, 'Sem descricao', 'Sem imagem')");

        }
        
        public override void Down()
        {
        }
    }
}
