package com.tabletale.rpgwiki.repositories.dao;

import com.tabletale.rpgwiki.domain.entity.Mesa;
import jakarta.persistence.TypedQuery;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class MesaDaoImpl extends AbstractDao<Mesa, String> implements MesaDao {

    @Override
    public List<Mesa> findByNameOfGame(String nomeDoJogo) {
        String jpql = "select m from Mesa m where m.nome = '" + nomeDoJogo + "'";
        TypedQuery<Mesa> typedQuery = getEntityManager().createQuery(jpql, Mesa.class);
        List<Mesa> lista = typedQuery.getResultList();
        lista.forEach(m -> System.out.println(m.getId() + ", " + m.getNomeDoJogo()));
        return lista;
    }

}
