FROM maven:3.8-openjdk-17 AS build
COPY . .
RUN mvn clean package

FROM eclipse-temurin:17-jdk-jammy
COPY --from=build target/transactions-1.2.0.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "/app.jar"]
