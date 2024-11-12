FROM eclipse-temurin:21-jdk-alpine
VOLUME /tmp
COPY target/*.jar ./app.jar
ENTRYPOINT ["sh", "-c", "java -jar ./app.jar ${JAVA_ARGS}"]
