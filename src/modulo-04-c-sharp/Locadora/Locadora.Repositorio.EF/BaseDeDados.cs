using System;
using System.Collections.Generic;
using System.Data.Entity;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Data.Entity.ModelConfiguration;
using Locadora.Dominio;

namespace Locadora.Repositorio.EF
{
    public class BaseDeDados : DbContext
    {
        public DbSet<Jogo> Jogo { get; set; }
        public DbSet<Cliente> Cliente { get; set; }
  
        public BaseDeDados() : base("LOCADORA2")
        {
        }

        protected override void OnModelCreating(DbModelBuilder modelBuilder)
        {
            modelBuilder.Configurations.Add(new ClienteMap());
            modelBuilder.Configurations.Add(new JogoMap());
            base.OnModelCreating(modelBuilder);
        }
    }

    class ClienteMap : EntityTypeConfiguration<Cliente>
    {
        public ClienteMap()
        {
            ToTable("Cliente");
            HasKey(p => p.Id);

            Property(p => p.Nome).IsRequired().HasMaxLength(250);
        }
    }

    class JogoMap : EntityTypeConfiguration<Jogo>
    {
        public JogoMap()
        {
            ToTable("Jogo");
            HasKey(p => p.Id);

            Property(j => j.Nome).IsRequired().HasMaxLength(250);
            Property(j => j.Preco).IsRequired().HasPrecision(19, 2);
            Property(j => j.Categoria).IsRequired().HasColumnName("IdCategoria");
            HasOptional(j => j.Cliente).WithOptionalDependent().Map(m => m.MapKey("IdClienteLocacao"));
            Property(j => j.Selo).IsRequired().HasColumnName("IDSelo");
            Property(j => j.Descricao).IsRequired().HasMaxLength(8000);
            Property(j => j.Imagem).IsRequired().HasMaxLength(8000);
        }
    }
}
