package br.com.cwi.crescer.dto;

import java.math.BigDecimal;

import br.com.cwi.crescer.domain.Produto;

public class ProdutoDTO {

	private Long id;
    private String material;
    private String servico;
    private BigDecimal valor;
    private Long prazo;
    private String situacao;

    public ProdutoDTO(String material, String servico, BigDecimal valor, Long prazo, String situacao) {
        this.material = material;
        this.servico = servico;
        this.valor = valor;
        this.prazo = prazo;
        this.situacao = situacao;
    }

    public ProdutoDTO(Produto entity) {
    	this.id = entity.getIdProduto();
        this.material = entity.getMaterial().getDescricao();
        this.servico = entity.getServico().getDescricao();
        this.valor = entity.getValor();
        this.prazo = entity.getPrazo();
        this.situacao = entity.getSituacao().toString();
    }
   
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getMaterial() {
		return material;
	}

	public void setMaterial(String material) {
		this.material = material;
	}

	public String getServico() {
		return servico;
	}

	public void setServico(String servico) {
		this.servico = servico;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

	public Long getPrazo() {
		return prazo;
	}

	public void setPrazo(Long prazo) {
		this.prazo = prazo;
	}

	public String getSituacao() {
		return situacao;
	}

	public void setSituacao(String situacao) {
		this.situacao = situacao;
	}
}

