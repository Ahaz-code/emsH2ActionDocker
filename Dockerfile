FROM openjdk:17
EXPOSE 8080
ADD target/ems-h2-action-docker.jar ems-h2-action-docker.jar
ENTRYPOINT ["java","-jar","/ems-h2-action-docker.jar"]