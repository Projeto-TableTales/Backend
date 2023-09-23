package com.tabletale.rpgwiki.repositories.dao;

import com.tabletale.rpgwiki.domain.entity.Usuario;
import jakarta.persistence.TypedQuery;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UsuarioDaoImpl extends AbstractDao<Usuario, String> implements UsuarioDao{

    @Override
    public List<Usuario> findByName(String nome) {
        String jpql = "select u from Usuario u where u.nome = '" + nome + "'";
        TypedQuery<Usuario> typedQuery = getEntityManager().createQuery(jpql, Usuario.class);
        List<Usuario> lista = typedQuery.getResultList();
        lista.forEach(u -> System.out.println(u.getId() + ", " + u.getNome()));
        return lista;
    }

    @Override
    public Usuario findByEmail(String email) {
        String jpql = "select u from Usuario u where u.email = '" + email + "'";
        TypedQuery<Usuario> typedQuery = getEntityManager().createQuery(jpql, Usuario.class);
        Usuario usuario = typedQuery.getSingleResult();
        System.out.println("USUARIO\n" + "ID: " + usuario.getId() + "\n" + "NOME: " + usuario.getNome() + "\n" + "EMAIL : " + usuario.getEmail() + "\n" + "SENHA: " + usuario.getSenha() + "\n" + "ROLE: " + usuario.getRole() + "\n" + "GENERO: " + usuario.getGenero() + "\n" + "PAIS: " + usuario.getPais() + "\n\n");
        return usuario;
    }

    @Override
    public Usuario findByEmailAndCodigoRecuperacaoSenha(String email, String codigoRecuperacaoSenha) {
        String jpql = "select u from Usuario u where u.email = '" + email + "' and u.codigoRecuperacaoSenha = '" + codigoRecuperacaoSenha + "'";
        TypedQuery<Usuario> typedQuery = getEntityManager().createQuery(jpql, Usuario.class);
        Usuario usuario = typedQuery.getSingleResult();
        System.out.println("USUARIO\n" + "ID: " + usuario.getId() + "\n" + "NOME: " + usuario.getNome() + "\n" + "EMAIL : " + usuario.getEmail() + "\n" + "SENHA: " + usuario.getSenha() + "\n" + "ROLE: " + usuario.getRole() + "\n" + "GENERO: " + usuario.getGenero() + "\n" + "PAIS: " + usuario.getPais() + "\n\n");
        return usuario;
    }


}
