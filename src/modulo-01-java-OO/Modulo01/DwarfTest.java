

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
        thranduil.atirarFlecha(gimli);
        assertEquals(100, gimli.getVida());
    }
    
    @Test
    public void dwarfPerde110DeVidaAoReceber11Flechas(){
        Elfo thranduil = new Elfo ("Thranduil", 11);
        Dwarf gimli = new Dwarf("Gimli");
        for(int i = 0; i <= 10; i++){
          thranduil.atirarFlecha(gimli);  
        }
        assertEquals(0, gimli.getVida());
    }
    
    @Test
    public void dwarfMorto(){
       Dwarf gimli = new Dwarf("Gimli");
       for(int i = 0; i <= 10; i++){  
           gimli.recebeDano();
       }
        assertEquals(Status.MORTO, gimli.getStatus());
    }
    
    @Test 
    public void dwarfVidaNaoPassaDeZero(){
        Dwarf gimli = new Dwarf("Gimli");
       for(int i = 0; i <= 11; i++){
          gimli.recebeDano();  
       }
        assertEquals(0, gimli.getVida());
    }
    
    @Test
    public void nasceComDiaNascimento(){
        Dwarf gimli = new Dwarf ("Gimli", new DataTerceiraEra(12, 2, 1998));
        assertEquals(12, gimli.getDataNascimento().getDia());
        assertEquals(2, gimli.getDataNascimento().getMes());
        assertEquals(1998, gimli.getDataNascimento().getAno());
    }
    
    @Test
    public void dwarfComVida80EAnoBissextoTrue(){
      Dwarf gimli = new Dwarf("Gimli", new DataTerceiraEra(29, 2, 2016));
      for(int i = 0; i <= 2; i++){
          gimli.recebeDano();  
      }
      assertEquals(-3333.0, gimli.getSorte(), 0.001);
    }
    
    @Test
    public void dwarfComNomeSeixasEAnoBissextoFalse(){
      Dwarf seixas = new Dwarf("Seixas", new DataTerceiraEra(29, 3, 1997));
      assertEquals(33, seixas.getSorte(), 0.001);
    }
    
    @Test
    public void dwarfComNomeMeirelesEAnoBissextoFalse(){
      Dwarf meireles = new Dwarf("Meireles", new DataTerceiraEra(29, 3, 1997));
      assertEquals(33, meireles.getSorte(), 0.001);
    }
    
    @Test
    public void dwarfComNomeDiferenteDeMeirelesESeixasEAnoBissextoFalse(){
       Dwarf gimli = new Dwarf("Gimli", new DataTerceiraEra(29, 3, 1997));
       assertEquals(101.0, gimli.getSorte(), 0.001);
    }
    
    
    
} 
