# MessageUcoLab

Una aplicación Spring Boot para el manejo y procesamiento de mensajes.

## Requisitos Previos

- Java 17 o superior
- Maven 3.6.x o superior
- IDE (IntelliJ IDEA, Eclipse, Visual Studio Code, etc.)
- Infraestructura necesaria:
  - MongoDB (versión 4.4 o superior)
  - Redis (versión 6.0 o superior)
  - PostgreSQL (versión 12 o superior)
  - Apache Pulsar (versión 3.2.2)
  - Observabilidad (opcional pero recomendado):
    - Grafana (para visualización de métricas y logs)
    - Loki (para almacenamiento y consulta de logs)
    - OpenTelemetry Collector (para recopilación de telemetría)
    - Prometheus (para almacenamiento y consulta de métricas)

## Estructura del Proyecto

El proyecto está organizado en múltiples módulos:

- `Core`: Lógica de negocio principal y modelos de dominio
- `Infrastructure`: Componentes de la capa de infraestructura (contiene la clase principal para ejecutar la aplicación)
- `Utils`: Clases de utilidad y funciones auxiliares

## Configuración de Infraestructura

### MongoDB

1. Instalar MongoDB (versión 4.4 o superior)
2. Crear una base de datos llamada `messageuco`
3. Configurar las credenciales en las variables de entorno o en `application.properties`

### Redis

1. Instalar Redis (versión 6.0 o superior)
2. Configurar las credenciales en las variables de entorno o en `application.properties`

### PostgreSQL

1. Instalar PostgreSQL (versión 12 o superior)
2. Crear una base de datos llamada `ucolab`
3. Crear un usuario `crosswords` con contraseña `crosswords` (o configurar según tus necesidades)
4. Asignar permisos al usuario para la base de datos
5. Si estás configurando PostgreSQL manualmente (sin Docker), ejecutar el script SQL ubicado en `deployment/docker/init.sql` para crear las tablas necesarias
   > Nota: Si utilizas el docker-compose proporcionado, este script se ejecutará automáticamente al iniciar el contenedor de PostgreSQL

### Apache Pulsar

1. Instalar Apache Pulsar (versión 3.2.2)
2. Configurar el servicio según la documentación oficial
3. Crear el topic `list-messageModel-topic`

### Infraestructura de Observabilidad

#### Grafana

1. Instalar Grafana (o usar Docker)
2. Configurar para conectarse a Prometheus y Loki
3. Importar dashboards predefinidos para monitoreo de aplicaciones Spring Boot

#### Loki

1. Instalar Loki (o usar Docker)
2. Configurar para recibir logs de la aplicación
3. La aplicación está configurada para enviar logs a Loki en `http://localhost:3100/loki/api/v1/push`

#### OpenTelemetry Collector

1. Instalar OpenTelemetry Collector (o usar Docker)
2. Usar la configuración en `deployment/docker/otel-collector-config.yaml`
3. El collector escucha en los puertos 4317 (gRPC) y 4318 (HTTP)

#### Prometheus

1. Instalar Prometheus (o usar Docker)
2. Usar la configuración en `deployment/docker/prometheus.yml`
3. Prometheus escucha en el puerto 9090
4. La aplicación expone métricas en el endpoint `/actuator/prometheus`

## Variables de Entorno

Configura las siguientes variables de entorno antes de ejecutar la aplicación:

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

# Azure Key Vault (solo para producción)
AZURE_KEYVAULT_UCOLAB_ENDPOINT=your_azure_keyvault_endpoint

