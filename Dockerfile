FROM openjdk:21
RUN mkdir /app
WORKDIR /app
COPY target/*.jar /app/app.jar
EXPOSE 8080
ENTRYPOINT java -jar app.jar