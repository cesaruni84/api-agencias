FROM openjdk:8
MAINTAINER cesaruni cesaruni84@gmail.com
EXPOSE 8090
ADD target/api-agencias-docker.jar api-agencias-docker.jar
ENTRYPOINT ["java", "-jar", "/api-agencias-docker.jar"]