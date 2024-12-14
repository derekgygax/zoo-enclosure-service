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
