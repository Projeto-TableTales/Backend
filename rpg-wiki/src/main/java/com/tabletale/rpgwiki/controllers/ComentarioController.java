// package com.tabletale.rpgwiki.controllers;

// import java.util.List;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.http.ResponseEntity;
// import org.springframework.web.bind.annotation.CrossOrigin;
// import org.springframework.web.bind.annotation.DeleteMapping;
// import org.springframework.web.bind.annotation.GetMapping;
// import org.springframework.web.bind.annotation.PathVariable;
// import org.springframework.web.bind.annotation.PostMapping;
// import org.springframework.web.bind.annotation.RequestBody;
// import org.springframework.web.bind.annotation.RequestMapping;
// import org.springframework.web.bind.annotation.RestController;

// import com.tabletale.rpgwiki.domain.dto.ComentarioDTO;
// import com.tabletale.rpgwiki.domain.entity.Comentario;
// import com.tabletale.rpgwiki.repositories.dao.ComentarioDao;
// import com.tabletale.rpgwiki.services.ComentarioService;

// @RestController
// @RequestMapping("/comentario")
// @CrossOrigin("*")
// public class ComentarioController {

//     @Autowired
//     private ComentarioService comentarioService;

//     @Autowired
//     private ComentarioDao comentarioRepository;

//     @GetMapping("/buscarAll")
//     public List<Comentario> buscarAllComentarios() throws Exception {
//         return comentarioService.buscarTodos();
//     }

//     @PostMapping("/criarComentario")
//     public ResponseEntity<Comentario> criarComentario(@RequestBody ComentarioDTO data) {
//         Comentario newComentario = new Comentario(data.conteudo(), data.dataComentario());
//         this.comentarioRepository.save(newComentario);
//         return ResponseEntity.ok().build();
//     }

//     @DeleteMapping("/excluirComentario/{id}")
//     public ResponseEntity<?> excluir(@PathVariable("id") String id) {
//         comentarioService.excluir(id);
//         return ResponseEntity.ok().body(comentarioService.excluir(id));
//     }
// }