# Usa una imagen de Maven para construir el proyecto
FROM maven:3.9.4-eclipse-temurin-17 AS builder

# Directorio de trabajo en el contenedor de build
WORKDIR /app

# Copia todo el proyecto (incluido el pom padre y todos los módulos)
COPY . .

# Construye solo el microservicio actual, resolviendo el padre y dependencias compartidas
RUN mvn -pl accreditations -am clean package -DskipTests

# Imagen final más liviana solo con el JAR
FROM eclipse-temurin:17-jdk-alpine
WORKDIR /app

# Copia el JAR del microservicio desde el contenedor de build
COPY --from=builder /app/accreditations/target/accreditations-*.jar app.jar

# Comando de inicio
ENTRYPOINT ["java", "-jar", "app.jar"]
