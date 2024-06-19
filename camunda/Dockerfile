FROM openjdk:17-jdk-slim
WORKDIR /app
COPY target/consultant-avipsa-1.0-SNAPSHOT.jar /app/app.jar
ENTRYPOINT ["java", "-jar", "app.jar"]