

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * A classe de teste DwarfTest.
 *
 * @author  (seu nome)
 * @version (um número de versão ou data)
 */
public class DwarfTest
{   
    @Test
    public void nomeCerto(){
        Dwarf thrain = new Dwarf ("Thrain");
        assertEquals("Thrain", thrain.getNome());
    }
    
    @Test
    public void dwarfNasceCom110DeVida(){
        Dwarf gimli = new Dwarf("Gimli");
        assertEquals(110, gimli.getVida());
    }
    
    @Test
    public void dwarfPerde10DeVidaAoReceberFlecha(){
        Elfo thranduil = new Elfo ("Thranduil", 10);
        Dwarf gimli = new Dwarf("Gimli");
        thranduil.atacarDwarf(gimli);
        assertEquals(100, gimli.getVida());
    }
    
    @Test
    public void dwarfPerde110DeVidaAoReceber11Flechas(){
        Elfo thranduil = new Elfo ("Thranduil", 11);
        Dwarf gimli = new Dwarf("Gimli");
        for(int i = 0; i <= 10; i++){
          thranduil.atacarDwarf(gimli);  
        }
        assertEquals(0, gimli.getVida());
    }
    
    @Test
    public void dwarfMorreAoReceberDano11Vezes(){
       Dwarf gimli = new Dwarf("Gimli");
       for(int i = 0; i <= 10; i++){  
           gimli.recebeDano(10);
       }
        assertEquals(Status.MORTO, gimli.getStatus());
    }
    
    @Test 
    public void dwarfVidaNaoPassaDeZero(){
        Dwarf gimli = new Dwarf("Gimli");
       for(int i = 0; i <= 11; i++){
          gimli.recebeDano(10);  
       }
        assertEquals(0, gimli.getVida());
    }
    
    @Test
    public void nasceComDiaNascimento(){
        Dwarf gimli = new Dwarf ("Gimli", new DataTerceiraEra(12, 2, 1998));
        DataTerceiraEra data = new DataTerceiraEra(12, 2, 1998);
        assertEquals(data, gimli.getDataNascimento());
    }
    
    @Test
    public void dwarfComVida90EAnoBissextoTrue(){
      Dwarf gimli = new Dwarf("Gimli", new DataTerceiraEra(29, 2, 2016));
      for(int i = 0; i <= 2; i++){
          gimli.recebeDano(10);  
      }
      assertEquals(-3333.0, gimli.getSorte(), 0.001);
    }
    
    @Test
    public void dwarfComVida80EAnoBissextoTrueNaoPassaDe90(){
      Dwarf gimli = new Dwarf("Gimli", new DataTerceiraEra(29, 2, 2016));
      for(int i = 0; i <= 2; i++){
          gimli.recebeDano(10);  
      }
      assertEquals(90, gimli.getVida());
    }
    
    @Test
    public void dwarfComNomeSeixasEAnoBissextoFalse(){
      Dwarf seixas = new Dwarf("Seixas", new DataTerceiraEra(29, 3, 1997));
      assertEquals(33, seixas.getSorte(), 0.001);
    }
    
    @Test
    public void dwarfComNomeSeixasEAnoBissextoTrue(){
      Dwarf seixas = new Dwarf("Seixas", new DataTerceiraEra(29, 3, 2016));
      assertEquals(101.0, seixas.getSorte(), 0.001);
    }
    
    @Test
    public void dwarfComNomeMeirelesEAnoBissextoFalse(){
      Dwarf meireles = new Dwarf("Meireles", new DataTerceiraEra(29, 3, 1997));
      assertEquals(33, meireles.getSorte(), 0.001);
    }
    @Test
    public void dwarfComNomeMeirelesEAnoBissextoTrue(){
      Dwarf meireles = new Dwarf("Meireles", new DataTerceiraEra(29, 3, 2016));
      assertEquals(101.0, meireles.getSorte(), 0.001);
    }
    
    @Test
    public void dwarfComNomeDiferenteDeMeirelesESeixasEAnoBissextoFalse(){
       Dwarf gimli = new Dwarf("Gimli", new DataTerceiraEra(29, 3, 1997));
       assertEquals(101.0, gimli.getSorte(), 0.001);
    }
    
