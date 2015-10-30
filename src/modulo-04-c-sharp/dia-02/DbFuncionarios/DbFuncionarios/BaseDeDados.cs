﻿using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace DbFuncionarios
{
    public class BaseDeDados
    {
        public List<Funcionario> Funcionarios
        {
            get; private set;
        }

        public BaseDeDados()
        {
            CriarBase();
        }

        private void CriarBase()
        {
            Funcionarios = new List<Funcionario>();

            Cargo desenvolvedor = new Cargo("Desenvolvedor", 190);
            Cargo analista = new Cargo("Analista", 250);
            Cargo gerente = new Cargo("Gerente", 550.5);

            Funcionario lucasLeal = new Funcionario(1, "Lucas Leal", new DateTime(1995, 01, 24));
            lucasLeal.Cargo = desenvolvedor;
            lucasLeal.TurnoTrabalho = TurnoTrabalho.Manha;
            Funcionarios.Add(lucasLeal);

            Funcionario jeanPinzon = new Funcionario(2, "Jean Pinzon", new DateTime(1991, 04, 25));
            jeanPinzon.Cargo = desenvolvedor;
            jeanPinzon.TurnoTrabalho = TurnoTrabalho.Tarde;
            Funcionarios.Add(jeanPinzon);

            Funcionario rafaelBenetti = new Funcionario(3, "Rafael Benetti", new DateTime(1991, 08, 15));
            rafaelBenetti.Cargo = desenvolvedor;
            rafaelBenetti.TurnoTrabalho = TurnoTrabalho.Noite;
            Funcionarios.Add(rafaelBenetti);

            Funcionario mauricioBorges = new Funcionario(4, "Maurício Borges", new DateTime(1996, 11, 30));
            mauricioBorges.Cargo = desenvolvedor;
            mauricioBorges.TurnoTrabalho = TurnoTrabalho.Manha;
            Funcionarios.Add(mauricioBorges);

            Funcionario leandroAndreolli = new Funcionario(5, "Leandro Andreolli", new DateTime(1990, 03, 07));
            leandroAndreolli.Cargo = desenvolvedor;
            leandroAndreolli.TurnoTrabalho = TurnoTrabalho.Manha;
            Funcionarios.Add(leandroAndreolli);

            Funcionario felipeNervo = new Funcionario(6, "Felipe Nervo", new DateTime(1994, 01, 12));
            felipeNervo.Cargo = desenvolvedor;
            felipeNervo.TurnoTrabalho = TurnoTrabalho.Tarde;
            Funcionarios.Add(felipeNervo);

            Funcionario lucasKauer = new Funcionario(7, "Lucas Kauer", new DateTime(1997, 05, 10));
            lucasKauer.Cargo = desenvolvedor;
            lucasKauer.TurnoTrabalho = TurnoTrabalho.Noite;
            Funcionarios.Add(lucasKauer);

            Funcionario eduardoArnold = new Funcionario(8, "Eduardo Arnold", new DateTime(1989, 09, 16));
            eduardoArnold.Cargo = desenvolvedor;
            eduardoArnold.TurnoTrabalho = TurnoTrabalho.Tarde;
            Funcionarios.Add(eduardoArnold);

            Funcionario gabrielAlboy = new Funcionario(9, "Gabriel Alboy", new DateTime(1990, 02, 25));
            gabrielAlboy.Cargo = analista;
            gabrielAlboy.TurnoTrabalho = TurnoTrabalho.Manha;
            Funcionarios.Add(gabrielAlboy);

            Funcionario carlosHenrique = new Funcionario(10, "Carlos Henrique", new DateTime(1965, 12, 02));
            carlosHenrique.Cargo = analista;
            carlosHenrique.TurnoTrabalho = TurnoTrabalho.Tarde;
            Funcionarios.Add(carlosHenrique);

            Funcionario margareteRicardo = new Funcionario(11, "Margarete Ricardo", new DateTime(1980, 10, 10));
            margareteRicardo.Cargo = gerente;
            margareteRicardo.TurnoTrabalho = TurnoTrabalho.Manha;
            Funcionarios.Add(margareteRicardo);
        }

        public IList<Funcionario> OrdenadosPorCargo()
        {
            return Funcionarios.OrderBy(funcionario => funcionario.Cargo.Titulo).ToList();

        }

        public IList<Funcionario> BuscarPorNome(string nome)
        {
            return Funcionarios.Where(funcionario => funcionario.Nome.Contains(nome))
                .OrderBy(funcionario => funcionario.Nome).ToList();
        }

        public IList<Funcionario> BuscarPorTurno(params TurnoTrabalho[] turnos)
        {
            return Funcionarios.Where(funcionario => turnos.Contains(funcionario.TurnoTrabalho) || false).ToList();
        }

        public IList<dynamic> QtdFuncionariosPorTurno()
        {
            List<Funcionario> funcionarios = Funcionarios;

            var query = from f in funcionarios
                        group f by f.TurnoTrabalho into g
                        select new
                      {
                        Turno = g.Key,
                        Count = g.Count()
                      };

            return query.ToList<dynamic>();
        }

        public IList<Funcionario> BuscarPorCargo(Cargo cargo)
        {
            return Funcionarios.Where(funcionario => funcionario.Cargo.Equals(cargo)).ToList();
        }

        public IList<Funcionario> FiltrarPorIdadeAproximada(int idade)
        {
            DateTime dataAtual = DateTime.Now;
            DateTime dataInicial = new DateTime(1, 1, 1);

            return Funcionarios
                     .Where(funcionario => 
                        (dataInicial + (dataAtual - funcionario.DataNascimento)).Year - 1 > idade - 5 
                            && (dataInicial + (dataAtual - funcionario.DataNascimento)).Year - 1 < idade + 5).ToList();
        }

        public double SalarioMedio()
        {
            return Funcionarios.Average(funcionario => funcionario.Cargo.Salario);
        }

        public double SalarioMedio(TurnoTrabalho turno)
        {
            return Funcionarios.Where(funcionario => funcionario.TurnoTrabalho == turno)
                .Average(funcionario => funcionario.Cargo.Salario);
        }

        public IList<Funcionario> AniversariantesDoMes()
        {
            int mesAtual = DateTime.Now.Month;

            return Funcionarios.Where(funcionario => funcionario.DataNascimento.Month == mesAtual).ToList();
        }
    }

}
    

    

