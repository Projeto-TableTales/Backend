package com.tabletale.rpgwiki.repositories;


import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.security.core.userdetails.UserDetails;
import com.tabletale.rpgwiki.domain.entity.Usuario;

public interface UserRepository extends JpaRepository<Usuario, String> {

    UserDetails findByEmail(String email);

    List<Usuario> findByNome(String nome);

    Usuario findByEmailAndCodigoRecuperacaoSenha(String email, String codigoRecuperacaoSenha);

}