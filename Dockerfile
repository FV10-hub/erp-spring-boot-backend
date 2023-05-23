FROM openjdk:17-jdk-alpine

# Copia el archivo JAR desde el directorio local al directorio de trabajo del contenedor
COPY ./target/erp-0.0.1-SNAPSHOT.jar /app/erp.jar

# Establece el directorio de trabajo como el directorio donde se encuentra el archivo JAR
WORKDIR /app

EXPOSE 8080

# Comando de inicio para ejecutar el archivo JAR
CMD ["java", "-jar", "erp.jar"]


