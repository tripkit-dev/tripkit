package com.tripkit.lighthouse.controller;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.maps.GeoApiContext;
import com.google.maps.GeocodingApi;
import com.google.maps.errors.ApiException;
import com.google.maps.model.GeocodingResult;
import com.tripkit.lighthouse.injector.GoogleProperties;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class ApiController {

    @Autowired
    private GoogleProperties googleAPI;

    @GetMapping("")
    public String getTest() {
        return "Hello World!";
    }

    @GetMapping("/2")
    public String getTest2() {return "This is Second Test";}

    @GetMapping("/check")
    public String getTest3() throws IOException, InterruptedException, ApiException {
        GeoApiContext context = new GeoApiContext.Builder()
                .apiKey(googleAPI.getKey())
                .build();
        GeocodingResult[] results =  GeocodingApi.geocode(context,
                "1600 Amphitheatre Parkway Mountain View, CA 94043").await();
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        System.out.println(gson.toJson(results[0].addressComponents));

        // Invoke .shutdown() after your application is done making requests
        context.shutdown();
        return gson.toJson(results[0].addressComponents);
    }
}
