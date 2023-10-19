package com.tabletale.rpgwiki.services;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import com.tabletale.rpgwiki.domain.entity.*;
import com.tabletale.rpgwiki.repositories.dao.*;
import com.tabletale.rpgwiki.services.exceptions.ImagemNotFoundException;
import com.tabletale.rpgwiki.services.exceptions.LoadImagemException;
import com.tabletale.rpgwiki.services.exceptions.PersonagemNotFoundException;
import com.tabletale.rpgwiki.services.exceptions.UserNotFoundException;
import jakarta.persistence.NoResultException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

@Service
@Transactional(readOnly = false)
public class ImagemService {

    @Value("${contato.disco.raiz}")
    private String raiz;

    @Value("${contato.disco.diretorio-imagens-perfil}")
    private String diretorioImagensPerfil;

    @Value("${contato.disco.diretorio-imagens-personagem}")
    private String diretorioImagensPersonagens;

    @Value("${contato.disco.diretorio-imagens-post}")
    private String diretorioImagensPost;

    @Autowired
    private ImagemPerfilDaoImpl imagemPerfilDao;

    @Autowired
    private ImagemPersonagemDaoImpl imagemPersonagemDao;

    @Autowired
    private UsuarioDao usuarioDao;

    @Autowired
    private PersonagemDao personagemDao;

    //------------------------ Serviço de Imagem para o perfil do usuário -----------------------------//

    public void inserirImagemPerfilUsuario(MultipartFile file, String idUsuario) {
        if (usuarioDao.findById(idUsuario) == null) {
            throw new UserNotFoundException("Usuário informado não existe");
        }
        Usuario usuario = usuarioDao.findById(idUsuario);
        String nomeImagem = String.valueOf(file.getOriginalFilename());
        String caminho = salvar(this.diretorioImagensPerfil, file);
        ImagemPerfil imagem = new ImagemPerfil(nomeImagem, caminho, usuario);
        imagemPerfilDao.save(imagem);
        usuario.setImagemPerfil(imagem);
        usuarioDao.update(usuario);
    }

    @Transactional(readOnly = true)
    public byte[] buscarImagemPerfilUsuario(String idUsuario) {
        try {
            if (usuarioDao.findById(idUsuario) == null) {
                throw new UserNotFoundException("Usuário informado não existe");
            }
            ImagemPerfil imagemPerfil = imagemPerfilDao.buscarImagemPerfilUsuario(idUsuario); //Pode lançar excessão NoResultException
            File arquivoImg = new File(imagemPerfil.getCaminho());
            return Files.readAllBytes(Paths.get(arquivoImg.getAbsolutePath()));
        }
        catch (NoResultException | IOException e) {
            if (e.getClass() == NoResultException.class) {
                throw new ImagemNotFoundException("Usuário não possui imagem de perfil");
            }
            else {
                throw new LoadImagemException("Problema ao carregar imagem: " + e.getMessage());
            }
        }
    }

    public String excluirImagemPerfilUsuario(String idUsuario) {
        try {
            if (usuarioDao.findById(idUsuario) == null) {
                throw new UserNotFoundException("Usuário informado não existe");
            }
            Usuario usuario = usuarioDao.findById(idUsuario);
            ImagemPerfil imagemPerfil = imagemPerfilDao.buscarImagemPerfilUsuario(idUsuario);
            File arquivoImg = new File(imagemPerfil.getCaminho());
            Files.delete(Paths.get(arquivoImg.getAbsolutePath()));
            imagemPerfilDao.delete(imagemPerfil.getId());
            usuario.setImagemPerfil(null);
            usuarioDao.update(usuario);
            return "Imagem excluida com sucesso";
        }
        catch (NoResultException | IOException e) {
            if (e.getClass() == NoResultException.class) {
                throw new ImagemNotFoundException("Usuário não possui imagem de perfil");
            }
            else {
                throw new LoadImagemException("Problema ao carregar imagem: " + e.getMessage());
            }
        }
    }

    //------------------------ Serviço de Imagem para os personagens -----------------------------//

    public void inserirImagemPersonagem(MultipartFile file, String idPersonagem) {
        Personagem personagem = personagemDao.findById(idPersonagem);
        String nomeImagem = String.valueOf(file.getOriginalFilename());
        String caminho = salvar(this.diretorioImagensPersonagens, file);
        ImagemPersonagem imagem = new ImagemPersonagem(nomeImagem, caminho, personagem);
        imagemPersonagemDao.save(imagem);
        personagem.setImagemPersonagem(imagem);
        personagemDao.update(personagem);
    }

    @Transactional(readOnly = true)
    public byte[] buscarImagemPersonagem(String idPersonagem) {
        try {
            ImagemPersonagem imagemPersonagem = imagemPersonagemDao.buscarImagemPersonagem(idPersonagem);
            File arquivoImg = new File(imagemPersonagem.getCaminho());
            return Files.readAllBytes(Paths.get(arquivoImg.getAbsolutePath()));
        }
        catch (NoResultException | IOException e) {
            if (e.getClass() == NoResultException.class) {
                throw new ImagemNotFoundException("Personagem não possui imagem");
            }
            else {
                throw new LoadImagemException("Problema ao carregar imagem: " + e.getMessage());
            }
        }
    }

    public String excluirImagemPersonagem(String idPersonagem) {
        try {
            if (personagemDao.findById(idPersonagem) == null) {
                throw new PersonagemNotFoundException("Personagem não existe");
            }
            Personagem personagem = personagemDao.findById(idPersonagem);
            ImagemPersonagem imagemPersonagem = imagemPersonagemDao.buscarImagemPersonagem(idPersonagem);
            File arquivoImg = new File(imagemPersonagem.getCaminho());
            Files.delete(Paths.get(arquivoImg.getAbsolutePath()));
            imagemPersonagemDao.delete(imagemPersonagem.getId());
            personagem.setImagemPersonagem(null);
            personagemDao.update(personagem);
            return "Imagem excluida com sucesso";
        }
        catch (NoResultException | IOException e) {
            if (e.getClass() == NoResultException.class) {
                throw new ImagemNotFoundException("Personagem não possui imagem");
            }
            else {
                throw new LoadImagemException("Problema ao carregar imagem: " + e.getMessage());
            }
        }
    }

    //------------------------ Serviço de Imagem para o perfil do usuário -----------------------------//


    public void inserirImagemPost(MultipartFile file, String idPost) {

    }


    //------------------------ Função Auxiliar ---------------//

    private String salvar(String diretorio, MultipartFile arquivo) {
        Path diretorioImagemPath = Paths.get(this.raiz, diretorio);
        Path arquivoPath = diretorioImagemPath.resolve(arquivo.getOriginalFilename());

        try {
            Files.createDirectories(diretorioImagemPath);
            arquivo.transferTo(arquivoPath.toFile());
            return arquivoPath.toString();
        }
        catch (IOException e) {
            throw new RuntimeException("Problemas na tentativa de salvar o arquivo");
        }
    }


}