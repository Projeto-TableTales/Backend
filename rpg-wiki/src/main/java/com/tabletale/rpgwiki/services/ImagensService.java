package com.tabletale.rpgwiki.services;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.tabletale.rpgwiki.domain.entity.Imagens;
import com.tabletale.rpgwiki.repositories.ImagensRepository;

@Service
public class ImagensService {

    @Autowired
    private ImagensRepository imagensRepository;

    public List<Imagens> buscarTodos() {
        return imagensRepository.findAll();
    }

    public Imagens inserir(MultipartFile file) {
        Imagens objeto = new Imagens();

        try {
            if (!file.isEmpty()) {
                byte[] bytes = file.getBytes();
                String nomeImagem = String.valueOf(file.getOriginalFilename());
                Path caminho = Paths
                        .get("c:/Users/Public/Pictures" + nomeImagem);
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
        Imagens objeto = imagensRepository.findById(id).get();
        imagensRepository.delete(objeto);
    }
}