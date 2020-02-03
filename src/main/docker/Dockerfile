FROM openjdk:8-jdk-alpine
VOLUME /tmp
ADD gs-spring-boot-docker-0.1.0.jar target/app.jar
RUN bash -c 'touch target/app.jar'
ENTRYPOINT ["java","-jar","-Dspring.profiles.active=local","target/app.jar"]
