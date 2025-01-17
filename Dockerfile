FROM eclipse-temurin:17-alpine
#ARG JAR_FILE=target/*.jar
EXPOSE 8080
COPY ./target/AssoManager-0.0.1-SNAPSHOT.jar assomanager.jar
ENTRYPOINT ["java", "-jar", "/assomanager.jar"]
