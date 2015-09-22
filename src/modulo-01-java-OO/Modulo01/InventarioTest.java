

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
   public void itemAdicionadoNaPrimeiraPosição(){
       Inventario i = new Inventario();
       Item batata = new Item("Batata", 3);
       i.adicionarItem(batata);
       assertEquals(batata, i.getListaDeItens().get(0));
   }
   
   @Test
   public void itemAdicionadoNaSegundaPosição(){
       Inventario i = new Inventario();
       Item batata = new Item("Batata", 3);
       Item batataDoce = new Item("Batata Doce", 1);
       i.adicionarItem(batataDoce);
       i.ListaDeItens.add(1, batata);
       i.ListaDeItens.set(0, null);
       assertEquals(batata, i.getListaDeItens().get(1));
   }
   
   @Test
   public void itemAdicionadoNaSegundaPosição2(){
       Inventario i = new Inventario();
       Item batata = new Item("Batata", 3);
       Item batataDoce = new Item("Batata Doce", 1);
       i.adicionarItem(batataDoce);
       i.ListaDeItens.set(0, null);
       i.adicionarItem(batata);
       //i.ListaDeItens.add(1, batata);
       assertEquals(batata, i.getListaDeItens().get(1));
   }
   
   @Test
   public void removerItemNaSegundaPosição(){
       Inventario i = new Inventario();
       Item batata = new Item("Batata", 3);
       Item batataDoce = new Item("Batata Doce", 1);
       i.adicionarItem(batata);
       i.adicionarItem(batataDoce);
       i.removerItem(batataDoce);
       assertEquals(1, i.getListaDeItens().size());
   }
   
   @Test
   public void removerUmItemEListaFicaVazia(){
       Inventario i = new Inventario();
       Item batata = new Item("Batata", 3);
       i.adicionarItem(batata);
       i.removerItem(batata);
       assertTrue(i.getListaDeItens().isEmpty());
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
    public void itemComMaiorQuantidadeComItensIguais(){
      Inventario invDoThorin = new Inventario();
      invDoThorin.adicionarItem(new Item("Pedra Arken", 5));
      invDoThorin.adicionarItem(new Item("Tererê de barba", 5));
      invDoThorin.adicionarItem(new Item("Espada emprestada do brother Légolas", 5));
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
       invDoThorin.adicionarItem(new Item("Pedra Arken", 1));
       invDoThorin.adicionarItem(new Item("Tererê de barba", 3));
       invDoThorin.adicionarItem(new Item("Espada emprestada do brother Légolas", 5));
       invDoThorin.ordenarItens();
       assertEquals(1, invDoThorin.getListaDeItens().get(0).getQuantidade());
       assertEquals(3, invDoThorin.getListaDeItens().get(1).getQuantidade());
       assertEquals(5, invDoThorin.getListaDeItens().get(2).getQuantidade());
   }
   
   @Test
    public void inventarioOrdenaInventarioCorreto(){
       Inventario invDoThorin = new Inventario();
       Inventario invDoBilbo = new Inventario();
       invDoThorin.adicionarItem(new Item("Pedra Arken", 1));
       invDoThorin.adicionarItem(new Item("Tererê de barba", 3));
       invDoThorin.adicionarItem(new Item("Espada emprestada do brother Légolas", 1));
       invDoBilbo.adicionarItem(new Item("Ferroada", 1));
       invDoThorin.ordenarItens();
       assertEquals(1, invDoThorin.getListaDeItens().get(0).getQuantidade());
       assertEquals(1, invDoThorin.getListaDeItens().get(1).getQuantidade());
       assertEquals(3, invDoThorin.getListaDeItens().get(2).getQuantidade());
       assertEquals("Ferroada", invDoBilbo.getListaDeItens().get(0).getDescricao());
   }
   
   @Test
    public void inventarioGetDescriçõesDosItensApósOrdenados(){
       Inventario invDoThorin = new Inventario();
       invDoThorin.adicionarItem(new Item("Pedra Arken", 3));
       invDoThorin.adicionarItem(new Item("Tererê de barba", 5));
       invDoThorin.adicionarItem(new Item("Espada emprestada do brother Légolas", 1));
       assertEquals("Pedra Arken,Tererê de barba,Espada emprestada do brother Légolas", invDoThorin.getDescricoesItens());
       invDoThorin.ordenarItens();
       assertEquals("Espada emprestada do brother Légolas,Pedra Arken,Tererê de barba", invDoThorin.getDescricoesItens());
       assertEquals(1, invDoThorin.getListaDeItens().get(0).getQuantidade());
       assertEquals(3, invDoThorin.getListaDeItens().get(1).getQuantidade());
       assertEquals(5, invDoThorin.getListaDeItens().get(2).getQuantidade());
   }
import java.util.*;

public class InventarioTest
{
    @Test
    public void adicionarItemNoInventario() {
        Inventario mochila = new Inventario();
        Inventario esperado = new Inventario();
        esperado.adicionarItem(new Item(1, "Adaga"));

        mochila.adicionarItem(new Item(1, "Adaga"));

        assertEquals(esperado, mochila);
    }

    @Test
    public void adicionarDoisItensNoInventario() {
        Inventario mochila = new Inventario();
        Inventario esperado = new Inventario();
        esperado.adicionarItem(new Item(2, "Poções"));
        esperado.adicionarItem(new Item(1, "Machado"));

        mochila.adicionarItem(new Item(2, "Poções"));
        mochila.adicionarItem(new Item(1, "Machado"));

        assertEquals(esperado, mochila);
    }

    @Test
    public void perderItemDoInventario() {
        Inventario mochila = new Inventario();
        Inventario esperado = new Inventario();
        Item adaga = new Item(1, "Adaga");
        mochila.adicionarItem(adaga);

        mochila.perderItem(adaga);

        assertEquals(esperado, mochila);
    }

    @Test
    public void perderItemComDoisNoInventario() {
        Inventario mochila = new Inventario();
        Inventario esperado = new Inventario();
        Item adaga = new Item(1, "Adaga");
        Item escudo = new Item(2, "Escudo");
        esperado.adicionarItem(escudo);
        mochila.adicionarItem(adaga);
        mochila.adicionarItem(escudo);

        mochila.perderItem(adaga);

        assertEquals(esperado, mochila);
    }

    @Test
    public void perderItemQueNãoEstáNoInventário() {
        Inventario mochila = new Inventario();
        Inventario esperado = new Inventario();
        mochila.perderItem(new Item(1, "Luvas de prata"));
        assertEquals(esperado, mochila);
    }

    @Test
    public void getDescricoesItensComDoisItens() {
        Inventario mochila = new Inventario();
        mochila.adicionarItem(new Item(2, "Poções"));
        mochila.adicionarItem(new Item(1, "Machado"));
        String esperado = "Poções,Machado";
        String obtido = mochila.getDescricoesItens();
        assertEquals(esperado, obtido);
    }

    @Test
    public void aumentar1000UnidadesEmCadaItem() {
        Inventario mochila = new Inventario();
        Inventario esperado = new Inventario();
        esperado.adicionarItem(new Item(1002, "Poções"));
        esperado.adicionarItem(new Item(1001, "Machado"));
        mochila.adicionarItem(new Item(2, "Poções"));
        mochila.adicionarItem(new Item(1, "Machado"));
        mochila.aumentar1000UnidadesEmCadaItem();
        
        assertEquals(esperado, mochila);
    }
    
    @Test
    public void obterItemComMaiorQuantidade() {
        Inventario mochila = new Inventario();
        mochila.adicionarItem(new Item(9, "Elder Scroll"));
        mochila.adicionarItem(new Item(99, "Escudo"));
        mochila.adicionarItem(new Item(2, "Canivete suíço"));
        Item esperado = new Item(99, "Escudo");
        Item obtido = mochila.getItemComMaiorQuantidade();
        
        assertEquals(esperado, obtido);
    }
    
    @Test
    public void obterItemComMaiorQuantidadeTodosIguais() {
        Inventario mochila = new Inventario();
        mochila.adicionarItem(new Item(99, "Elder Scroll"));
        mochila.adicionarItem(new Item(99, "Escudo"));
        mochila.adicionarItem(new Item(99, "Canivete suíço"));
        Item esperado = new Item(99, "Elder Scroll");
        Item obtido = mochila.getItemComMaiorQuantidade();
        
        assertEquals(esperado, obtido);
    }
    
    @Test
    public void ordenarItens() {
        Inventario mochila = new Inventario();
        mochila.adicionarItem(new Item(9, "Elder Scroll"));
        mochila.adicionarItem(new Item(99, "Escudo"));
        mochila.adicionarItem(new Item(2, "Canivete suíço"));
        Inventario esperado = new Inventario();
        esperado.adicionarItem(new Item(2, "Canivete suíço"));
        esperado.adicionarItem(new Item(9, "Elder Scroll"));
        esperado.adicionarItem(new Item(99, "Escudo"));
        
        mochila.ordenarItens();
        
        assertEquals(esperado, mochila);
    }
    
    @Test
    public void buscarItemPorDescricaoRetornaItem() {
        Inventario mochila = new Inventario();
        Item itemEsperado = new Item(9, "Elder Scroll");
        mochila.adicionarItem(itemEsperado);
        
        Item itemEncontrado = mochila.getItemPorDescricao("Elder Scroll");
        
        assertEquals(itemEsperado.getQuantidade(), itemEncontrado.getQuantidade());
        assertEquals(itemEsperado.getDescricao(), itemEncontrado.getDescricao());
    }
    
    @Test
    public void buscarItemPorDescricaoNaoRetornaItem() {
        Inventario mochila = new Inventario();
        mochila.adicionarItem(new Item(9, "Elder Scroll"));
        
        Item itemEncontrado = mochila.getItemPorDescricao("Elder Scrolls");
        
        assertNull(itemEncontrado);
    }
    

}
