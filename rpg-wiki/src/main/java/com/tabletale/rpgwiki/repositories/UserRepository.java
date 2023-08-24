package com.tabletale.rpgwiki.repositories;


import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.security.core.userdetails.UserDetails;
import com.tabletale.rpgwiki.domain.entity.Usuario;

public interface UserRepository extends JpaRepository<Usuario, Long> {
    UserDetails findByLogin(String email);
}