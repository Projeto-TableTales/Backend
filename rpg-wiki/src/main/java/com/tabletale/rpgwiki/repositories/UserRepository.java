package com.tabletale.rpgwiki.repositories;


import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;

import com.tabletale.rpgwiki.domain.entity.Usuario;
@Repository
public interface UserRepository extends JpaRepository<Usuario, String> {

    UserDetails findByEmail(String email);

    List<Usuario> findByNome(String nome);

    Usuario findByEmailAndCodigoRecuperacaoSenha(String email, String codigoRecuperacaoSenha);

}