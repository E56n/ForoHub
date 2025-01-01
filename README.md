# ForoHub

Una **API RESTful** construida con **Spring Boot** que implementa un sistema básico de foros. La API permite la gestión de tópicos, usuarios y autenticación utilizando **JSON Web Tokens (JWT)**. Está diseñada para interactuar con una base de datos PostgreSQL, ofreciendo endpoints seguros y eficientes.

## Características Principales

- Listar, crear y eliminar tópicos.
- Autenticación con JSON Web Tokens (JWT).
- Configuración de seguridad con Spring Security.
- Persistencia de datos con JPA y PostgreSQL.
- Gestión de errores con códigos de estado HTTP claros e informativos.

## Tecnologías Utilizadas

- **Java 21**
- **Spring Boot 3.4.1**
- **PostgreSQL**
- **Maven**
- **Hibernate (JPA)**

## Configuración Inicial

### Prerrequisitos

Antes de comenzar, asegúrate de tener instalado:

- **Java 21**
- **Maven**
- **PostgreSQL**

### Configuración de la Base de Datos

1. Crea una base de datos en PostgreSQL:

   ```sql
   CREATE DATABASE forumdb;
   CREATE USER springuser WITH PASSWORD 'password';
   GRANT ALL PRIVILEGES ON DATABASE forumdb TO springuser;
   ```

2. Configura el archivo `application.properties` en `src/main/resources`:

   ```properties
   spring.datasource.url=jdbc:postgresql://localhost:5432/forumdb
   spring.datasource.username=springuser
   spring.datasource.password=password

   spring.jpa.hibernate.ddl-auto=update
   spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.PostgreSQLDialect

   jwt.secret=YOUR_SECRET_KEY
   jwt.expiration=86400000
   ```

### Instalación del Proyecto

1. Clona este repositorio:

   ```bash
   git clone https://github.com/tu-usuario/forum-api.git
   cd forum-api
   ```

2. Compila el proyecto usando Maven:

   ```bash
   mvn clean install
   ```

3. Ejecuta la aplicación:

   ```bash
   mvn spring-boot:run
   ```

## Uso de la API

### Endpoints Principales

| Método | Endpoint          | Descripción                   |
|--------|-------------------|-------------------------------|
| GET    | `/topicos`        | Listar todos los tópicos      |
| POST   | `/topicos`        | Crear un nuevo tópico         |
| DELETE | `/topicos/{id}`   | Eliminar un tópico específico |
| POST   | `/auth/login`     | Obtener token JWT             |

### Autenticación

Para los endpoints protegidos, se requiere un token JWT en el header de la petición:

```
Authorization: Bearer <TOKEN_JWT>
```

### Crear un Tópico

Ejemplo de cuerpo JSON para `POST /topicos`:

```json
{
  "titulo": "Mi primer tópico",
  "mensaje": "Este es el contenido del tópico",
  "usuarioId": 1
}
```

## Estructura del Proyecto

```
src/
└── main/
    ├── java/com/forum/
    │   ├── controller/      # Controladores REST
    │   ├── dto/             # Clases DTO
    │   ├── model/           # Entidades de JPA
    │   ├── repository/      # Repositorios
    │   ├── security/        # Seguridad (JWT)
    │   ├── service/         # Lógica de negocios
    │   └── ForumApplication.java # Clase principal
    └── resources/
        ├── application.properties
        └── static/          # Archivos estáticos (si es necesario)
```

## Pruebas

1. Ejecuta las pruebas unitarias con Maven:

   ```bash
   mvn test
   ```

## Contribución

Si deseas contribuir al proyecto:

1. Haz un fork del repositorio.
2. Crea una nueva rama (`git checkout -b feature/nueva-funcionalidad`).
3. Realiza tus cambios y haz un commit (`git commit -m 'Añadida nueva funcionalidad'`).
4. Haz un push a tu rama (`git push origin feature/nueva-funcionalidad`).
5. Abre un Pull Request en GitHub.

## Licencia

Este proyecto está licenciado bajo la [MIT License](LICENSE).
