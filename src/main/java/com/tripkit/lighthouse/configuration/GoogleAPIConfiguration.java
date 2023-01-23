package com.tripkit.lighthouse.configuration;

import com.tripkit.lighthouse.injector.GoogleProperties;
import lombok.RequiredArgsConstructor;
import okhttp3.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Component
@RequiredArgsConstructor
public class GoogleAPIConfiguration {


    @Autowired
    private GoogleProperties googleAPI;


    public String findPlaceFromText(String text) {
        // Google API 주소 설정
        String googlePlaceAPIAddress = "https://maps.googleapis.com/maps/api/place/findplacefromtext/json?input=";
        String optionalFields = "name,rating,opening_hours,geometry,place_id";
        String APIkey = googleAPI.getKey();

        return googlePlaceAPIAddress + text + "&inputtype=textquery&fields=" + optionalFields + "&key=" + APIkey;
    }


    public String textSearch(String query) {
        // Google API 주소 설정
        String googlePlaceAPIAddress = "https://maps.googleapis.com/maps/api/place/textsearch/json?query=";
        String optionalFields = "name,rating,opening_hours,geometry,place_id";
        String APIkey = googleAPI.getKey();

        return googlePlaceAPIAddress + query + "&inputtype=textquery&fields=" + optionalFields + "&key=" + APIkey;
    }


    public String placeDetail(String placeId) {
        // Google API 주소 설정
        String googlePlaceAPIAddress = "https://maps.googleapis.com/maps/api/place/details/json?place_id=";
        String optionalFields = "name,rating,formatted_phone_number,formatted_address,geometry,opening_hours";
        String APIkey = googleAPI.getKey();

        return googlePlaceAPIAddress + placeId + "&inputtype=textquery&fields=" + optionalFields + "&key=" + APIkey;
    }


    public String getResponseBodyByString(String url) {
        // setting okhttpclient setting
        OkHttpClient client = new OkHttpClient().newBuilder().build();

        // set mediatype for pasing
        // set "requestbody" is ONLY for POST
        // MediaType mediaType = MediaType.parse("application/json; charset=utf-8");
        // RequestBody body = RequestBody.create(mediaType, "");

        // build request
        Request request = new Request.Builder()
                .url(url)
                .method("GET", null)
                .build();

        // get response from request
        try(Response response = client.newCall(request).execute()) {
            // response.body().string()은 일회성
            // response는 메모리에 저장되지 않음
            if (response.isSuccessful()){
                return response.body().string();
            }
            else {
                return null;
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
