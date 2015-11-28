package br.com.cwi.crescer.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import br.com.cwi.crescer.domain.Produto;

@Repository
public class ProdutoDAO extends AbstractDAO {

    public Produto findById(Long id) {
        return em.find(Produto.class, id);
    }

    public List<Produto> findAll() {
        return em.createQuery("FROM Produto", Produto.class).getResultList();
    }
    
    @Transactional
    public Produto save(Produto produto) {

        if (produto.getIdProduto() == null) {
            em.persist(produto);
            return produto;
        }

        return em.merge(produto);
    }

    @Transactional
    public void remove(Long id){
        em.remove(em.getReference(Produto.class, id));
    }
}
