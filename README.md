# spring_security_login_system

# Spring Security 6 - Login System with Spring Data JPA and JWTs

This repository contains a simple implementation of a login system using Spring Security 6, Spring Data JPA, and JWTs. It is up-to-date as of 2023 and aims to demonstrate the integration of these technologies to secure a web application.

## Prerequisites

To run this project, you will need the following:

- Java Development Kit (JDK) 11 or later
- Maven 3.6.x or later
- Your favorite code editor

## Setup and Configuration

1. Clone the repository to your local machine.

```bash git clone https://github.com/ericmaniraguha/spring_security_login_system.git ```


## Navigate to the project directory.

cd spring-security-login

1. Build the project using Maven.

mvn clean package

2. Run the application.

mvn spring-boot:run

The application will start on http://localhost:portNumber.

## Usage

Once the application is running, you can access the login system via your web browser or use a tool like cURL or Postman to interact with the API endpoints.

## Endpoints

`POST /api/authenticate:` Authenticates a user and generates a JWT token.
`POST /api/register:` Registers a new user.
`GET /api/user/{id}:` Retrieves user information by ID.

## Configuration

You can modify the application configuration in the application.properties file located in the `src/main/resources directory.`

## Contributing

If you wish to contribute to this project, please fork the repository and create a pull request with your changes.

## License

This project is licensed under the [MIT License](https://opensource.org/licenses/MIT).

