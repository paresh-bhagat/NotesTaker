# NotesTaker

REST API for users to save notes. It supports CRUD operations for notes. User can signup then login to generate a web token for using this API. It is based on microservices architecture.

## Tech Used

#### Java

#### Spring 
The Spring Framework is an application framework and inversion of control container for the Java platform.

#### Spring Boot
Spring Boot Tutorial provides basic and advanced concepts of Spring Framework. Our Spring Boot Tutorial is designed for beginners and professionals both. It also comes with Tomcat embedded.

### Database

#### MySQL

MySQL is an open-source relational database management system. It is used for UserService for storing user credentials. Notestaker database will be created automatically by this service if it does not exist.

#### PostgreSQL

PostgreSQL is a powerful, open source object-relational database. It is used for NoteService service here to store notes data. You need to create a notestaker database by yourself before running the service otherwise running the NoteService will throw an error.

## Tools

Postman - Postman is an API(application programming interface) development tool which helps to build, test and modify APIs

## Services

* USER-SERVICE

It uses MySQL database and handles user, signup, login, jwt authentication. After validating the token it calls the NOTE-SERVICE for notes data. it runs on port 8081.

* NOTE-SERVICE

It uses PostgreSQL database and handles CRUD operations for notes. It runs on port 8082.

* SERVICE-REGISTRY

Service registry used is Netflix Eureka server. Its primary purpose is to facilitate service discovery and registration, allowing microservices to locate and communicate with each other in a dynamic and scalable manner. It runs on port 8761.

* API-GATEWAY

API Gateway is a server or service that acts as an API front-end, receiving API requests and passing requests to the back-end service. Spring Cloud Gateway is used here. Spring Cloud Gateway is a lightweight and highly customizable API Gateway built on top of Spring Boot. It run son port 8080.

## How to use?

* Signup

With parameters "username" and "password". Also keep username and password between 1 to 20 otherwise server will return 400.

| Request | URL                                   | 
| ------- | ------------------------------------- | 
| POST    | http://localhost:8080/notestaker/signup |

* Login

With parameters "username" and "password"

| Request | URL                                  |
|---------|------------------------------------- |
| POST    | http://localhost:8080/notestaker/login |


You will get a JWT token in response after successfull login. Add the authorization header and add your token (add "Bearer" to token) for all below requests.

* Get all notes

| Request | URL                                       |
|---------|------------------------------------------ |
| GET     | http://localhost:8080/notestaker/user/notes |

* Get a note

| Request | URL                                            |
|---------|----------------------------------------------- |
| GET     | http://localhost:8080/notestaker/user/notes/{id} |

* Add a new note

With parameters "title" and "content". Skip the id otherwise server will return 400 Status code. Also keep title between 1 to 70 characters and content between 1 to 7500 characters otherwise server will return 400.

| Request | URL                                       |
|---------|------------------------------------------ |
| POST    | http://localhost:8080/notestaker/user/notes |

* Update a note

With parameters "title" and "content". Skip the id otherwise server will return 400 Status code. Also keep title between 1 to 70 characters and content between 1 to 7500 characters otherwise server will return 400.

| Request | URL                                            |
|---------|----------------------------------------------- |
| PUT     | http://localhost:8080/notestaker/user/notes/{id} |

* Delete a note

| Request | URL                                            |
|---------|----------------------------------------------- |
| DELETE  | http://localhost:8080/notestaker/user/notes/{id} |

* Delete user

| Request | URL                                 |
|---------|------------------------------------ |
| DELETE  | http://localhost:8080/notestaker/user |

### Status codes

| Status code | Meaning               |
| ----------- | --------------------- |
| 200         | Success               |
| 500         | Internal Server Error |
| 404         | Not Found             |
| 201         | Created               |
| 400         | Bad Request           |
| 501         | Not Implemented       |
| 401         | Unauthorized          |
