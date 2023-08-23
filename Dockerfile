FROM eclipse-temurin:17-jre-focal
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} examen.jar
ENTRYPOINT ["java","-jar","/examen.jar"]