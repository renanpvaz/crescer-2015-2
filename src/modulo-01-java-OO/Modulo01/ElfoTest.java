

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ElfoTest
{
    //Nome
    @Test
    public void elfoCriadoNomeEscolhido(){
        Elfo thranduil = new Elfo ("Thranduil");
        assertEquals("Thranduil", thranduil.getNome());
    }
    @Test
    public void elfoCriadoNomeEscolhidoNull(){        
        Elfo elfoNulo = new Elfo(null);
        assertNull(elfoNulo.getNome());
    }
    @Test
    public void elfoCriadoNomeEscolhidoVazio(){        
        Elfo elfoVazio = new Elfo("");
        assertEquals("", elfoVazio.getNome());
    }
    
    //Flechas
    @Test
    public void flechasNotNull(){
        Elfo thranduil = new Elfo ("Thranduil");
        assertNotNull(thranduil.getFlechas());
    }
    @Test
    public void elfoMuitasFlechas(){
        Elfo muitasFlechas = new Elfo ("Muitas Flechas", 1000);
        assertNotNull(muitasFlechas.getFlechas());
    }
    @Test
    public void elfoPoucasFlechas(){
        Elfo poucasFlechas = new Elfo ("Poucas Flechas", 1);
        assertNotNull(poucasFlechas.getFlechas());
    }
    //Status
    @Test 
    public void elfoNasceVivo(){
        Elfo vivao = new Elfo("Vivão");
        assertEquals(Status.VIVO, vivao.getStatus());
    }
    //Exp
    public void elfoComeçaCom0Exp(){
        Elfo exp0 = new Elfo("Exp0");
        assertEquals(0, exp0.getExperiencia());
    }
    
    //AtirarFlecha
    @Test
    public void elfoAtiraFlechaEmDwarf(){
        Elfo thranduil = new Elfo("Thranduil");
        Dwarf gimli = new Dwarf("Gimli");
        thranduil.atirarFlecha(gimli);
        assertEquals(41, thranduil.getFlechas());
        assertEquals(1, thranduil.getExperiencia());
        assertEquals(100, gimli.getVida());
   }
    
    
    @Test
    public void toStringComNiveisEFlechas(){
      Elfo thranduil = new Elfo("Thranduil", 10);  
     assertEquals("Thranduil possui 10 flechas e 0 níveis de experiência.", thranduil.toString());        
          
    }
    @Test
    public void toStringUmaFlechaUmNível(){
      Elfo thranduil = new Elfo("Thranduil", 2);
      Dwarf gimli = new Dwarf("Gimli");
      thranduil.atirarFlecha(gimli);
      assertEquals("Thranduil possui 1 flecha e 1 nível de experiência.", thranduil.toString());    
    }
}
