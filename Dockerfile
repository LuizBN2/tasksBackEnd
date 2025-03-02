# Usa una imagen oficial de Java como base
FROM openjdk:11-jdk-slim

# Instalar Maven
RUN apt-get update && apt-get install -y maven

# Establece el directorio de trabajo
WORKDIR /app

# Copiar los archivos del proyecto en el contenedor
COPY . /app

# Ejecutar el comando de construcción Maven
RUN mvn clean package -DskipTests

# Exponer el puerto en el que la aplicación Spring Boot correrá
EXPOSE 8080

# Comando para ejecutar la aplicación Spring Boot
CMD ["java", "-jar", "target/*.jar"]
