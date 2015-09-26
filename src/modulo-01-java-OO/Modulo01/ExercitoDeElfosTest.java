

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.util.HashMap;
import java.util.ArrayList;

/**
 * The test class ExercitoDeElfosTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class ExercitoDeElfosTest
{
    @Test
    public void umElfoVerdeÉAlistado(){
        ExercitoDeElfos exercitoDeElfos = new ExercitoDeElfos();
        ElfoVerde green = new ElfoVerde("Fandango");
        exercitoDeElfos.alistarElfo(green);
        assertEquals(green, exercitoDeElfos.getExercito().get("Fandango"));
    }
    
    @Test
    public void umElfoNoturnoÉAlistado(){
        ExercitoDeElfos exercitoDeElfos = new ExercitoDeElfos();
        ElfoNoturno noturno = new ElfoNoturno("Noturno");
        exercitoDeElfos.alistarElfo(noturno);
        assertEquals(noturno, exercitoDeElfos.getExercito().get("Noturno"));
    }
    
    @Test
    public void elfoErradoÉChamado(){
        ExercitoDeElfos exercitoDeElfos = new ExercitoDeElfos();
        ElfoVerde green = new ElfoVerde("Fandango");
        exercitoDeElfos.alistarElfo(green);
        assertEquals(null, exercitoDeElfos.getExercito().get("Cebolitos"));
    }
    
    @Test
    public void umElfoParaCadaTipoÉAlistado(){
        ExercitoDeElfos exercitoDeElfos = new ExercitoDeElfos();
        ElfoNoturno noturno = new ElfoNoturno("Noturno");
        ElfoVerde green = new ElfoVerde("Fandango");
        exercitoDeElfos.alistarElfo(green);
        exercitoDeElfos.alistarElfo(noturno);
        assertEquals(noturno, exercitoDeElfos.getExercito().get("Noturno"));
        assertEquals(green, exercitoDeElfos.getExercito().get("Fandango"));
    }
    
    @Test
    public void umElfoVivoAgrupadoPorStatus(){
        ExercitoDeElfos exercitoDeElfos = new ExercitoDeElfos();
        ElfoVerde green = new ElfoVerde("Fandango");
        exercitoDeElfos.alistarElfo(green);
        exercitoDeElfos.agruparPorStatus();
        assertEquals(green, exercitoDeElfos.buscar(Status.VIVO).get(0));
    }
    
    @Test
    public void umElfoMortoAgrupadoPorStatus(){
       ExercitoDeElfos exercitoDeElfos = new ExercitoDeElfos();
       ElfoNoturno noturno = new ElfoNoturno("Noturno", 100);
       for(int i = 0; i < 99; i++){
           noturno.atirarFlecha(new Dwarf());
       }
       exercitoDeElfos.alistarElfo(noturno);
       exercitoDeElfos.agruparPorStatus();
       assertEquals(noturno, exercitoDeElfos.buscar(Status.MORTO).get(0));
    }

    @Test
    public void doisElfosVivoAgrupadosPorStatus(){
        ExercitoDeElfos exercitoDeElfos = new ExercitoDeElfos();
        ElfoVerde green = new ElfoVerde("Fandango");
        ElfoNoturno noturno = new ElfoNoturno("Noturno", 100);
        exercitoDeElfos.alistarElfo(green);
        exercitoDeElfos.alistarElfo(noturno);
        exercitoDeElfos.agruparPorStatus();
        assertEquals(green, exercitoDeElfos.buscar(Status.VIVO).get(0));
        assertEquals(noturno, exercitoDeElfos.buscar(Status.VIVO).get(1));
    }
    
    @Test
    public void doisElfosMortosAgrupadosPorStatus(){
        ExercitoDeElfos exercitoDeElfos = new ExercitoDeElfos();
        ElfoNoturno noturno = new ElfoNoturno("Noturno", 100);
        ElfoNoturno noturno2 = new ElfoNoturno("Noturno II", 100);
        for(int i = 0; i < 99; i++){
           noturno.atirarFlecha(new Dwarf());
           noturno2.atirarFlecha(new Dwarf());
       }
        exercitoDeElfos.alistarElfo(noturno);
        exercitoDeElfos.alistarElfo(noturno2);
        exercitoDeElfos.agruparPorStatus();
        assertEquals(noturno, exercitoDeElfos.buscar(Status.MORTO).get(0));
        assertEquals(noturno2, exercitoDeElfos.buscar(Status.MORTO).get(1));
    }
    
    @Test
    public void umElfoMortoEUmVivoAgrupadosPorStatus(){
       ExercitoDeElfos exercitoDeElfos = new ExercitoDeElfos();
       ElfoVerde green = new ElfoVerde("Fandango");
       ElfoNoturno noturno = new ElfoNoturno("Noturno", 100);
       for(int i = 0; i < 99; i++){
           noturno.atirarFlecha(new Dwarf());
       }
       exercitoDeElfos.alistarElfo(green);
       exercitoDeElfos.alistarElfo(noturno);
       exercitoDeElfos.agruparPorStatus();
       assertEquals(green, exercitoDeElfos.buscar(Status.VIVO).get(0));
       assertEquals(noturno, exercitoDeElfos.buscar(Status.MORTO).get(0));
    }
    
    @Test
    public void doisElfosMortosEDoisVivosAgrupadosPorStatus(){
       ExercitoDeElfos exercitoDeElfos = new ExercitoDeElfos();
       ElfoVerde green = new ElfoVerde("Fandango");
       ElfoVerde green2 = new ElfoVerde("Fandango2");
       ElfoNoturno noturno = new ElfoNoturno("Noturno", 100);
       ElfoNoturno noturno2 = new ElfoNoturno("Noturno II", 100);
       for(int i = 0; i < 99; i++){
           noturno.atirarFlecha(new Dwarf());
           noturno2.atirarFlecha(new Dwarf());
       }
       exercitoDeElfos.alistarElfo(green);
       exercitoDeElfos.alistarElfo(green2);
       exercitoDeElfos.alistarElfo(noturno);
       exercitoDeElfos.alistarElfo(noturno2);
       exercitoDeElfos.agruparPorStatus();
       
       assertEquals(green, exercitoDeElfos.buscar(Status.VIVO).get(0));
       assertEquals(green2, exercitoDeElfos.buscar(Status.VIVO).get(1));
       assertEquals(noturno, exercitoDeElfos.buscar(Status.MORTO).get(0));
       assertEquals(noturno2, exercitoDeElfos.buscar(Status.MORTO).get(1));
    }
    
    @Test
    public void contemoisElfosMortosEDoisVivosAgrupadosPorStatus(){
       ExercitoDeElfos exercitoDeElfos = new ExercitoDeElfos();
       ElfoVerde green = new ElfoVerde("Fandango");
       ElfoVerde green2 = new ElfoVerde("Fandango2");
       ElfoNoturno noturno = new ElfoNoturno("Noturno", 100);
       ElfoNoturno noturno2 = new ElfoNoturno("Noturno II", 100);
       for(int i = 0; i < 99; i++){
           noturno.atirarFlecha(new Dwarf());
           noturno2.atirarFlecha(new Dwarf());
       }
       exercitoDeElfos.alistarElfo(green);
       exercitoDeElfos.alistarElfo(green2);
       exercitoDeElfos.alistarElfo(noturno);
       exercitoDeElfos.alistarElfo(noturno2);
       exercitoDeElfos.agruparPorStatus();
       
       assertTrue(exercitoDeElfos.buscar(Status.VIVO).contains(green));
       assertTrue(exercitoDeElfos.buscar(Status.VIVO).contains(green2));
       assertTrue(exercitoDeElfos.buscar(Status.MORTO).contains(noturno));
       assertTrue(exercitoDeElfos.buscar(Status.MORTO).contains(noturno2));
    }
    
    @Test
    public void contemoisElfosMortosEDoisVivosOrdenadosDeixandoElfosNoturnosPorUltimo(){
       ExercitoDeElfos exercitoDeElfos = new ExercitoDeElfos();
       ElfoVerde green = new ElfoVerde("Fandango");
       ElfoVerde green2 = new ElfoVerde("Fandango2");
       ElfoNoturno noturno = new ElfoNoturno("Noturno");
       ElfoNoturno noturno2 = new ElfoNoturno("Noturno II");
       
       exercitoDeElfos.alistarElfo(noturno);
       exercitoDeElfos.alistarElfo(noturno2);
       exercitoDeElfos.alistarElfo(green);
       exercitoDeElfos.alistarElfo(green2);
       exercitoDeElfos.agruparPorStatus();
       ArrayList<Elfo> ordenados = exercitoDeElfos.ordenarNoturnosNoFinal();
       
       assertTrue(ordenados.get(0) instanceof ElfoVerde);
       assertTrue(ordenados.get(1) instanceof ElfoVerde);
       assertTrue(ordenados.get(2) instanceof ElfoNoturno);
       assertTrue(ordenados.get(3) instanceof ElfoNoturno);
    }
}
