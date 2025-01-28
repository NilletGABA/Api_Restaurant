FROM openjdk:21-jdk-slim
ARG JAR_FILE=target/Api_Restaurant-0.0.1.jar
COPY ${JAR_FILE} Api_Restaurant.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "Api_Restaurant.jar"]