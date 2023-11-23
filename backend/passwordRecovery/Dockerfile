# Utiliza la imagen de Golang 1.20 como base
FROM golang:1.20

# Establece el directorio de trabajo dentro del contenedor
WORKDIR /app

# Copia el código fuente de tu aplicación al contenedor
COPY . .

# Descarga las dependencias del módulo Go
RUN go mod download

# Compila la aplicación
RUN go build -o passwordRecovery ./cmd

# Expone el puerto en el que la aplicación escucha
EXPOSE 8088

# Comando para ejecutar la aplicación
CMD ["./passwordRecovery"]
