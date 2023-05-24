package com.ey.desafio.service;

import com.ey.desafio.model.Phone;
import com.ey.desafio.model.User;
import com.ey.desafio.repository.UserRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.*;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

/**
 * Clase que utilizamos para crear pruebas unitarias al servicio de usuarios con JUnit y Mockito.
 * Por temas de tiempo solo crearon algunos test para el método de creación.
 */

public class UserServiceTest {

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserService userService;

    @Captor
    private ArgumentCaptor<User> userCaptor;

    @BeforeEach
    public void setup() {

        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testCreateUser() throws Exception {
        // Datos de prueba
        String name = "Pepito Perez";
        String email = "pepitop@dominio.com";
        String password = "EY.123$";
        List<Phone> phones = new ArrayList<>();

        User user = new User();
        user.setId(null);
        user.setName(name);
        user.setEmail(email);
        user.setPassword(password);
        user.setPhones(phones);

        // Llamada al método de creación de usuarios
        userService.createUser(user);

        // Verificar que el método save del UserRepository fue llamado
        verify(userRepository, times(1)).save(userCaptor.capture());

        // Obtener el usuario capturado por el UserRepository
        User capturedUser = userCaptor.getValue();

        // Verificar que los datos del usuario capturado sean correctos
        Assertions.assertEquals(name, capturedUser.getName());
        Assertions.assertEquals(email, capturedUser.getEmail());
        Assertions.assertEquals(password, capturedUser.getPassword());
    }

    @Test
    public void testCreateUser_InvalidEmailFormat() throws Exception{
        // Datos de prueba
        String name = "Pepito Perez";
        String email = "pepitopdominio.com"; //correo no cumple con el formato
        String password = "EY.123$";
        List<Phone> phones = new ArrayList<>();

        User user = new User();
        user.setId(null);
        user.setName(name);
        user.setEmail(email);
        user.setPassword(password);
        user.setPhones(phones);

        // Verificación de que se produce una excepción al crear el usuario
        Assertions.assertThrows(Exception.class, () -> {
            userService.createUser(user);
        });

        // Verificar que el método save del UserRepository no fue llamado
        verify(userRepository, never()).save(any(User.class));
    }

    @Test
    public void testCreateUser_InvalidPasswordFormat() throws Exception{
        // Datos de prueba
        String name = "Pepito Perez";
        String email = "pepitop@dominio.com"; //correo no cumple con el formato
        String password = "1234";
        List<Phone> phones = new ArrayList<>();

        User user = new User();
        user.setId(null);
        user.setName(name);
        user.setEmail(email);
        user.setPassword(password);
        user.setPhones(phones);

        // Verificación de que se produce una excepción al crear el usuario
        Assertions.assertThrows(Exception.class, () -> {
            userService.createUser(user);
        });

        // Verificar que el método save del UserRepository no fue llamado
        verify(userRepository, never()).save(any(User.class));
    }
}
