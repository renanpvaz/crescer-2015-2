package br.com.cwi.crescer.dto;

import java.math.BigDecimal;

import br.com.cwi.crescer.domain.Produto;

public class ProdutoDTO {

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
        this.material = entity.getMaterial().getDescricao();
        this.servico = entity.getServico().getDescricao();
        this.valor = entity.getValor();
        this.prazo = entity.getPrazo();
        this.situacao = entity.getSituacao().toString();
    }

}
