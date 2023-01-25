FROM openjdk:17-jdk as BUILDER

#COPY gradlew .
#COPY gradle gradle
#COPY build.gradle .
#COPY settings.gradle .
#COPY src src
#RUN chmod +x ./gradlew
#RUN ./gradlew bootjar
#
#RUN chmod +x ./gradlew
#RUN ./gradlew build

WORKDIR /tripkit

COPY gradle gradle
COPY build.gradle gradlew gradlew.bat ./
COPY src src

RUN gradle build -x test

FROM openjdk:17-jdk-slim
# application 결과물 -> build/libs/app.jar
#ARG JAR_FILE=build/libs/*.jar
#COPY ${JAR_FILE} app.jar

WORKDIR /tripkit
#COPY --from=build /tripkit/src/main/resources resources
COPY --from=build /tripkit/build/libs/*.jar app.jar

# java -Dspring.profiles.active=dev -jar community.jar --spring.config.location=resources/
# java -DGOOGLE_API_KEYS="" -jar app.jar
ENTRYPOINT ["sh", "-c", "java ${JAVA_OPTS} -jar app.jar"]

# multi-stage build가 아닌 해결 법으로 ``gradlew build docker``가 있지만, 이럴 경우 git pull 하기가 복잡해짐