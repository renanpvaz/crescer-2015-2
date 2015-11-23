package br.com.cwi.crescer.dao;

import org.springframework.stereotype.Repository;

import br.com.cwi.crescer.domain.Cidade;

@Repository
public class CidadeDAO extends AbstractDAO {

    public Cidade findById (Long id) {
        return this.em.find(Cidade.class, id);
    }
}
