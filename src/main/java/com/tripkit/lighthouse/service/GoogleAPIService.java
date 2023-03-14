package com.tripkit.lighthouse.service;

import com.google.maps.FindPlaceFromTextRequest;
import com.google.maps.FindPlaceFromTextRequest.*;
import com.google.maps.GeoApiContext;
import com.google.maps.PlaceDetailsRequest;
import com.google.maps.TextSearchRequest;
import com.google.maps.errors.ApiException;
import com.google.maps.model.FindPlaceFromText;
import com.google.maps.model.PlaceDetails;
import com.google.maps.model.PlacesSearchResult;
import com.tripkit.lighthouse.injector.GoogleProperties;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

@Component
@RequiredArgsConstructor
public class GoogleAPIService {

    @Autowired
    private final GoogleProperties googleAPI;

    private final GeoApiContext context;

    public List<PlacesSearchResult> findPlaceFromText(String text) throws ApiException, InterruptedException, IOException {
        try {
            FindPlaceFromTextRequest request = new FindPlaceFromTextRequest(context)
                    .input(text)
                    .fields(FieldMask.BUSINESS_STATUS,
                            FieldMask.FORMATTED_ADDRESS,
                            FieldMask.GEOMETRY,
                            FieldMask.ICON,
                            FieldMask.ID,
                            FieldMask.NAME,
                            FieldMask.OPENING_HOURS,
                            FieldMask.PHOTOS,
                            FieldMask.PLACE_ID,
                            FieldMask.PRICE_LEVEL,
                            FieldMask.RATING,
                            FieldMask.TYPES)
                    .inputType(InputType.TEXT_QUERY)
                    .language("ko");
            FindPlaceFromText response = request.await();

            return List.of(response.candidates);
        } catch (ApiException | InterruptedException | IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public String getPlaceId(String text) throws ApiException, InterruptedException, IOException {
        try {
            FindPlaceFromTextRequest request = new FindPlaceFromTextRequest(context)
                    .input(text)
                    .fields(FieldMask.PLACE_ID)
                    .inputType(InputType.TEXT_QUERY)
                    .language("ko");
            FindPlaceFromText response = request.await();

            return response.candidates[0].placeId;
        } catch (ApiException | InterruptedException | IOException e) {
            e.printStackTrace();
            return null;
        }
    }


    public List<PlacesSearchResult> textSearch(String query) throws ApiException, InterruptedException, IOException {
        try {
            TextSearchRequest request = new TextSearchRequest(context)
                    .query(query)
                    .language("ko");

            PlacesSearchResult[] results = request.await().results;

            return Arrays.asList(results);
        } catch (ApiException | InterruptedException | IOException e) {
            e.printStackTrace();
        }
        return null;
    }


    public PlaceDetails placeDetail(String placeId) {
        try {
            PlaceDetailsRequest request = new PlaceDetailsRequest(context)
                    .placeId(placeId)
                    .language("ko");
            return request.await();
        } catch (ApiException | InterruptedException | IOException e) {
            e.printStackTrace();
            return null;
        }
    }


//    public String getResponseBodyByString(String url) {
//        // setting okhttpclient setting
//        OkHttpClient client = new OkHttpClient().newBuilder().build();
//
//        // set mediatype for pasing
//        // set "requestbody" is ONLY for POST
//        // MediaType mediaType = MediaType.parse("application/json; charset=utf-8");
//        // RequestBody body = RequestBody.create(mediaType, "");
//
//        // build request
//        Request request = new Request.Builder()
//                .url(url)
//                .method("GET", null)
//                .build();
//
//        // get response from request
//        try(Response response = client.newCall(request).execute()) {
//            // response.body().string()은 일회성
//            // response는 메모리에 저장되지 않음
//            if (response.isSuccessful()){
//                return response.body().string();
//            }
//            else {
//                return null;
//            }
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
//    }
}
