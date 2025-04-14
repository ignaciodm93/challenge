# Usa una imagen de Maven
FROM maven:3.9.4-eclipse-temurin-17 AS builder

# Crea el directorio de trabajo
WORKDIR /app

# Copia todo el proyecto (incluido el pom padre y todos los módulos)
COPY . .

# Construye solo el microservicio actual, resolviendo el padre y dependencias compartidas
RUN mvn -pl selling-points -am clean package -DskipTests

# Imagen final más liviana
FROM eclipse-temurin:17-jdk-alpine
WORKDIR /app
COPY --from=builder /app/selling-points/target/selling-points-*.jar app.jar
ENTRYPOINT ["java", "-jar", "app.jar"]
