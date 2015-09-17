

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ElfoTest
{
    Elfo thranduil = new Elfo ("Thranduil", 10);
    Dwarf gimli = new Dwarf("Gimli");
    
    @Test
    public void elfoCriadoNomeCerto(){        
        assertEquals("Thranduil", thranduil.getNome());
    }
    
    @Test
    public void flechasNotNull(){
        Elfo thranduil = new Elfo ("Thranduil", null);
        assertNotNull(thranduil.getFlechas());
    }
    
    @Test
    public void elfoPerdeFlechas(){
        thranduil.atirarFlecha(gimli);
        assertEquals(9, thranduil.getFlechas());
    }
    
    @Test
    public void elfoGanhaExperiencia(){
        thranduil.atirarFlecha(gimli);
        assertEquals(1, thranduil.getExperiencia());
    }
    
    @Test
    public void testeToStringContem(){       
       String info = thranduil.toString();       
       boolean contain = info.contains(thranduil.getNome() + " possui " + thranduil.getFlechas() + 
            " flechas e " + thranduil.getExperiencia() + " níveis de experiência.");       
       assertEquals(true, contain);     
    }
}
