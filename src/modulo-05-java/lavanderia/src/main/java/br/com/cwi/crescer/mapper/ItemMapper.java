package br.com.cwi.crescer.mapper;

import java.util.ArrayList;
import java.util.List;

import br.com.cwi.crescer.domain.Item;
import br.com.cwi.crescer.dto.ItemDTO;
import br.com.cwi.crescer.dto.ItemProcessamentoDTO;

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
	
	public static List<ItemDTO> toDTOList(List<Item> itens) {
		
		List<ItemDTO> dtos = new ArrayList<ItemDTO>();
		
		for(Item item : itens) {
			dtos.add(new ItemDTO(item));
		}
		
		return dtos;
	}
}
