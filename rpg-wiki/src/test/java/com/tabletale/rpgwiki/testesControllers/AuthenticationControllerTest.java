package com.tabletale.rpgwiki.testesControllers;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.userdetails.UserDetails;

import com.tabletale.rpgwiki.controllers.AuthenticationController;
import com.tabletale.rpgwiki.domain.dto.RegisterDTO;
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
        // Implement your test for login method here
    }

    @Test
    public void testRegister() {
        // Crie um objeto RegisterDTO de exemplo
        RegisterDTO testData = new RegisterDTO("John Doe", Pais.BRA, "johndoe@example.com", "12345", Genero.MASCULINO,
                LocalDate.of(204, 05, 24));

        // Simule o comportamento do UserRepository para retornar null, indicando que o
        // email não existe no banco de dados
        when(userRepository.findByEmail(toString())).thenReturn(null);

        // Simule o comportamento do BCryptPasswordEncoder para retornar a senha
        // criptografada
        when(bCryptPasswordEncoder.encode("password")).thenReturn("encryptedPassword");

        // Chame o método register na classe AuthenticationController
        ResponseEntity<String> response = authenticationController.register(testData);

        // Verifique se o UserRepository foi chamado para procurar o email
        verify(userRepository, times(1)).findByEmail("johndoe@example.com");

        // Verifique se o UserRepository foi chamado para salvar um novo usuário
        verify(userRepository, times(1)).save(any(Usuario.class));

        // Verifique se a resposta HTTP é OK (200)
        assertEquals(200, response.getStatusCodeValue());

        // Você também pode verificar o corpo da resposta, se necessário
        // assertEquals("Mensagem de sucesso esper
    }

    private Object when(UserDetails findByEmail) {
        return null;
    }
}