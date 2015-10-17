

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class PizzaTest{
    
    @Test
    public void pizzaPequenaComValorESaborCerto(){
        Pizza pizza = new Pizza(TamanhoPizza.PEQUENO);
        
        pizza.adicionarSabor("Peperoni");
        
        assertEquals(20, pizza.getPreco(), 0);
        assertEquals("Peperoni", pizza.getSabores().get(0));
    }
    
    @Test
    public void pizzaGrandeComValorESaboresCertos(){
        Pizza pizza = new Pizza(TamanhoPizza.GRANDE);
        
        pizza.adicionarSabor("Peperoni");
        pizza.adicionarSabor("quatro queijos");
        
        assertEquals(40, pizza.getPreco(), 0);
        assertEquals("Peperoni", pizza.getSabores().get(0));
        assertEquals("quatro queijos", pizza.getSabores().get(1));
    }
    
    @Test
    public void pizzaTitanicComValorESaboresCertos(){
        Pizza pizza = new Pizza(TamanhoPizza.TITANIC);
        
        pizza.adicionarSabor("Peperoni1");
        pizza.adicionarSabor("Peperoni2");
        pizza.adicionarSabor("Peperoni3");
        pizza.adicionarSabor("Peperoni4");
        pizza.adicionarSabor("Peperoni5");
        pizza.adicionarSabor("Peperoni6");
        
        assertEquals(100, pizza.getPreco(), 0);
        assertEquals(6, pizza.getSabores().size());
    }
   
}
