FROM maven:3.8.4-openjdk-17-slim AS build
WORKDIR /app

COPY pom.xml .
COPY infrastructure/pom.xml infrastructure/
COPY core/pom.xml core/
COPY utils/pom.xml utils/

RUN mvn dependency:go-offline -B

# Copiar el código fuente de todos los módulos
COPY infrastructure/src infrastructure/src
COPY core/src core/src
COPY utils/src utils/src

# Construir todos los módulos
RUN mvn clean package -DskipTests -B

# Etapa de ejecución
FROM eclipse-temurin:17-jre-alpine
WORKDIR /app

# Crear directorio de logs y dar permisos
RUN mkdir -p /app/logs && \
    chmod 777 /app/logs

# Crear usuario no root para mayor seguridad
RUN addgroup -S spring && adduser -S spring -G spring && \
    chown -R spring:spring /app/logs
USER spring:spring

# Copiar el JAR desde la etapa de construcción
COPY --from=build /app/infrastructure/target/infrastructure-0.0.1-SNAPSHOT.jar app.jar

# Configuración de variables de entorno
ENV JAVA_OPTS="-Xms512m -Xmx1024m -XX:+UseG1GC -XX:MaxGCPauseMillis=200"

# Exponer el puerto en el que se ejecutará la aplicación
EXPOSE 8085

# Comando para ejecutar la aplicación con healthcheck
HEALTHCHECK --interval=30s --timeout=3s --start-period=60s --retries=3 \
    CMD wget --no-verbose --tries=1 --spider http://localhost:8085/actuator/health || exit 1

# Comando para ejecutar la aplicación
ENTRYPOINT ["sh", "-c", "java $JAVA_OPTS -jar app.jar"]