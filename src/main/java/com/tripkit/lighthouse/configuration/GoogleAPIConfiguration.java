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
        String mainQuery = text;
        String optionalFields = "name,rating,opening_hours,geometry,place_id";
        String APIkey = googleAPI.getKey();

        String url = googlePlaceAPIAddress + mainQuery + "&inputtype=textquery&fields=" + optionalFields + "&key=" + APIkey;

        return url;
    }

    public String textSearch(String query) {
        // Google API 주소 설정
        String googlePlaceAPIAddress = "https://maps.googleapis.com/maps/api/place/textsearch/json?query=";
        String mainQuery = query;
        String optionalFields = "name,rating,opening_hours,geometry,place_id";
        String APIkey = googleAPI.getKey();

        String url = googlePlaceAPIAddress + mainQuery + "&inputtype=textquery&fields=" + optionalFields + "&key=" + APIkey;

        return url;
    }

    public List<ResponseBody> getResponseBodies(String url) {
        List<ResponseBody> responseBodies = new ArrayList<>();

        OkHttpClient client = new OkHttpClient().newBuilder()
                .build();
        MediaType mediaType = MediaType.parse("text/plain");
        RequestBody body = RequestBody.create(mediaType, "");
        Request request = new Request.Builder()
                .url(url)
//                .method("GET", body)
                .build();
        try(Response response = client.newCall(request).execute()) {
            System.out.println(response);
            System.out.println(response.body().string());
            responseBodies.add(response.body());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return responseBodies;
    }

    public List<String> getPlaceId(String url) {
        List<String> placeIds = new ArrayList<>();

        OkHttpClient client = new OkHttpClient().newBuilder()
                .build();
        MediaType mediaType = MediaType.parse("text/plain");
        RequestBody body = RequestBody.create(mediaType, "");
        Request request = new Request.Builder()
                .url(url)
//                .method("GET", body)
                .build();
        try(Response response = client.newCall(request).execute()) {
            System.out.println(response);
            System.out.println(response.body());
            response.body();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return placeIds;
    }

}
