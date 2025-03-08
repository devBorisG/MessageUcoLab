# MessageUcoLab

A Spring Boot application for message handling and processing.

## Prerequisites

- Java 17 or higher
- Maven 3.6.x or higher
- Docker (for containerized deployment)
- Docker Compose (optional, for local development)

## Project Structure

The project is organized into multiple modules:

- `core`: Core business logic and domain models
- `infrastructure`: Infrastructure layer components
- `utils`: Utility classes and helper functions

## Building the Application

### Local Build

1. Clone the repository:

```bash
git clone https://github.com/devBorisG/MessageUcoLab.git
cd MessageUcoLab
```

2. Build the project using Maven:

```bash
mvn clean install
```

## Running the Application

### Local Development

To run the application locally:

```bash
mvn spring-boot:run
```

The application will start on port 8085 by default.

### Docker Deployment

1. Build the Docker image:

```bash
docker build -t messageuco-lab:latest .
```

2. Run the container:

```bash
docker run -d -p 8085:8085 --name messageuco-lab messageuco-lab:latest
```

## Docker Compose Setup

Create a `docker-compose.yml` file in the root directory:

```yaml
version: '3.8'
services:
  app:
    build: .
    ports:
      - "8085:8085"
    environment:
      - SPRING_PROFILES_ACTIVE=prod
    networks:
      - messageuco-network

networks:
  messageuco-network:
    driver: bridge
```

To start the application using Docker Compose:

```bash
docker-compose up -d
```

## API Documentation

The API documentation is available at:

- Swagger UI: `http://localhost:8085/swagger-ui.html`
- OpenAPI JSON: `http://localhost:8085/v3/api-docs`

## Environment Variables

The following environment variables can be configured:

| Variable | Description | Default Value |
|----------|-------------|---------------|
| SERVER_PORT | Application port | 8085 |
| SPRING_PROFILES_ACTIVE | Active Spring profile | dev |

## Consuming the API

### Example API Endpoints

1. Health Check:

```bash
curl http://localhost:8085/actuator/health
```

2. API Version:

```bash
curl http://localhost:8085/api/version
```

## Monitoring and Logging

- Application logs are available in the `logs/` directory
- When running in Docker, view logs using:

```bash
docker logs messageuco-lab
```

## Troubleshooting

Common issues and solutions:

1. Port already in use:
   - Change the port using `SERVER_PORT` environment variable
   - Or stop the process using the conflicting port

2. Docker container not starting:
   - Check logs: `docker logs messageuco-lab`
   - Verify environment variables
   - Ensure sufficient system resources
