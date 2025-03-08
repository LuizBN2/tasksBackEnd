FROM openjdk:17-jdk-alpine
COPY target/task-0.0.1-SNAPSHOT.jar tasks-app.jar
ENTRYPOINT ["java", "-jar", "tasks-app.jar"]