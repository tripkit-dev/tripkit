package com.tripkit.lighthouse.controller;

import com.tripkit.lighthouse.injector.GoogleProperties;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class ApiController {

    private GoogleProperties googleAPI;

    @GetMapping("")
    public String getTest() {
        return "Hello World!";
    }

    @GetMapping("/2")
    public String getTest2() {return "This is Second Test";}

    @GetMapping("/check")
    public String getTest3() {return googleAPI.getKey();}
}
