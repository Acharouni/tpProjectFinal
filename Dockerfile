FROM maven:3.8.3-openjdk-11 AS build
WORKDIR /app
COPY pom.xml .
COPY mvnw .
COPY mvnw.cmd .
COPY .mvn .mvn
COPY src src
RUN mvn clean install -DskipTests
FROM openjdk:11-jre-slim
WORKDIR /app
COPY --from=build /app/target/app-1.0-SNAPSHOT.jar /app/tpProject.jar
EXPOSE 9090
CMD ["java", "-jar", "tpProject.jar"]
