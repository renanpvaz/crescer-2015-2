package br.com.cwi.crescer.mapper;

import br.com.cwi.crescer.domain.Produto;
import br.com.cwi.crescer.dto.ProdutoDTO;

public class ProdutoMapper {

	public static Produto merge(ProdutoDTO dto, Produto entity) {
        entity.setMaterial(dto.getMaterial());
        entity.setServico(dto.getServico());
        entity.setPrazo(dto.getPrazo());
        entity.setSituacao(dto.getSituacao());
        entity.setValor(dto.getValor());
        
        return entity;
    }
}
