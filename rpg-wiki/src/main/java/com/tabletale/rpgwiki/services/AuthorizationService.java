package com.tabletale.rpgwiki.services;


import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.tabletale.rpgwiki.domain.entity.Usuario;
import com.tabletale.rpgwiki.repositories.UserRepository;

@Service
public class AuthorizationService implements UserDetailsService {

     @Autowired
    UserRepository repository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return repository.findByEmail(username);
    }

    public String alterarSenha(Usuario usuario) {

        Usuario usuarioBanco = userRepository.findByEmailAndCodigoRecuperacaoSenha(usuario.getEmail(),
                usuario.getCodigoRecuperacaoSenha());
        if (usuarioBanco != null) {
            Date diferenca = new Date(new Date().getTime() - usuarioBanco.getDataEnvioCodigo().getTime());
            if (diferenca.getTime() / 1000 < 900) {
                usuarioBanco.setSenha(passwordEncoder.encode(usuario.getSenha()));
                usuarioBanco.setCodigoRecuperacaoSenha(null);
                userRepository.saveAndFlush(usuarioBanco);
                return "Senha alterada com sucesso!";

            } else {
                return "Tempo expirado, solicite um novo código";
            }
        } else {
            return "Email ou código não encontrado!";
        }
    }
}