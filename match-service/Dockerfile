FROM openjdk:17
VOLUME /tmp
EXPOSE 8082
ARG JAR_FILE=target/match-service-1.0-SNAPSHOT.jar
ADD ${JAR_FILE} app.jar
ENTRYPOINT ["java","-jar","/app.jar"]