# Doppler (opcional)
DOPPLERTOKEN=your_doppler_token
```

## Compilación del Proyecto

### Compilación Local

1. Clonar el repositorio:

```bash
git clone https://github.com/devBorisG/MessageUcoLab.git
cd MessageUcoLab
```

2. Compilar el proyecto usando Maven:

```bash
mvn clean install
```

## Ejecución de la Aplicación

### Ejecución desde IDE

Para ejecutar la aplicación desde tu IDE (IntelliJ IDEA, Eclipse o Visual Studio Code):

1. Asegúrate de tener todas las dependencias de infraestructura en ejecución (MongoDB, Redis, PostgreSQL, Pulsar)
2. Configura las variables de entorno necesarias en la configuración de ejecución de tu IDE
3. Abre el proyecto como un proyecto Maven
4. Localiza la clase principal: `co.edu.uco.infrastructure.init.CrossWordApplication`
5. Ejecuta esta clase como una aplicación Spring Boot

#### Configuración en IntelliJ IDEA

1. Abre el proyecto en IntelliJ IDEA
2. Ve a Run > Edit Configurations
3. Haz clic en el botón "+" y selecciona "Spring Boot"
4. Configura lo siguiente:
   - Name: MessageUcoLab
   - Main class: co.edu.uco.infrastructure.init.CrossWordApplication
   - Working directory: $MODULE_WORKING_DIR$
   - Environment variables: Configura las variables mencionadas anteriormente
5. Haz clic en "Apply" y luego en "OK"
6. Ejecuta la configuración creada

#### Configuración en Eclipse

1. Abre el proyecto en Eclipse
2. Haz clic derecho en el proyecto > Run As > Run Configurations
3. Crea una nueva configuración de "Spring Boot App"
4. Configura lo siguiente:
   - Name: MessageUcoLab
   - Project: MessageUcoLab
   - Main class: co.edu.uco.infrastructure.init.CrossWordApplication
   - En la pestaña "Environment", agrega las variables de entorno necesarias
5. Haz clic en "Apply" y luego en "Run"

#### Configuración en Visual Studio Code

1. Abre el proyecto en VS Code
2. Instala la extensión "Spring Boot Tools" si aún no la tienes
3. Crea un archivo `.vscode/launch.json` con la siguiente configuración:

```json
{
  "version": "0.2.0",
  "configurations": [
    {
      "type": "java",
      "name": "MessageUcoLab",
      "request": "launch",
      "mainClass": "co.edu.uco.infrastructure.init.CrossWordApplication",
      "projectName": "Infrastructure",
      "env": {
        "MONGOURI": "mongodb://localhost:27017/messageuco",
        "MONGODBHOST": "localhost",
        "MONGODBPORT": "27017",
        "MONGODBUSER": "your_mongodb_user",
        "MONGOPASSWORD": "your_mongodb_password",
        "MONGODBDATABASE": "messageuco",
        "REDISHOST": "localhost",
        "REDISPORT": "6379",
        "REDISPASSWORD": "your_redis_password",
        "REDISDATABASE": "0"
      }
    }
  ]
}
```

4. Ejecuta la configuración desde la pestaña "Run and Debug"

### Ejecución con Maven

También puedes ejecutar la aplicación usando Maven:

```bash
mvn spring-boot:run -pl Infrastructure
```

La aplicación se iniciará en el puerto 8085 por defecto.

## Documentación de la API

La documentación de la API está disponible en:

- Swagger UI: `http://localhost:8085/swagger-ui.html`
- OpenAPI JSON: `http://localhost:8085/v3/api-docs`

## Endpoints de la API

### Ejemplos de Endpoints

1. Verificación de salud:

```bash
curl http://localhost:8085/actuator/health
```

2. Endpoints de mensajes:

```bash
# Obtener mensajes para una aplicación
curl http://localhost:8085/messageucolab/v1/application/{id}/messages

# Obtener un mensaje específico por código
curl http://localhost:8085/messageucolab/v1/application/{id}/message/{messageCode}

# Obtener token para una aplicación
curl http://localhost:8085/messageucolab/v1/application/{id}/token
```

## Monitoreo y Logging

- Los logs de la aplicación están disponibles en el directorio `logs/`
- La aplicación expone métricas de Prometheus en `http://localhost:8085/actuator/prometheus`
- Acceso a interfaces de monitoreo:
  - Grafana: `http://localhost:3000` (usuario: admin, contraseña: admin)
  - Prometheus: `http://localhost:9090`
  - Loki: `http://localhost:3100`

## Solución de Problemas

Problemas comunes y soluciones:

1. Puerto ya en uso:
   - Cambiar el puerto usando la variable de entorno `SERVER_PORT`
   - O detener el proceso que está usando el puerto en conflicto

2. Problemas de conexión con MongoDB/Redis/PostgreSQL:
   - Verificar que los servicios estén en ejecución
   - Comprobar las credenciales y configuraciones en `application.properties`
   - Verificar la conectividad de red

3. Errores de compilación:
   - Asegurarse de usar Java 17
   - Limpiar y reconstruir el proyecto: `mvn clean install`

## Uso de Docker para Infraestructura (Opcional)

Si prefieres no instalar todos los componentes de infraestructura localmente, puedes usar Docker para ejecutarlos. En la carpeta `deployment/docker` encontrarás un archivo `docker-compose.yml` que puedes usar para levantar todos los servicios necesarios:

```bash
cd deployment/docker
docker-compose up -d
```

Esto iniciará:

- MongoDB
- Redis
- PostgreSQL (con las tablas ya creadas automáticamente mediante el script init.sql)
- Apache Pulsar
- Servicios de observabilidad:
  - Grafana (puerto 3000)
  - Loki (puerto 3100)
  - OpenTelemetry Collector (puertos 4317, 4318)
  - Prometheus (puerto 9090)

Luego puedes ejecutar la aplicación desde tu IDE conectándose a estos servicios.

### Configuración de Grafana

Después de iniciar los servicios con Docker Compose, puedes acceder a Grafana en `http://localhost:3000` con las siguientes credenciales:

- Usuario: admin
- Contraseña: admin

Se recomienda configurar las siguientes fuentes de datos:

1. Prometheus: `http://prometheus:9090`
2. Loki: `http://loki:3100`
