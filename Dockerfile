FROM openjdk:11-jdk-slim
USER 1000
ARG JAR_FILE=app/target/*.jar
COPY ${JAR_FILE} app.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","/app.jar"]
