# MessageUcoLab

A Spring Boot application for message handling and processing.

## Prerequisites

- Java 17 or higher
- Maven 3.6.x or higher
- Required infrastructure:
  - MongoDB (version 4.4 or higher)
  - Redis (version 6.0 or higher)
  - PostgreSQL (version 12 or higher)
  - Apache Pulsar (version 3.2.2)
  - Apache Kafka (version 7.0.0 or higher)
  - Zookeeper (version 7.0.0 or higher)
  - KSQLDB (version 0.20.0 or higher)
  - Debezium Connect (version 1.9 or higher)
  - Kong API Gateway (version 3.5 or higher)
  - Observability (optional but recommended):
    - Grafana (for metrics and logs visualization)
    - Loki (for log storage and querying)
    - OpenTelemetry Collector (for telemetry collection)
    - Prometheus (for metrics storage and querying)

## Project Structure

The project is organized into multiple modules:

- `Core`: Main business logic and domain models
- `Infrastructure`: Infrastructure layer components (contains the main application class)
- `Utils`: Utility classes and helper functions

## Infrastructure Configuration

### MongoDB

1. Install MongoDB (version 4.4 or higher)
2. Create a database named `messageuco`
3. Configure credentials in environment variables or in `application.properties`

### Redis

1. Install Redis (version 6.0 or higher)
2. Configure credentials in environment variables or in `application.properties`

### PostgreSQL

1. Install PostgreSQL (version 12 or higher)
2. Create a database named `ucolab`
3. Create a user `crosswords` with password `crosswords` (or configure according to your needs)
4. Assign permissions to the user for the database
5. If you're configuring PostgreSQL manually (without Docker), run the SQL script located at `deployment/docker/scripts/init.sql` to create the necessary tables
   > Note: If you use the provided docker-compose, this script will be executed automatically when the PostgreSQL container starts

### Apache Kafka

1. Install Apache Kafka (version 7.0.0 or higher)
2. Install Zookeeper (version 7.0.0 or higher)
3. Configure the following topics:
   - `connect-configs`
   - `connect-offsets`
   - `connect-status`

### KSQLDB

1. Install KSQLDB Server (version 0.20.0 or higher)
2. Configure to connect to Kafka cluster
3. KSQLDB Server listens on port 8088

### Debezium Connect

1. Install Debezium Connect (version 1.9 or higher)
2. Configure to connect to:
   - Kafka cluster
   - PostgreSQL database
   - MongoDB database
3. Debezium Connect listens on port 8083

### Kong API Gateway

1. Install Kong Gateway (version 3.5 or higher)
2. Configure in DB-less mode
3. Use the configuration in `deployment/docker/kong.yaml`
4. Kong Gateway exposes:
   - API Gateway on port 8000
   - Admin API on port 8001

### Apache Pulsar

1. Install Apache Pulsar (version 3.2.2)
2. Configure the service according to the official documentation
3. Create the topic `list-messageModel-topic`

### Observability Infrastructure

#### Grafana

1. Install Grafana (or use Docker)
2. Configure to connect to Prometheus and Loki
3. Import predefined dashboards for Spring Boot application monitoring

#### Loki

1. Install Loki (or use Docker)
2. Configure to receive logs from the application
3. The application is configured to send logs to Loki at `http://localhost:3100/loki/api/v1/push`

#### OpenTelemetry Collector

1. Install OpenTelemetry Collector (or use Docker)
2. Use the configuration in `deployment/docker/otel-collector-config.yaml`
3. The collector listens on ports 4317 (gRPC) and 4318 (HTTP)

#### Prometheus

1. Install Prometheus (or use Docker)
2. Use the configuration in `deployment/docker/prometheus.yml`
3. Prometheus listens on port 9090
4. The application exposes metrics at the `/actuator/prometheus` endpoint

## Environment Variables

Configure the following environment variables before running the application:

