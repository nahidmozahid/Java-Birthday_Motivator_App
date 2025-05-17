# Use Maven to build the app
FROM maven:3.9.4-eclipse-temurin-17 AS build

WORKDIR /app

# Copy pom.xml and source code
COPY pom.xml .
COPY src ./src

# Package the app
RUN mvn clean package -DskipTests

# Use a minimal JRE image to run the app
FROM eclipse-temurin:17-jre-alpine

WORKDIR /app

# Copy the jar from the build stage
COPY --from=build /app/target/birthday-motivator-web-1.0.0.jar app.jar


# Expose port 8080
EXPOSE 8080

# Run the jar file
ENTRYPOINT ["java", "-jar", "app.jar"]
