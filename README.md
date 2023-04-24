# Post-Service
Introduction:
This is a Post Service application built using Spring Boot. The purpose of this application is to provide CRUD operations for managing posts.

Technology Stack:
- Java 20
- Spring Boot 2.4.5
- Spring Data JPA
- PostgreSQL Database
- Maven


API Endpoints:
The following endpoints are available in this application:

1. GET /api/posts - This endpoint returns a list of all posts.
2. GET /api/posts/{id} - This endpoint returns a single post based on the provided id.
3. POST /api/posts - This endpoint creates a new post.
4. PUT /api/posts/{id} - This endpoint updates an existing post based on the provided id.
5. DELETE /api/posts/{id} - This endpoint deletes an existing post based on the provided id.

Database:
This application uses an PostgreSql database to store the data. You can access the PostgreSql console at http://localhost:http://localhost:8082/. The JDBC URL is `jdbc:postgresql://localhost:5432/postgres` and the username and password are both `sa`.

Testing:
This application has unit tests written for the service layer using JUnit and Mockito. Run `mvn test` command to run the tests.

Conclusion:
This Post Service application provides basic CRUD operations for managing posts. It can be easily extended to add more features based on your requirements.
