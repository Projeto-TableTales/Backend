package com.tabletale.rpgwiki.repositories.dao;

import com.tabletale.rpgwiki.domain.entity.Personagem;
import jakarta.persistence.TypedQuery;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PersonagemDaoImpl extends AbstractDao<Personagem, String> implements PersonagemDao {
    @Override
    public List<Personagem> findByName(String nome) {
        String jpql = "select p from Personagem p where p.nome = '" + nome + "'";
        TypedQuery<Personagem> typedQuery = getEntityManager().createQuery(jpql, Personagem.class);
        List<Personagem> lista = typedQuery.getResultList();
        lista.forEach(p -> System.out.println(p.getId() + ", " + p.getNome()));
        return lista;
    }

    @Override
    public List<Personagem> buscarTodosPersonagensDoUsuario(String idUsuario) {
        String jpql = "select p from Personagem p where p.usuario = (select u from Usuario u where u.id = '" + idUsuario + "')";
        TypedQuery<Personagem> typedQuery = getEntityManager().createQuery(jpql, Personagem.class);
        List<Personagem> lista = typedQuery.getResultList();
        lista.forEach(p -> System.out.println(p.getUsuario().getNome() + ", " + p.getNome()));
        return lista;
    }

}
