

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class PedidoTest
{
    
    @Test
    public void pedidoPepsiLataPizzaPequenaCacularValor(){
        Pedido pedido = new Pedido(new Cliente("Cliente legal", "Rua legal", 9232311));
        
        pedido.adicionarProduto(new Pizza(TamanhoPizza.PEQUENO));
        pedido.adicionarProduto(new Bebida(TamanhoBebida.LATA, MarcaBebida.PEPSI));
        
        assertEquals(28.0, pedido.calcularValor(), 0);
    }
    
    @Test
    public void pedidoPepsiLataPizzaPequenaCacularTrocoPara30(){
        Pedido pedido = new Pedido(new Cliente("Cliente legal", "Rua legal", 9232311));
        
        pedido.adicionarProduto(new Pizza(TamanhoPizza.PEQUENO));
        pedido.adicionarProduto(new Bebida(TamanhoBebida.LATA, MarcaBebida.PEPSI));
        
        pedido.calcularValor();
        
        assertEquals(2, pedido.calcularTroco(30), 0);
    }
    
    @Test
    public void pedidoComTeleEntregaGratuita(){
        Pedido pedido = new Pedido(new Cliente("Cliente legal", "Rua legal", 9232311));
        
        pedido.adicionarProduto(new Pizza(TamanhoPizza.GRANDE));
        pedido.adicionarProduto(new Bebida(TamanhoBebida.GARRAFA, MarcaBebida.COCA_COLA));
        pedido.adicionarProduto(new Bebida(TamanhoBebida.GARRAFA, MarcaBebida.GUARANA_ANTARCTICA));
        pedido.adicionarProduto(new Bebida(TamanhoBebida.GARRAFA, MarcaBebida.PEPSI));
        
        pedido.calcularValor();
        
        assertTrue(!pedido.getTeleEntrega());
    }
    
    @Test
    public void pedidoComTeleEntregaGratuitaEDesconto(){
        Pedido pedido = new Pedido(new Cliente("Cliente legal", "Rua legal", 9232311));
        
        pedido.adicionarProduto(new Pizza(TamanhoPizza.TITANIC));
        
        pedido.calcularValor();
        
        assertTrue(pedido.getDesconto());
        assertEquals(90, pedido.getValorTotal(), 0);
    }
}
