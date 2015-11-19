package br.com.cwi.dao.test;

import static org.junit.Assert.assertTrue;

import java.sql.SQLException;

import org.junit.Test;

import br.com.cwi.dao.PedidoDao;
import br.com.cwi.model.Cliente;
import br.com.cwi.model.Pedido;


public class PedidoDaoTest {

    @Test
    public void test() throws SQLException {

        PedidoDao dao = new PedidoDao();

        Pedido pedido = dao.load(1L);
        Pedido pedido2 = new Pedido();

        Cliente cliente = new Cliente();

        cliente.setIdCliente(1L);
        cliente.setNmCliente("sdfsdfsdf");
        cliente.setNrCpf("23423");

        pedido2.setIdPedido(1L);
        pedido2.setDsPedido("Pedido mt legal");
        pedido2.setCliente(cliente);

        assertTrue(pedido.equals(pedido2));
    }

}
