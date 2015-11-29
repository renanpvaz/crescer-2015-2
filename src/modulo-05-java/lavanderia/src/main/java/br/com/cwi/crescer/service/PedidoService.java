package br.com.cwi.crescer.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.cwi.crescer.dao.ClienteDAO;
import br.com.cwi.crescer.dao.PedidoDAO;
import br.com.cwi.crescer.domain.Cliente;
import br.com.cwi.crescer.domain.Pedido;
import br.com.cwi.crescer.domain.Item.SituacaoItem;
import br.com.cwi.crescer.dto.ItemDTO;
import br.com.cwi.crescer.dto.PedidoDTO;
import br.com.cwi.crescer.dto.PedidoResumoDTO;
import br.com.cwi.crescer.dto.ProdutoDTO;
import br.com.cwi.crescer.mapper.PedidoMapper;
import br.com.cwi.crescer.mapper.ProdutoMapper;

@Service
public class PedidoService {

	private PedidoDAO pedidoDAO;

    @Autowired
    public PedidoService(PedidoDAO pedidoDAO) {
        this.pedidoDAO = pedidoDAO;
    }
    
    public ItemDTO atribuirProdutoANovoItem(ProdutoDTO produto, Long idPedido) { 	
    	ItemDTO item = new ItemDTO(); 
    	Pedido pedido = buscarPorId(idPedido);
    	
    	item.setValorUnitario(produto.getValor());
    	item.setPedido(pedido);
    	item.setProduto(ProdutoMapper.getNewEntity(produto));
    	item.setSituacao(SituacaoItem.PENDENTE);
    	
    	return item;
    }
	
    public PedidoDTO buscarUltimo() {
    	return new PedidoDTO(pedidoDAO.last());
    }
    
	public List<PedidoResumoDTO> listarTodos() {
		
		List<Pedido> pedidos = pedidoDAO.listAll();
		List<PedidoResumoDTO> dtos = new ArrayList<PedidoResumoDTO>();
		
		for(Pedido pedido : pedidos) {
			
			dtos.add(new PedidoResumoDTO(pedido));
		}
		
		return dtos;
	}

	public void incluir(Pedido pedido) {
		pedidoDAO.save(pedido);
	}

	public Pedido buscarPorId(Long id) {
		return pedidoDAO.findById(id);
	}

}
