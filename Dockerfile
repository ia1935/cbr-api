FROM openjdk:21-jdk-slim

WORKDIR /app

# Copy the pre-built JAR file into the container
COPY cbrapi/build/libs/cbrapi-0.0.1-SNAPSHOT.jar app.jar

EXPOSE 8080

# Run the app
ENTRYPOINT ["java", "-jar", "app.jar"]

