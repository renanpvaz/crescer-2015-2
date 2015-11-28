package br.com.cwi.crescer.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import br.com.cwi.crescer.domain.Material;
import br.com.cwi.crescer.domain.Produto;
import br.com.cwi.crescer.domain.Servico;

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
    
    public List<Produto> findByServicoEMaterial(Servico servico, Material material) {
    	
    	return em.createQuery("FROM Produto p where p.servico = :servico and p.material = :material", Produto.class)
                .setParameter("material", material)
                .setParameter("servico", servico)
                .getResultList();
    }

	public List<Produto> findByServico(Servico servico) {
		
		return em.createQuery("FROM Produto p where p.servico = :servico", Produto.class)
			.setParameter("servico", servico)
			.getResultList();
	}
	
	public List<Produto> findByMaterial(Material material) {
		
		return em.createQuery("FROM Produto p where p.material= :material", Produto.class)
			.setParameter("material", material)
			.getResultList();
	}
}
