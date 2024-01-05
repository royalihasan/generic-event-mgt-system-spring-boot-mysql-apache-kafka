# Use the official OpenJDK image as a base image
FROM openjdk:17-jdk-alpine

# Set the working directory inside the container
WORKDIR /app

# Copy the application JAR file into the container at /app
COPY target/com.generic-event-mgt-system-0.0.1-SNAPSHOT.jar /app/

# Expose the port that your application will run on
EXPOSE 8080

# Specify the command to run on container startup
CMD ["java", "-jar", "com.generic-event-mgt-system-0.0.1-SNAPSHOT"]
