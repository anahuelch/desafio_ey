package com.ey.desafio.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Clase que utilizamos para mapear los datos del usuario
 * En esta prueba se pide un output en específico al crear un nuevo usuario.
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OutputUser {
    public String id;
    public String created;
    public String modified;
    public String last_login;
    public Boolean isactive;
    public String token;
}
