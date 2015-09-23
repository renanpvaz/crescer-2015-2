

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class OrcTest
{
    @Test
    public void criaUrukHai(){
        /*Orc orc = new Orc(TipoOrc.URUKHAI);
        
        int vidaEsperada = 150;
        Inventario inventarioEsperado = new Inventario();
        inventarioEsperado.adicionarItem(new Item(1, "Escudo Uruk-Hai"));
        inventarioEsperado.adicionarItem(new Item(1, "Espada"));
        
        assertEquals(vidaEsperada, orc.getVida());
        assertEquals(inventarioEsperado, orc.getInventario());
        */
    }
    
    @Test
    public void criaSnaga(){
        /*
        Orc orc = new Orc(TipoOrc.SNAGA);
        
        int vidaEsperada = 70;
        Inventario inventarioEsperado = new Inventario();
        inventarioEsperado.adicionarItem(new Item(1, "Arco"));
        inventarioEsperado.adicionarItem(new Item(5, "Flecha"));
        
        assertEquals(vidaEsperada, orc.getVida());
        assertEquals(inventarioEsperado, orc.getInventario());
        */
    }
    
    @Test
    public void orcUrukHaiRecebeDanoDeAnao(){
        Orc orc = new UrukHai();
        
        orc.levarAtaque();
        
        assertEquals(144, orc.getVida());
    }
    
    @Test
    public void orcUrukHaiRecebeDanoDeElfo(){
        Orc orc = new UrukHai();
        
        orc.levarAtaque();
        
        assertEquals(144, orc.getVida());
    }
    
    @Test
    public void orcSnagaRecebeDanoDeAnao(){
        Orc orc = new Snaga();
        
        orc.levarAtaque();
        
        assertEquals(60, orc.getVida());
    }
    
    @Test
    public void orcSnagaRecebeDanoDeElfo(){
        Orc orc = new Snaga();
        
        orc.levarAtaque();
        
        assertEquals(60, orc.getVida());
    }
    
    @Test
    public void orcSnagaFicaSemFlechasParaAtirarEFoge(){
        Orc orc = new Snaga();
        Elfo elfo = new Elfo(null);
        
        for(int i = 0; i < 6; i++){
            orc.atacar(elfo);
        }
        
        assertEquals(Status.FUGINDO, orc.getStatus());
    }
    
    @Test
    public void orcSnagaAtiraFlechaEmElfoEFicaCom4Flechas(){
    
        Orc orc = new Snaga();
        Elfo elfo = new Elfo(null);
        
        orc.atacar(elfo);
        
        int qtdFlechas = orc.getInventario().getItemPorDescricao("Flecha").getQuantidade();
        
        assertEquals(4, qtdFlechas);
        
    }
    
}
