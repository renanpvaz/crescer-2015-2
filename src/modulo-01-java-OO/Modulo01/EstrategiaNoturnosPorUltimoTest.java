
import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.util.ArrayList;

public class EstrategiaNoturnosPorUltimoTest{
    @Test
    public void cincoElfosAtacamCincoDwarves(){
            ExercitoDeElfos exercito = new ExercitoDeElfos();
            ArrayList<Dwarf> dwarves = new ArrayList<Dwarf>();
            
            Elfo e1 = new ElfoNoturno("1");
            Elfo e2 = new ElfoNoturno("2");
            Elfo e3 = new ElfoVerde("3");
            Elfo e4 = new ElfoVerde("4");
            Elfo e5 = new ElfoVerde("5");
            
            Dwarf d1 = new Dwarf();
            Dwarf d2 = new Dwarf();
            Dwarf d3 = new Dwarf();
            Dwarf d4 = new Dwarf();
            Dwarf d5 = new Dwarf();
            
            exercito.alistarElfo(e1);
            exercito.alistarElfo(e2);
            exercito.alistarElfo(e3);
            exercito.alistarElfo(e4);
            exercito.alistarElfo(e5);
            
            dwarves.add(d1);
            dwarves.add(d2);
            dwarves.add(d3);
            dwarves.add(d4);
            dwarves.add(d5);
            
            exercito.mudarEstrategia(new EstrategiaNoturnosPorUltimo());
            exercito.getEstrategiaDeAtaque().atacar(exercito, dwarves);
            
            assertEquals(e3, exercito.getOrdemDoUltimoAtaque().get(0));
            assertEquals(e4, exercito.getOrdemDoUltimoAtaque().get(1));
            assertEquals(e5, exercito.getOrdemDoUltimoAtaque().get(2));
            assertEquals(e1, exercito.getOrdemDoUltimoAtaque().get(3));
            assertEquals(e2, exercito.getOrdemDoUltimoAtaque().get(4));
    }
}
