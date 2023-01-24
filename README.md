# Tripkit Server

차세대 여행 계획 어플 "트립킷"의 서버. Google Maps API를 활용하여 위치 정보를 client에게 보내준다.

## Packages / Library
- Google Maps API
- Java Lombok
- Java Jackson
- ModelMapper
- Swagger UI
- OKHttp
- Spring Data JPA
- Spring RestDocs

## Docker Integration
1. 첫 ``.jar``파일 빌드를 위하여 최상위 폴더에서 아래의 명령어 입령. 위치는 ``build/libs``에 생성
    ```bash
    $ ./gradlew bootJar
    ```
2. 다음의 ``Dockerfile``생성
    ```
    FROM openjdk:{$YOUR-JAVA-VERSION}-jdk-alpine
    ARG JAR_FILE=build/libs/*.jar
    COPY ${JAR_FILE} app.jar
    ENTRYPOINT ["java","-jar","/app.jar"]
   ```
3. ``docker build -t {$docker-image-name} .`` 도커 이미지 생성
4. ``docker run {$docker-image-name}`` 도커 컨테이너 생성

## Jackson
JSON String을 읽고 Java 객체 및 Tree로 파싱해주는 라이브러리.

## ModelMapper
Entity와 DTO간 변환 시 자동으로 매핑해주는 라이브러리.

매핑 해줄 클래스에는 setter가 있어야하고, 매핑이 되는 클래스에는 getter가 있어야한다.

## Swagger UI

## OKHttp
Square에서 제작한 REST API client 라이브러리 오픈소스 프로젝트이다. 통신을 동기화로 할지 비동기로 처리 할지 선택하여 사용할 수 있다. 스레드를 넘나들 수 없다는 단점이 있음. (스레드간에 데이터를 공유하기 위해서는 Handler를 활용해야함)