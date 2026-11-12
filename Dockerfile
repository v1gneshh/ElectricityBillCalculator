
# Stage 1: Build the Java application
FROM maven:3.9.9-eclipse-temurin-17 AS build

WORKDIR /app

COPY pom.xml .
COPY src ./src

RUN mvn -B clean package -DskipTests

# Stage 2: Run the application
FROM eclipse-temurin:17-jre

WORKDIR /app

COPY --from=build /app/target/ElectricityBillCalculator-1.0.0.jar app.jar

ENTRYPOINT ["java", "-cp", "app.jar", "com.example.ElectricityBillCalculator"]