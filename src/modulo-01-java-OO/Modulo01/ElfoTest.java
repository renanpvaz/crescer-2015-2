

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ElfoTest
{
    //Nome
    @Test
    public void elfoCriadoNomeEscolhido(){
        Elfo thranduil = new Elfo ("Thranduil");
        assertEquals("Thranduil", thranduil.getNome());
    }
    @Test
    public void elfoCriadoNomeEscolhidoNull(){        
        Elfo elfoNulo = new Elfo(null);
        assertNull(elfoNulo.getNome());
    }
    @Test
    public void elfoCriadoNomeEscolhidoVazio(){        
        Elfo elfoVazio = new Elfo("");
        assertEquals("", elfoVazio.getNome());
    }
    
    //Flechas
    @Test
    public void flechasNotNull(){
        Elfo thranduil = new Elfo ("Thranduil");
        assertNotNull(thranduil.getFlechas());
    }
    @Test
    public void elfoMuitasFlechas(){
        Elfo muitasFlechas = new Elfo ("Muitas Flechas", 1000);
        assertNotNull(muitasFlechas.getFlechas());
    }
    @Test
    public void elfoPoucasFlechas(){
        Elfo poucasFlechas = new Elfo ("Poucas Flechas", 1);
        assertNotNull(poucasFlechas.getFlechas());
    }
    //Status
    @Test 
    public void elfoNasceVivo(){
        Elfo vivao = new Elfo("Vivão");
        assertEquals(Status.VIVO, vivao.getStatus());
    }
    //Exp
    public void elfoComeçaCom0Exp(){
        Elfo exp0 = new Elfo("Exp0");
        assertEquals(0, exp0.getExperiencia());
    }
    
    //AtirarFlecha
    @Test
    public void elfoAtiraFlechaEmDwarf(){
        Elfo thranduil = new Elfo("Thranduil");
        Dwarf gimli = new Dwarf("Gimli");
        thranduil.atacarDwarf(gimli);
        assertEquals(41, thranduil.getFlechas());
        assertEquals(1, thranduil.getExperiencia());
        assertEquals(100, gimli.getVida());
   }
    
    
    @Test
    public void toStringComNiveisEFlechas(){
      Elfo thranduil = new Elfo("Thranduil", 10);  
     assertEquals("Thranduil possui 10 flechas e 0 níveis de experiência.", thranduil.toString());        
          
    }
    @Test
    public void toStringUmaFlechaUmNível(){
      Elfo thranduil = new Elfo("Thranduil", 2);
      Dwarf gimli = new Dwarf("Gimli");
      thranduil.atacarDwarf(gimli);
      assertEquals("Thranduil possui 1 flecha e 1 nível de experiência.", thranduil.toString());    
    }
    @Test
    public void elfoCriadoComNomeNasceCom42Flechas() {
        Elfo celeborn = new Elfo("Celeborn");
        assertEquals(42, celeborn.getFlechas());
    }

    @Test
    public void elfoCriadoComNomeNull() {
        Elfo elrond = new Elfo(null);
        assertNull(elrond.getNome());
    }

    @Test
    public void elfoCriadoNasceCom0DeExperiencia() {
        Elfo legolas = new Elfo("Legolas II");
        assertEquals(0, legolas.getExperiencia());
    }

    @Test
    public void elfoCriadoComNomeVazio() {
        Elfo elrond = new Elfo("");
        assertEquals("", elrond.getNome());
    }

    @Test
    public void elfoCriadoComNomeEPoucasFlechas() {
        Elfo elfoHumilde = new Elfo("Elfo Humilde", 2);
        assertEquals("Elfo Humilde", elfoHumilde.getNome());
        assertEquals(2, elfoHumilde.getFlechas());
    }

    @Test
    public void elfoCriadoComNomeEComMuitasFlechas() {
        Elfo elfoHumilde = new Elfo("Elfo Bacana", 349857);
        assertEquals("Elfo Bacana", elfoHumilde.getNome());
        assertEquals(349857, elfoHumilde.getFlechas());
    }

    @Test
    public void elfoCriadoComNomeEDevendoFlechas() {
        Elfo elfoHumilde = new Elfo("Elfo Devedor", -349857);
        assertEquals("Elfo Devedor", elfoHumilde.getNome());
        assertEquals(-349857, elfoHumilde.getFlechas());
    }

    @Test
    public void elfoAtiraEmDoisAnoes() {
        // Arrange
        Elfo elfo = new Elfo("Elfo caçador");
        Dwarf balin = new Dwarf("Balin");
        Dwarf filhoDeBalin = new Dwarf("Filho de Balin");
        int qtdFlechasEsperada = 40;
        int experienciaEsperada = 2;
        int vidaEsperada = 100;
        // Act
        elfo.atirarFlecha(balin);
        elfo.atirarFlecha(filhoDeBalin);
        // Assert
        assertEquals(qtdFlechasEsperada, elfo.getFlechas());
        assertEquals(experienciaEsperada, elfo.getExperiencia());
        assertEquals(vidaEsperada, balin.getVida());
        assertEquals(vidaEsperada, filhoDeBalin.getVida());
    }

    @Test
    public void doisElfosAtiramEmDoisDwarves() {
        // Arrange
        Elfo elfo1 = new Elfo("Elfo caçador");
        Elfo elfo2 = new Elfo("Segundo elfo");
        Dwarf balin = new Dwarf("Balin");
        Dwarf filhoDeBalin = new Dwarf("Filho de Balin");
        int qtdFlechasEsperada = 40;
        int experienciaEsperada = 2;
        int vidaEsperada = 90;
        // Act
        elfo1.atirarFlecha(balin);
        elfo1.atirarFlecha(filhoDeBalin);
        elfo2.atirarFlecha(balin);
        elfo2.atirarFlecha(filhoDeBalin);
        // Assert
        assertEquals(qtdFlechasEsperada, elfo1.getFlechas());
        assertEquals(experienciaEsperada, elfo1.getExperiencia());
        assertEquals(qtdFlechasEsperada, elfo2.getFlechas());
        assertEquals(experienciaEsperada, elfo2.getExperiencia());
        assertEquals(vidaEsperada, balin.getVida());
        assertEquals(vidaEsperada, filhoDeBalin.getVida());
    }

    @Test
    public void elfoComNomeEFlechasInformadasToString() {
        Elfo elfo1 = new Elfo("Acabaram os nomes", 1000);
        String textoEsperado = "Acabaram os nomes possui 1000 flechas e 0 níveis de experiência.";
        
        assertEquals(textoEsperado, elfo1.toString());
    }
    
    @Test
    public void elfoComUmaFlechaInformadaToString() {
        Elfo elfo1 = new Elfo("Monoflecha", 1);
        String textoEsperado = "Monoflecha possui 1 flecha e 0 níveis de experiência.";
        assertEquals(textoEsperado, elfo1.toString());
    }
    
    @Test
    public void elfoComUmDeExperienciaToString() {
        Elfo elfo1 = new Elfo(null);
        elfo1.atirarFlecha(new Dwarf("Dwarf"));
        String textoEsperado = "null possui 41 flechas e 1 nível de experiência.";
        assertEquals(textoEsperado, elfo1.toString());
    }
    
    @Test
    public void elfoRecebeEspadadaDoOrcUrukHai(){
        Orc orc = new Orc(TipoOrc.URUKHAI);
        Elfo elfo = new Elfo(null);
        
        orc.atacarElfo(elfo);
        
        assertEquals(68, elfo.getVida());
    }
    
    @Test
    public void elfoRecebeFlechadaDoOrcSnaga(){
        Orc orc = new Orc(TipoOrc.SNAGA);
        Elfo elfo = new Elfo(null);
        
        orc.atacarElfo(elfo);
        
        assertEquals(72, elfo.getVida());
    }
    
    
    
    
    
}
