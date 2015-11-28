package br.com.cwi.crescer.dto;

import java.math.BigDecimal;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;

import br.com.cwi.crescer.domain.Material;
import br.com.cwi.crescer.domain.Produto;
import br.com.cwi.crescer.domain.Produto.SituacaoProduto;
import br.com.cwi.crescer.domain.Servico;

public class ProdutoDTO {

	private Long id;
	
	@NotNull
    private Material material;
    
    @NotNull
    private Servico servico;
	
    @NotNull
    private BigDecimal valor;
	
    @NotNull
    private Long prazo;
    private SituacaoProduto situacao;

    public ProdutoDTO() {
    }

    public ProdutoDTO(Produto entity) {
    	this.id = entity.getIdProduto();
        this.material = entity.getMaterial();
        this.servico = entity.getServico();
        this.valor = entity.getValor();
        this.prazo = entity.getPrazo();
        this.situacao = entity.getSituacao();
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

	public SituacaoProduto getSituacao() {
		return situacao;
	}

	public void setSituacao(SituacaoProduto situacao) {
		this.situacao = situacao;
	}
}

