package br.com.cwi.crescer.dto;

import java.math.BigDecimal;

import br.com.cwi.crescer.domain.Material;
import br.com.cwi.crescer.domain.Produto;
import br.com.cwi.crescer.domain.Servico;

public class ProdutoDTO {

	private Long id;
    private Material material;
    private Servico servico;
    private BigDecimal valor;
    private Long prazo;
    private String situacao;

    public ProdutoDTO(Material material, Servico servico, BigDecimal valor, Long prazo, String situacao) {
        this.material = material;
        this.servico = servico;
        this.valor = valor;
        this.prazo = prazo;
        this.situacao = situacao;
    }

    public ProdutoDTO(Produto entity) {
    	this.id = entity.getIdProduto();
        this.material = entity.getMaterial();
        this.servico = entity.getServico();
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

	public Material getMaterial() {
		return material;
	}

	public void setMaterial(Material material) {
		this.material = material;
	}

	public Servico getServico() {
		return servico;
	}

	public void setServico(Servico servico) {
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

