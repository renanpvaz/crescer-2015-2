

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class ClienteTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class ClienteTest
{
    @Test
    public void clienteCriadoComNomeEnderecoETelefoneCertos(){
        Cliente cliente = new Cliente("Cliente legal", "Rua legal", 9232311);
        
        assertEquals("Cliente legal", cliente.getNome());
        assertEquals("Rua legal", cliente.getEndereco());
        assertEquals(9232311, cliente.getNumero()); 
    }
}
