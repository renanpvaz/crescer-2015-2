﻿
using Locadora.Dominio;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace Locadora.Web.MVC.Models
{
    public class JogoDetalhesModel
    {

        public int? Id { get; set; }
        public string Nome { get; set; }
        public decimal Preco { get
            {
                var selo = this.Selo.ToString();

                if(selo == "Ouro")
                {
                    return 15;
                }
                else if(selo == "Prata")
                {
                    return 10;
                }
                else if (selo == "Bronze")
                {
                    return 5;
                }
                return 0;
            }
        }
        public Categoria Categoria { get; set; }
        public Selo Selo { get; set; }
        public string Descricao { get; set; }
        public string Imagem { get; set; }


        public JogoDetalhesModel()
        {
        }

        public JogoDetalhesModel(Jogo jogo)
        {
            this.Id = jogo.Id;
            this.Nome = jogo.Nome;
            this.Descricao = jogo.Descricao;
            this.Selo = jogo.Selo;
            this.Categoria = jogo.Categoria;
            this.Imagem = jogo.Imagem;
        }

        public Jogo ConverterParaJogo()
        {
            Jogo jogo = null;

            if(this.Id.HasValue)
            {
                jogo = new Jogo((int)this.Id);
            }
            else
            {
                jogo = new Jogo();
            }

            jogo.Nome = this.Nome;
            jogo.Descricao = this.Descricao;
            jogo.Selo = this.Selo;
            jogo.Preco = this.Preco;
            jogo.Categoria = this.Categoria;
            jogo.Imagem = this.Imagem;

            return jogo;
        }

        public JogoDetalhesModel ConverterJogoParaModel(Jogo jogo)
        {          
            this.Id = jogo.Id;
            this.Nome = jogo.Nome;
            this.Descricao = jogo.Descricao;
            this.Categoria = jogo.Categoria;
            this.Imagem = jogo.Imagem;
            this.Selo = jogo.Selo;

            return this;
        }

    }

}
