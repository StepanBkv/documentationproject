#mvn package
#docker build --build-arg JAR_FILE=target/*.jar -t back_doc .
#docker run -p 8080:8080 back_doc

FROM eclipse-temurin:17-jdk-alpine
VOLUME /tmp
ARG JAR_FILE
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java","-jar","/app.jar"]