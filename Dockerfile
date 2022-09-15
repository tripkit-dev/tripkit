FROM openjdk:17-jdk-alpine

WORKDIR /app
COPY --from=0 /app/myProject /app

# This changes default user to root
USER root
# This changes ownership of folder
RUN chown -R gradle /app
# This changes the user back to the default user "gradle"
USER gradle

RUN ./gradlew build --stacktrace

# git-pull
#RUN apk update
#RUN apk add git
#RUN git clone ${GITHUB_TOKEN}@github.com/Marhead/tripkit.git

# application 빌드
RUN apk add gradle
RUN ./gradlew build

# application 결과물 -> build/libs/app.jar
ARG JAR_FILE=build/libs/*.jar
COPY ${JAR_FILE} app.jar

# TRIPKIT-SERVER INITIATE
ENTRYPOINT ["java","-jar","/app.jar"]