
import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class ItemTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class ItemTest
{
    @Test
    public void itemCriadoComDescriçãoInformada(){
        Item itemTeste = new Item("Item Teste", 1);
        assertEquals("Item Teste", itemTeste.getDescricao());
    }

    @Test
    public void itemCriadoComQuantidadeInformada(){
        Item itemTeste = new Item("Item Teste", 1);
        assertEquals(1, itemTeste.getQuantidade());
    }
}