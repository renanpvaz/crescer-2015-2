package br.com.cwi.crescer.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.cwi.crescer.dao.ClienteDAO;
import br.com.cwi.crescer.dao.PedidoDAO;
import br.com.cwi.crescer.domain.Pedido;
import br.com.cwi.crescer.dto.PedidoResumoDTO;

@Service
public class PedidoService {

	private PedidoDAO pedidoDAO;

    @Autowired
    public PedidoService(PedidoDAO pedidoDAO) {
        this.pedidoDAO = pedidoDAO;
    }
	
	public List<PedidoResumoDTO> listarTodos() {
		
		List<Pedido> pedidos = pedidoDAO.listAll();
		List<PedidoResumoDTO> dtos = new ArrayList<PedidoResumoDTO>();
		
		for(Pedido pedido : pedidos) {
			
			dtos.add(new PedidoResumoDTO(pedido));
		}
		
		return dtos;
	}

}
