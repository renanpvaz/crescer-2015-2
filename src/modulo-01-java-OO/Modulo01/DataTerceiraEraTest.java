import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class DataTerceiraEraTest
{
    @Test
    public void dataTerceiraEraÉCriadaComDiaMesAno() {
        DataTerceiraEra primeiroDia = new DataTerceiraEra(1, 1, 1);
        assertEquals(1, primeiroDia.getDia());
        assertEquals(1, primeiroDia.getMes());
        assertEquals(1, primeiroDia.getAno());
    }
    
    @Test
    public void dataTerceiraEraÉCriadaComDiaMesAnoNegativos() {
        DataTerceiraEra primeiroDia = new DataTerceiraEra(-10, -10, -10);
        assertEquals(-10, primeiroDia.getDia());
        assertEquals(-10, primeiroDia.getMes());
        assertEquals(-10, primeiroDia.getAno());
    }
    
    @Test
    public void dataTerceiraEraÉCriadaComDiaMesAnoZerados() {
        DataTerceiraEra primeiroDia = new DataTerceiraEra(0, 0, 0);
        assertEquals(0, primeiroDia.getDia());
        assertEquals(0, primeiroDia.getMes());
        assertEquals(0, primeiroDia.getAno());
    }
}
