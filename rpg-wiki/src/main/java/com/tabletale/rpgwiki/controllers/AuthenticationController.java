package com.tabletale.rpgwiki.controllers;

import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tabletale.rpgwiki.domain.dto.AuthenticationDTO;
import com.tabletale.rpgwiki.domain.dto.LoginResponseDTO;
import com.tabletale.rpgwiki.domain.dto.RegisterDTO;
import com.tabletale.rpgwiki.domain.entity.Usuario;
import com.tabletale.rpgwiki.repositories.UserRepository;
import com.tabletale.rpgwiki.services.details.ManagerUser;
import com.tabletale.rpgwiki.services.details.TokenService;

@RestController
@RequestMapping("/rpgwiki")
public class AuthenticationController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private ManagerUser managerUser;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private TokenService tokenService;

    @PostMapping("/codigo-forgot")
    public String recuperarCodigo(@RequestBody Usuario usuario){
        return managerUser.solicitarCodigo(usuario.getEmail());
    }

    @PostMapping("/alterar-senha")
    public String alterarSenha(@RequestBody Usuario usuario){
        return managerUser.alterarSenha(usuario);
    }


    @PostMapping("/login")
    public ResponseEntity<LoginResponseDTO> login(@RequestBody @Valid AuthenticationDTO data) {
        var usernamePassword = new UsernamePasswordAuthenticationToken(data.email(), data.senha());
        var auth = this.authenticationManager.authenticate(usernamePassword);

        var token = tokenService.generateToken((Usuario) auth.getPrincipal());
        return ResponseEntity.ok(new LoginResponseDTO(token));
    }
    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody @Valid RegisterDTO data) {
        if (this.userRepository.findByEmail(data.email()) != null)
            return ResponseEntity.badRequest().build();

        String encryptedPassword = new BCryptPasswordEncoder().encode(data.senha());
        Usuario newUser = new Usuario(data.nome(), data.pais(), data.email(), data.genero(),
                encryptedPassword, data.dataNascimento());

        this.userRepository.save(newUser);

        return ResponseEntity.ok().build();
    }

}