FROM openjdk:8-jdk-alpine
VOLUME /tmp
ADD gs-spring-boot-docker-0.1.0.jar gs-spring-boot-docker-0.1.0.jar
RUN bash -c 'touch /gs-spring-boot-docker-0.1.0.jar'
ENTRYPOINT ["java","-jar","-Dspring.profiles.active=local","/gs-spring-boot-docker-0.1.0.jar"]
