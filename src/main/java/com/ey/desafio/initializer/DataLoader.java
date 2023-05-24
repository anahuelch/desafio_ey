package com.ey.desafio.initializer;

import com.ey.desafio.model.User;
import com.ey.desafio.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

/**
 * Esta Clase se creó con el objetivo de poder crear un usuario por defecto al momento de levantar la API.
 * Esto porque H2 es una base de datos temporal, por lo que siempre que se levante la API, esta estará vacía.
 * Lo que hace que no tengamos ningún usuario con el que podamos autenticarnos, por lo tantro, no podemos hacer nada con la API. Como por ejemplo crear nuevos usuarios.
 * Para poder hacer esto, debemos implementar el método "run" de la clase CommandLineRunner, para que springboot lo ejecute al momento de levantar el servicio.
 */

@Component
public class DataLoader implements CommandLineRunner {
    private final UserRepository userRepository;

    @Autowired
    public DataLoader(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        /**
         * Seteamos las credenciales del usuario principal (usuario: alvaro@test.cl, contraseña: admin)
         * La contraseña va encriptada.
         */
        User user = new User();
        user.setEmail("alvaro@test.cl");
        user.setPassword(new BCryptPasswordEncoder().encode("admin"));
        user.setName("Alvaro");

        userRepository.save(user);
    }
}
