# Engineer Registry API

A RESTful API for managing software engineers and their tech stacks, built with Spring Boot and PostgreSQL.

## Tech Stack

- **Java 21**
- **Spring Boot 4.1**
- **Spring Data JPA** — data access layer
- **PostgreSQL** — relational database
- **Docker** — local database via Docker Compose
- **Maven** — build tool

## Getting Started

### Prerequisites

- Java 21+
- Maven
- Docker & Docker Compose

### 1. Start the database

```bash
docker compose up -d
```

This spins up a PostgreSQL instance on port `5332`.

### 2. Run the application

```bash
./mvnw spring-boot:run
```

The API will be available at `http://localhost:8080`.

## API Reference

Base path: `/api/v1/software-engineers`

| Method | Endpoint              | Description                  |
|--------|-----------------------|------------------------------|
| GET    | `/`                   | Get all engineers            |
| GET    | `/{id}`               | Get engineer by ID           |
| POST   | `/`                   | Create a new engineer        |
| PUT    | `/{id}`               | Update an existing engineer  |
| DELETE | `/{id}`               | Delete an engineer           |

### Example Payloads

**Create / Update an engineer**

```json
{
  "name": "Malik",
  "techStack": "Java, Spring Boot, PostgreSQL"
}
```

**Response**

```json
{
  "id": 1,
  "name": "Malik",
  "techStack": "Java, Spring Boot, PostgreSQL"
}
```

## Project Structure

```
src/
└── main/
    ├── java/com/malik/engineerregistry/
    │   ├── Application.java              # Entry point
    │   ├── SoftwareEngineer.java         # JPA entity
    │   ├── SoftwareEngineerRepository.java  # Data access
    │   ├── SoftwareEngineerService.java  # Business logic
    │   └── SoftwareEngineerController.java  # REST endpoints
    └── resources/
        └── application.properties        # App & DB config
```

## Configuration

Database connection is configured in `src/main/resources/application.properties`.

| Property                            | Default                                         |
|-------------------------------------|-------------------------------------------------|
| `spring.datasource.url`             | `jdbc:postgresql://localhost:5332/engineer_registry` |
| `spring.datasource.username`        | `malik`                                         |
| `spring.datasource.password`        | `password`                                      |
| `spring.jpa.hibernate.ddl-auto`     | `create-drop`                                   |

> **Note:** `ddl-auto=create-drop` recreates the schema on each restart — suitable for local development.

## Running Tests

```bash
./mvnw test
```
