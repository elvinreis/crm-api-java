# syntax=docker/dockerfile:1
FROM openjdk:11.0.4
COPY target/crmapi-0.0.1-SNAPSHOT.jar elvincrmapi.jar
ENTRYPOINT ["java","-jar","elvincrmapi.jar"]