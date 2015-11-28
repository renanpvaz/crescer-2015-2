package br.com.cwi.crescer.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.cwi.crescer.dao.MaterialDAO;
import br.com.cwi.crescer.dao.ProdutoDAO;
import br.com.cwi.crescer.dao.ServicoDAO;
import br.com.cwi.crescer.domain.Cliente;
import br.com.cwi.crescer.domain.Produto;
import br.com.cwi.crescer.dto.ClienteResumoDTO;
import br.com.cwi.crescer.dto.ProdutoDTO;
import br.com.cwi.crescer.mapper.ClienteMapper;

@Service
public class ProdutoService {

    private ProdutoDAO produtoDAO;
    private ServicoDAO servicoDAO;
    private MaterialDAO materialDAO;

    
    @Autowired
    public ProdutoService(ProdutoDAO produtoDAO, ServicoDAO servicoDAO, MaterialDAO materialDAO) {
		this.produtoDAO = produtoDAO;
		this.servicoDAO = servicoDAO;
		this.materialDAO = materialDAO;
	}
   
    public ProdutoDTO buscarPorId(Long id) {
    	Produto produto = produtoDAO.findById(id);
    	return new ProdutoDTO(produto);
    }

    public List<ProdutoDTO> listarTodos() {
        List<Produto> produtos = produtoDAO.findAll();
        List<ProdutoDTO> produtosDTO = new ArrayList<ProdutoDTO>();
        
        for (Produto produto: produtos) {
        	produtosDTO.add(new ProdutoDTO(produto));
        }

        return produtosDTO;
    }

	public void atualizar(ProdutoDTO produto) {
		Produto entity = produtoDAO.findById(produto.getId());

        ProdutoMapper.merge(produto, entity);

        entity.setServico(servicoDAO.findById(produto.getServico().getIdServico()));
        entity.setMaterial(materialDAO.findById(produto.getMaterial().getIdMaterial()));

        clienteDAO.save(entity);
	}

}