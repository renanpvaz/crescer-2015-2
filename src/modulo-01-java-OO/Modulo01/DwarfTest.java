

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
    
    
}
