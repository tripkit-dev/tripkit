package com.tripkit.lighthouse.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/api/test")
public class TestController {
    @GetMapping("")
    public String getTest() {
        return "Hello World!";
    }
}
