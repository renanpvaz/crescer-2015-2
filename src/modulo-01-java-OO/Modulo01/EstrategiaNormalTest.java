

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.util.*;

/**
 * The test class EstrategiaNormalTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class EstrategiaNormalTest{
    
    @Test
    public void cincoElfosVerdesVivosAtacam5Dwarves(){
        ExercitoDeElfos exercito = new ExercitoDeElfos();
        ArrayList<Dwarf> dwarves = new ArrayList<Dwarf>();
        
        Elfo e1 = new ElfoVerde("1");
        Elfo e2 = new ElfoVerde("2");
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
        
        exercito.getEstrategiaDeAtaque().atacar(exercito, dwarves);
        
        assertEquals(60, dwarves.get(0).getVida());
        assertEquals(60, dwarves.get(1).getVida());
        assertEquals(60, dwarves.get(2).getVida());
        assertEquals(60, dwarves.get(3).getVida());
        assertEquals(60, dwarves.get(4).getVida());
        
    }
    
    @Test
    public void cincoElfosVerdesVivosAtacam5DwarvesTresOndas(){
        ExercitoDeElfos exercito = new ExercitoDeElfos();
        ArrayList<Dwarf> dwarves = new ArrayList<Dwarf>();
        
        Elfo e1 = new ElfoVerde("1");
        Elfo e2 = new ElfoVerde("2");
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
        
        dwarves.add(d1);
        dwarves.add(d2);
        dwarves.add(d3);
        dwarves.add(d4);
        dwarves.add(d5);
        
        exercito.agruparPorStatus();
        
        exercito.getEstrategiaDeAtaque().atacar(exercito, dwarves);
        exercito.getEstrategiaDeAtaque().atacar(exercito, dwarves);
        exercito.getEstrategiaDeAtaque().atacar(exercito, dwarves);
        
        assertEquals(0, dwarves.get(0).getVida());
        assertEquals(0, dwarves.get(1).getVida());
        assertEquals(0, dwarves.get(2).getVida());
        assertEquals(0, dwarves.get(3).getVida());
        assertEquals(0, dwarves.get(4).getVida());
        
    }
    
    @Test
    public void cincoElfosNoturnosVivosAtacam5Dwarves(){
        ExercitoDeElfos exercito = new ExercitoDeElfos();
        ArrayList<Dwarf> dwarves = new ArrayList<Dwarf>();
        
        Elfo e1 = new ElfoNoturno("1");
        Elfo e2 = new ElfoNoturno("2");
        Elfo e3 = new ElfoNoturno("3");
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
        
        exercito.getEstrategiaDeAtaque().atacar(exercito, dwarves);
        
        assertEquals(70, dwarves.get(0).getVida());
        assertEquals(70, dwarves.get(1).getVida());
        assertEquals(70, dwarves.get(2).getVida());
        assertEquals(70, dwarves.get(3).getVida());
        assertEquals(70, dwarves.get(4).getVida());
        
    }
}
