package com.tripkit.lighthouse.service;

import com.tripkit.lighthouse.injector.GoogleProperties;
import okhttp3.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.restdocs.AutoConfigureRestDocs;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;

@AutoConfigureMockMvc
@AutoConfigureRestDocs
@SpringBootTest
class SpotServiceTest {
    @Autowired
    SpotService spotService;
    @Autowired
    GoogleProperties googleAPI;

    @Test
    @DisplayName("카테고리로 Spot 가져오기")
    void getSpotByCategory() {
    }

    @Test
    @DisplayName("위치정보 더하기")
    void addSpot() {
    }

    @Test
    @DisplayName("Title로 위치정보 가져오기")
    void getSpotByTitle() {
        // API 설정
//        String googlePlaceAPI = "https://maps.googleapis.com/maps/api/place/findplacefromtext/json?input=";
//        String mainQuery = "카페";
//        String optionalFields = "name,rating,opening_hours,geometry,place_id";
//        String APIkey = googleAPI.getKey();
//
//        String url = googlePlaceAPI + mainQuery + "&inputtype=textquery&fields=" + optionalFields + "&key=" + APIkey;
//
//        // API 요청 빌드 시작 부분
//        OkHttpClient client = new OkHttpClient().newBuilder()
//                .build();
//        MediaType mediaType = MediaType.parse("text/plain");
//        RequestBody body = RequestBody.create(mediaType, "");
//        Request request = new Request.Builder()
//                .url(url)
////                .method("GET", body)
//                .build();
//        try(Response response = client.newCall(request).execute()) {
//            System.out.println(response);
//            System.out.println(response.body());
//
//            response.body();
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
    }

    @Test
    @DisplayName("태그로 위치정보 가져오기")
    void getSpotByTag() {
    }
}