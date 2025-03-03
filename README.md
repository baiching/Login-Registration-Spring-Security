# User Authentication Service with Spring Boot and JWT

A secure user authentication and authorization system built with Spring Boot, Spring Security, and JSON Web Tokens (JWT). Supports role-based access control (USER, MODERATOR, ADMIN) and integrates with PostgreSQL.

---

## Features
- **User Registration & Login**: Signup and signin endpoints with JWT token generation.
- **Role-Based Access Control**: Public, user, moderator, and admin endpoints.
- **JWT Authentication**: Stateless security using JWT tokens.
- **CORS Configuration**: Global CORS policy for cross-origin requests.
- **Validation**: Jakarta Validation for request body checks.

---

## Technologies
- **Spring Boot 3.4.2**
- Spring Security
- Spring Data JPA
- PostgreSQL
- JJWT (Java JWT Library)
- Jakarta Validation

---

## Setup

### Prerequisites
- Java 21
- Maven
- PostgreSQL

### Steps
1. **Clone the repository**:
   ```bash
   git clone [your-repository-url]
   cd signUpAndSignIn

2. Configure PostgreSQL

* **Create a database named `auth_db`**.
* **Update `src/main/resources/application.properties`**:
   ```properties
   spring.datasource.url=jdbc:postgresql://localhost:5432/auth_db
   spring.datasource.username=postgres
   spring.datasource.password=your_password
   spring.jpa.hibernate.ddl-auto=update
   jwt.secret=your_jwt_secret_key_here
3. Build and run
   ```properties
   mvn clean install
   mvn spring-boot:run

## API Endpoints

### Authentication (`AuthController.java`)

| Method | Path             | Description                                          |
|--------|-----------------|------------------------------------------------------|
| POST   | `/api/auth/signup` | Register a new user (supports roles: user, mod, admin). |
| POST   | `/api/auth/signin` | Authenticate and receive a JWT token. |

### Test Endpoints (`TestController.java`)

| Method | Path             | Access                   | Response            |
|--------|-----------------|--------------------------|----------------------|
| GET    | `/api/test/all`  | Public                   | `"Public Content"`  |
| GET    | `/api/test/user` | USER, MODERATOR, ADMIN   | `"User Content"`    |
| GET    | `/api/test/mod`  | MODERATOR                | `"Moderator Board."` |
| GET    | `/api/test/admin` | ADMIN                    | `"Admin Board."`    |

## Security Configuration (`WebSecurityConfig.java`)

- **CORS:** Allows all origins, methods, and headers.

### Public Endpoints:

- `/api/auth/**`
- `/api/test/**`
- `/error`

## JWT Filter

- **Validates tokens** in the `Authorization` header.

## Dependencies (Key)

- **`spring-boot-starter-web`**: REST API support.  
- **`spring-boot-starter-security`**: Security features.  
- **`spring-boot-starter-data-jpa`**: Database integration.  
- **`jjwt-api`, `jjwt-impl`, `jjwt-jackson`**: JWT handling.  
- **`postgresql`**: PostgreSQL driver.  
- **`jakarta.validation-api`**: Request validation.  

## License

- **MIT**

## Notes for Developers

1. **JWT Secret**: Replace `your_jwt_secret_key_here` in `application.properties` with a secure key.  
2. **Role Initialization**: Ensure `ROLE_USER`, `ROLE_MODERATOR`, and `ROLE_ADMIN` exist in your database (use SQL scripts or a `@PostConstruct` method).  
3. **Testing**: Use tools like Postman to test endpoints. Include the JWT token in the `Authorization: Bearer <token>` header for secured endpoints.  

