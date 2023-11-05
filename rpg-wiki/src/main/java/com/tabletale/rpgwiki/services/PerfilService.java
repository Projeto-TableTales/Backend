package com.tabletale.rpgwiki.services;

import com.tabletale.rpgwiki.domain.entity.Imagem;
import com.tabletale.rpgwiki.domain.entity.Usuario;
import com.tabletale.rpgwiki.repositories.dao.UsuarioDaoImpl;
import com.tabletale.rpgwiki.services.exceptions.InvalidationOperationException;
import com.tabletale.rpgwiki.services.exceptions.UserNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class PerfilService {

    @Autowired
    private UsuarioDaoImpl repositoryUsuario;

    //-------------- Funções relacionadas a informações básicas do Usuario -----------------//
    
        public Imagem getImgPerfil(String id) {
        if (repositoryUsuario.findById(id) == null) {
            throw new UserNotFoundException("Usuário não existe");
        }
        return repositoryUsuario.findById(id).getImgPerfil();
    }

    public Usuario getUsuario(String id) {
        if (repositoryUsuario.findById(id) == null) {
            throw new UserNotFoundException("Usuário não existe");
        }
        return repositoryUsuario.findById(id);
    }

    //------------------- Funções relacionadas a lista de RPGs Favoritos do Usuario -----------------------//
    public List<String> getRPGSfavoritos(String id) {
        if (repositoryUsuario.findById(id) == null) {
            throw new UserNotFoundException("Usuário não existe");
        }
        return repositoryUsuario.findById(id).getRpgsFavoritos();
    }

    @Transactional(readOnly = false)
    public List<String> adicionarRPGSlistaFavoritos(String id, String nomeRPG) {
        if (repositoryUsuario.findById(id) == null) {
            throw new UserNotFoundException("Usuário não existe");
        }
        Usuario usuario = repositoryUsuario.findById(id);
        if (usuario.getRpgsFavoritos().contains(nomeRPG.toUpperCase())) {
            throw new InvalidationOperationException("O " + nomeRPG.toUpperCase() + " já exsite na lista");
        }
        usuario.adicionarRPGSFavoritos(nomeRPG.toUpperCase());
        repositoryUsuario.update(usuario);
        return getRPGSfavoritos(id);
    }

    @Transactional(readOnly = false)
    public List<String> removerRPGSlistaFavoritos(String id, String nomeRPG) {
        if (repositoryUsuario.findById(id) == null) {
            throw new UserNotFoundException("Usuário não existe");
        }
        Usuario usuario = repositoryUsuario.findById(id);
        if (!usuario.getRpgsFavoritos().contains(nomeRPG.toUpperCase())) {
            throw new InvalidationOperationException("O " + nomeRPG.toUpperCase() + " não existe na lista, por isso não pode ser removido");
        }
        usuario.removerRPGSFavoritos(nomeRPG.toUpperCase());
        repositoryUsuario.update(usuario);
        return getRPGSfavoritos(id);
    }

}
