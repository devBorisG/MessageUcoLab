# Build stage
FROM maven:3.9-eclipse-temurin-17 AS build
WORKDIR /app
COPY . .
RUN mvn clean package -DskipTests

# Run stage
FROM eclipse-temurin:17-jre-jammy
WORKDIR /app

# Copy the built artifacts from the build stage
COPY --from=build /app/infrastructure/target/*.jar app.jar

# Create volume for logs
VOLUME /app/logs

# Set environment variables
ENV SERVER_PORT=8085
ENV SPRING_PROFILES_ACTIVE=prod

# Expose the application port
EXPOSE 8085

# Run the application
ENTRYPOINT ["java", "-jar", "app.jar"]