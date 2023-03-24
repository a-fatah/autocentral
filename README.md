## autocentral

This is a simple REST API for managing car lease contracts. It is written in Java using Spring Boot and Spring Data JPA and uses mysql as the database.



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