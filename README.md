## autocentral

This is a simple REST API for managing car lease contracts. It is written in Java using Spring Boot and Spring Data JPA and uses mysql as the database.

It uses Flyway for database migrations including the initial schema creation and data seeding.

### Prerequisites

- Java 11
- Docker
- Gradle
- MySQL


### Models

- `Vehicle` - a car that can be leased
- `Contract` - a lease contract for a vehicle
- `Customer` - a customer who can lease a vehicle

### Endpoints
The REST endpoints are exposed by Spring Data REST. The following endpoints are available:

- `GET /vehicles` - list all vehicles
- `GET /vehicles/{id}` - get a vehicle by id
- `POST /vehicles` - create a new vehicle
- `PUT /vehicles/{id}` - update a vehicle
- `PATCH /vehicles/{id}` - partially update a vehicle
- `DELETE /vehicles/{id}` - delete a vehicle
- `GET /contracts` - list all contracts
- `GET /contracts/{id}` - get a contract by id
- `POST /contracts` - create a new contract
- `PUT /contracts/{id}` - update a contract
- `PATCH /contracts/{id}` - partially update a contract
- `DELETE /contracts/{id}` - delete a contract
- `GET /customers` - list all customers
- `GET /customers/{id}` - get a customer by id
- `POST /customers` - create a new customer
- `PUT /customers/{id}` - update a customer
- `PATCH /customers/{id}` - partially update a customer
- `DELETE /customers/{id}` - delete a customer


### Running the tests

The tests can be run using the following command:

    ./gradlew test

### Building the application

The application can be built using the following command:

    ./gradlew build

### Building the docker image

The docker image can be built using the following command:

    ./gradlew bootBuildImage

### Running the application

The application can be run using the following command:

    ./gradlew bootRun

### Running the application in containerized environment with a database

The application can be run in a containerized environment using the following command:

    docker-compose up

In order to run the application in a containerized environment, the following environment variables need to be set:

- `MYSQL_ROOT_PASSWORD` - the root password for the mysql database
- `MYSQL_PASSWORD` - the password for the database

In order to create environment variables, create a `.env` file in the root directory of the project and add the following lines:

    MYSQL_ROOT_PASSWORD=secret
    MYSQL_PASSWORD=secret

