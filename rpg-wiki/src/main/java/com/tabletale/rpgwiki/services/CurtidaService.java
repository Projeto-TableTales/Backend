// package com.tabletale.rpgwiki.services;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.stereotype.Service;

// import com.tabletale.rpgwiki.domain.entity.Curtida;
// import com.tabletale.rpgwiki.domain.entity.Post;
// import com.tabletale.rpgwiki.domain.entity.Usuario;
// import com.tabletale.rpgwiki.repositories.CurtidaRepository;
// import com.tabletale.rpgwiki.repositories.dao.PostDao;

// @Service
// public class CurtidaService {

//      @Autowired
//      private CurtidaRepository curtidaRepository;
//      @Autowired
//      private PostDao postRepository;


//      public void curtirPost(String postId, Usuario usuario) throws Exception {
//           if (curtidaRepository.existsByUsuarioAndPostagem(usuario, postId)) {
//               throw new Exception("Você já curtiu este post.");
//           }
  
//           Post post = postRepository.findById(postId);
//           post.setLikes(post.getLikes()+1);
//           postRepository.save(post);
  
//           Curtida curtida = new Curtida();
//           curtida.setUsuario(usuario);
//           curtida.setPostagem(post);
//           curtidaRepository.save(curtida);
//       }

//      // public void curtirComentario(Usuario usuario, Comentario comentario) {

//      //      if (!usuarioJaCurtiu(usuario, comentario)) {
//      //           Curtida curtida = new Curtida();
//      //           curtida.setUsuario(usuario);
//      //           curtida.setComentario(comentario);
//      //           curtida.setDataCurtida(new Date());
//      //           curtidaRepository.save(curtida);
//      //      }
//      // }

//      // public void curtirPersonagem(Usuario usuario, Personagem personagem) {

//      //      if (!usuarioJaCurtiu(usuario, personagem)) {
//      //           Curtida curtida = new Curtida();
//      //           curtida.setUsuario(usuario);
//      //           curtida.setPersonagem(personagem);
//      //           curtida.setDataCurtida(new Date());
//      //           curtidaRepository.save(curtida);
//      //      }
//      // }

//      public boolean usuarioJaCurtiu(Usuario usuario, String postagemId) {
//           return curtidaRepository.existsByUsuarioAndPostagem(usuario, postagemId);
//      }



// }
