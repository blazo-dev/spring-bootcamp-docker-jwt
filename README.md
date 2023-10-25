# Dockerización de una Aplicación Spring Boot

Este archivo README proporciona una guía paso a paso para ejecutar una aplicación Spring Boot en docker, que implementa la autenticación con Spring Security y JWT (JSON Web Tokens). Asegúrate de cumplir con los requisitos y sigue estos pasos para levantar el proyecto en tu entorno.

## Requisitos

Asegúrate de tener los siguientes requisitos instalados en tu sistema:

- **Postman**: Para probar la API después de levantar la aplicación.
- **Docker**: Para contenerizar la aplicación.
- **Docker Compose**: Para simplificar la gestión de contenedores.
- **IDE**: Un entorno de desarrollo integrado como Visual Studio Code o IntelliJ IDEA para trabajar con el proyecto Spring Boot.

**Opcional** (Requisito para usar `make` en Windows):

- **Make (Opcional)**: Para automatizar la construcción y ejecución de la aplicación con los comandos definidos en el archivo Makefile. Puedes instalar `make` en Windows siguiendo estos pasos:
    - Instala el administrador de paquetes Chocolatey para Windows: [Instrucciones de instalación de Chocolatey](https://chocolatey.org/install).
    - Ejecuta el siguiente comando para instalar `make`:
      ```shell
      choco install make
      ```

**Opcional** (Requisito para usar `make` en Ubuntu):

- **Make (Opcional)**: Para automatizar la construcción y ejecución de la aplicación con los comandos definidos en el archivo Makefile. Puedes instalar `make` en Ubuntu siguiendo estos pasos:
    - Abre una terminal en tu sistema Ubuntu.
    - Ejecuta el siguiente comando para actualizar la lista de paquetes disponibles:
      ```shell
      sudo apt update
      ```
    - Una vez que se complete la actualización, puedes instalar `make` con el siguiente comando:
      ```shell
      sudo apt install make
      ```

## Endpoints Disponibles

La aplicación ofrece los siguientes endpoints para la gestión de usuarios y la autenticación:

- **Registro de Usuario (POST)**:
    - Ruta: `/api/auth/signup`
    - Cuerpo (Body):
        ```json
        {
            "email": "tu-email@example.com",
            "password": "tu-contraseña",
            "name": "Tu Nombre",
            "lastName": "Tu Apellido"
        }
        ```

- **Inicio de Sesión (POST)**:
    - Ruta: `/api/auth/signin`
    - Cuerpo (Body):
        ```json
        {
            "email": "tu-email@example.com",
            "password": "tu-contraseña"
        }
        ```

- **Obtener Todos los Usuarios (GET)**:
    - Ruta: `/api/users`
    - Requiere un Token JWT en el encabezado de autorización (Bearer Token).

- **Obtener Tu Propio Usuario (GET)**:
    - Ruta: `/api/users/me`
    - Requiere un Token JWT en el encabezado de autorización (Bearer Token).

## Pasos para Levantar el Proyecto

Sigue estos pasos para levantar la aplicación Spring Boot y ejecutarla:

**Correr la aplicación usando make**:
   Si tienes `make` instalado, puedes correr la aplicación con el siguiente comando en la terminal:

   ```shell
   make run
   ```
**Correr la aplicación manualmente**:
  ```shell
  ./mvnw clean package -DskipTests
  ```

  ```shell
  docker-compose build
  ```

  ```shell
  docker-compose up
  ```

Asegúrate de estar en el directorio raíz de tu proyecto Spring Boot al ejecutar estos comandos. Con estos comandos, podrás automatizar fácilmente la construcción y ejecución de tu aplicación Dockerizada.
