﻿using Locadora.Dominio;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace Locadora.Web.MVC.Models
{
    public class JogoLocacaoModel
    {
        public int? Id { get; set; }
        public int IdLocacao { get; set; }
        public string Nome { get; set; }
        public string DataEntrega { get; set; }
        public string Situacao {
            get
            {
                if(this.DataEntrega == "")
                {
                    return "Aberta";
                }
                else
                {
                    return "Fechada";
                }
            }
        }
        public decimal Preco
        {
            get
            {
                var selo = this.Selo.ToString();

                if (selo == "Ouro")
                {
                    return 15;
                }
                else if (selo == "Prata")
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
        public string PrecoTotal {
            get
            {
                var diasAtraso = (decimal)(DateTime.Now.Date - Convert.ToDateTime(this.DataLocacao)).TotalDays;

                if(diasAtraso > 0)
                { 

                return (this.Preco + diasAtraso * 5).ToString("c");
                }
                else
                {
                    return this.Preco.ToString("c");
                }
            }
        }
        public Selo Selo { get; set; }
        public int NumeroDeDiasDeEntrega
        {
            get
            {

                var selo = this.Selo.ToString();
                

                if (selo == "Ouro")
                {
                    return 1;
                }
                else if (selo == "Prata")
                {
                    return 2;
                }
                else if (selo == "Bronze")
                {
                    return 3;
                }
                return 0;
            }
        }
        public string Cliente { get; set; }

        public string DataLocacao { get; set; }

        public JogoLocacaoModel(Jogo jogo)
        {
            this.Id = jogo.Id;
            this.Nome = jogo.Nome;
            this.Selo = jogo.Selo;
        }

        public JogoLocacaoModel(Locacao locacao)
        {
            this.Id = locacao.Jogo.Id;
            this.Nome = locacao.Jogo.Nome;
            this.Selo = locacao.Jogo.Selo;
            this.DataLocacao = locacao.DataLocacao.ToString("dd/MM/yyyy");
            this.Cliente = locacao.Cliente.Nome;
            this.IdLocacao = locacao.Id;
            this.DataEntrega = locacao.DataEntrega.ToString();
        }

    }
}