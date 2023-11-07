package com.tabletale.rpgwiki.services;

import java.util.List;

import com.tabletale.rpgwiki.domain.entity.Usuario;
import com.tabletale.rpgwiki.repositories.dao.PersonagemDaoImpl;
import com.tabletale.rpgwiki.repositories.dao.UsuarioDaoImpl;
import com.tabletale.rpgwiki.services.exceptions.PersonagemNotFoundException;
import com.tabletale.rpgwiki.services.exceptions.UserNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tabletale.rpgwiki.domain.entity.Personagem;

@Service
@Transactional(readOnly = true)
public class PersonagemService {

    @Autowired
    private PersonagemDaoImpl repositoryPersonagem;

    @Autowired
    private UsuarioDaoImpl repositoryUsuario;

    @Transactional(readOnly = false)
    public String criarPersonagem(String idUsuario, Personagem personagem) {
        if (repositoryUsuario.findById(idUsuario) == null) {
            throw new UserNotFoundException("Usuário não encontrado");
        }
        Usuario usuario = repositoryUsuario.findById(idUsuario);

        usuario.adicionarPersonagem(personagem);
        personagem.setUsuario(usuario);
        repositoryPersonagem.save(personagem);
        repositoryUsuario.update(usuario);
        return "Personagem criado com sucesso";
    }

    public String excluirPersonagem (String idUsuario, String idPersonagem) {
        if (repositoryUsuario.findById(idUsuario) == null) {
            throw new UserNotFoundException("Usuário não encontrado");
        }
        if (repositoryPersonagem.findById(idPersonagem) == null) {
            throw new PersonagemNotFoundException("Personagem não encontrado");
        }
        Usuario usuario = repositoryUsuario.findById(idUsuario);
        Personagem personagem = repositoryPersonagem.findById(idPersonagem);
        usuario.removerPersonagem(personagem);
        repositoryPersonagem.delete(idPersonagem);
        repositoryUsuario.update(usuario);
        return "Personagem excluido com sucesso";
    }

    public List<Personagem> buscarTodosPersonagensDoUsuario(String idUsuario) {
        if (repositoryUsuario.findById(idUsuario) == null) {
            throw new UserNotFoundException("Usuário não encontrado");
        }
        if (repositoryPersonagem.buscarTodosPersonagensDoUsuario(idUsuario).isEmpty()) {
            throw new PersonagemNotFoundException("Usuário não possui personagens criados");
        }
        return repositoryPersonagem.buscarTodosPersonagensDoUsuario(idUsuario);
    }



}