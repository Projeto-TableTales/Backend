package com.tabletale.rpgwiki.services;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import com.tabletale.rpgwiki.domain.entity.*;
import com.tabletale.rpgwiki.repositories.dao.*;
import com.tabletale.rpgwiki.services.exceptions.ImagemLoadException;
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

    public void inserirImagemPerfilUsuario(MultipartFile file, String idUsuaio) {
        Usuario usuario = usuarioDao.findById(idUsuaio);
        ImagemPerfil imagem;
        String nomeImagem = String.valueOf(file.getOriginalFilename());
        String caminho = salvar(this.diretorioImagensPerfil, file);
        imagem = new ImagemPerfil(nomeImagem, caminho, usuario);
        imagemPerfilDao.save(imagem);
        usuario.setImagemPerfil(imagem);
        usuarioDao.update(usuario);
    }


    //------------------------ Serviço de Imagem para os personagens -----------------------------//

    public void inserirImagemPersonagem(MultipartFile file, String idPersonagem) {
        Personagem personagem = personagemDao.findById(idPersonagem);
        ImagemPersonagem imagem;
        String nomeImagem = String.valueOf(file.getOriginalFilename());
        String caminho = salvar(this.diretorioImagensPersonagens, file);
        imagem = new ImagemPersonagem(nomeImagem, caminho, personagem);
        imagemPersonagemDao.save(imagem);
        personagem.setImagemPersonagem(imagem);
        personagemDao.update(personagem);
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