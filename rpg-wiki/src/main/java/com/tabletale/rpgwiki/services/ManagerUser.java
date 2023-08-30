package com.tabletale.rpgwiki.services;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.tabletale.rpgwiki.domain.entity.Usuario;
import com.tabletale.rpgwiki.repositories.UserRepository;

@Service
public class ManagerUser {


    @Autowired
    private UserRepository userRepository;

    @Autowired
    private EmailService emailService;

    @Autowired
    PasswordEncoder passwordEncoder;

    public String solicitarCodigo(String email) {
        Usuario usuario = (Usuario) userRepository.findByEmail(email);
        usuario.setCodigoRecuperacaoSenha(getCodigoRecuperacaoSenha(usuario.getId()));
        usuario.setDataEnvioCodigo(new Date());
        userRepository.saveAndFlush(usuario);
        emailService.enviarEmailTexto(usuario.getEmail(), "Código de Recuperação de Senha",
                "Olá, o seu código para recuperação de senha é o seguinte: " + usuario.getCodigoRecuperacaoSenha());
        return "Código Enviado!";
    }

    public String alterarSenha(Usuario user) {

        Usuario userBanco = userRepository.findByEmailAndCodigoRecuperacaoSenha(user.getEmail(),
                user.getCodigoRecuperacaoSenha());
        if (userBanco != null) {
            Date diferenca = new Date(new Date().getTime() - userBanco.getDataEnvioCodigo().getTime());
            if (diferenca.getTime() / 1000 < 900) {
                //depois que adicionar o spring security é necessário criptografar a senha!!
                userBanco.setSenha(passwordEncoder.encode(user.getSenha()));
                userBanco.setCodigoRecuperacaoSenha(null);
                userRepository.saveAndFlush(userBanco);
                return "Senha alterada com sucesso!";
            } else {
                return "Tempo expirado, solicite um novo código";
            }
        } else {
            return "Email ou código não encontrado!";
        }
    }

    private String getCodigoRecuperacaoSenha(String id) {
        DateFormat format = new SimpleDateFormat("ddMMyyyyHHmmssmm");
        return format.format(new Date()) + id;
    }

}
