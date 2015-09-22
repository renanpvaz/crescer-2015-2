
import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class IrishDwarfTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class IrishDwarfTest
{
    @Test
    public void irishDwarfTestaSorteEGanhaNaMega(){
        IrishDwarf gimli = new IrishDwarf("Gimli", new DataTerceiraEra(29, 2, 2016));
        for(int i = 0; i <= 2; i++){
            gimli.recebeDano(10);  
        }
        gimli.getInventario().adicionarItem(new Item("Pedra Arken", 3));
        gimli.tentarSorte();
        assertEquals(6009, gimli.getInventario().getListaDeItens().get(0).getQuantidade());
    }

    @Test
    public void irishDwarfTestaSorteENãoGanhaNaMega(){
        IrishDwarf gimli = new IrishDwarf("Gimli", new DataTerceiraEra(29, 2, 2015));
        for(int i = 0; i <= 2; i++){
            gimli.recebeDano(10);  
        }
        gimli.getInventario().adicionarItem(new Item("Pedra Arken", 3));
        gimli.tentarSorte();
        assertEquals(3, gimli.getInventario().getListaDeItens().get(0).getQuantidade());
    }

    @Test
    public void irishDwarfTestaSorteEGanhaNaMegaMaisSomaDasQuantidades(){
        IrishDwarf gimli = new IrishDwarf("Gimli", new DataTerceiraEra(29, 2, 2016));
        Inventario invDoThorin = new Inventario();
        for(int i = 0; i <= 2; i++){
            gimli.recebeDano(10);  
        }
        gimli.getInventario().adicionarItem(new Item("Pedra Arken", 1));
        gimli.getInventario().adicionarItem(new Item("Tererê de barba", 3));
        gimli.getInventario().adicionarItem(new Item("Espada emprestada do brother Légolas", 5));
        gimli.tentarSorte();
        assertEquals(1002, gimli.getInventario().getListaDeItens().get(0).getQuantidade());
        assertEquals(6009, gimli.getInventario().getListaDeItens().get(1).getQuantidade());
        assertEquals(15020, gimli.getInventario().getListaDeItens().get(2).getQuantidade());
    }
}