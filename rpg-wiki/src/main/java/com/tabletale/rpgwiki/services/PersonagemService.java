package com.tabletale.rpgwiki.services;

import java.util.ArrayList;
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
    private PersonagemDaoImpl repository;

    @Autowired
    private UsuarioDaoImpl usuarioRepository;

    @Transactional(readOnly = false)
    public void criarPersonagem(String idUsuario, Personagem personagem) {
        Usuario usuario = usuarioRepository.findById(idUsuario);
        usuario.adicionarPersonagem(personagem);
        personagem.setUsuario(usuario);
        repository.save(personagem);
        usuarioRepository.update(usuario);
    }

    public List<Personagem> buscarTodosPersonagensDoUsuario(String idUsuario) {
        return repository.buscarTodosPersonagensDoUsuario(idUsuario);
    }

    public String getNomePersonagem(String id, String idPersonagem) {
        return repository.buscarPersonagemUsuario(id, idPersonagem).getNome();
    }

    @Transactional(readOnly = false)
    public String alterarNomePersonagem(String id, String novoNome) {
        Personagem personagem = repository.findById(id);
        System.out.println("Antes: " + personagem.getNome());
        personagem.setNome(novoNome);
        repository.update(personagem);
        System.out.println("Depois: " + repository.findById(id).getNome()+ "\n");
        return novoNome;
    }

    public int getIdadePersonagem(String id, String idPersonagem) {
        return repository.buscarPersonagemUsuario(id, idPersonagem).getIdade();
    }

    @Transactional(readOnly = false)
    public int alterarIdadePersonagem(String id, int novaIdade) {
        Personagem personagem = repository.findById(id);
        System.out.println("Antes: " + personagem.getIdade());
        personagem.setIdade(novaIdade);
        repository.update(personagem);
        System.out.println("Depois: " + repository.findById(id).getIdade()+ "\n");
        return novaIdade;
    }

    public String getStatusPersonagem(String id, String idPersonagem) {
        return repository.buscarPersonagemUsuario(id, idPersonagem).getStatus();
    }

    @Transactional(readOnly = false)
    public String alterarStatusPersonagem(String id, String novoStatus) {
        Personagem personagem = repository.findById(id);
        System.out.println("Antes: " + personagem.getStatus());
        personagem.setStatus(novoStatus);
        repository.update(personagem);
        System.out.println("Depois: " + repository.findById(id).getStatus() + "\n");
        return novoStatus;
    }

    public String getSistemaDoRPGPersonagem(String id, String idPersonagem) {
        return repository.buscarPersonagemUsuario(id, idPersonagem).getSistemaDoRPG();
    }

    @Transactional(readOnly = false)
    public String alterarSistemaDoRPGPersonagem(String id, String novoSistemaDoRPG) {
        Personagem personagem = repository.findById(id);
        System.out.println("Antes: " + personagem.getSistemaDoRPG());
        personagem.setSistemaDoRPG(novoSistemaDoRPG);
        repository.update(personagem);
        System.out.println("Depois: " + repository.findById(id).getSistemaDoRPG() + "\n");
        return novoSistemaDoRPG;
    }

    public String getDescricaoPersonagem(String id, String idPersonagem) {
        return repository.buscarPersonagemUsuario(id, idPersonagem).getDescricao();
    }

    @Transactional(readOnly = false)
    public String editarDescricaoPersonagem(String id, String novaDescricao) {
        Personagem personagem = repository.findById(id);
        System.out.println("Antes: " + personagem.getDescricao());
        personagem.setDescricao(novaDescricao);
        repository.update(personagem);
        System.out.println("Depois: " + repository.findById(id).getDescricao() + "\n");
        return novaDescricao;
    }

    public String getPersonalidadePersonagem(String id, String idPersonagem) {
        return repository.buscarPersonagemUsuario(id, idPersonagem).getPersonalidade();
    }

    @Transactional(readOnly = false)
    public String alterarPersonalidadePersonagem(String id, String novaPersonalidade) {
        Personagem personagem = repository.findById(id);
        System.out.println("Antes: " + personagem.getPersonalidade());
        personagem.setPersonalidade(novaPersonalidade);
        repository.update(personagem);
        System.out.println("Depois: " + repository.findById(id).getPersonalidade() + "\n");
        return novaPersonalidade;
    }

    public int getLikesPersonagem(String id,String idPersonagem) {
        return repository.buscarPersonagemUsuario(id, idPersonagem).getLikes();
    }

    public String getHistoriaPersonagem(String id, String idPersonagem) {
        return repository.buscarPersonagemUsuario(id, idPersonagem).getHistoria();
    }

    @Transactional(readOnly = false)
    public String editarHistoriaPersonagem(String id, String novaHistoria) {
        Personagem personagem = repository.findById(id);
        System.out.println("Antes: " + personagem.getHistoria());
        personagem.setHistoria(novaHistoria);
        repository.update(personagem);
        System.out.println("Depois: " + repository.findById(id).getHistoria() + "\n");
        return novaHistoria;
    }

    public List<String> getTagsPersonagem(String id, String idPersonagem) {
        return repository.buscarPersonagemUsuario(id, idPersonagem).getTagsPersonagem();
    }

    @Transactional(readOnly = false)
    public List<String> adicionarTagPersonagem(String id, String idPersonagem, String novaTag) {
        Personagem personagem = repository.buscarPersonagemUsuario(id, idPersonagem);
        personagem.adicionarTagPersonagem(novaTag.toUpperCase());
        repository.update(personagem);
        return getTagsPersonagem(id, idPersonagem);
    }

    @Transactional(readOnly = false)
    public List<String> removerTagPersonagem(String id, String idPersonagem, String tag) {
        Personagem personagem = repository.buscarPersonagemUsuario(id, idPersonagem);
        personagem.removerTagPersonagem(tag.toUpperCase());
        repository.update(personagem);
        return getTagsPersonagem(id, idPersonagem);
    }

}