    @Test 
    public void dwarfNasceCom0DeExperiencia(){
        Dwarf gimli = new Dwarf("Gimli");
        assertEquals(0, gimli.getExperiencia());
    }
    
    @Test
    public void dwarfComVida80EAnoBissextoTrueGanha2Exp(){
      Dwarf gimli = new Dwarf("Gimli", new DataTerceiraEra(29, 2, 2016));
      for(int i = 0; i <= 2; i++){
          gimli.recebeDano(10);  
      }
      assertEquals(2, gimli.getExperiencia());
    }
    
    @Test
    public void dwarfTestaSorteEGanhaNaMega(){
      Dwarf gimli = new Dwarf("Gimli", new DataTerceiraEra(29, 2, 2016));
      for(int i = 0; i <= 2; i++){
          gimli.recebeDano(10);  
      }
      gimli.getInventario().adicionarItem(new Item("Pedra Arken", 1));
      gimli.tentarSorte();
      assertEquals(1001, gimli.getInventario().getListaDeItens().get(0).getQuantidade());
    }
    
    @Test
    public void dwarfTestaSorteEGanhaNaMega3xQuantidades(){
      Dwarf gimli = new Dwarf("Gimli", new DataTerceiraEra(29, 2, 2016));
      Inventario invDoThorin = new Inventario();
      for(int i = 0; i <= 2; i++){
          gimli.recebeDano(10);  
      }
      gimli.getInventario().adicionarItem(new Item("Pedra Arken", 1));
      gimli.getInventario().adicionarItem(new Item("Tererê de barba", 3));
      gimli.getInventario().adicionarItem(new Item("Espada emprestada do brother Légolas", 5));
      gimli.tentarSorte();
      assertEquals(1001, gimli.getInventario().getListaDeItens().get(0).getQuantidade());
      assertEquals(1003, gimli.getInventario().getListaDeItens().get(1).getQuantidade());
      assertEquals(1005, gimli.getInventario().getListaDeItens().get(2).getQuantidade());
    }
    
    @Test
    public void dwarfTestaSorteEGanhaNaMega3xNomes(){
      Dwarf gimli = new Dwarf("Gimli", new DataTerceiraEra(29, 2, 2016));
      Inventario invDoThorin = new Inventario();
      for(int i = 0; i <= 2; i++){
          gimli.recebeDano(10);  
      }
      gimli.getInventario().adicionarItem(new Item("Pedra Arken", 1));
      gimli.getInventario().adicionarItem(new Item("Tererê de barba", 3));
      gimli.getInventario().adicionarItem(new Item("Espada emprestada do brother Légolas", 5));
      gimli.tentarSorte();
      assertEquals("Pedra Arken", gimli.getInventario().getListaDeItens().get(0).getDescricao());
      assertEquals("Tererê de barba", gimli.getInventario().getListaDeItens().get(1).getDescricao());
      assertEquals("Espada emprestada do brother Légolas", gimli.getInventario().getListaDeItens().get(2).getDescricao());
    }
} 
public class DwarfTest
{
    @Test
    public void dwarfNasceCom110DeVida() {
        Dwarf gimli = new Dwarf();
        assertEquals(110, gimli.getVida());
    }

    @Test
    public void dwarfNasceVivo() {
        Dwarf balin = new Dwarf();
        assertEquals(Status.VIVO, balin.getStatus());
    }

    @Test
    public void dwarfNasceCom0DeExperiencia() {
        Dwarf balin = new Dwarf();
        assertEquals(0, balin.getExperiencia());
    }

    @Test
    public void dwarfNasceComDataNascimentoPadrão() {
        Dwarf bofur = new Dwarf();
        DataTerceiraEra esperada = new DataTerceiraEra(1,1,1);
        DataTerceiraEra obtida = bofur.getDataNascimento();
        assertEquals(esperada, obtida);
    }

    @Test
    public void dwarfNasceComNomeEDataDeNascimento() {
        DataTerceiraEra esperada = new DataTerceiraEra(12,11,1987);
        Dwarf bernardin = new Dwarf("Bernardin", new DataTerceiraEra(12, 11, 1987));
        assertEquals(esperada, bernardin.getDataNascimento());
        assertEquals("Bernardin", bernardin.getNome());
    }

