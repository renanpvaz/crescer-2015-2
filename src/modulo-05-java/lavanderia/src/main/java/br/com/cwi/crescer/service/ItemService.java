package br.com.cwi.crescer.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.cwi.crescer.dao.ItemDAO;
import br.com.cwi.crescer.domain.Item;
import br.com.cwi.crescer.domain.Item.SituacaoItem;
import br.com.cwi.crescer.dto.ItemDTO;
import br.com.cwi.crescer.mapper.ItemMapper;

@Service
public class ItemService {

	private ItemDAO itemDAO;
	
	@Autowired
	public ItemService(ItemDAO itemDAO) {
		this.itemDAO = itemDAO;
	}
	
	public void adicionarItem(ItemDTO item) {
		itemDAO.save(ItemMapper.getNewEntity(item));
	}

	public void processarTodos(List<Item> itens) {
		
		for(Item item : itens) {
			processarItem(item);
		}
	}
	
	public void processarItem(Item item) {
		item.setSituacao(SituacaoItem.PROCESSADO);
		
		itemDAO.save(item);
	}

	public Item buscarPorId(Long id) {
		return itemDAO.findById(id);
	}
}
