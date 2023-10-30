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

    /*
         ---------- FUNÇÕES  DOS ATRIBUTOS DO PERSOAGEM ----------------
     */

    //---------------------- Nome do Personagem ------------------//
    public String getNomePersonagem(String idPersonagem) {
        if (repositoryPersonagem.findById(idPersonagem) == null) {
            throw new PersonagemNotFoundException("Personagem não existe");
        }
        return repositoryPersonagem.findById(idPersonagem).getNome();
    }

    @Transactional(readOnly = false)
    public String alterarNomePersonagem(String idPersonagem, String novoNome) {
        Personagem personagem = repositoryPersonagem.findById(idPersonagem);
        System.out.println("Antes: " + personagem.getNome());
        personagem.setNome(novoNome);
        repositoryPersonagem.update(personagem);
        System.out.println("Depois: " + repositoryPersonagem.findById(idPersonagem).getNome()+ "\n");
        return novoNome;
    }

    //---------------------- Idade do Personagem ------------------//
    public int getIdadePersonagem(String idPersonagem) {
        if (repositoryPersonagem.findById(idPersonagem) == null) {
            throw new PersonagemNotFoundException("Personagem não existi");
        }
        return repositoryPersonagem.findById(idPersonagem).getIdade();
    }

    @Transactional(readOnly = false)
    public int alterarIdadePersonagem(String idPersonagem, int novaIdade) {
        Personagem personagem = repositoryPersonagem.findById(idPersonagem);
        System.out.println("Antes: " + personagem.getIdade());
        personagem.setIdade(novaIdade);
        repositoryPersonagem.update(personagem);
        System.out.println("Depois: " + repositoryPersonagem.findById(idPersonagem).getIdade()+ "\n");
        return novaIdade;
    }

    //---------------------- Status do Personagem ------------------//
    public String getStatusPersonagem(String idPersonagem) {
        if (repositoryPersonagem.findById(idPersonagem) == null) {
            throw new PersonagemNotFoundException("Personagem não existe");
        }
        return repositoryPersonagem.findById(idPersonagem).getStatus();
    }

    @Transactional(readOnly = false)
    public String alterarStatusPersonagem(String idPersonagem, String novoStatus) {
        Personagem personagem = repositoryPersonagem.findById(idPersonagem);
        System.out.println("Antes: " + personagem.getStatus());
        personagem.setStatus(novoStatus);
        repositoryPersonagem.update(personagem);
        System.out.println("Depois: " + repositoryPersonagem.findById(idPersonagem).getStatus() + "\n");
        return novoStatus;
    }

    //---------------------- Sistema RPG do Personagem ------------------//
    public String getSistemaDoRPGPersonagem(String idPersonagem) {
        if (repositoryPersonagem.findById(idPersonagem) == null) {
            throw new PersonagemNotFoundException("Personagem não existe");
        }
        return repositoryPersonagem.findById(idPersonagem).getSistemaDoRPG();
    }

    @Transactional(readOnly = false)
    public String alterarSistemaDoRPGPersonagem(String idPersonagem, String novoSistemaDoRPG) {
        Personagem personagem = repositoryPersonagem.findById(idPersonagem);
        System.out.println("Antes: " + personagem.getSistemaDoRPG());
        personagem.setSistemaDoRPG(novoSistemaDoRPG);
        repositoryPersonagem.update(personagem);
        System.out.println("Depois: " + repositoryPersonagem.findById(idPersonagem).getSistemaDoRPG() + "\n");
        return novoSistemaDoRPG;
    }

    //---------------------- Descrição do Personagem ------------------//
    public String getDescricaoPersonagem(String idPersonagem) {
        if (repositoryPersonagem.findById(idPersonagem) == null) {
            throw new PersonagemNotFoundException("Personagem não existe");
        }
        return repositoryPersonagem.findById(idPersonagem).getDescricao();
    }

    @Transactional(readOnly = false)
    public String editarDescricaoPersonagem(String idPersonagem, String novaDescricao) {
        Personagem personagem = repositoryPersonagem.findById(idPersonagem);
        System.out.println("Antes: " + personagem.getDescricao());
        personagem.setDescricao(novaDescricao);
        repositoryPersonagem.update(personagem);
        System.out.println("Depois: " + repositoryPersonagem.findById(idPersonagem).getDescricao() + "\n");
        return novaDescricao;
    }

    //---------------------- Personalidade do Personagem ------------------//
    public String getPersonalidadePersonagem(String idPersonagem) {
        if (repositoryPersonagem.findById(idPersonagem) == null) {
            throw new PersonagemNotFoundException("Personagem não existe");
        }
        return repositoryPersonagem.findById(idPersonagem).getPersonalidade();
    }

    @Transactional(readOnly = false)
    public String alterarPersonalidadePersonagem(String idPersonagem, String novaPersonalidade) {
        Personagem personagem = repositoryPersonagem.findById(idPersonagem);
        System.out.println("Antes: " + personagem.getPersonalidade());
        personagem.setPersonalidade(novaPersonalidade);
        repositoryPersonagem.update(personagem);
        System.out.println("Depois: " + repositoryPersonagem.findById(idPersonagem).getPersonalidade() + "\n");
        return novaPersonalidade;
    }

    //---------------------- Likes do Personagem ------------------//
    public int getLikesPersonagem(String idPersonagem) {
        if (repositoryPersonagem.findById(idPersonagem) == null) {
            throw new PersonagemNotFoundException("Personagem não existe");
        }
        return repositoryPersonagem.findById(idPersonagem).getLikes();
    }

    //---------------------- História dp Personagem ------------------//
    public String getHistoriaPersonagem(String idPersonagem) {
        if (repositoryPersonagem.findById(idPersonagem) == null) {
            throw new PersonagemNotFoundException("Personagem não existe");
        }
        return repositoryPersonagem.findById(idPersonagem).getHistoria();
    }

    @Transactional(readOnly = false)
    public String editarHistoriaPersonagem(String idPersonagem, String novaHistoria) {
        Personagem personagem = repositoryPersonagem.findById(idPersonagem);
        System.out.println("Antes: " + personagem.getHistoria());
        personagem.setHistoria(novaHistoria);
        repositoryPersonagem.update(personagem);
        System.out.println("Depois: " + repositoryPersonagem.findById(idPersonagem).getHistoria() + "\n");
        return novaHistoria;
    }

    //---------------------- Tags do Personagem ------------------//
    public List<String> getTagsPersonagem(String idPersonagem) {
        if (repositoryPersonagem.findById(idPersonagem) == null) {
            throw new PersonagemNotFoundException("Personagem não existe");
        }
        return repositoryPersonagem.findById(idPersonagem).getTagsPersonagem();
    }

    @Transactional(readOnly = false)
    public List<String> adicionarTagPersonagem(String idPersonagem, String novaTag) {
        if (repositoryPersonagem.findById(idPersonagem) == null) {
            throw new PersonagemNotFoundException("Personagem não existe");
        }
        Personagem personagem = repositoryPersonagem.findById(idPersonagem);
        personagem.adicionarTagPersonagem(novaTag.toUpperCase());
        repositoryPersonagem.update(personagem);
        return getTagsPersonagem(idPersonagem);
    }

    @Transactional(readOnly = false)
    public List<String> removerTagPersonagem(String idPersonagem, String tag) {
        if (repositoryPersonagem.findById(idPersonagem) == null) {
            throw new PersonagemNotFoundException("Personagem não existe");
        }
        Personagem personagem = repositoryPersonagem.findById(idPersonagem);
        personagem.removerTagPersonagem(tag.toUpperCase());
        repositoryPersonagem.update(personagem);
        return getTagsPersonagem(idPersonagem);
    }

}