    @Test
    public void dwarfNasceComNome() {
        Dwarf oin = new Dwarf("Oin II");
        assertEquals("Oin II", oin.getNome());
    }

    @Test
    public void dwarfRecebeFlechaEPerde10Vida() {
        // AAA
        // Arrange
        Dwarf gimli = new Dwarf();
        int vidaEsperada = 100;
        // Act
        gimli.receberFlechada();
        // Assert
        assertEquals(vidaEsperada, gimli.getVida());
    }

    @Test
    public void dwarfRecebeFlecha11VezesEVidaÉ0() {
        Dwarf gimli = new Dwarf();
        int vidaEsperada = 0;
        // Act
        gimli.receberFlechada();
        gimli.receberFlechada();
        gimli.receberFlechada();
        gimli.receberFlechada();
        gimli.receberFlechada();
        gimli.receberFlechada();
        gimli.receberFlechada();
        gimli.receberFlechada();
        gimli.receberFlechada();
        gimli.receberFlechada();
        gimli.receberFlechada();
        // Assert
        assertEquals(vidaEsperada, gimli.getVida());
    }

    @Test
    public void dwarfRecebeFlecha7VezesEVidaÉ40() {
        Dwarf gimli = new Dwarf();
        int vidaEsperada = 40;
        // Act
        gimli.receberFlechada();
        gimli.receberFlechada();
        gimli.receberFlechada();
        gimli.receberFlechada();
        gimli.receberFlechada();
        gimli.receberFlechada();
        gimli.receberFlechada();
        // Assert
        assertEquals(vidaEsperada, gimli.getVida());
    }

    @Test
    public void dwarfRecebeFlecha5VezesESobrevive() {
        Dwarf gimli = new Dwarf();
        // Act
        gimli.receberFlechada();
        gimli.receberFlechada();
        gimli.receberFlechada();
        gimli.receberFlechada();
        gimli.receberFlechada();
        // Assert
        assertEquals(Status.VIVO, gimli.getStatus());
    }

    @Test
    public void dwarfRecebeFlecha12VezesEMorre() {
        Dwarf gimli = new Dwarf();
        // Act
        gimli.receberFlechada();
        gimli.receberFlechada();
        gimli.receberFlechada();
        gimli.receberFlechada();
        gimli.receberFlechada();
        gimli.receberFlechada();
        gimli.receberFlechada();
        gimli.receberFlechada();
        gimli.receberFlechada();
        gimli.receberFlechada();
        gimli.receberFlechada();
        gimli.receberFlechada();
        // Assert
        assertEquals(Status.MORTO, gimli.getStatus());
    }

    @Test
    public void dwarfRecebeFlecha13VezesEVidaFicaZerada() {
        Dwarf gimli = new Dwarf();
        // Act
        gimli.receberFlechada();
        gimli.receberFlechada();
        gimli.receberFlechada();
        gimli.receberFlechada();
        gimli.receberFlechada();
        gimli.receberFlechada();
        gimli.receberFlechada();
        gimli.receberFlechada();
        gimli.receberFlechada();
        gimli.receberFlechada();
        gimli.receberFlechada();
        gimli.receberFlechada();
        gimli.receberFlechada();
        // Assert
        assertEquals(0, gimli.getVida());
    }

    @Test
    public void gerarNumeroAnoBissextoVidaEntre80e90() {
        // Arrange
        Dwarf uru = new Dwarf("Uru", new DataTerceiraEra(01, 01, 2016));
        uru.receberFlechada();
        uru.receberFlechada();
        uru.receberFlechada();
        // Act
        double resultado = uru.gerarNumero();
        // Assert
        assertEquals(-3333.0, resultado, 0.00001);
    }

    @Test
    public void gerarNumeroAnoNaoBissextoNomeSeixas() {
        // Arrange
        Dwarf seixas = new Dwarf("Seixas", new DataTerceiraEra(01, 01, 2015));
        // Act
        double resultado = seixas.gerarNumero();
        // Assert
        assertEquals(33.0, resultado, 0.00001);
    }

