FROM adoptopenjdk/openjdk11:latest
LABEL maintainer="Gustavo"

VOLUME /tmp


EXPOSE 8080

ADD target/spring-boot-docker-maven.jar spring-boot-docker-maven.jar 


ENTRYPOINT ["java", "-Djava.security.edg=file:/dev/./urandom", "-jar", "spring-boot-docker-maven.jar"]