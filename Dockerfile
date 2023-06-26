#Dockerfile will build app and create image
# Note: No need of explicit build for jar file
FROM openjdk:17
WORKDIR /Users/adityabarik/Downloads/Alertify
COPY . .
RUN ./mvnw clean package -DskipTests
COPY target/*.jar app.jar
ENTRYPOINT ["java","-jar","/app.jar"]
