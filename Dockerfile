# Use an official OpenJDK runtime as the parent image
FROM openjdk:17

# Define volume to which the external files can be mapped
VOLUME /tmp

# Expose the application port
EXPOSE 8080

# Add the application's jar to the container at /app.jar
COPY build/libs/*.jar app.jar

# Run app.jar when the container starts
ENTRYPOINT ["java", "-jar", "/app.jar"]