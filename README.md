# Dockerización de una Aplicación Spring Boot con JWT

Este archivo Readme proporciona una guía paso a paso para dockerizar una aplicación Spring Boot e implementar la autenticación JWT. Asegúrate de cumplir con los requisitos y sigue estos pasos para levantar el proyecto en tu entorno.

## Requisitos

Asegúrate de tener los siguientes requisitos instalados en tu sistema:

- **Postman**: Para probar la API después de levantar la aplicación.
- **Docker**: Para contenerizar la aplicación.
- **Docker Compose**: Para simplificar la gestión de contenedores.
- **IDE**: Un entorno de desarrollo integrado como Visual Studio Code o IntelliJ IDEA para trabajar con el proyecto Spring Boot.

## Pasos para Levantar el Proyecto

Sigue estos pasos para dockerizar la aplicación Spring Boot y ejecutarla con JWT:

1. **Descargar el Proyecto**:
   - Clona o descarga el proyecto desde el repositorio.

2. **Abrir el Proyecto**:
   - Abre el proyecto en tu IDE preferido.

3. **Compilar el Proyecto**:
   - Abre una terminal en la carpeta raíz del proyecto.
   - Ejecuta el siguiente comando para compilar el proyecto y generar el paquete:
     ```shell
     ./mvnw clean package -DskipTests
     ```

4. **Construir la Imagen Docker**:
   - Asegúrate de que Docker esté en funcionamiento.
   - En la terminal, ejecuta el siguiente comando para construir la imagen Docker:
     ```shell
     docker-compose build
     ```

5. **Ejecutar la Aplicación en un Contenedor Docker**:
   - Una vez que se complete la construcción de la imagen, ejecuta el siguiente comando para iniciar la aplicación en un contenedor:
     ```shell
     docker-compose up
     ```

6. **Probar la API con Postman**:
   - Abre Postman y utiliza las siguientes rutas para probar la API:

     - Obtener todos los usuarios (GET):
       ```
       http://localhost:8080/api/users
       ```

     - Obtener un usuario (GET):
       ```
       http://localhost:8080/api/users/{id}
       ```

     - Crear un usuario (POST):
       ```
       http://localhost:8080/api/users
       ```

     **Cuerpo (Body)**:
     ```json
     {
       "name": "John Doe"
     }
     ```

## Notas Adicionales

- Asegúrate de que el contenedor de Docker esté en funcionamiento antes de probar la API.
