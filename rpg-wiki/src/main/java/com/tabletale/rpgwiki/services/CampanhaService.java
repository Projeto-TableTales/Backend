package com.tabletale.rpgwiki.services;

import com.tabletale.rpgwiki.domain.entity.Campanha;
import com.tabletale.rpgwiki.domain.entity.Usuario;
import com.tabletale.rpgwiki.repositories.dao.CampanhaDaoImpl;
import com.tabletale.rpgwiki.repositories.dao.UsuarioDaoImpl;
import com.tabletale.rpgwiki.services.exceptions.CampanhaNotFoundException;
import com.tabletale.rpgwiki.services.exceptions.UserNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class CampanhaService {

    @Autowired
    private CampanhaDaoImpl repositoryCampanha;

    @Autowired
    private UsuarioDaoImpl repositoryUsuario;

    @Transactional(readOnly = false)
    public void criarCampanha(Campanha campanha, String idUsuario) {
        if (repositoryUsuario.findById(idUsuario) == null) {
            throw new UserNotFoundException("Usuário não encontrado");
        }
        Usuario usuario = repositoryUsuario.findById(idUsuario);
        campanha.setCriadorCampanha(usuario);
        usuario.criarCampanha(campanha);
        repositoryCampanha.save(campanha);
        repositoryUsuario.update(usuario);
    }

    public List<Campanha> buscarCampanhas() {
        return repositoryCampanha.findAll();
    }

    public List<Campanha> buscarCampanhaPorNome(String nomeCampanha) {
        if (repositoryCampanha.buscarCampanhaPorNome(nomeCampanha).isEmpty()) {
            throw new CampanhaNotFoundException("Nenhuma campanha com o nome " + nomeCampanha + " foi encontrada");
        }
        return repositoryCampanha.buscarCampanhaPorNome(nomeCampanha);
    }

    public List<Campanha> buscarCampanhaPorCriador(String idUsuario) {
        if (repositoryCampanha.buscarCampanhaPorCriador(idUsuario).isEmpty()) {
            throw new CampanhaNotFoundException("O usuário não criou campanhas");
        }
        return repositoryCampanha.buscarCampanhaPorCriador(idUsuario);
    }

    // Fazer verificações para evitar bugs e erros OBS:. Código incompleto
    @Transactional(readOnly = false)
    public void seguirCampanha(String idCampanha, String idUsuario) {
        Usuario usuario = repositoryUsuario.findById(idUsuario);
        Campanha campanha = repositoryCampanha.findById(idCampanha);
        campanha.receberSeguidor(usuario);
        usuario.seguirCampanha(campanha);
        repositoryUsuario.update(usuario);
        repositoryCampanha.update(campanha);
    }

    // Fazer verificações para evitar bugs e erros OBS:. Código incompleto
    @Transactional(readOnly = false)
    public void sairCampanha(String idCampanha, String idUsuario) {
        Usuario usuario = repositoryUsuario.findById(idUsuario);
        Campanha campanha = repositoryCampanha.findById(idCampanha);
        campanha.retirarSeguidor(usuario);
        usuario.sairCampanha(campanha);
        repositoryUsuario.update(usuario);
        repositoryCampanha.update(campanha);
    }


    public List<Campanha> buscarCampanhaSeguida(String idUsuario) {
        return repositoryCampanha.buscarCampanhaSeguida(idUsuario);
    }

}
