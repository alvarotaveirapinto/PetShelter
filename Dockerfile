FROM openjdk:11
ARG JAR_FILE=target/backend-shelter.jar
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java", "-jar", "/app.jar"]



#docker  like box container => spring boot ==> java