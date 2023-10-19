package com.tabletale.rpgwiki.testesControllers;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.stubbing.OngoingStubbing;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

import com.tabletale.rpgwiki.controllers.AuthenticationController;
import com.tabletale.rpgwiki.domain.dto.AuthenticationDTO;
import com.tabletale.rpgwiki.domain.dto.LoginResponseDTO;
import com.tabletale.rpgwiki.domain.dto.RegisterDTO;
import com.tabletale.rpgwiki.domain.entity.Usuario;
import com.tabletale.rpgwiki.domain.entity.enums.Genero;
import com.tabletale.rpgwiki.domain.entity.enums.Pais;
import com.tabletale.rpgwiki.repositories.UserRepository;
import com.tabletale.rpgwiki.services.details.ManagerUser;
import com.tabletale.rpgwiki.services.details.TokenService;

@SpringBootTest
public class AuthenticationControllerTest {

    @InjectMocks
    private AuthenticationController authenticationController;

    @Mock
    private AuthenticationManager authenticationManager;

    @Mock
    private ManagerUser managerUser;

    @Mock
    private UserRepository userRepository;

    @Mock
    private TokenService tokenService;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(authenticationController);
    }

    @Test
    public void testRecuperarCodigo() {
        // Implement your test for recuperarCodigo method here
    }

    @Test
    public void testAlterarSenha() {
        // Implement your test for alterarSenha method here
    }

    @Test
    public void testLogin() {
        // RegisterDTO auth = new RegisterDTO("John Doe", Pais.BRA, "johndoe@example.com", "12345", Genero.MASCULINO,
        //         LocalDate.of(2000, 06, 20));
        // AuthenticationDTO data = new AuthenticationDTO("johndoe@example.com", "12345");
        // when((authenticationManager.authenticate(auth))
        //         .thenReturn(new UsernamePasswordAuthenticationToken(data.email(), data.senha())));
        // when(tokenService.generateToken(any(Usuario.class))).thenReturn("token_esperado");

        // ResponseEntity<LoginResponseDTO> result = authenticationController.login(data);

        // assertEquals("token_esperado", result.getBody().token());
    }

    @Test
    public void testRegister() {
        RegisterDTO data = new RegisterDTO("John Doe", Pais.BRA, "johndoe@example.com", "12345", Genero.MASCULINO,
                LocalDate.of(2000, 06, 20));
        when(userRepository.findByEmail(data.email())).thenReturn(null);

        ResponseEntity<String> result = authenticationController.register(data);

        verify(userRepository, times(1)).save(any(Usuario.class));
        assertEquals(HttpStatus.OK, result.getStatusCode());
    }

    @Test
    public void testRegister_UsuarioJaExiste() {
        RegisterDTO data = new RegisterDTO("John Doe", Pais.BRA, "johndoe@example.com", "12345", Genero.MASCULINO,
                LocalDate.of(2000, 06, 20));

        when(userRepository.findByEmail(data.email())).thenReturn(new Usuario());

        ResponseEntity<String> result = authenticationController.register(data);

        verify(userRepository, never()).save(any(Usuario.class));

        assertEquals(HttpStatus.BAD_REQUEST, result.getStatusCode());
    }

}