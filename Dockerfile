FROM eclipse-temurin:17-jre-focal

COPY target/examen-0.0.1-SNAPSHOT.jar examen.jar
ENTRYPOINT [ "java", "-jar", "/examen.jar" ]