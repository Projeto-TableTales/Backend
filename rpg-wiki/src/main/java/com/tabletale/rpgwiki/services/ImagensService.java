package com.tabletale.rpgwiki.services;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import com.tabletale.rpgwiki.domain.entity.*;
import com.tabletale.rpgwiki.repositories.dao.ImagensPerfilUsuarioDaoImpl;
import com.tabletale.rpgwiki.repositories.dao.ImagensPersonagensDaoImpl;
import com.tabletale.rpgwiki.repositories.dao.PersonagemDao;
import com.tabletale.rpgwiki.repositories.dao.UsuarioDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

@Service
@Transactional(readOnly = false)
public class ImagensService {

    @Autowired
    private ImagensPerfilUsuarioDaoImpl imagensUsuarioDao;

    @Autowired
    private ImagensPersonagensDaoImpl imagensPersonagensDao;

    @Autowired
    private UsuarioDao usuarioDao;

    @Autowired
    private PersonagemDao personagemDao;

    /**
    public AbstractImagens inserir(MultipartFile file) {
        AbstractImagens objeto = new AbstractImagens();

        try {
            if (!file.isEmpty()) {
                byte[] bytes = file.getBytes();
                String nomeImagem = String.valueOf(file.getOriginalFilename());
                Path caminho = Paths.get("c:/","Users/Public/Pictures","/"+ nomeImagem);
                Files.write(caminho, bytes);
                objeto.setNome(nomeImagem);

            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        objeto = imagensRepository.saveAndFlush(objeto);
        return objeto;
    }

    public void remover(Long id) {
        AbstractImagens objeto = imagensRepository.findById(id).get();
        imagensRepository.delete(objeto);
    }
*/

    //------------------------ Serviço de Imagem para o perfil do usuário -----------------------------//

    public void inserirImagemPerfilUsuario(MultipartFile file, String idUsuaio) {
        Usuario usuario = usuarioDao.findById(idUsuaio);
        ImagensPerfilUsuario imagem;

        try {
            if (!file.isEmpty()) {
                byte[] bytes = file.getBytes();
                String nomeImagem = String.valueOf(file.getOriginalFilename());
                Path caminho = Paths.get("c:/","Users/Public","/"+ nomeImagem);
                Files.write(caminho, bytes);
                imagem = new ImagensPerfilUsuario(nomeImagem, caminho.toString(), usuario);
                imagensUsuarioDao.save(imagem);
                usuario.setImagemPerfilUsuario(imagem);
                usuarioDao.update(usuario);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void buscarImagemPerfilUsuario(String id) {

    }

    //------------------------ Serviço de Imagem para os personagens -----------------------------//

    public void inserirImagemPersonagem(MultipartFile file, String idUsuaio, String idPersonagem) {
        Personagem personagem = personagemDao.buscarPersonagemUsuario(idUsuaio, idPersonagem);
        ImagensPersonagens imagem;

        try {
            if (!file.isEmpty()) {
                byte[] bytes = file.getBytes();
                String nomeImagem = String.valueOf(file.getOriginalFilename());
                Path caminho = Paths.get("c:/","Users/Public","/"+ nomeImagem);
                Files.write(caminho, bytes);
                imagem = new ImagensPersonagens(nomeImagem, caminho.toString(), personagem);
                imagensPersonagensDao.save(imagem);
                personagem.setImagemPersonagem(imagem);
                personagemDao.update(personagem);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void buscarImagemPersonagem(String id) {

    }


}