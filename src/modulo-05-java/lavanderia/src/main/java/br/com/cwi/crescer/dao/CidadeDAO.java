package br.com.cwi.crescer.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import br.com.cwi.crescer.domain.Cidade;

@Repository
public class CidadeDAO extends AbstractDAO {

    public Cidade findById (Long id) {
        return this.em.find(Cidade.class, id);
    }

    public List<Cidade> listAll() {
        return em.createQuery("FROM Cidade", Cidade.class)
                .getResultList();
    }
}
