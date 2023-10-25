# Makefile para automatizar la construcción y ejecución de la aplicación

# Paso 1: Empaquetar la aplicación
package:
	./mvnw clean package -DskipTests

# Paso 2: Construir las imágenes de Docker
build:
	docker-compose build

# Paso 3: Levantar la aplicación con Docker Compose
up:
	docker-compose up

# Comando para ejecutar los tres pasos en orden
run: package build up

# Comando para detener y eliminar los contenedores
down:
	docker-compose down

# Comando para limpiar todos los contenedores e imágenes
clean:
	docker-compose down -v
	docker system prune -f

# Comando por defecto (ayuda)
help:
	@echo "Uso: make [package|build|up|run|down|clean|help]"

.PHONY: package build up run down clean help