package br.com.cwi.crescer.dto;

import java.math.BigDecimal;

import br.com.cwi.crescer.domain.Item;
import br.com.cwi.crescer.domain.Item.SituacaoItem;
import br.com.cwi.crescer.domain.Pedido;
import br.com.cwi.crescer.domain.Produto;

public class ItemDTO {
	
	private Pedido pedido;
	private Produto produto;
	private BigDecimal peso;
	private BigDecimal valorUnitario;
	private BigDecimal valorTotal;
	private SituacaoItem situacao;
	
	public ItemDTO() {
	}
	
	public ItemDTO(Item item) {
		this.pedido = item.getPedido();
		this.produto = item.getProduto();
		this.peso = item.getPeso();
		this.valorUnitario = item.getValorUnitario();
		this.valorTotal = item.getValorTotal();
		this.situacao = item.getSituacao();
	}
	
	public Pedido getPedido() {
		return pedido;
	}

	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}

	public Produto getProduto() {
		return produto;
	}
	public void setProduto(Produto produto) {
		this.produto = produto;
	}
	public BigDecimal getPeso() {
		return peso;
	}
	public void setPeso(BigDecimal peso) {
		this.peso = peso;
	}
	public BigDecimal getValorUnitario() {
		return valorUnitario;
	}
	public void setValorUnitario(BigDecimal valorUnitario) {
		this.valorUnitario = valorUnitario;
	}
	public BigDecimal getValorTotal() {
		return valorTotal;
	}
	public void setValorTotal(BigDecimal valorTotal) {
		this.valorTotal = valorTotal;
	}
	public SituacaoItem getSituacao() {
		return situacao;
	}
	public void setSituacao(SituacaoItem situacao) {
		this.situacao = situacao;
	}
}
