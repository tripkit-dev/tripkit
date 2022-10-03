package com.tripkit.lighthouse.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class ApiController {
    @GetMapping("")
    public String getTest() {
        return "Hello World!";
    }

    @GetMapping("/2")
    public String getTest2() {return "This is Second Test";}
}
