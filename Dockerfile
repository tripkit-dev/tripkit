FROM openjdk:17-jdk as builder

COPY gradlew .
COPY gradle gradle
COPY build.gradle .
COPY settings.gradle .
COPY src src
RUN chmod +x ./gradlew
RUN ./gradlew bootjar

FROM openjdk:17-jdk
# application 결과물 -> build/libs/app.jar
ARG JAR_FILE=build/libs/*.jar
COPY ${JAR_FILE} app.jar

# TRIPKIT-SERVER INITIATE
ENTRYPOINT ["java","-jar","/app.jar"]