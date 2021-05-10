FROM openjdk:11-jre-slim

EXPOSE 8080

RUN mkdir /app

COPY target/*.jar /app/app.jar

ENTRYPOINT ["java", "-XX:+UnlockExperimentalVMOptions", "-Dspring.profiles.active=docker", "-Djava.security.egd=file:/dev/./urandom", "-jar", "/app/app.jar"]
