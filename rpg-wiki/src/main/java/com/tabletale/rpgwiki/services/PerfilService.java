package com.tabletale.rpgwiki.services;

import com.tabletale.rpgwiki.domain.entity.Imagem;
import com.tabletale.rpgwiki.domain.entity.Usuario;
import com.tabletale.rpgwiki.repositories.dao.UsuarioDaoImpl;
import com.tabletale.rpgwiki.services.exceptions.InvalidationOperationListRPGExcption;
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

    public String getName(String id) {
        if (repositoryUsuario.findById(id) == null) {
            throw new UserNotFoundException("Usuário não existe");
        }
        return repositoryUsuario.findById(id).getNome();
    }


    public String getBiografia(String id) {
        if (repositoryUsuario.findById(id) == null) {
            throw new UserNotFoundException("Usuário não existe");
        }
        return repositoryUsuario.findById(id).getBiografia();
    }

    @Transactional(readOnly = false)
    public String alterarBiografia(String id, String novaBiografia) {
        if (repositoryUsuario.findById(id) == null) {
            throw new UserNotFoundException("Usuário não existe");
        }
        Usuario usuario = repositoryUsuario.findById(id);
        System.out.println("Antes: " + usuario.getBiografia());
        usuario.setBiografia(novaBiografia);
        repositoryUsuario.update(usuario);
        System.out.println("Depois: " + repositoryUsuario.findById(id).getBiografia() + "\n");
        return novaBiografia;
    }

    public String getPais(String id) {
        if (repositoryUsuario.findById(id) == null) {
            throw new UserNotFoundException("Usuário não existe");
        }
        return repositoryUsuario.findById(id).getPais().getDescricao();
    }

    public String getNarrativa(String id) {
        if (repositoryUsuario.findById(id) == null) {
            throw new UserNotFoundException("Usuário não existe");
        }
        return repositoryUsuario.findById(id).getNarrativa();
    }

    @Transactional(readOnly = false)
    public String alterarNarrativa(String id, String novaNarrativa) {
        if (repositoryUsuario.findById(id) == null) {
            throw new UserNotFoundException("Usuário não existe");
        }
        Usuario usuario = repositoryUsuario.findById(id);
        System.out.println("Antes: " + usuario.getNarrativa());
        usuario.setNarrativa(novaNarrativa);
        repositoryUsuario.update(usuario);
        System.out.println("Depois: " + repositoryUsuario.findById(id).getNarrativa() + "\n");
        return novaNarrativa;
    }

    public String getExperiencia(String id) {
        if (repositoryUsuario.findById(id) == null) {
            throw new UserNotFoundException("Usuário não existe");
        }
        return repositoryUsuario.findById(id).getExperiencia();
    }

    @Transactional(readOnly = false)
    public String alterarExperiencia(String id, String novaExperiencia) {
        if (repositoryUsuario.findById(id) == null) {
            throw new UserNotFoundException("Usuário não existe");
        }
        Usuario usuario = repositoryUsuario.findById(id);
        System.out.println("Antes: " + usuario.getExperiencia());
        usuario.setExperiencia(novaExperiencia);
        repositoryUsuario.update(usuario);
        System.out.println("Depois: " + repositoryUsuario.findById(id).getExperiencia() + "\n");
        return novaExperiencia;
    }

    public String getTipoDeJogador(String id) {
        if (repositoryUsuario.findById(id) == null) {
            throw new UserNotFoundException("Usuário não existe");
        }
        return repositoryUsuario.findById(id).getTipoDeJogador();
    }

    @Transactional(readOnly = false)
    public String alterarTipoDeJogador(String id, String novoTipoDeJogador) {
        if (repositoryUsuario.findById(id) == null) {
            throw new UserNotFoundException("Usuário não existe");
        }
        Usuario usuario = repositoryUsuario.findById(id);
        System.out.println("Antes: " + usuario.getTipoDeJogador());
        usuario.setTipoDeJogador(novoTipoDeJogador);
        repositoryUsuario.update(usuario);
        System.out.println("Depois: " + repositoryUsuario.findById(id).getTipoDeJogador() + "\n");
        return novoTipoDeJogador;
    }

    public String getCargo(String id) {
        if (repositoryUsuario.findById(id) == null) {
            throw new UserNotFoundException("Usuário não existe");
        }
        return repositoryUsuario.findById(id).getCargo();
    }

    @Transactional(readOnly = false)
    public String alterarCargo(String id, String novoCargo) {
        if (repositoryUsuario.findById(id) == null) {
            throw new UserNotFoundException("Usuário não existe");
        }
        Usuario usuario = repositoryUsuario.findById(id);
        System.out.println("Antes: " + usuario.getCargo());
        usuario.setCargo(novoCargo);
        repositoryUsuario.update(usuario);
        System.out.println("Depois: " + repositoryUsuario.findById(id).getCargo() + "\n");
        return novoCargo;
    }

    //----------------- Funções relacionadas aos Links de Redes Sociais do Usuario ----------------//
    public String getUsernameInstagram(String id) {
        if (repositoryUsuario.findById(id) == null) {
            throw new UserNotFoundException("Usuário não existe");
        }
        return repositoryUsuario.findById(id).getUsernameInstragram();
    }

    @Transactional(readOnly = false)
    public String alterarUsernameInstagram(String id, String novoUsername) {
        if (repositoryUsuario.findById(id) == null) {
            throw new UserNotFoundException("Usuário não existe");
        }
        Usuario usuario = repositoryUsuario.findById(id);
        System.out.println("Antes: " + usuario.getUsernameInstragram());
        usuario.setUsernameInstragram(novoUsername);
        repositoryUsuario.update(usuario);
        System.out.println("Depois: " + repositoryUsuario.findById(id).getUsernameInstragram() + "\n");
        return novoUsername;
    }

    public String getUsernameFacebook(String id) {
        if (repositoryUsuario.findById(id) == null) {
            throw new UserNotFoundException("Usuário não existe");
        }
        return repositoryUsuario.findById(id).getUsernameFacebook();
    }

    @Transactional(readOnly = false)
    public String alterarUsernameFacebook(String id, String novoUsername) {
        if (repositoryUsuario.findById(id) == null) {
            throw new UserNotFoundException("Usuário não existe");
        }
        Usuario usuario = repositoryUsuario.findById(id);
        System.out.println("Antes: " + usuario.getUsernameFacebook());
        usuario.setUsernameFacebook(novoUsername);
        repositoryUsuario.update(usuario);
        System.out.println("Depois: " + repositoryUsuario.findById(id).getUsernameFacebook() + "\n");
        return novoUsername;
    }

    public String getUsernameTwitter(String id) {
        if (repositoryUsuario.findById(id) == null) {
            throw new UserNotFoundException("Usuário não existe");
        }
        return repositoryUsuario.findById(id).getUsernameTwitter();
    }

    @Transactional(readOnly = false)
    public String alterarUsernameTwitter(String id, String novoUsername) {
        if (repositoryUsuario.findById(id) == null) {
            throw new UserNotFoundException("Usuário não existe");
        }
        Usuario usuario = repositoryUsuario.findById(id);
        System.out.println("Antes: " + usuario.getUsernameTwitter());
        usuario.setUsernameTwitter(novoUsername);
        repositoryUsuario.update(usuario);
        System.out.println("Depois: " + repositoryUsuario.findById(id).getUsernameTwitter() + "\n");
        return novoUsername;
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
            throw new InvalidationOperationListRPGExcption("O " + nomeRPG.toUpperCase() + " já exsite na lista");
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
            throw new InvalidationOperationListRPGExcption("O " + nomeRPG.toUpperCase() + " não existe na lista, por isso não pode ser removido");
        }
        usuario.removerRPGSFavoritos(nomeRPG.toUpperCase());
        repositoryUsuario.update(usuario);
        return getRPGSfavoritos(id);
    }

}
