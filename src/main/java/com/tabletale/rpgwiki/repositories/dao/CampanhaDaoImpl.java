package com.tabletale.rpgwiki.repositories.dao;

import com.tabletale.rpgwiki.domain.entity.Campanha;
import jakarta.persistence.TypedQuery;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CampanhaDaoImpl extends AbstractDao<Campanha, String> implements CampanhaDao{

    @Override
    public List<Campanha> buscarCampanhaPorNome(String nomeCampanha) {
        String jpql = "select c from Campanha c where c.nomeCampanha = '" + nomeCampanha + "'";
        TypedQuery<Campanha> typedQuery = getEntityManager().createQuery(jpql, Campanha.class);
        List<Campanha> campanhas = typedQuery.getResultList();
        campanhas.forEach(c -> System.out.println("Criador: " + c.getCriadorCampanha().getNome() + "   Nome Campanha: " + c.getNomeCampanha()));
        return campanhas;
    }

    @Override
    public List<Campanha> buscarCampanhaPorCriador(String idUsuario) {
        String jpql = "select c from Campanha c where c.criadorCampanha = (select u from Usuario u where u.id = '" + idUsuario + "')";
        TypedQuery<Campanha> typedQuery = getEntityManager().createQuery(jpql, Campanha.class);
        List<Campanha> campanhas = typedQuery.getResultList();
        campanhas.forEach(c -> System.out.println("Criador: " + c.getCriadorCampanha().getNome() + "   Nome Campanha: " + c.getNomeCampanha()));
        return campanhas;
    }

    @Override
    public List<Campanha> buscarCampanhaSeguida(String idUsuario) {
        String jpql = "select c from Campanha c join c.participantes u where u.id = '" + idUsuario + "'";
        TypedQuery<Campanha> typedQuery = getEntityManager().createQuery(jpql, Campanha.class);
        List<Campanha> campanhas = typedQuery.getResultList();
        campanhas.forEach(c -> System.out.println("Criador: " + c.getCriadorCampanha().getNome() + "   Nome Campanha: " + c.getNomeCampanha()));
        return campanhas;
    }

}
