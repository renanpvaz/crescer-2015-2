
import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class DataTerceiraEraTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class DataTerceiraEraTest
{
    @Test
    public void dataTerceiraEraComDiaMesEAnoEscolhidos(){
        DataTerceiraEra data = new DataTerceiraEra(12, 2, 1998);
        assertEquals(12, data.getDia());
        assertEquals(2, data.getMes());
        assertEquals(1998, data.getAno());
    }

    @Test
    public void dataSemInformarDiaMesEAno(){
        DataTerceiraEra data = new DataTerceiraEra();
        assertEquals(1, data.getDia());
        assertEquals(1, data.getMes());
        assertEquals(1, data.getAno()); 
    }

    @Test
    public void dataEhBissextoTrue(){
        DataTerceiraEra data = new DataTerceiraEra(12, 2, 2016);  
        assertTrue(data.ehBissexto());
    }

    @Test
    public void dataEhBissextoFalse(){
        DataTerceiraEra data = new DataTerceiraEra(12, 2, 2015);  
        assertFalse(data.ehBissexto());
    }
}
