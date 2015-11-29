package br.com.cwi.crescer.mapper;

import java.math.BigDecimal;
import java.util.Date;

import br.com.cwi.crescer.domain.Cliente;
import br.com.cwi.crescer.domain.Pedido;
import br.com.cwi.crescer.domain.Pedido.SituacaoPedido;

public class PedidoMapper {

	public static Pedido getNewEntity(Cliente cliente) {
        return new Pedido(cliente, new Date(), new BigDecimal(0), SituacaoPedido.PENDENTE);
    }
	
}
