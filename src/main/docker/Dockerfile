FROM openjdk:8-jdk-alpine
VOLUME /tmp
ARG JAR_FILE
COPY ${JAR_FILE} gs-spring-boot-docker-0.1.0.jar
ENTRYPOINT ["java","-jar","/gs-spring-boot-docker-0.1.0.jar"]
