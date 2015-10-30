﻿using Microsoft.VisualStudio.TestTools.UnitTesting;
using DbFuncionarios;
using System.Collections.Generic;
using System;

namespace BaseDeDadosTeste
{
    [TestClass]
    public class BaseDeDadosTeste
    {
        [TestMethod]
        public void PrimeiroCargoComecaComLetraAAposOrdenacao()
        {
            var baseDeDados = new BaseDeDados();
            List<Funcionario> funcionarios = baseDeDados.Funcionarios;
            var ordenadosPorCargo = baseDeDados.OrdenadosPorCargo();

            Assert.AreEqual("Analista", ordenadosPorCargo[0].Cargo.Titulo);
        }

        [TestMethod]
        public void BuscaFuncionarioComNomeContendoZon()
        {
            var baseDeDados = new BaseDeDados();
            List<Funcionario> funcionarios = baseDeDados.Funcionarios;
            var resultado = baseDeDados.BuscarPorNome("zon");

            Assert.AreEqual("Jean Pinzon", resultado[0].Nome);
        }

        [TestMethod]
        public void BuscaFuncionariosDoTurnoManha()
        {
            var baseDeDados = new BaseDeDados();
            List<Funcionario> funcionarios = baseDeDados.Funcionarios;
            var resultado = baseDeDados.BuscarPorTurno(TurnoTrabalho.Manha);

            Assert.AreEqual(TurnoTrabalho.Manha, resultado[0].TurnoTrabalho);
        }

        [TestMethod]
        public void BuscaFuncionariosNoiteRetornaDoisFuncionarios()
        {
            var baseDeDados = new BaseDeDados();
            List<Funcionario> funcionarios = baseDeDados.Funcionarios;
            var resultado = baseDeDados.QtdFuncionariosPorTurno();

            Assert.AreEqual(TurnoTrabalho.Noite, resultado);

        }

        [TestMethod]
        public void BuscaFuncionariosPorCargoRetornaFuncionarioComCargoInformado()
        {
            var baseDeDados = new BaseDeDados();
            List<Funcionario> funcionarios = baseDeDados.Funcionarios;
            var resultado = baseDeDados.BuscarPorCargo(new Cargo("Desenvolvedor", 190));

            Assert.AreEqual("Lucas Leal", resultado[0].Nome);
        }

        [TestMethod]
        public void BuscaMediaDosSalariosDeTodosFuncionarios()
        {
            var baseDeDados = new BaseDeDados();
            List<Funcionario> funcionarios = baseDeDados.Funcionarios;
            var resultado = baseDeDados.SalarioMedio();

            Assert.AreEqual(233, Math.Floor(resultado));
        }

        [TestMethod]
        public void BuscaMediaDosSalariosDeTodosFuncionariosDaManha()
        {
            var baseDeDados = new BaseDeDados();
            List<Funcionario> funcionarios = baseDeDados.Funcionarios;
            var resultado = baseDeDados.SalarioMedio(TurnoTrabalho.Manha);

            Assert.AreEqual(274.1, resultado);
        }

        [TestMethod]
        public void BuscaFuncionarioQueFazemAniversarioNoMesAtual()
        {
            var baseDeDados = new BaseDeDados();
            List<Funcionario> funcionarios = baseDeDados.Funcionarios;
            var resultado = baseDeDados.AniversariantesDoMes();

            Assert.AreEqual(DateTime.Now.Month, resultado[0].DataNascimento.Month);
        }




    }
}
