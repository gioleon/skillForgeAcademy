# Utiliza la imagen de Java 17 como base
FROM openjdk:17-jdk-slim

# Establece el directorio de trabajo dentro del contenedor
WORKDIR /app

# Variables de entorno para la base de datos
ENV DB_URL=jdbc:postgresql://postgres:5433/skillforgeacademy
ENV DB_USER=postgres
ENV DB_PASSWORD=postgres

# Variables de entorno para Hibernate
ENV HIBERNATE_DDL_AUTO=create
ENV HIBERNATE_DIALECT=org.hibernate.dialect.PostgreSQLDialect

# Variable de entorno para JWT
ENV JWT_SECRET="este es el string por ahora"

# Variable de entorno para Kafka
ENV KAFKA_PORT=broker:9092

# Copiar el archivo .jar al contenedor
COPY ./target/skillForgeAcademy-0.0.1-SNAPSHOT.jar /app/skillForgeAcademy.jar

# Ejecutar la aplicación
CMD ["java", "-jar", "/app/skillForgeAcademy.jar"]
