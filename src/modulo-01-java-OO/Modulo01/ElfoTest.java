

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ElfoTest
{
    @Test
    public void nomeCerto(){
        Elfo thranduil = new Elfo ("Thranduil", null);
        assertEquals("Thranduil", thranduil.getNome());
    }
    
    @Test
    public void flechasNotNull(){
        Elfo thranduil = new Elfo ("Thranduil", null);
        assertEquals(42, thranduil.getFlechas());
    }
    
    @Test
    public void elfoPerdeFlechas(){
        Elfo thranduil = new Elfo ("Thranduil", 10);
        Dwarf gimli = new Dwarf("Gimli");
        thranduil.atirarFlecha(gimli);
        assertEquals(9, thranduil.getFlechas());
    }
    
    @Test
    public void elfoGanhaExperiencia(){
        Elfo thranduil = new Elfo ("Thranduil", 10);
        Dwarf gimli = new Dwarf("Gimli");
        thranduil.atirarFlecha(gimli);
        assertEquals(1, thranduil.getExperiencia());
    }
   
}
