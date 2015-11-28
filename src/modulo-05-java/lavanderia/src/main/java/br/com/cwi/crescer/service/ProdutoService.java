package br.com.cwi.crescer.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.cwi.crescer.dao.ProdutoDAO;
import br.com.cwi.crescer.domain.Cliente;
import br.com.cwi.crescer.domain.Produto;
import br.com.cwi.crescer.dto.ClienteResumoDTO;
import br.com.cwi.crescer.dto.ProdutoDTO;

@Service
public class ProdutoService {

    private ProdutoDAO produtoDAO;

    @Autowired
    public ProdutoService(ProdutoDAO produtoDAO) {
        this.produtoDAO = produtoDAO;
    }

    public Object listarTodos() {
        List<Produto> produtos = produtoDAO.findAll();
        List<ProdutoDTO> produtosDTO = new ArrayList<ProdutoDTO>();
        
        for (Produto produto: produtos) {
        	produtosDTO.add(new ProdutoDTO(produto));
        }

        return produtosDTO;
    }

}
