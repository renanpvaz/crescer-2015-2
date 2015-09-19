

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
}
