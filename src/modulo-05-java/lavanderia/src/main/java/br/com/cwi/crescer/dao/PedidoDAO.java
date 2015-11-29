package br.com.cwi.crescer.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import br.com.cwi.crescer.domain.Cliente;
import br.com.cwi.crescer.domain.Pedido;
import br.com.cwi.crescer.domain.Produto;
import br.com.cwi.crescer.domain.Pedido.SituacaoPedido;

@Repository
public class PedidoDAO extends AbstractDAO {

    public Pedido findById(Long id) {
        return em.find(Pedido.class, id);
    }

    public List<Pedido> findBySituacao(SituacaoPedido situacao) {
        return em.createQuery("FROM Pedido p WHERE p.situacao = :situacao", Pedido.class)
                .setParameter("situacao", situacao)
                .getResultList();
    }

    public List<Pedido> listAll() {
        return em.createQuery("FROM Pedido", Pedido.class).getResultList();
    }

	@Transactional
    public Pedido save(Pedido pedido) {

        if (pedido.getIdPedido() == null) {
            em.persist(pedido);
            return pedido;
        }

        return em.merge(pedido);
    }

	public Pedido last() {
		return em.createQuery("FROM Pedido ORDER BY idPedido DESC", Pedido.class)
				.setMaxResults(1)
				.getSingleResult();
	}
}
