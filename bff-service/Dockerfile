FROM openjdk:17-jdk-slim

WORKDIR /app

# Paso 3: Copiar el archivo .jar generado por Maven al contenedor
# Nota: "target/*.jar" buscará el archivo compilado. Asegúrate de haber corrido 'mvn package' antes.
COPY target/*.jar app.jar

# Paso 4: Exponer el puerto en el que corre el BFF (8084 según nuestro diseño)
EXPOSE 8084

# Paso 5: Comando para ejecutar la aplicación al iniciar el contenedor
ENTRYPOINT ["java", "-jar", "app.jar"]