# desafio_ey
 API RESTful para creación de usuarios con Springboot

IMPORTANTE:

H2 es una base de datos temporal, por lo que siempre que se levante la API, esta estará vacía.
Lo que hace que no tengamos ningún usuario con el que podamos autenticarnos, por lo tantro, no podemos hacer nada con la API. Como por ejemplo crear nuevos usuarios.
Para esto se creó un usuario por defecto con cual podemos autenticarnos y utilizar los métodos de la API.

El usuario por defecto para la obtención del token es:

usuario: alvaro@test.cl
contraseña: admin

Este usuario por defecto se configura en la clase DataLoader que se encuentra en:
    "com.ey.desafio.initializer"

El diagrama de la solucion se encuentra en la raís del proyecto y se llama:
    "diagrama_solucion.png"