# Task-Manager-Backend
# Task Manager App - Backend

This is the backend API for the **Simple Task Manager App**, developed using **Spring Boot** and **PostgreSQL**.

## Features

- User signup and login with secure password hashing using **bcrypt**
- JWT token-based authentication with tokens expiring after **1 hour**
- Full CRUD (Create, Read, Update, Delete) operations on user-specific tasks
- Tasks and users stored in PostgreSQL database
- Secure REST API endpoints with JWT validation filters
- Exception handling and validation for robustness

## Tech Stack

- **Backend Framework:** Spring Boot
- **Database:** PostgreSQL
- **Authentication:** JWT (JSON Web Token)
- **Password Security:** bcrypt hashing
- **Build Tool:** Maven or Gradle
- **Java Version:** 17 (or specify your version)

## Setup & Run Instructions

### Prerequisites

- Java 17 or later installed
- PostgreSQL installed and running
- Maven or Gradle installed
- Postman or any API client (optional, for testing)

### Steps

1. Clone the repository:
   ```bash
   git clone https://github.com/dibya-prakash-bal/Task-Manager-Backend.git
   cd Task-Manager-Backend

Application properties
spring.application.name=Project name
spring.datasource.url=jdbc:postgresql://localhost:5432/Taskdb(Database name)
spring.datasource.username=name
spring.datasource.password=password
spring.datasource.driver-class-name=org.postgresql.Driver

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.PostgreSQLDialect
spring.jpa.properties.hibernate.globally_quoted_identifiers=true
spring.jpa.properties.hibernate.globally_quoted_identifiers_skip_column_definitions=true

jwt.secret=YourJWTSecretKeyHere
jwt.expiration=	3600000  # 1 hour in milliseconds

Build and run the application:

Using Maven:(run )

bash
mvn clean install
mvn spring-boot:run
Or using Gradle:


./gradlew build
./gradlew bootRun
The backend server will start on http://localhost:8080.

Use an API client to test endpoints:

POST /auth/signup — Create a new user

POST /auth/login — Login and receive JWT token

GET /tasks — Get all tasks for logged-in user (send JWT in Authorization header)

POST /tasks — Create new task

PUT /tasks/{id} — Update task

DELETE /tasks/{id} — Delete task


Assumptions
The frontend will send JWT tokens in the Authorization header as Bearer <token>

Passwords are stored only in hashed form using bcrypt

JWT tokens expire after 1 hour, requiring re-authentication or token refresh (not implemented here)

Task data is isolated per user and cannot be accessed by others

Future Improvements
Implement refresh tokens for seamless user sessions

Add role-based access control and admin features

Write integration and unit tests for API endpoints

Implement logging and monitoring

Add Swagger/OpenAPI documentation for the API
