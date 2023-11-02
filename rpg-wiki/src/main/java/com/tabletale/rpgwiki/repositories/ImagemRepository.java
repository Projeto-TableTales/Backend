package com.tabletale.rpgwiki.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import com.tabletale.rpgwiki.domain.entity.Imagem;
import com.tabletale.rpgwiki.domain.entity.Post;
import com.tabletale.rpgwiki.domain.entity.Usuario;

@Repository
public interface ImagemRepository extends JpaRepository<Imagem, Long>  { 
    List<Imagem> findByImgPostagem(Post idPost);
    List<Imagem> findByImgPerfil(Usuario idImgPerfil);
    List<Imagem> findByImgCapa(Usuario idCapa);
}
