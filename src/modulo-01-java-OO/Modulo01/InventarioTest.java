

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class InventarioTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class InventarioTest
{
   @Test
   public void itemAdicionadoPosição1(){
       Inventario i = new Inventario();
       Item batata = new Item("Batata", 3);
       i.adicionarItem(batata);
       assertEquals(i.getListaDeItens().get(0), batata);
   }
   
   @Test
   public void itemRemoverPosição1(){
       Inventario i = new Inventario();
       Item batata = new Item("Batata", 3);
       Item batataDoce = new Item("Batata Doce", 1);
       i.adicionarItem(batata);
       i.adicionarItem(batataDoce);
       i.removerItem(batataDoce);
       assertEquals(1, i.getListaDeItens().size());
   }
   
   @Test
   public void itemNãoRemovidoPassaASerOPrimeiroDeDois(){
       Inventario i = new Inventario();
       Item batata = new Item("Batata", 3);
       Item batataDoce = new Item("Batata Doce", 1);
       i.adicionarItem(batata);
       i.adicionarItem(batataDoce);
       i.removerItem(batata);
       assertEquals(batataDoce, i.getListaDeItens().get(0));
   }
   
   @Test
    public void dwarfRetornaDescriçõesDosSeusItens(){
      Inventario invDoThorin = new Inventario();
      invDoThorin.adicionarItem(new Item("Pedra Arken", 1));
      invDoThorin.adicionarItem(new Item("Tererê de barba", 5));
      invDoThorin.adicionarItem(new Item("Espada emprestada do brother Légolas", 1));
      assertEquals("Pedra Arken,Tererê de barba,Espada emprestada do brother Légolas", invDoThorin.getDescricoesItens());
    }
    
    @Test 
    public void itemComMaiorQuantidadeÉOItemComMaiorQuantidade(){
      Inventario invDoThorin = new Inventario();
      invDoThorin.adicionarItem(new Item("Pedra Arken", 3));
      invDoThorin.adicionarItem(new Item("Tererê de barba", 5));
      invDoThorin.adicionarItem(new Item("Espada emprestada do brother Légolas", 1));
      assertEquals(5, invDoThorin.getItemComMaiorQuantidade().getQuantidade());  
    }
    
    @Test 
    public void itensOrdenadosDeFormaAscendente1(){
      Inventario invDoThorin = new Inventario();
      invDoThorin.adicionarItem(new Item("Pedra Arken", 3));
      invDoThorin.adicionarItem(new Item("Tererê de barba", 5));
      invDoThorin.adicionarItem(new Item("Espada emprestada do brother Légolas", 1));
      invDoThorin.ordenarItens();
      assertEquals(1, invDoThorin.getListaDeItens().get(0).getQuantidade());
      
    }
    
    @Test 
    public void itensOrdenadosDeFormaAscendente2(){
      Inventario invDoThorin = new Inventario();
      invDoThorin.adicionarItem(new Item("Pedra Arken", 3));
      invDoThorin.adicionarItem(new Item("Tererê de barba", 5));
      invDoThorin.adicionarItem(new Item("Espada emprestada do brother Légolas", 1));
      invDoThorin.ordenarItens();
     
      assertEquals(3, invDoThorin.getListaDeItens().get(1).getQuantidade());
      
    }
    
    @Test 
    public void itensOrdenadosDeFormaAscendente3(){
      Inventario invDoThorin = new Inventario();
      invDoThorin.adicionarItem(new Item("Pedra Arken", 3));
      invDoThorin.adicionarItem(new Item("Tererê de barba", 5));
      invDoThorin.adicionarItem(new Item("Espada emprestada do brother Légolas", 1));
      invDoThorin.ordenarItens();
     
      assertEquals(5, invDoThorin.getListaDeItens().get(2).getQuantidade());
    }
    
    @Test
    public void inventarioOrdenarItensComItensJaOrdenados(){
       Inventario invDoThorin = new Inventario();
       invDoThorin.adicionarItem(new Item("Pedra Arken", 3));
       invDoThorin.adicionarItem(new Item("Tererê de barba", 5));
       invDoThorin.adicionarItem(new Item("Espada emprestada do brother Légolas", 1));
       invDoThorin.ordenarItens();
       assertEquals(1, invDoThorin.getListaDeItens().get(0).getQuantidade());
       assertEquals(3, invDoThorin.getListaDeItens().get(1).getQuantidade());
       assertEquals(5, invDoThorin.getListaDeItens().get(2).getQuantidade());
   }
}
