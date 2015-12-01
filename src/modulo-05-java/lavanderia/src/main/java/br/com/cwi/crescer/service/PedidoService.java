package br.com.cwi.crescer.service;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.thymeleaf.util.DateUtils;

import br.com.cwi.crescer.dao.PedidoDAO;
import br.com.cwi.crescer.domain.Item;
import br.com.cwi.crescer.domain.Item.SituacaoItem;
import br.com.cwi.crescer.domain.Pedido;
import br.com.cwi.crescer.dto.ItemDTO;
import br.com.cwi.crescer.dto.PedidoDTO;
import br.com.cwi.crescer.dto.PedidoResumoDTO;
import br.com.cwi.crescer.dto.ProdutoDTO;
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

	public void atualizarInformacoes(Pedido pedido, ItemDTO item) throws ParseException {
		BigDecimal valorBruto = pedido.getValorBruto();
		Date dataEntrega = calcularDataEntrega(pedido.getDataInclusao(), item.getProduto().getPrazo());
		
		pedido.setValorBruto(valorBruto.add(item.getValorTotal()));
		
		if(dataDeEntregaMaior(pedido, dataEntrega)) {
			pedido.setDataEntrega(dataEntrega);	
		}
		
		pedido = aplicarDesconto(pedido);
				
		pedidoDAO.save(pedido);
	}
	
	public Pedido aplicarDesconto(Pedido pedido) throws ParseException {
		BigDecimal descontoValorOuPeso = calcularDescontosPorValorOuPeso(pedido);
		BigDecimal descontoData = calcularDescontosPorData(pedido);
		
		if(descontoValorOuPeso.compareTo(descontoData) == 1) {
			pedido.setValorDesconto(descontoValorOuPeso);
			pedido.setValorFinal(pedido.getValorBruto().subtract(descontoValorOuPeso));
		} 
		else {
			pedido.setValorDesconto(descontoData);
			pedido.setValorFinal(pedido.getValorBruto().subtract(descontoData));
		}
		
		return pedido;
	}
	
	public BigDecimal getPesoTotal(Pedido pedido) {
		BigDecimal pesoTotal = new BigDecimal(0);
		
		for(Item item : pedido.getItens()) {
			pesoTotal = pesoTotal.add(item.getPeso());
		}
		
		return pesoTotal;
	}
	
	public BigDecimal calcularDescontosPorValorOuPeso(Pedido pedido) {
		BigDecimal desconto = new BigDecimal(0);
		BigDecimal minimoParaDesconto = new BigDecimal(90);
		boolean podeReceberDescontoPorValor = pedido.getValorBruto().compareTo(minimoParaDesconto) == 1;
		boolean podeReceberDescontoPorPeso = getPesoTotal(pedido).compareTo(new BigDecimal(15)) == 1;
		
		if(podeReceberDescontoPorValor || podeReceberDescontoPorPeso) {
			desconto = pedido.getValorBruto().multiply(new BigDecimal("0.0487"));
		}
		
		return desconto;
	}
	
	public BigDecimal calcularDescontosPorData(Pedido pedido) {	
		BigDecimal desconto = new BigDecimal(0);
		
		Integer diaDaSemana = DateUtils.dayOfWeek(pedido.getDataInclusao());
		
		if(diaDaSemana == Calendar.MONDAY || diaDaSemana == Calendar.TUESDAY || diaDaSemana == Calendar.WEDNESDAY) {
			desconto = pedido.getValorBruto().multiply(new BigDecimal("0.08"));
		} 
		else if(diaDaSemana == Calendar.THURSDAY || diaDaSemana == Calendar.FRIDAY) {
			desconto = pedido.getValorBruto().multiply(new BigDecimal("0.04"));
		}
		
		return desconto;
	}
	
	public boolean dataDeEntregaMaior(Pedido pedido, Date dataEntrega) {
		
		if(pedido.getDataEntrega() == null) {
			return true;
		}
		
		int resultadoCompare = pedido.getDataEntrega().compareTo(dataEntrega);
		
		return resultadoCompare == -1; 
	}
	
	public Date calcularDataEntrega(Date dataInclusao, Long prazo) {
		Calendar calendar = Calendar.getInstance();
		
		calendar.setTime(dataInclusao);
		calendar.add(Calendar.DATE, prazo.intValue());
		
		return calendar.getTime();
	}
}
