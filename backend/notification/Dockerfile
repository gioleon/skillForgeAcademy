# Utiliza la imagen de Java 17 como base
FROM openjdk:17-jdk-slim

# Establece el directorio de trabajo dentro del contenedor
WORKDIR /app

# Copia el archivo JAR de tu aplicación al contenedor
COPY ./target/notification-0.0.1-SNAPSHOT.jar /app/notification.jar

# Define las variables de entorno para tu aplicación
ENV SPRING_MAIL_HOST=smtp-mail.outlook.com \
    SPRING_MAIL_PORT=587 \
    SPRING_MAIL_USERNAME=giovannileon2018@outlook.com \
    SPRING_MAIL_PASSWORD=g3004586742 \
    SPRING_MAIL_PROPERTIES_MAIL_PROTOCOL=smtp \
    SPRING_MAIL_PROPERTIES_MAIL_TLS=true \
    SPRING_MAIL_PROPERTIES_MAIL_SMTP_AUTH=true \
    SPRING_MAIL_PROPERTIES_MAIL_SMTP_STARTTLS_ENABLE=true \
    SPRING_MAIL_PROPERTIES_MAIL_SMTP_SSL_TRUST=smtp-mail.outlook.com \
    SPRING_CLOUD_STREAM_KAFKA_BINDER_DEFAULTBROKERPORT=broker:9092 \
    SPRING_CLOUD_STREAM_BINDINGS_RECEIVEEMAIL-IN-0_DESTINATION=email.sender

# Expone el puerto en el que la aplicación escucha
EXPOSE 8081

# Comando para ejecutar la aplicación
CMD ["java", "-jar", "/app/notification.jar"]