```text
# MongoDB
MONGOURI=mongodb://localhost:27017/messageuco
MONGODBHOST=localhost
MONGODBPORT=27017
MONGODBUSER=your_mongodb_user
MONGOPASSWORD=your_mongodb_password
MONGODBDATABASE=messageuco

# Redis
REDISHOST=localhost
REDISPORT=6379
REDISPASSWORD=your_redis_password
REDISDATABASE=0

# PostgreSQL
POSTGRES_HOST=localhost
POSTGRES_PORT=5435
POSTGRES_DATABASE=crs-crossword-db
POSTGRES_USERNAME=your_postgres_user
POSTGRES_PASSWORD=your_postgres_password

# Azure Key Vault (for production only)
AZURE_KEYVAULT_UCOLAB_ENDPOINT=your_azure_keyvault_endpoint

# Doppler (optional)
DOPPLERTOKEN=your_doppler_token
```

## Building the Project

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

To run the application, make sure all infrastructure dependencies are running (MongoDB, Redis, PostgreSQL, Kafka), then use Maven:

```bash
mvn spring-boot:run -pl Infrastructure
```

The application will start on port 8085 by default.

## API Documentation

API documentation is available at:

- Swagger UI: `http://localhost:8085/swagger-ui.html`
- OpenAPI JSON: `http://localhost:8085/v3/api-docs`

## API Endpoints

### Example Endpoints

1. Health check:

```bash
# Direct access
curl http://localhost:8085/actuator/health

# Through API Gateway
curl http://localhost:8000/actuator/health
```

2. Message endpoints:

```bash
# Get messages for an application
# Direct access
curl http://localhost:8085/messageucolab/v1/application/{id}/messages

# Through API Gateway
curl http://localhost:8000/messageucolab/v1/application/{id}/messages

# Get a specific message by code
# Direct access
curl http://localhost:8085/messageucolab/v1/application/{id}/message/{messageCode}

# Through API Gateway
curl http://localhost:8000/messageucolab/v1/application/{id}/message/{messageCode}

# Get token for an application
# Direct access
curl http://localhost:8085/messageucolab/v1/application/{id}/token

# Through API Gateway
curl http://localhost:8000/messageucolab/v1/application/{id}/token
```

## Monitoring and Logging

- Application logs are available in the `logs/` directory
- The application exposes Prometheus metrics at `http://localhost:8085/actuator/prometheus`
- Access to monitoring interfaces:
  - Grafana: `http://localhost:3000` (user: admin, password: admin)
  - Prometheus: `http://localhost:9090`
  - Loki: `http://localhost:3100`

## Troubleshooting

Common problems and solutions:

1. Port already in use:
   - Change the port using the `SERVER_PORT` environment variable
   - Or stop the process that is using the conflicting port

2. Connection problems with MongoDB/Redis/PostgreSQL:
   - Verify that the services are running
   - Check credentials and configurations in `application.properties`
   - Verify network connectivity

3. Compilation errors:
   - Make sure you're using Java 17
   - Clean and rebuild the project: `mvn clean install`

## Using Docker for Infrastructure (Optional)

If you prefer not to install all infrastructure components locally, you can use Docker to run them. In the `deployment/docker` folder, you'll find a `docker-compose.yml` file that you can use to start all the necessary services:

```bash
cd deployment/docker
docker-compose up -d
```

This will start:

- MongoDB (port 27017)
- Redis (port 6379)
- PostgreSQL (port 5435)
- Apache Kafka (port 9094)
- Zookeeper (port 2181)
- KSQLDB Server (port 8088)
- Debezium Connect (port 8083)
- Kong API Gateway (ports 8000, 8001)
- Observability services:
  - Grafana (port 3000)
  - Loki (port 3100)
  - OpenTelemetry Collector (ports 4317, 4318)
  - Prometheus (port 9090)

Then you can run the application connecting to these services.

### Kong Gateway Configuration

After starting the services with Docker Compose, you can access Kong Gateway at:
- API Gateway: `http://localhost:8000`
- Admin API: `http://localhost:8001`

