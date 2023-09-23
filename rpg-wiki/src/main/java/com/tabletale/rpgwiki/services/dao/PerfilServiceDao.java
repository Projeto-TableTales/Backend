package com.tabletale.rpgwiki.services.dao;

import com.tabletale.rpgwiki.domain.entity.Usuario;
import com.tabletale.rpgwiki.repositories.dao.UsuarioDaoImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class PerfilServiceDao {

    @Autowired
    private UsuarioDaoImpl repository;

    //-------------- Funções relacionadas a informações básicas do Usuario -----------------//
    public String getName(String id) {
        return repository.findById(id).getNome();
    }

    public String getBiografia(String id) {
        return repository.findById(id).getBiografia();
    }

    public String getPais(String id) {
        return repository.findById(id).getPais().getDescricao();
    }

    //----------------- Funções relacionadas aos Links de Redes Sociais do Usuario ----------------//
    public String getUsernameInstagram(String id) {
        return repository.findById(id).getUsernameInstragram();
    }

    @Transactional(readOnly = false)
    public String alterarUsernameInstagram(String id, String novoUsername) {
        Usuario usuario = repository.findById(id);
        System.out.println("Antes: " + usuario.getUsernameInstragram());
        usuario.setUsernameInstragram(novoUsername);
        repository.update(usuario);
        System.out.println("Depois: " + repository.findById(id).getUsernameInstragram() + "\n");
        return novoUsername;
    }

    public String getUsernameFacebook(String id) {
        return repository.findById(id).getUsernameFacebook();
    }

    @Transactional(readOnly = false)
    public String alterarUsernameFacebook(String id, String novoUsername) {
        Usuario usuario = repository.findById(id);
        System.out.println("Antes: " + usuario.getUsernameFacebook());
        usuario.setUsernameFacebook(novoUsername);
        repository.update(usuario);
        System.out.println("Depois: " + repository.findById(id).getUsernameFacebook() + "\n");
        return novoUsername;
    }

    public String getUsernameTwitter(String id) {
        return repository.findById(id).getUsernameTwitter();
    }

    @Transactional(readOnly = false)
    public String alterarUsernameTwitter(String id, String novoUsername) {
        Usuario usuario = repository.findById(id);
        System.out.println("Antes: " + usuario.getUsernameTwitter());
        usuario.setUsernameTwitter(novoUsername);
        repository.update(usuario);
        System.out.println("Depois: " + repository.findById(id).getUsernameTwitter() + "\n");
        return novoUsername;
    }

    //------------------- Funções relacionadas a lista de RPGs Favoritos do Usuario -----------------------//
    public List<String> getRPGSfavoritos(String id) {
        return repository.findById(id).getRpgsFavoritos();
    }

    @Transactional(readOnly = false)
    public void adicionarRPGSlistaFavoritos(String id, String nomeRPG) {
        Usuario usuario = repository.findById(id);
        usuario.adicionarRPGSFavoritos(nomeRPG);
        repository.update(usuario);
    }

    @Transactional(readOnly = false)
    public void removerRPGSlistaFavoritos(String id, String nomeRPG) {
        Usuario usuario = repository.findById(id);
        usuario.removerRPGSFavoritos(nomeRPG);
        repository.update(usuario);
    }

}
