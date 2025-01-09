# Enclosure Service

The `enclosure-service` is a Spring Boot microservice designed to manage the enclosures within a zoo. It provides functionality to create, update, retrieve, and delete enclosures while ensuring secure access through JWT-based authentication.

## Features

- Manage enclosures in the zoo:
  - Create new enclosures.
  - Update existing enclosures.
  - Retrieve details of enclosures.
  - Delete enclosures.
- Secure API endpoints using Spring Security with JWT authentication.
- Integration with PostgreSQL as the production database.
- In-memory H2 database for development and testing.

## Requirements

- Java 17
- Maven 3.6+
- PostgreSQL (for production)

## Setup

### Clone the Repository
```bash
git clone https://github.com/derekgygax/zoo-enclosure-service.git
cd zoo-enclosure-service
```

### Configuration

Update the `application.properties` or `application.yml` file with your database and security configurations.

For example:
```properties
# Database configuration
spring.datasource.url=jdbc:postgresql://localhost:5432/zoo_enclosures
spring.datasource.username=your_username
spring.datasource.password=your_password

# JWT Configuration
jwt.secret=your_jwt_secret
jwt.expiration=3600000
```

### Build and Run

#### Build the Application
```bash
mvn clean install
```

#### Run the Application
```bash
mvn spring-boot:run
```

The application will start on `http://localhost:8080` by default.

## API Endpoints

### Public Endpoints

- **Health Check**
  - `GET /health`
  - Description: Verifies the service is running.

### Secured Endpoints (Require JWT Authentication)

- **Get All Enclosures**
  - `GET /api/v1/enclosures`
  - Description: Retrieves a list of all enclosures.

- **Get Enclosure by ID**
  - `GET /api/v1/enclosures/{id}`
  - Description: Retrieves the details of a specific enclosure.

- **Create Enclosure**
  - `POST /api/v1/enclosures`
  - Description: Creates a new enclosure.

- **Update Enclosure**
  - `PUT /api/v1/enclosures/{id}`
  - Description: Updates an existing enclosure.

- **Delete Enclosure**
  - `DELETE /api/v1/enclosures/{id}`
  - Description: Deletes a specific enclosure.

## Running Tests

Run unit and integration tests using:
```bash
mvn test
```

## Development

### Database
- **H2**: Used for development and testing (in-memory).
- **PostgreSQL**: Used for production.

### Authentication
- JWT (JSON Web Token) is used for securing API endpoints. Make sure to configure the `jwt.secret` in `application.properties`.

## Contribution Guidelines

1. Fork the repository.
2. Create a feature branch.
3. Commit your changes.
4. Push to the branch.
5. Open a pull request.

## License

This project is licensed under the [MIT License](LICENSE).

## Repository

The repository for this project is hosted at: [https://github.com/derekgygax/zoo-enclosure-service.git](https://github.com/derekgygax/zoo-enclosure-service.git)


# enclosure-service

This project uses Quarkus, the Supersonic Subatomic Java Framework.

If you want to learn more about Quarkus, please visit its website: <https://quarkus.io/>.

## Running the application in dev mode

You can run your application in dev mode that enables live coding using:

```shell script
./mvnw quarkus:dev
```

> **_NOTE:_**  Quarkus now ships with a Dev UI, which is available in dev mode only at <http://localhost:8080/q/dev/>.

## Packaging and running the application

The application can be packaged using:

```shell script
./mvnw package
```

It produces the `quarkus-run.jar` file in the `target/quarkus-app/` directory.
Be aware that it’s not an _über-jar_ as the dependencies are copied into the `target/quarkus-app/lib/` directory.

The application is now runnable using `java -jar target/quarkus-app/quarkus-run.jar`.

If you want to build an _über-jar_, execute the following command:

```shell script
./mvnw package -Dquarkus.package.jar.type=uber-jar
```

The application, packaged as an _über-jar_, is now runnable using `java -jar target/*-runner.jar`.

## Creating a native executable

You can create a native executable using:

```shell script
./mvnw package -Dnative
```

Or, if you don't have GraalVM installed, you can run the native executable build in a container using:

```shell script
./mvnw package -Dnative -Dquarkus.native.container-build=true
```

You can then execute your native executable with: `./target/enclosure-service-0.0.1-SNAPSHOT-runner`

If you want to learn more about building native executables, please consult <https://quarkus.io/guides/maven-tooling>.

## Related Guides

- REST ([guide](https://quarkus.io/guides/rest)): A Jakarta REST implementation utilizing build time processing and Vert.x. This extension is not compatible with the quarkus-resteasy extension, or any of the extensions that depend on it.
- Hibernate ORM ([guide](https://quarkus.io/guides/hibernate-orm)): Define your persistent model with Hibernate ORM and Jakarta Persistence
- JDBC Driver - H2 ([guide](https://quarkus.io/guides/datasource)): Connect to the H2 database via JDBC
- SmallRye OpenAPI ([guide](https://quarkus.io/guides/openapi-swaggerui)): Document your REST APIs with OpenAPI - comes with Swagger UI
- REST Jackson ([guide](https://quarkus.io/guides/rest#json-serialisation)): Jackson serialization support for Quarkus REST. This extension is not compatible with the quarkus-resteasy extension, or any of the extensions that depend on it
- OpenID Connect ([guide](https://quarkus.io/guides/security-openid-connect)): Verify Bearer access tokens and authenticate users with Authorization Code Flow
- Hibernate ORM with Panache ([guide](https://quarkus.io/guides/hibernate-orm-panache)): Simplify your persistence code for Hibernate ORM via the active record or the repository pattern
- Security JPA ([guide](https://quarkus.io/guides/security-getting-started)): Secure your applications with username/password stored in a database via Jakarta Persistence
- JDBC Driver - PostgreSQL ([guide](https://quarkus.io/guides/datasource)): Connect to the PostgreSQL database via JDBC