The gateway is configured in DB-less mode using the configuration file at `deployment/docker/kong.yaml`.

### Kafka Configuration

The Kafka cluster is configured with:
- External access on port 9094
- Internal communication on port 9092
- Automatic topic creation enabled
- Single broker setup for development

### Debezium Connect Configuration

Debezium Connect is configured to:
- Connect to Kafka cluster
- Monitor PostgreSQL database changes
- Monitor MongoDB database changes
- Store configurations in Kafka topics

# Change Data Capture (CDC) Configuration

## Configuración de Debezium para PostgreSQL

Para configurar el CDC con Debezium, sigue estos pasos:

1. **Configurar el Conector de PostgreSQL**
   
   Realiza una petición POST al endpoint de Kafka Connect:
   ```bash
   curl -X POST http://localhost:8083/connectors \
   -H "Content-Type: application/json" \
   -d '{
     "name": "postgres-source-connector",    
     "config": {
       "connector.class": "io.debezium.connector.postgresql.PostgresConnector",
       "transforms.unwrap.delete.handling.mode": "drop",
       "slot.name": "debezium_slot",
       "publication.name": "debezium_publication",
       "transforms": "unwrap,extractId",
       "topic.prefix": "postgres",
       "transforms.unwrap.drop.tombstones": "false",
       "transforms.unwrap.type": "io.debezium.transforms.ExtractNewRecordState",
       "value.converter": "org.apache.kafka.connect.json.JsonConverter",
       "key.converter": "org.apache.kafka.connect.storage.StringConverter",
       "database.user": "your_postgres_user",
       "database.dbname": "crs-crossword-db",
       "database.server.name": "postgres",
       "database.port": "5432",
       "plugin.name": "pgoutput",
       "key.converter.schemas.enable": "false",
       "transforms.unwrap.unwrap.keys": "true",
       "database.hostname": "debezium-postgres",
       "transforms.extractId.type": "org.apache.kafka.connect.transforms.ExtractField$Key",
       "database.password": "your_postgres_password",
       "name": "postgres-source-connector",
       "value.converter.schemas.enable": "false",
       "transforms.unwrap.add.fields": "op,source.ts_ms",
       "transforms.extractId.field": "id",
       "table.include.list": "public.language_base_data,public.application_state_data,public.application_data,public.environment_type_data,public.environment_state_data,public.environment_data,public.functionality_state_data,public.functionality_data,public.message_category_data,public.message_type_data,public.message_state_data,public.message_data,public.message_environment_state_data,public.message_environment_data,public.parameter_data,public.represent_parameter_data,public.token_state_data,public.token_data,public.message_data_table"
     }
   }'
   ```

2. **Configurar KSQLDB**

   a. Accede al servidor KSQLDB:
   ```bash
   ksql http://localhost:8088
   ```

   b. Ejecuta los comandos SQL contenidos en el archivo `deployment/docker/scripts/ksql.sql`:
   - Creación de tablas para datos de referencia
   - Creación de streams para datos transaccionales
   - Creación de streams con joins para datos enriquecidos

