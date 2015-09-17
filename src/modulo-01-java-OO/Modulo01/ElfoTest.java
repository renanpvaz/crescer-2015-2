

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ElfoTest
{
    Elfo thranduil = new Elfo ("Thranduil", 10);
    Dwarf gimli = new Dwarf("Gimli");
    
    @Test
    public void elfoCriadoNomeEscolhido(){        
        assertEquals("Thranduil", thranduil.getNome());
    }
    
    @Test
    public void flechasNotNull(){
        Elfo thranduil = new Elfo ("Thranduil");
        assertNotNull(thranduil.getFlechas());
    }
    
    @Test
    public void elfoPerdeFlechasAoAtirar(){
        int flechasIni = thranduil.getFlechas();
        thranduil.atirarFlecha(gimli);       
        assertEquals(flechasIni - 1, thranduil.getFlechas());
    }
    
    @Test
    public void elfoGanhaExperienciaAoAtirar(){
        thranduil.atirarFlecha(gimli);
        assert(0 < thranduil.getExperiencia());
    }
    
    @Test
    public void toStringRetornaInfoCorreta(){       
       String info = thranduil.toString();       
       boolean contain = info.contains(thranduil.getNome() + " possui " + thranduil.getFlechas() + 
            " flechas e " + thranduil.getExperiencia() + " níveis de experiência.");       
       assertEquals(true, contain);     
    }    
}
