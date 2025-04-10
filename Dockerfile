# Use a base image with Java
FROM openjdk:17-jdk-alpine

# Set working directory
WORKDIR /app

# Copy the JAR file from the build context
COPY target/*.jar app.jar

# Run the JAR
ENTRYPOINT ["java", "-jar", "app.jar"]


