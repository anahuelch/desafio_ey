# desafio_ey
 API RESTful para creación de usuarios con Springboot

IMPORTANTE:

H2 es una base de datos temporal, por lo que siempre que se levante la API, esta estará vacía.
Lo que hace que no tengamos ningún usuario con el que podamos autenticarnos, por lo tantro, no podemos hacer nada con la API. Como por ejemplo crear nuevos usuarios.
Para esto se creó un usuario por defecto con cual podemos autenticarnos y utilizar los métodos de la API.

El usuario por defecto para la obtención del token es:

usuario: alvaro@test.cl
contraseña: admin

Este usuario por defecto se configura por fuera, en la clase DataLoader que se encuentra en:
    "com.ey.desafio.initializer"

Para hacer login con la API, se debe enviar una solicitud POST con las credenciales en el body y en formato JSON, de esta forma:

    {
        "email": "alvaro@test.cl",
        "password": "admin"
    }

Con esto, la API nos devuelve un Bearer token en el header de la respuesta, con el que podemos autenticarnos y así poder utilizar los métodos del controlador de usuarios.

La configuración para la conexión con la base de datos se agrega en el archivo "application.properties".

El diagrama de la solucion se encuentra en la raís del proyecto y se llama:
    "diagrama_solucion.png"