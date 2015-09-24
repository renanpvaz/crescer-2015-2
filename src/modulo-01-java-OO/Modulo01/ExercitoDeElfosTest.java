

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
    public void umElfoAgrupadoPorStatus(){
        ExercitoDeElfos exercitoDeElfos = new ExercitoDeElfos();
        ElfoNoturno noturno = new ElfoNoturno("Noturno");
        ArrayList <Elfo> vivos;
        exercitoDeElfos.agruparPorStatus();
        //vivos = (ArrayList)exercitoDeElfos.getAgrupamentoPorStatus().get(Status.VIVO);
        
        assertEquals(noturno, exercitoDeElfos.getElfoVivoPorPosicao(0));
    }
    
}
