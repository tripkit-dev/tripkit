FROM openjdk:17-alpine as BUILDER

COPY gradlew .
COPY gradle gradle
COPY build.gradle .
COPY settings.gradle .
COPY src src
RUN chmod +x ./gradlew
RUN ./gradlew bootjar

#RUN chmod +x ./gradlew
#RUN ./gradlew bootjar

FROM openjdk:17-jdk
VOLUME /tmp
# application 결과물 -> build/libs/app.jar
ARG JAR_FILE=build/libs/*.jar
COPY ${JAR_FILE} app.jar

# TRIPKIT-SERVER INITIATE
ENTRYPOINT ["java","-jar","/app.jar"]

# multi-stage build가 아닌 해결 법으로 ``gradlew build docker``가 있지만, 이럴 경우 git pull 하기가 복잡해짐