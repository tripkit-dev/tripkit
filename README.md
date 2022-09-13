# Tripkit Server

차세대 여행 계획 어플 "트립킷"의 서버

## Packages
- Java lombok
- Spring Data JPA

## Docker Integration
1. 첫 ``.jar``파일 빌드를 위하여 최상위 폴더에서 아래의 명령어 입령. 위치는 ``build/libs``에 생성
    ```bash
    $ ./gradlew bootJar
    ```
2. 다음의 ``Dockerfile``생성
    ```
    FROM openjdk:{$your-java-version}-jdk-alpine
    ARG JAR_FILE=build/libs/*.jar
    COPY ${JAR_FILE} app.jar
    ENTRYPOINT ["java","-jar","/app.jar"]
   ```
3. ``docker build -t {$docker-image-name} .`` 도커 이미지 생성
4. ``docker run {$docker-image-name}`` 도커 컨테이너 생성