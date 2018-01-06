FROM openjdk:8-jdk-alpine



ADD target/user-handler-0.0.1-SNAPSHOT.jar user-handler.jar
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/user-handler.jar"]