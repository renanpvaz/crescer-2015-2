package br.com.cwi.crescer.dto;

import java.util.ArrayList;
import java.util.List;

public class ItemProcessamentoDTO {

	private List<ItemDTO> itens;
	
	private List<ItemDTO> itensSelecionados;
	
	public ItemProcessamentoDTO() {
		this.itens = new ArrayList<ItemDTO>();
		this.itensSelecionados = new ArrayList<ItemDTO>();
	}
	
	public ItemProcessamentoDTO(List<ItemDTO> itens, List<ItemDTO> itensSelecionados) {
		this.itens = itens;
		this.itensSelecionados = itensSelecionados;
	}

	public ItemProcessamentoDTO(List<ItemDTO> itens) {
		this.itens = itens;
	}

	public List<ItemDTO> getItens() {
		return itens;
	}

	public void setItens(List<ItemDTO> itens) {
		this.itens = itens;
	}

	public List<ItemDTO> getItensSelecionados() {
		return itensSelecionados;
	}

	public void setItensSelecionados(List<ItemDTO> itensSelecionados) {
		this.itensSelecionados = itensSelecionados;
	}
	
	
}
