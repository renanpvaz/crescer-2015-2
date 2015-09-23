

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class ElfoNoturnoTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class ElfoNoturnoTest
{
   @Test
   public void elfoNoturnoAtiraFlecha(){
       ElfoNoturno noturno = new ElfoNoturno("Noturno", 10);
       noturno.atirarFlecha(new Dwarf());
       assertEquals(95, noturno.getVida());
   }
   
   @Test
   public void elfoNoturnoAtiraDuasFlechas(){
       ElfoNoturno noturno = new ElfoNoturno("Noturno", 10);
       noturno.atirarFlecha(new Dwarf());
       noturno.atirarFlecha(new Dwarf());
       assertEquals(90, noturno.getVida());
   }
   
   @Test
   public void elfoNoturnoAtiraCemFlechas(){
       ElfoNoturno noturno = new ElfoNoturno("Noturno", 100);
       for(int i = 0; i < 99; i++){
           noturno.atirarFlecha(new Dwarf());
        }
       assertEquals(Status.MORTO, noturno.getStatus());      
   }
   
   @Test
   public void elfoNoturnoAtiraCemFlechasFicaComVidaZerada(){
       ElfoNoturno noturno = new ElfoNoturno("Noturno", 100);
       for(int i = 0; i < 99; i++){
           noturno.atirarFlecha(new Dwarf());
        }
       assertEquals(0, noturno.getVida());      
   }
}
