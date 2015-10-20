

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class BebidaTest{ 
    @Test
    public void bebidaLataComPrecoCerto(){
        Produto bebida = new Bebida(TamanhoBebida.LATA, MarcaBebida.PEPSI);
        
        assertEquals(3.50, bebida.getPreco(), 0);
    }
    
    @Test
    public void bebidaGarrafaComPrecoCerto(){
        Produto bebida = new Bebida(TamanhoBebida.GARRAFA, MarcaBebida.PEPSI);
        
        assertEquals(7, bebida.getPreco(), 0);
    }
    
    @Test
    public void bebidaLataComNomeCerto(){
        Produto bebida = new Bebida(TamanhoBebida.LATA, MarcaBebida.PEPSI);
        
        assertEquals("PEPSI LATA", bebida.getNome());
    }
    
    @Test
    public void bebidaGarrafaComNomeCerto(){
        Produto bebida = new Bebida(TamanhoBebida.GARRAFA, MarcaBebida.COCA_COLA);
        
        assertEquals("COCA_COLA GARRAFA", bebida.getNome());
    }
}