3. **Configurar Conectores MongoDB**

   Realiza peticiones POST para cada conector MongoDB:
   ```bash
   # Conector para Token State
   curl -X POST http://localhost:8083/connectors \
   -H "Content-Type: application/json" \
   -d '{
     "name": "mongodb-token-state-sink",
     "config": {
       "connector.class": "com.mongodb.kafka.connect.MongoSinkConnector",
       "topics": "postgres.public.token_state_data",
       "collection": "token_state",
       "database": "messageuco",
       "document.id.strategy": "com.mongodb.kafka.connect.sink.processor.id.strategy.PartialValueStrategy",
       "document.id.strategy.partial.value.projection.list": "id",
       "connection.uri": "mongodb://your_mongodb_user:your_mongodb_password@localhost:27017/messageuco",
       "value.converter.schemas.enable": "false",
       "value.converter": "org.apache.kafka.connect.json.JsonConverter",
       "document.id.strategy.partial.value.projection.type": "allowlist",
       "errors.log.enable": "true",
       "key.converter": "org.apache.kafka.connect.storage.StringConverter"
     }
   }'

   # Conector para Token
   curl -X POST http://localhost:8083/connectors \
   -H "Content-Type: application/json" \
   -d '{
     "name": "mongodb-token-sink",
     "config": {
       "connector.class": "com.mongodb.kafka.connect.MongoSinkConnector",
       "topics": "postgres.public.token_data",
       "collection": "token",
       "database": "messageuco",
       "document.id.strategy": "com.mongodb.kafka.connect.sink.processor.id.strategy.PartialValueStrategy",
       "document.id.strategy.partial.value.projection.list": "id",
       "connection.uri": "mongodb://your_mongodb_user:your_mongodb_password@localhost:27017/messageuco",
       "value.converter.schemas.enable": "false",
       "value.converter": "org.apache.kafka.connect.json.JsonConverter",
       "document.id.strategy.partial.value.projection.type": "allowlist",
       "errors.log.enable": "true",
       "key.converter": "org.apache.kafka.connect.storage.StringConverter"
     }
   }'

   # Conector para Message Environment
   curl -X POST http://localhost:8083/connectors \
   -H "Content-Type: application/json" \
   -d '{
     "name": "mongodb-message-environment-sink",
     "config": {
       "connector.class": "com.mongodb.kafka.connect.MongoSinkConnector",
       "topics": "message_environment_data_stream",
       "collection": "message_environment",
       "database": "messageuco",
       "document.id.strategy": "com.mongodb.kafka.connect.sink.processor.id.strategy.PartialValueStrategy",
       "document.id.strategy.partial.value.projection.list": "message_environment_id",
       "connection.uri": "mongodb://your_mongodb_user:your_mongodb_password@localhost:27017/messageuco",
       "value.converter.schemas.enable": "false",
       "value.converter": "org.apache.kafka.connect.json.JsonConverter",
       "document.id.strategy.partial.value.projection.type": "allowlist",
       "errors.log.enable": "true",
       "key.converter": "org.apache.kafka.connect.storage.StringConverter"
     }
   }'

   # Conector para Messages
   curl -X POST http://localhost:8083/connectors \
   -H "Content-Type: application/json" \
   -d '{
     "name": "mongodb-message-sink",
     "config": {
       "connector.class": "com.mongodb.kafka.connect.MongoSinkConnector",
       "topics": "MESSAGE_DATA_COLLECTION",
       "collection": "messages",
       "database": "messageuco",
       "document.id.strategy": "com.mongodb.kafka.connect.sink.processor.id.strategy.PartialValueStrategy",
       "document.id.strategy.partial.value.projection.list": "message_id",
       "connection.uri": "mongodb://your_mongodb_user:your_mongodb_password@localhost:27017/messageuco",
       "value.converter.schemas.enable": "false",
       "value.converter": "org.apache.kafka.connect.json.JsonConverter",
       "document.id.strategy.partial.value.projection.type": "allowlist",
       "errors.log.enable": "true",
       "key.converter": "org.apache.kafka.connect.storage.StringConverter"
     }
   }'
   ```

## Estructura de Datos en MongoDB

Después de la configuración, los datos se sincronizarán en las siguientes colecciones de MongoDB:

- `token_state`: Estado de los tokens
- `token`: Información de tokens
- `message_environment`: Relación mensaje-entorno
- `messages`: Mensajes con información enriquecida

## Verificación

Para verificar que todo está funcionando correctamente:

1. Revisa el estado de los conectores:
   ```bash
   curl http://localhost:8083/connectors
   ```

2. Verifica los logs de los contenedores:
   ```bash
   docker-compose logs -f connect
   docker-compose logs -f kafka
   ```

3. Consulta los datos en MongoDB:
   ```bash
   mongosh "mongodb://your_mongodb_user:your_mongodb_password@localhost:27017/messageuco"
   ```
