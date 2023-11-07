package com.tabletale.rpgwiki.services;

import com.tabletale.rpgwiki.domain.entity.Campanha;
import com.tabletale.rpgwiki.domain.entity.Usuario;
import com.tabletale.rpgwiki.repositories.dao.CampanhaDaoImpl;
import com.tabletale.rpgwiki.repositories.dao.UsuarioDaoImpl;
import com.tabletale.rpgwiki.services.exceptions.CampanhaNotFoundException;
import com.tabletale.rpgwiki.services.exceptions.InvalidationOperationException;
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
            throw new UserNotFoundException("Id do usuário inválido, não foi encontrado nenhum usuário cadastrado com o id = " + idUsuario);
        }
        Usuario usuario = repositoryUsuario.findById(idUsuario);
        campanha.setCriadorCampanha(usuario);
        usuario.criarCampanha(campanha);
        repositoryCampanha.save(campanha);
        repositoryUsuario.update(usuario);
    }

    public List<Campanha> buscarCampanhas() {
        if (repositoryCampanha.findAll().isEmpty()) {
            throw new CampanhaNotFoundException("Não há campanhas criadas no momento");
        }
        return repositoryCampanha.findAll();
    }

    public List<Campanha> buscarCampanhaPorNome(String nomeCampanha) {
        if (repositoryCampanha.buscarCampanhaPorNome(nomeCampanha).isEmpty()) {
            throw new CampanhaNotFoundException("Nenhuma campanha com o nome " + nomeCampanha + " foi encontrada");
        }
        return repositoryCampanha.buscarCampanhaPorNome(nomeCampanha);
    }

    public List<Campanha> buscarCampanhaPorCriador(String idUsuario) {
        if (repositoryUsuario.findById(idUsuario) == null) {
            throw new UserNotFoundException("Id do usuário inválido, não foi encontrado nenhum usuário cadastrado com o id = " + idUsuario);
        }
        if (repositoryCampanha.buscarCampanhaPorCriador(idUsuario).isEmpty()) {
            throw new CampanhaNotFoundException("O usuário ainda não criou campanhas");
        }
        return repositoryCampanha.buscarCampanhaPorCriador(idUsuario);
    }

    // Fazer verificações para evitar bugs e erros OBS:. Código incompleto
    @Transactional(readOnly = false)
    public void seguirCampanha(String idCampanha, String idUsuario) {
        if (repositoryUsuario.findById(idUsuario) == null) {
            throw new UserNotFoundException("Id do usuário inválido, não foi encontrado nenhum usuário cadastrado com o id = " + idUsuario);
        }
        if (repositoryCampanha.findById(idCampanha) == null) {
            throw new CampanhaNotFoundException("Id da campanha inválido, não foi encontrado nenhuma campanha cadastrada com o id = " + idCampanha);
        }
        Usuario usuario = repositoryUsuario.findById(idUsuario);
        Campanha campanha = repositoryCampanha.findById(idCampanha);
        campanha.receberSeguidor(usuario);
        usuario.seguirCampanha(campanha);
        repositoryUsuario.update(usuario);
        repositoryCampanha.update(campanha);
    }

    // Fazer verificações para ver se o usuário segue a cmpanha
    @Transactional(readOnly = false)
    public void deixarSeguirCampanha(String idCampanha, String idUsuario) {
        if (repositoryUsuario.findById(idUsuario) == null) {
            throw new UserNotFoundException("Id do usuário inválido, não foi encontrado nenhum usuário cadastrado com o id = " + idUsuario);
        }
        if (repositoryCampanha.findById(idCampanha) == null) {
            throw new CampanhaNotFoundException("Id da campanha inválido, não foi encontrado nenhuma campanha cadastrada com o id = " + idCampanha);
        }
        Usuario usuario = repositoryUsuario.findById(idUsuario);
        Campanha campanha = repositoryCampanha.findById(idCampanha);
        campanha.retirarSeguidor(usuario);
        usuario.deixarSeguirCampanha(campanha);
        repositoryUsuario.update(usuario);
        repositoryCampanha.update(campanha);
    }

    public List<Campanha> buscarCampanhaSeguida(String idUsuario) {
        if (repositoryUsuario.findById(idUsuario) == null) {
            throw new UserNotFoundException("Id do usuário inválido, não foi encontrado nenhum usuário cadastrado com o id = " + idUsuario);
        }
        if (repositoryCampanha.buscarCampanhaSeguida(idUsuario).isEmpty()) {
            throw new CampanhaNotFoundException("O usuário não possui campanhas seguidas");
        }
        return repositoryCampanha.buscarCampanhaSeguida(idUsuario);
    }

    @Transactional(readOnly = false)
    public String excluirCampanha(String idCampanha, String idUsuario) {
        if (repositoryUsuario.findById(idUsuario) == null) {
            throw new UserNotFoundException("Id do usuário inválido, não foi encontrado nenhum usuário cadastrado com o id = " + idUsuario);
        }
        if (repositoryCampanha.findById(idCampanha) == null) {
            throw new CampanhaNotFoundException("Id da campanha inválido, não foi encontrado nenhuma campanha cadastrada com o id = " + idCampanha);
        }
        Campanha campanha = repositoryCampanha.findById(idCampanha);
        Usuario usuario = repositoryUsuario.findById(idUsuario);

        if (campanha.getCriadorCampanha().equals(usuario)) {
            for (Usuario participante : campanha.getParticipantes()) {
                participante.deixarSeguirCampanha(campanha);
                repositoryUsuario.update(participante);
            }
            usuario.excluirCampanha(campanha);
            repositoryCampanha.delete(idCampanha);
            repositoryUsuario.update(usuario);
            return "Campanha Excluída Com Sucesso";
        }
        else {
            throw new InvalidationOperationException("Erro ao executar a ação, o usuário não pode excluir campanhas se não for o criador da respectiva campanha");
        }
    }

}
