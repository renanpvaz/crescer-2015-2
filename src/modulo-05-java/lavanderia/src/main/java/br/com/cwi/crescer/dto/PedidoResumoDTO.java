package br.com.cwi.crescer.dto;

import java.math.BigDecimal;
import java.util.Date;

import br.com.cwi.crescer.domain.Cliente;
import br.com.cwi.crescer.domain.Pedido;
import br.com.cwi.crescer.domain.Pedido.SituacaoPedido;

public class PedidoResumoDTO {
	
	private Long id;
	private Cliente cliente;
	private Date dataInclusao;
	private BigDecimal valorTotal;
	private SituacaoPedido situacao;
	
	public PedidoResumoDTO(Pedido entity) {
		this.id = entity.getIdPedido();
		this.cliente = entity.getCliente();
		this.dataInclusao = entity.getDataInclusao();
		this.valorTotal = entity.getValorBruto();
		this.situacao = entity.getSituacao();
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	public Date getDataInclusao() {
		return dataInclusao;
	}
	public void setDataInclusao(Date dataInclusao) {
		this.dataInclusao = dataInclusao;
	}
	public BigDecimal getValorTotal() {
		return valorTotal;
	}
	public void setValorTotal(BigDecimal valorFinal) {
		this.valorTotal = valorFinal;
	}
	public SituacaoPedido getSituacao() {
		return situacao;
	}
	public void setSituacao(SituacaoPedido situacao) {
		this.situacao = situacao;
	}
	
	
}
