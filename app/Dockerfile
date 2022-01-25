FROM openjdk:11
VOLUME /tmp
ARG JAR_FILE=target/editora-api-1.0.0.jar
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java", "-jar", "/app.jar"]