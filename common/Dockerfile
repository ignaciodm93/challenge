# Usa una imagen de Maven
FROM maven:3.9.4-eclipse-temurin-17 AS builder

# crea el directorio de trabajo
WORKDIR /app

# Copia todo el proyecto (incluido el pom padre y todos los módulos)
COPY . .

RUN mvn -pl common -am clean package -DskipTests

FROM eclipse-temurin:17-jdk-alpine
WORKDIR /app
COPY --from=builder /app/common/target/common-*.jar app.jar
ENTRYPOINT ["java", "-jar", "app.jar"]
