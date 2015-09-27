

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.util.ArrayList;

/**
 * The test class EstrategiaIntercaladaTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class EstrategiaIntercaladaTest
{
    @Test
    public void cincoElfosAtacamCincoDwarves(){
            ExercitoDeElfos exercito = new ExercitoDeElfos();
            ArrayList<Dwarf> dwarves = new ArrayList<Dwarf>();
            
            Elfo e1 = new ElfoNoturno("1");
            Elfo e2 = new ElfoVerde("2");
            Elfo e3 = new ElfoVerde("3");
            Elfo e4 = new ElfoNoturno("4");
            
            Dwarf d1 = new Dwarf();
            Dwarf d2 = new Dwarf();
            Dwarf d3 = new Dwarf();
            Dwarf d4 = new Dwarf();
            Dwarf d5 = new Dwarf();
            
            exercito.alistarElfo(e1);
            exercito.alistarElfo(e2);
            exercito.alistarElfo(e3);
            exercito.alistarElfo(e4);
            
            dwarves.add(d1);
            dwarves.add(d2);
            dwarves.add(d3);
            dwarves.add(d4);
            dwarves.add(d5);
            
            exercito.agruparPorStatus();
            exercito.mudarEstrategia(new EstrategiaIntercalada());
            exercito.getEstrategiaDeAtaque().atacar(exercito, dwarves);
            
            assertEquals(e1, exercito.getOrdemDoUltimoAtaque().get(0));
            assertEquals(e2, exercito.getOrdemDoUltimoAtaque().get(1));
            assertEquals(e4, exercito.getOrdemDoUltimoAtaque().get(2));

    }
}
