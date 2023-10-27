# Alumni (Backend) - Networking Portal

## About This Repository

This repository houses the RESTful API code essential for data interfacing in the Alumni Networking Portal. 

## Table of Contents

- [Background](#Background)
- [Technologies](#Technologies)
- [Installation](#Installation)
- [API Documentation](#API_Documentation)
- [Maintainers](#Maintainers)
- [Contributing](#Contributing)
- [License](#License)

## Background

The Alumni Networking Portal was conceived to 
address the challenges faced by graduates in maintaining connections post-graduation. 
It offers a dedicated space designed to facilitate communication,
event organization, and networking opportunities, ensuring alumni can easily reconnect and collaborate.

### Technologies

- [Java 17](https://www.oracle.com/java/technologies/downloads/#java17)
- [Spring JPA, Spring Boot, Spring Boot Web, Spring Security](https://spring.io/projects/spring-boot)
- [PostgreSQL](https://www.postgresql.org/)
- [Gradle](https://gradle.org/)
- [Hibernate ORM](https://hibernate.org/)
- [Lombok](https://projectlombok.org/)
- [MapStruct](https://mapstruct.org/)
- [Docker](https://www.docker.com/)
- [Swagger (OpenAPI)](https://swagger.io/)

## Installation

### 1. Clone the Repository:
```shell
git clone [https://github.com/OzKara/alumni-backend]
```
### 2. Install Dependencies:
Open the project in IntelliJ. It will automatically install the necessary dependencies.

### 3. Database Configuration:
Set up a PostgreSQL database. Before running the application, set the database URL, username, and password as environment variables in the command line:

```shell
set DATABASE_URL=your_database_url
set DATABASE_USER=your_username
set DATABASE_PASS=your_password
```
**Tip**: The commands provided are for the Windows command prompt. For macOS or Linux, adjust the commands to set environment variables specific to your platform.

## API Documentation

The API Documentation (with Swagger) can be found [here](https://alumni-web.azurewebsites.net/swagger-ui/index.html#/)

Valid JWT token is required to access the endpoints.

## Maintainers

- [@Ozan Kara](https://github.com/OzKara)
- [@Lucas Tran](https://github.com/lucastrann)
- [@Henning Sletner](https://github.com/HennningS)
- [@Hashir Raja](https://github.com/hashirraja)

## Contributing

This project is currently not open for contributions.

## License

MIT © 2023 Ozan Kara, Lucas Tran, Henning Sletner & Hashir Raja
