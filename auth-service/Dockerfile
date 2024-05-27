FROM openjdk:17
EXPOSE 8085
ARG JAR_FILE=target/auth-service-1.0-SNAPSHOT.jar
ADD ${JAR_FILE} app.jar
ENTRYPOINT ["java","-jar","/app.jar"]
