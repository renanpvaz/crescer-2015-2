

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
       assertEquals(95, noturno.getVidaDecrescida(), 0.0001);
   }
   
   @Test
   public void elfoNoturnoAtiraDuasFlechas(){
       ElfoNoturno noturno = new ElfoNoturno("Noturno", 10);
       noturno.atirarFlecha(new Dwarf());
       noturno.atirarFlecha(new Dwarf());
       assertEquals(90.25, noturno.getVidaDecrescida(), 0.0001);
   }
}
