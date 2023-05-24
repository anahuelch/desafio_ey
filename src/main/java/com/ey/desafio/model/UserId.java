package com.ey.desafio.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import java.util.UUID;

/**
 * Clase que utilizamos para definir la combinación de claves primarias para la tabla user.
 * Esta clase es llamada en User mediante la anotación @IdClass(UserId.class).
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class UserId {
    private UUID id;
    private String email;
}
