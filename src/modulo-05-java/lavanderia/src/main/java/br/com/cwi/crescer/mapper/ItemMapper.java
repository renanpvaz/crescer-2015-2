package br.com.cwi.crescer.mapper;

import br.com.cwi.crescer.domain.Item;
import br.com.cwi.crescer.dto.ItemDTO;

public class ItemMapper {

	public static Item getNewEntity(ItemDTO dto) {
		Item item = new Item();
		
		item.setIdItem(dto.getIdItem());
		item.setPedido(dto.getPedido());
		item.setProduto(dto.getProduto());
		item.setPeso(dto.getPeso());
		item.setValorUnitario(dto.getValorUnitario());
		item.setValorTotal(dto.getValorTotal());
		item.setSituacao(dto.getSituacao());
		
        return item;
    }
	
}
