package com.tabletale.rpgwiki.services;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import com.tabletale.rpgwiki.domain.entity.*;
import com.tabletale.rpgwiki.repositories.ImagemRepository;
import com.tabletale.rpgwiki.repositories.dao.CampanhaDao;
import com.tabletale.rpgwiki.repositories.dao.PostDao;
import com.tabletale.rpgwiki.repositories.dao.UsuarioDao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class ImagemService {

    @Value("${contato.disco.raiz}")
    private String raiz;

    @Value("${contato.disco.diretorio-imagens}")
    private String diretorioImagens;

    @Autowired
    private ImagemRepository imgRepository;

    @Autowired
    private UsuarioDao usuarioDao;

    @Autowired
    private PostDao postDao;

    @Autowired
    private CampanhaDao campanhaDao;

    private String salvar(String diretorio, MultipartFile arquivo, String nomeImagem) {
        Path diretorioImagemPath = Paths.get(this.raiz, diretorio);
        Path arquivoPath = diretorioImagemPath.resolve(arquivo.getOriginalFilename());

        int cont = 1;
        String nomeBase = nomeImagem;
        String extensao = "";

        if (nomeImagem.contains(".")) {
            int lastDot = nomeImagem.lastIndexOf(".");
            nomeBase = nomeImagem.substring(0, lastDot);
            extensao = nomeImagem.substring(lastDot);
        }
        while (Files.exists(arquivoPath)) {
            nomeImagem = nomeBase + "_" + cont + extensao;
            arquivoPath = diretorioImagemPath.resolve(nomeImagem);
            cont++;
        }
        try {
            Files.createDirectories(diretorioImagemPath);
            arquivo.transferTo(arquivoPath.toFile());
            return arquivoPath.toString();
        } catch (IOException e) {
            throw new RuntimeException("Problemas na tentativa de salvar o arquivo");
        }
    }

    public Imagem upImagemPost(String idPost, MultipartFile file) {
        Post postagem = postDao.findById(idPost);
        String nomeImagem = String.valueOf(file.getOriginalFilename());
        String caminho = salvar(this.diretorioImagens, file, nomeImagem);
        Imagem img = new Imagem(nomeImagem, caminho, postagem, null, null, null);

        return imgRepository.saveAndFlush(img);

    }

    public Imagem upImagemPerfil(String idUsuairo, MultipartFile file) {
        Usuario usuario = usuarioDao.findById(idUsuairo);
        String nomeImagem = String.valueOf(file.getOriginalFilename());
        String caminho = salvar(this.diretorioImagens, file, nomeImagem);
        Imagem img = new Imagem(nomeImagem, caminho, null, usuario, null, null);

        return imgRepository.saveAndFlush(img);
    }

    public Imagem upImagemCapa(String idUsuairio, MultipartFile file) {
        Usuario usuario = usuarioDao.findById(idUsuairio);
        String nomeImagem = String.valueOf(file.getOriginalFilename());
        String caminho = salvar(this.diretorioImagens, file, nomeImagem);
        Imagem img = new Imagem(nomeImagem, caminho, null, null, usuario, null);

        return imgRepository.saveAndFlush(img);

    }
    public Imagem upImagemCampanha(String idCampanha, MultipartFile file) {
        Campanha campanha = campanhaDao.findById(idCampanha);
        String nomeImagem = String.valueOf(file.getOriginalFilename());
        String caminho = salvar(this.diretorioImagens, file, nomeImagem);
        Imagem img = new Imagem(nomeImagem, caminho, null, null,null, campanha);

        return imgRepository.saveAndFlush(img);

    }

    public Imagem findPorId(Long id) {
        return imgRepository.findById(id).orElse(null);
    }

    public String remover(Long id) throws IOException {

        Imagem img = imgRepository.findById(id).get();

        File arquivoImg = new File(img.getCaminho());
        Files.delete(Paths.get(arquivoImg.getAbsolutePath()));
        imgRepository.delete(img);

        return "Imagem excluida!";

    }

}