    @Test
    public void gerarNumeroSemEntrarNasCondicoes() {
        // Arrange
        Dwarf balin = new Dwarf();
        // Act
        double resultado = balin.gerarNumero();
        // Assert
        assertEquals(101.0, resultado, 0.00001);
    }

    @Test
    public void dwarfRecebeFlechaComNumeroSorteNegativo() {
        // Arrange
        Dwarf dwarf = new Dwarf("Gimli", new DataTerceiraEra(1,1,2000));
        dwarf.receberFlechada();
        dwarf.receberFlechada();
        // Act
        dwarf.receberFlechada();
        // Assert
        assertEquals(2, dwarf.getExperiencia());
        assertEquals(90, dwarf.getVida());   
    }

    @Test
    public void dwarfReceberFlechadaComAnoNormalMeireles() {
        Dwarf meireles = new Dwarf("Meireles", new DataTerceiraEra(2, 3, 2015));
        meireles.receberFlechada();
        assertEquals(0, meireles.getExperiencia());
        assertEquals(110, meireles.getVida());
    }

    @Test
    public void dwarfReceberFlechadaNormal(){
        Dwarf dwarf = new Dwarf();
        dwarf.receberFlechada();
        assertEquals(100, dwarf.getVida());
        assertEquals(0, dwarf.getExperiencia());
    }

    @Test
    public void dwarfTentarSorteComSorte() {
        Dwarf dwarf = new Dwarf("Leprechaun sortudo", new DataTerceiraEra(1, 1, 2000));
        dwarf.receberFlechada();
        dwarf.receberFlechada();
        dwarf.adicionarItem(new Item(5, "Lança"));
        dwarf.adicionarItem(new Item(25, "Poção"));
        
        Inventario esperado = new Inventario();
        esperado.adicionarItem(new Item(1005, "Lança"));
        esperado.adicionarItem(new Item(1025, "Poção"));
        
        dwarf.tentarSorte();
        
        assertEquals(esperado, dwarf.getInventario());
    }

    @Test
    public void dwarfTentarSorteSemSorte() {
        Dwarf dwarf = new Dwarf();
        dwarf.adicionarItem(new Item(5, "Lança"));
        dwarf.adicionarItem(new Item(25, "Poção"));
        
        Inventario esperado = new Inventario();
        esperado.adicionarItem(new Item(5, "Lança"));
        esperado.adicionarItem(new Item(25, "Poção"));
        
        dwarf.tentarSorte();
        
        assertEquals(esperado, dwarf.getInventario());
    }
    
    @Test
    public void dwarfRecebeEspadadaDoOrcUrukHai(){
        Orc orc = new Orc(TipoOrc.URUKHAI);
        Dwarf dwarf = new Dwarf();
        
        orc.atacarAnao(dwarf);
        
        assertEquals(98, dwarf.getVida());
    }
    
    @Test
    public void dwarfRecebeFlechadaDoOrcSnaga(){
        Orc orc = new Orc(TipoOrc.SNAGA);
        Dwarf dwarf = new Dwarf();
        
        orc.atacarAnao(dwarf);
        
        assertEquals(102, dwarf.getVida());
    }
    
    @Test
    public void dwarfMataOrcUrukHai(){
        Orc orc = new Orc(TipoOrc.URUKHAI);
        Dwarf dwarf = new Dwarf();
        
        int golpesAteMatarOrc = 29;
        
        for(int i = 0; i < golpesAteMatarOrc; i++){
            dwarf.atacarOrc(orc);
            assertEquals(Status.FERIDO, orc.getStatus());
        }
        dwarf.atacarOrc(orc);
        assertEquals(Status.MORTO, orc.getStatus());
    }
    
    @Test
    public void dwarfMataOrcSnaga(){
        Orc orc = new Orc(TipoOrc.SNAGA);
        Dwarf dwarf = new Dwarf();
        
        int golpesAteMatarOrc = 6;
        
        for(int i = 0; i < golpesAteMatarOrc; i++){
            dwarf.atacarOrc(orc);
            assertEquals(Status.FERIDO, orc.getStatus());
        }
        
        dwarf.atacarOrc(orc);
        assertEquals(Status.MORTO, orc.getStatus());
    }

}
