package br.com.cwi.crescer.service;

import static org.junit.Assert.*;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import br.com.cwi.crescer.dao.PedidoDAO;
import br.com.cwi.crescer.domain.Item;
import br.com.cwi.crescer.domain.Pedido;

public class PedidoServiceTest {
	

	@Before
	public void setup() {
	}
	
	@Test
	public void pesoTotalDoPedidoDeveSer12() {
		PedidoDAO dao = new PedidoDAO();
		PedidoService service = new PedidoService(dao);
		Pedido pedido = new Pedido();
		
		Item item1 = new Item();
		Item item2 = new Item();
		Item item3 = new Item();
		List<Item> itens = new ArrayList<Item>();
		
		item1.setPeso(new BigDecimal(4));
		item2.setPeso(new BigDecimal(4));
		item3.setPeso(new BigDecimal(4));
		
		itens.add(item1);
		itens.add(item2);
		itens.add(item3);
		
		pedido.setItens(itens);
		
		assertEquals(new BigDecimal(12), service.getPesoTotal(pedido));
	}
	
	@Test
	public void deveRetornarDescontoDePorValorSuperiorA90() {
		PedidoDAO dao = new PedidoDAO();
		PedidoService service = new PedidoService(dao);
		Pedido pedido = new Pedido();		
		Item item1 = new Item();
		List<Item> itens = new ArrayList<Item>();
		
		item1.setPeso(new BigDecimal(4));
		
		itens.add(item1);
		
		pedido.setItens(itens);
		pedido.setValorBruto(new BigDecimal(100));
		
		assertEquals(4.87, service.calcularDescontosPorValorOuPeso(pedido).doubleValue(), 0.1);		
	}
	
	@Test
	public void deveRetornarDescontoDe8() {
		PedidoDAO dao = new PedidoDAO();
		PedidoService service = new PedidoService(dao);
		Pedido pedido = new Pedido();
		Date data = new GregorianCalendar(2015, 11, 4).getTime();
		
		pedido.setValorBruto(new BigDecimal(100));
		pedido.setDataInclusao(data);
		
		assertEquals(4, service.calcularDescontosPorData(pedido).intValue());		
	}
	
	@Test
	public void deveRetornarDescontoDe4(){
		PedidoDAO dao = new PedidoDAO();
		PedidoService service = new PedidoService(dao);
		Pedido pedido = new Pedido();
		Date data = new GregorianCalendar(2015, 12, 4).getTime();
		
		pedido.setValorBruto(new BigDecimal(100));
		pedido.setDataInclusao(data);
		
		assertEquals(8, service.calcularDescontosPorData(pedido).intValue());		
	}
}
